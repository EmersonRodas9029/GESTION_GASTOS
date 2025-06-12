package com.code.puppeteer.sistema_gastos_clientes.service.impl;

import com.code.puppeteer.sistema_gastos_clientes.dto.DLOG.*;
import com.code.puppeteer.sistema_gastos_clientes.entity.Log;
import com.code.puppeteer.sistema_gastos_clientes.entity.Usuario;
import com.code.puppeteer.sistema_gastos_clientes.repository.LogRepository;
import com.code.puppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.code.puppeteer.sistema_gastos_clientes.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrar(LogSaveRequest request) {
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Log log = new Log();
        log.setAccion(request.accion());
        log.setUsuario(usuario);

        logRepository.save(log);
    }

    @Override
    public List<LogListResponse> listarTodos() {
        return logRepository.findAll().stream()
                .map(l -> new LogListResponse(
                        l.getId(),
                        l.getAccion(),
                        l.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        l.getUsuario().getUsername()
                )).toList();
    }
}
