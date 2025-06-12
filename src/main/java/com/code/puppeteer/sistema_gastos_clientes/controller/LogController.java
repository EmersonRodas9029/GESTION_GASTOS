package com.code.puppeteer.sistema_gastos_clientes.controller;

import com.code.puppeteer.sistema_gastos_clientes.dto.DLOG.*;
import com.code.puppeteer.sistema_gastos_clientes.service.LogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogResponse> crear(@Valid @RequestBody LogSaveRequest request) {
        return ResponseEntity.ok(logService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<LogListResponse>> listar() {
        return ResponseEntity.ok(logService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(logService.findById(id));
    }
}
