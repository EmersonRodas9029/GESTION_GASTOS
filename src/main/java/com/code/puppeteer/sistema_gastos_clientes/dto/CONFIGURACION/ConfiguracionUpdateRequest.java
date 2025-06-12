package com.code.puppeteer.sistema_gastos_clientes.dto.CONFIGURACION;

import jakarta.validation.constraints.*;

public record ConfiguracionUpdateRequest(
        @NotNull(message = "El ID es obligatorio")
        Long id,

        @NotBlank(message = "El nombre del estudio es obligatorio")
        String nombreEstudio,

        @NotNull(message = "El logo es obligatorio")
        byte[] logo
) {}
