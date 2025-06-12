package com.itsqmet.app_tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name="codigo_proveedor")
    private Proveedor proveedor;
}
