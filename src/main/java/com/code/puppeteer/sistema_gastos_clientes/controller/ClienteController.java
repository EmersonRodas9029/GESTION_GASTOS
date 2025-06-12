package com.code.puppeteer.sistema_gastos_clientes.controller;

import com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE.*;
import com.code.puppeteer.sistema_gastos_clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crear(@Valid @RequestBody ClienteSaveRequest request) {
        return ResponseEntity.ok(clienteService.save(request));
    }

    @PutMapping
    public ResponseEntity<ClienteResponse> actualizar(@Valid @RequestBody ClienteUpdateRequest request) {
        return ResponseEntity.ok(clienteService.update(request));
    }

    @GetMapping
    public ResponseEntity<List<ClienteListResponse>> listar() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
