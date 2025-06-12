package com.code.puppeteer.sistema_gastos_clientes.dto.DLOG;

public record LogListResponse(
        Long id,
        String accion,
        String fecha,
        String usuarioNombre
) {}
