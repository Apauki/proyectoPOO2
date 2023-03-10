package com.itsqmet.ProyectoPOO2.repositorio;

import com.itsqmet.ProyectoPOO2.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Integer>{
    
}
