package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS.*;

import java.util.List;

public interface GastoService {
    GastoResponse crear(GastoSaveRequest request);
    GastoResponse actualizar(GastoUpdateRequest request);
    void eliminar(Long id);
    GastoResponse obtenerPorId(Long id);
    List<GastoListResponse> listarTodos();
}
