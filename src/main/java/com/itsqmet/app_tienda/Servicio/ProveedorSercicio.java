package com.itsqmet.app_tienda.Servicio;

import com.itsqmet.app_tienda.Entidad.Proveedor;
import com.itsqmet.app_tienda.Repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorSercicio {
    @Autowired
    private ProveedorRepositorio ProveedorRepositorio;

    public List<Proveedor> obtenerTodosLosProveedores() {
        return ProveedorRepositorio.findAll();
    }

    public Proveedor agregarProveedor(Proveedor proveedor) {ProveedorRepositorio.save(proveedor);
        return proveedor;
    }
    public Optional<Proveedor> buscarProveedorPorId(Long id){return ProveedorRepositorio.findById(id);
    }

    public void eliminarProveedor(Long id){ProveedorRepositorio.deleteById(id);
    }

}
