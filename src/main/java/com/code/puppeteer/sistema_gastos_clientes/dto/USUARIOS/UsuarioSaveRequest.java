package com.code.puppeteer.sistema_gastos_clientes.dto.USUARIOS;

import jakarta.validation.constraints.*;

public record UsuarioSaveRequest(
        @NotBlank(message = "El nombre de usuario es obligatorio")
        @Size(max = 255, message = "El nombre de usuario debe tener máximo 255 caracteres")
        String username,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String password,

        @NotBlank(message = "El rol es obligatorio")
        String rol
) {}