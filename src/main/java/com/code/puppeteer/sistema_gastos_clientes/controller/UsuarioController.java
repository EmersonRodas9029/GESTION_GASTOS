package com.code.puppeteer.sistema_gastos_clientes.controller;

import com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS.*;
import com.code.puppeteer.sistema_gastos_clientes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody UsuarioSaveRequest request) {
        return ResponseEntity.ok(usuarioService.save(request));
    }

    @PutMapping
    public ResponseEntity<UsuarioResponse> actualizar(@Valid @RequestBody UsuarioUpdateRequest request) {
        return ResponseEntity.ok(usuarioService.update(request));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListResponse>> listar() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
