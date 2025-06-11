package com.code.puppeteer.sistema_gastos_clientes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "configuraciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuracion {

    @Id
    private Long id;

    @Column(name = "nombre_estudio")
    private String nombreEstudio;

    @Lob
    private byte[] logo;
}
