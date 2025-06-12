package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.CONFIGURACION.*;

public interface ConfiguracionService {
    ConfiguracionResponse save(ConfiguracionSaveRequest request);
    ConfiguracionResponse update(ConfiguracionUpdateRequest request);
    ConfiguracionResponse findById(Long id);
}
