package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE.*;

import java.util.List;

public interface ClienteService {
    ClienteResponse crear(ClienteSaveRequest request);
    ClienteResponse actualizar(ClienteUpdateRequest request);
    void eliminar(Long id);
    ClienteResponse obtenerPorId(Long id);
    List<ClienteListResponse> listarTodos();
}
