package com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE;

public record ClienteResponse(
        Long id,
        String nombre,
        String dui,
        String nit,
        String empresa,
        String telefono,
        String correo,
        String fechaCreacion
) {}
