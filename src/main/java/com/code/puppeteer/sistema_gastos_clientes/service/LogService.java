package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.DLOG.*;

import java.util.List;

public interface LogService {
    LogResponse save(LogSaveRequest request);
    void delete(Long id);
    LogResponse findById(Long id);
    List<LogListResponse> findAll();
}