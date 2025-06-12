package com.itsqmet.app_tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private int cantidad;
    private double precio;
    private double subtotal;
    private double total;

    @ManyToOne
    @JoinColumn(name="cedula_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="codigo_producto")
    private Producto producto;
}
