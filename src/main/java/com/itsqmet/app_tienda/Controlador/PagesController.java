package com.itsqmet.app_tienda.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "Pages/InicioSession";
    }

    @GetMapping("/loginProveedor")
    public String loginProveedor() {
        return "Pages/InicioProveedor";
    }

    @GetMapping("/tienda")
    public String tienda() {
        return "Pages/Tienda";
    }
    @GetMapping("/factura")
    public String factura() {
        return "Pages/Factura";
    }
}
