package com.code.puppeteer.sistema_gastos_clientes.service.impl;

import com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS.*;
import com.code.puppeteer.sistema_gastos_clientes.entity.Usuario;
import com.code.puppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.code.puppeteer.sistema_gastos_clientes.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse save(UsuarioSaveRequest request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.username());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setRol(request.rol());
        usuario.setActivo(true);

        Usuario guardado = usuarioRepository.save(usuario);

        return new UsuarioResponse(
                guardado.getId(),
                guardado.getUsername(),
                guardado.getRol(),
                guardado.getActivo(),
                guardado.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
    }

    @Override
    public UsuarioResponse update(UsuarioUpdateRequest request) {
        Usuario usuario = usuarioRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setUsername(request.username());
        if (request.password() != null && !request.password().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(request.password()));
        }
        usuario.setRol(request.rol());
        usuario.setActivo(request.activo());

        Usuario actualizado = usuarioRepository.save(usuario);

        return new UsuarioResponse(
                actualizado.getId(),
                actualizado.getUsername(),
                actualizado.getRol(),
                actualizado.getActivo(),
                actualizado.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponse findById(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return new UsuarioResponse(
                u.getId(), u.getUsername(), u.getRol(), u.getActivo(),
                u.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
    }

    @Override
    public List<UsuarioListResponse> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioListResponse(u.getId(), u.getUsername(), u.getRol(), u.getActivo()))
                .toList();
    }
}
