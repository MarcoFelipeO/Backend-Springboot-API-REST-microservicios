package com.example.gestionclientesbackend.repository;

import com.example.gestionclientesbackend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}

//AQUI SIEMPRE DEBEMOS USAR LA Cliente y no ClienteDTO por que, ClienteDTO no contiene un mapeo de la TABLA.
