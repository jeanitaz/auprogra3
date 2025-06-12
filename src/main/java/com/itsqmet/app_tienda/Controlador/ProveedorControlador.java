package com.itsqmet.app_tienda.Controlador;

import com.itsqmet.app_tienda.Entidad.Proveedor;
import com.itsqmet.app_tienda.Servicio.ProveedorSercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorControlador {
    @Autowired
    private ProveedorSercicio ProveedorSercicio;

    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", ProveedorSercicio.obtenerTodosLosProveedores());
        return "Pages/listaProv";
    }

    @GetMapping("/formularioProveedor")
    public String formularioProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "Pages/formularioProv";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        ProveedorSercicio.agregarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        ProveedorSercicio.eliminarProveedor(id);
        return "redirect:/proveedores";
    }

}
