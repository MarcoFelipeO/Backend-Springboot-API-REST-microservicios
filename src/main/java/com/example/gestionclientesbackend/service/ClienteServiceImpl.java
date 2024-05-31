package com.example.gestionclientesbackend.service;

import com.example.gestionclientesbackend.ClienteDTO.ClienteDTO;
import com.example.gestionclientesbackend.entities.Cliente;
import com.example.gestionclientesbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService { // La Interfaz ClienteService trae los metodos.

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getAllCliente() {
        return clienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(this::convertToDTO).orElse(null);
    }



    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        // Establecer el valor por defecto para el campo role si no está presente
        if (cliente.getRole() == null || cliente.getRole().isEmpty()) {
            cliente.setRole("user");
        }
        Cliente savedCliente = clienteRepository.save(cliente);
        return convertToDTO(savedCliente);
    }


    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        if (clienteRepository.existsById(id)) {
            Cliente cliente = convertToEntity(clienteDTO);
            cliente.setId(id);
            Cliente updatedCliente = clienteRepository.save(cliente);
            return convertToDTO(updatedCliente);
        }
        return null;
    }


    @Override
    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getEmail(),cliente.getPassword() ,cliente.getRole());
    }

    private Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setPassword(clienteDTO.getPassword());
        cliente.setRole(clienteDTO.getRole());

        // Aquí no se establece el email, ya que no está en el DTO
        return cliente;
    }

}
