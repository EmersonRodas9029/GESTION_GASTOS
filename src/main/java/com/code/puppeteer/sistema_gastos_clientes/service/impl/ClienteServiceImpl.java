package com.code.puppeteer.sistema_gastos_clientes.service.impl;

import com.code.puppeteer.sistema_gastos_clientes.dto.CLIENTE.*;
import com.code.puppeteer.sistema_gastos_clientes.entity.Cliente;
import com.code.puppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.code.puppeteer.sistema_gastos_clientes.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteResponse crear(ClienteSaveRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.nombre());
        cliente.setDui(request.dui());
        cliente.setNit(request.nit());
        cliente.setEmpresa(request.empresa());
        cliente.setTelefono(request.telefono());
        cliente.setCorreo(request.correo());

        Cliente guardado = clienteRepository.save(cliente);

        return mapToResponse(guardado);
    }

    @Override
    public ClienteResponse actualizar(ClienteUpdateRequest request) {
        Cliente cliente = clienteRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.setNombre(request.nombre());
        cliente.setDui(request.dui());
        cliente.setNit(request.nit());
        cliente.setEmpresa(request.empresa());
        cliente.setTelefono(request.telefono());
        cliente.setCorreo(request.correo());

        Cliente actualizado = clienteRepository.save(cliente);
        return mapToResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponse obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public List<ClienteListResponse> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteListResponse(c.getId(), c.getNombre(), c.getEmpresa(), c.getTelefono()))
                .toList();
    }

    private ClienteResponse mapToResponse(Cliente c) {
        return new ClienteResponse(
                c.getId(),
                c.getNombre(),
                c.getDui(),
                c.getNit(),
                c.getEmpresa(),
                c.getTelefono(),
                c.getCorreo(),
                c.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
    }
}
