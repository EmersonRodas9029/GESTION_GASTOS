package com.code.puppeteer.sistema_gastos_clientes.dto.GASTOS;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record GastoSaveRequest(
        @NotNull(message = "La fecha es obligatoria")
        LocalDate fecha,

        @NotNull(message = "El monto es obligatorio")
        @Positive(message = "El monto debe ser positivo")
        Double monto,

        @Size(max = 1000, message = "La descripción puede tener máximo 1000 caracteres")
        String descripcion,

        @Size(max = 100, message = "La categoría puede tener máximo 100 caracteres")
        String categoria,

        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        @NotNull(message = "El ID del usuario es obligatorio")
        Long usuarioId
) {}