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
    private Long id;

    private String nombre;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name="id_proveedor")
    private Proveedor proveedor;
}
