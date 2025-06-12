package com.code.puppeteer.sistema_gastos_clientes.controller;

import com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS.*;
import com.code.puppeteer.sistema_gastos_clientes.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public ResponseEntity<GastoResponse> crear(@Valid @RequestBody GastoSaveRequest request) {
        return ResponseEntity.ok(gastoService.save(request));
    }

    @PutMapping
    public ResponseEntity<GastoResponse> actualizar(@Valid @RequestBody GastoUpdateRequest request) {
        return ResponseEntity.ok(gastoService.update(request));
    }

    @GetMapping
    public ResponseEntity<List<GastoListResponse>> listar() {
        return ResponseEntity.ok(gastoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(gastoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        gastoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
