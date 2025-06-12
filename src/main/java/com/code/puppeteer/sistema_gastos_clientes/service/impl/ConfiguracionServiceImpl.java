package com.code.puppeteer.sistema_gastos_clientes.service.impl;

import com.code.puppeteer.sistema_gastos_clientes.dto.CONFIGURACION.*;
import com.code.puppeteer.sistema_gastos_clientes.entity.Configuracion;
import com.code.puppeteer.sistema_gastos_clientes.repository.ConfiguracionRepository;
import com.code.puppeteer.sistema_gastos_clientes.service.ConfiguracionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    @Override
    public ConfiguracionResponse guardar(ConfiguracionSaveRequest request) {
        Configuracion config = new Configuracion();
        config.setId(request.id());
        config.setNombreEstudio(request.nombreEstudio());
        config.setLogo(request.logo());

        return mapToResponse(configuracionRepository.save(config));
    }

    @Override
    public ConfiguracionResponse actualizar(ConfiguracionUpdateRequest request) {
        Configuracion config = configuracionRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Configuración no encontrada"));

        config.setNombreEstudio(request.nombreEstudio());
        config.setLogo(request.logo());

        return mapToResponse(configuracionRepository.save(config));
    }

    @Override
    public ConfiguracionResponse obtener(Long id) {
        return configuracionRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Configuración no encontrada"));
    }

    private ConfiguracionResponse mapToResponse(Configuracion c) {
        return new ConfiguracionResponse(c.getId(), c.getNombreEstudio(), c.getLogo());
    }
}
