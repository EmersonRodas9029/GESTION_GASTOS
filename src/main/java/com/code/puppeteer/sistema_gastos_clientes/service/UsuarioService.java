package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS.*;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse save(UsuarioSaveRequest request);
    UsuarioResponse update(UsuarioUpdateRequest request);
    void delete(Long id);
    UsuarioResponse findById(Long id);
    List<UsuarioListResponse> findAll();
}
