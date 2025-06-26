package com.itsqmet.app_tienda.Servicio;

import com.itsqmet.app_tienda.Entidad.Cliente;
import com.itsqmet.app_tienda.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio{
    @Autowired
    private ClienteRepositorio ClienteRepositorio;

    public List<Cliente> obtenerTodosLosClientes() {
        return ClienteRepositorio.findAll();
    }
    public Cliente buscarPorEmail(String email) {
        return ClienteRepositorio.findByEmail(email);
    }
    public Cliente agregarCliente(Cliente cliente) {ClienteRepositorio.save(cliente);
        return cliente;
    }
    public Optional<Cliente> buscarClientePorId(Long id){return ClienteRepositorio.findById(id);
    }

    public void eliminarcliente(Long id){ClienteRepositorio.deleteById(id);
    }
}
