package com.itsqmet.app_tienda.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula;

    private String nombre;
    private String apellido;
    private String direccion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
}
