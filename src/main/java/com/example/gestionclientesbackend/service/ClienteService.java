package com.example.gestionclientesbackend.service;

import com.example.gestionclientesbackend.ClienteDTO.ClienteDTO;
import java.util.List;

public interface ClienteService {

    List<ClienteDTO> getAllCliente(); //le pasamos el objeto en una lista
    ClienteDTO getClienteById(Long id); //traer todos
    ClienteDTO createCliente(ClienteDTO clienteDTO); // crea cliente
    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO); // modifica cliente
    void deleteCliente(Long id); // elimina un cliente


}
