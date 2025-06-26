package com.itsqmet.app_tienda.Repositorio;

import com.itsqmet.app_tienda.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    List<Factura> findByNombreContainingIgnoreCase(String nombre);
}
