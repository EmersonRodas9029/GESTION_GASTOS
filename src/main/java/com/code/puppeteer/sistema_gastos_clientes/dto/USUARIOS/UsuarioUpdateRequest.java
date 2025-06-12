package com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS;

import jakarta.validation.constraints.*;

public record UsuarioUpdateRequest(
        @NotNull(message = "El ID es obligatorio")
        Long id,

        @NotBlank(message = "El nombre de usuario es obligatorio")
        @Size(max = 255, message = "El nombre de usuario debe tener máximo 255 caracteres")
        String username,

        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String password,

        @NotBlank(message = "El rol es obligatorio")
        String rol,

        @NotNull(message = "El estado activo es obligatorio")
        Boolean activo
) {}