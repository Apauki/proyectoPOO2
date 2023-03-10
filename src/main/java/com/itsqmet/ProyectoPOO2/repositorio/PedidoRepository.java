package com.itsqmet.ProyectoPOO2.repositorio;

import com.itsqmet.ProyectoPOO2.entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
