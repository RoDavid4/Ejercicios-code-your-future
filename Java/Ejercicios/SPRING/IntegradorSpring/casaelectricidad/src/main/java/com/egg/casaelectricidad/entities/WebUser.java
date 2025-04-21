package com.egg.casaelectricidad.entities;

import com.egg.casaelectricidad.enumerates.Rol;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class WebUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    @Column(name = "id_usuario")
    private UUID idUsuario;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

}

