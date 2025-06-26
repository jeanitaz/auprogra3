package com.itsqmet.app_tienda.Controlador;

import com.itsqmet.app_tienda.Entidad.Cliente;
import com.itsqmet.app_tienda.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteServicio.obtenerTodosLosClientes());
        return "Pages/listaCli";
    }
    @GetMapping("/formularioCliente")
    public String formularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Pages/formularioCli";
    }
    @PostMapping("/clientes/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteServicio.agregarCliente(cliente);
        return "redirect:/clientes";
    }
    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@ModelAttribute Long id) {
        clienteServicio.eliminarcliente(id);
        return "redirect:/clientes";
    }
    @GetMapping("/editarCliente/{id}")
    public String editarCliente(@ModelAttribute Long id, Model model) {
        clienteServicio.buscarClientePorId(id).ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "Pages/formularioCli";
    }
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "Pages/formularioCli";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Cliente cliente = clienteServicio.buscarPorEmail(email);
        if (cliente != null && cliente.getPassword().equals(password)) {
            return "redirect:/tienda";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "Pages/login";
        }
    }
}
