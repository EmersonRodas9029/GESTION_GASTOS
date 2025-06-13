package com.code.puppeteer.sistema_gastos_clientes.service.impl;

import com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS.*;
import com.code.puppeteer.sistema_gastos_clientes.entity.Cliente;
import com.code.puppeteer.sistema_gastos_clientes.entity.Gasto;
import com.code.puppeteer.sistema_gastos_clientes.entity.Usuario;
import com.code.puppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.code.puppeteer.sistema_gastos_clientes.repository.GastoRepository;
import com.code.puppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.code.puppeteer.sistema_gastos_clientes.service.GastoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public GastoResponse save(GastoSaveRequest request) {
        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Gasto gasto = new Gasto();
        gasto.setFecha(request.fecha());
        gasto.setMonto(BigDecimal.valueOf(request.monto())); // ✅ conversión correcta
        gasto.setDescripcion(request.descripcion());
        gasto.setCategoria(request.categoria());
        gasto.setCliente(cliente);
        gasto.setUsuario(usuario);

        Gasto guardado = gastoRepository.save(gasto);

        return mapToResponse(guardado);
    }

    @Override
    public GastoResponse update(GastoUpdateRequest request) {
        Gasto gasto = gastoRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        gasto.setFecha(request.fecha());
        gasto.setMonto(BigDecimal.valueOf(request.monto())); // ✅ conversión correcta
        gasto.setDescripcion(request.descripcion());
        gasto.setCategoria(request.categoria());
        gasto.setCliente(cliente);
        gasto.setUsuario(usuario);

        return mapToResponse(gastoRepository.save(gasto));
    }

    @Override
    public void delete(Long id) {
        gastoRepository.deleteById(id);
    }

    @Override
    public GastoResponse findById(Long id) {
        return gastoRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));
    }

    @Override
    public List<GastoListResponse> findAll() {
        return gastoRepository.findAll().stream()
                .map(g -> new GastoListResponse(
                        g.getId(),
                        g.getFecha(),
                        g.getMonto().doubleValue(), // ✅ conversión correcta
                        g.getCategoria(),
                        g.getCliente().getNombre()
                ))
                .toList();
    }

    private GastoResponse mapToResponse(Gasto g) {
        return new GastoResponse(
                g.getId(),
                g.getFecha(),
                g.getMonto().doubleValue(), // ✅ conversión correcta
                g.getDescripcion(),
                g.getCategoria(),
                g.getCliente().getId(),
                g.getUsuario().getId()
        );
    }
}
