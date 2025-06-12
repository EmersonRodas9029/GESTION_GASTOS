package com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE;
import jakarta.validation.constraints.*;

public record ClienteUpdateRequest(
        @NotNull(message = "El ID es obligatorio")
        Long id,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 255, message = "El nombre debe tener máximo 255 caracteres")
        String nombre,

        @Size(max = 10, message = "El DUI debe tener máximo 10 caracteres")
        String dui,

        @Size(max = 20, message = "El NIT debe tener máximo 20 caracteres")
        String nit,

        @Size(max = 255, message = "El nombre de la empresa debe tener máximo 255 caracteres")
        String empresa,

        @Size(max = 20, message = "El teléfono debe tener máximo 20 caracteres")
        String telefono,

        @Email(message = "Correo electrónico inválido")
        @Size(max = 255, message = "El correo debe tener máximo 255 caracteres")
        String correo
) {}

