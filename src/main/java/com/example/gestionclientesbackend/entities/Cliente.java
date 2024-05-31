package com.example.gestionclientesbackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="clientes")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="nombre")
    private String nombre;


    @Column(name ="apellido")
    private String apellido;


    @Column(name ="email")
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "role", nullable = false)
    private String role = "user"; // Valor por defecto

}
