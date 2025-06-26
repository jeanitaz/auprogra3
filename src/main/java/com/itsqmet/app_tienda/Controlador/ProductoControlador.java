package com.itsqmet.app_tienda.Controlador;

import com.itsqmet.app_tienda.Entidad.Producto;
import com.itsqmet.app_tienda.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductoControlador {
    @Autowired
    private ProductoServicio ProductoServicio;
     @GetMapping("/productos")
     public String listarProductos(Model model) {
         List<Producto> productos = ProductoServicio.obtenerTodosLosProductos();
         model.addAttribute("productos", productos);
         return "producto/lista";
     }
     @GetMapping("/formularioProducto")
    public String formularioProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/formulario";
     }

    @GetMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        ProductoServicio.eliminarProducto(id);
        return "redirect:/productos";
     }
    @GetMapping("/editarProducto/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = ProductoServicio.buscarProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto/formulario";
        } else {
            return "redirect:/productos";
        }
    }
    @GetMapping("/guardarProducto")
    public String guardarProducto(Producto producto) {
        ProductoServicio.agregarProducto(producto);
        return "redirect:/productos";
    }
    @GetMapping("/buscarProducto/{id}")
    public String buscarProducto(@PathVariable Long id, Model model) {
        Producto producto = ProductoServicio.buscarProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto/detalle";
        } else {
            return "redirect:/productos";
        }
    }

}
