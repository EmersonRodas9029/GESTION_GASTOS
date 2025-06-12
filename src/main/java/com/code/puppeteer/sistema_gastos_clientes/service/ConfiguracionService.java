package com.code.puppeteer.sistema_gastos_clientes.service;

import com.code.puppeteer.sistema_gastos_clientes.dto.CONFIGURACION.*;

public interface ConfiguracionService {
    ConfiguracionResponse guardar(ConfiguracionSaveRequest request);
    ConfiguracionResponse actualizar(ConfiguracionUpdateRequest request);
    ConfiguracionResponse obtener(Long id);
}
