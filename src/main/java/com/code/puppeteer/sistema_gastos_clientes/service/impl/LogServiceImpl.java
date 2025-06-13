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
    public LogResponse save(LogSaveRequest request) {
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Log log = new Log();
        log.setAccion(request.accion());
        log.setUsuario(usuario);

        Log guardado = logRepository.save(log);
        return mapToResponse(guardado);
    }

    @Override
    public void delete(Long id) {
        logRepository.deleteById(id);
    }

    @Override
    public LogResponse findById(Long id) {
        return logRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Log no encontrado"));
    }

    @Override
    public List<LogListResponse> findAll() {
        return logRepository.findAll().stream()
                .map(log -> new LogListResponse(
                        log.getId(),
                        log.getAccion(),
                        log.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        log.getUsuario().getUsername()
                ))
                .toList();
    }

    private LogResponse mapToResponse(Log log) {
        return new LogResponse(
                log.getId(),
                log.getAccion(),
                log.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                log.getUsuario().getId()
        );
    }
}
