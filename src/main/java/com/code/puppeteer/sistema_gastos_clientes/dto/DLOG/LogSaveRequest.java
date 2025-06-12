package com.code.puppeteer.sistema_gastos_clientes.dto.DLOG;

import jakarta.validation.constraints.*;

public record LogSaveRequest(
        @NotBlank(message = "La acción es obligatoria")
        String accion,

        @NotNull(message = "El ID del usuario es obligatorio")
        Long usuarioId
) {}