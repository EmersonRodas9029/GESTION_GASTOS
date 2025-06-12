package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.DLOG.*;

import java.util.List;

public interface LogService {
    void registrar(LogSaveRequest request);
    List<LogListResponse> listarTodos();
}
