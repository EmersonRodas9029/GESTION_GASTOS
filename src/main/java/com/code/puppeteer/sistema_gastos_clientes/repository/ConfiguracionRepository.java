package com.code.puppeteer.sistema_gastos_clientes.repository;

import com.code.puppeteer.sistema_gastos_clientes.entity.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {
}