package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE.*;

import java.util.List;

public interface ClienteService {
    ClienteResponse save(ClienteSaveRequest request);
    ClienteResponse update(ClienteUpdateRequest request);
    void delete(Long id);
    ClienteResponse findById(Long id);
    List<ClienteListResponse> findAll();
}
