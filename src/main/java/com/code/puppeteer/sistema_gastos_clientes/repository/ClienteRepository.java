package com.code.puppeteer.sistema_gastos_clientes.repository;

import com.code.puppeteer.sistema_gastos_clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
