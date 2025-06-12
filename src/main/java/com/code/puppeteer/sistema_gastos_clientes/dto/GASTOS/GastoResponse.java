package com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS;
import java.time.LocalDate;

public record GastoResponse(
        Long id,
        LocalDate fecha,
        Double monto,
        String descripcion,
        String categoria,
        Long clienteId,
        Long usuarioId
) {}