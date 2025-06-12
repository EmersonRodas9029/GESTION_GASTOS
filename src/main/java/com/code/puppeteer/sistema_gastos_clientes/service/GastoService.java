package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS.*;

import java.util.List;

public interface GastoService {
    GastoResponse save(GastoSaveRequest request);
    GastoResponse update(GastoUpdateRequest request);
    void delete(Long id);
    GastoResponse findById(Long id);
    List<GastoListResponse> findAll();
}
