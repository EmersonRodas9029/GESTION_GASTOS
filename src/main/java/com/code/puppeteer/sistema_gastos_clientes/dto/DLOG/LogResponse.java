package com.code.puppeteer.sistema_gastos_clientes.dto.DLOG;

public record LogResponse(
        Long id,
        String accion,
        String fecha,
        Long usuarioId
) {}
