package com.example.gestionclientesbackend.ClienteDTO;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO { // DTO = DATA OBJECT TRANSFER- LOS CONVIERTE EN OBJETOS.

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String role;
    private String password;


    public ClienteDTO() {
        this.id = 0L; // o cualquier otro valor predeterminado que desees usar
    }

}
