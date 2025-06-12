package com.code.puppeteer.sistema_gastos_clientes.controller;

import com.code.puppeteer.sistema_gastos_clientes.dto.CONFIGURACION.*;
import com.code.puppeteer.sistema_gastos_clientes.service.ConfiguracionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configuracion")
public class ConfiguracionController {

    private final ConfiguracionService configuracionService;

    public ConfiguracionController(ConfiguracionService configuracionService) {
        this.configuracionService = configuracionService;
    }

    @PostMapping
    public ResponseEntity<ConfiguracionResponse> crear(@Valid @RequestBody ConfiguracionSaveRequest request) {
        return ResponseEntity.ok(configuracionService.save(request));
    }

    @PutMapping
    public ResponseEntity<ConfiguracionResponse> actualizar(@Valid @RequestBody ConfiguracionUpdateRequest request) {
        return ResponseEntity.ok(configuracionService.update(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(configuracionService.findById(id));
    }
}
