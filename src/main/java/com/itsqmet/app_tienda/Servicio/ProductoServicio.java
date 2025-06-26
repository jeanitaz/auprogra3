package com.itsqmet.app_tienda.Servicio;

import com.itsqmet.app_tienda.Entidad.Producto;
import com.itsqmet.app_tienda.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }
    public Producto agregarProducto(Producto producto) {
        productoRepositorio.save(producto);
        return producto;
    }
    public Producto buscarProductoPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }
    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
