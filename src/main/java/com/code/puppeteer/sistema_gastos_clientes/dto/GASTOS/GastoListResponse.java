package com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS;
import java.time.LocalDate;


public record GastoListResponse(
        Long id,
        LocalDate fecha,
        Double monto,
        String categoria,
        String clienteNombre
) {}
