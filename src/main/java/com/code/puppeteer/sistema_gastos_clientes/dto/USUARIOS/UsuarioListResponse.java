package com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS;

public record UsuarioListResponse(
        Long id,
        String username,
        String rol,
        Boolean activo
) {}
