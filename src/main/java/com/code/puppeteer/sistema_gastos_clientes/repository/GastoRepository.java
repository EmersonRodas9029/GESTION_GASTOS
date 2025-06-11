package com.code.puppeteer.sistema_gastos_clientes.repository;

import com.code.puppeteer.sistema_gastos_clientes.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
