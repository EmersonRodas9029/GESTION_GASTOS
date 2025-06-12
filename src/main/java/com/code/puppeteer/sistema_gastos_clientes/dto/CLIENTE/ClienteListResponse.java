package com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE;

public record ClienteListResponse(
        Long id,
        String nombre,
        String empresa,
        String telefono
) {}
