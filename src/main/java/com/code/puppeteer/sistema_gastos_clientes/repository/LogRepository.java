package com.code.puppeteer.sistema_gastos_clientes.repository;

import com.code.puppeteer.sistema_gastos_clientes.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
