package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS.*;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse crear(UsuarioSaveRequest request);
    UsuarioResponse actualizar(UsuarioUpdateRequest request);
    void eliminar(Long id);
    UsuarioResponse obtenerPorId(Long id);
    List<UsuarioListResponse> listarTodos();
}
