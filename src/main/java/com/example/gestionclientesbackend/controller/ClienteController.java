package com.example.gestionclientesbackend.controller;

import com.example.gestionclientesbackend.ClienteDTO.ClienteDTO;
import com.example.gestionclientesbackend.entities.Cliente;
import com.example.gestionclientesbackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClienteDTO> getAllCliente() {
        return clienteService.getAllCliente();
    }

    @GetMapping("clientes/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.getClienteById(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/clientes")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdClienteDTO = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClienteDTO);
    }


    @PutMapping("clientes/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updatedClienteDTO = clienteService.updateCliente(id, clienteDTO);
        if (updatedClienteDTO != null) {
            return ResponseEntity.ok(updatedClienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("clientes/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/registroLogin")
    public ResponseEntity<ClienteDTO> createLogin(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdClienteDTO = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClienteDTO);

    }



}
