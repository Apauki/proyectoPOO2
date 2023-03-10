package com.itsqmet.ProyectoPOO2.controller;

import com.itsqmet.ProyectoPOO2.entidad.Libro;
import com.itsqmet.ProyectoPOO2.repositorio.LibroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroController {
    
    @Autowired
    LibroRepository libroRepository;
    
    //CRUD - CREATE
    @GetMapping("/listarLibros")
    public String listar(Model model){
        List<Libro> libros= libroRepository.findAll();
        model.addAttribute("libros", libros);
        return "verLibros";
    }
    
    @GetMapping("/formLibros")
    public String formulario(Model model){
        model.addAttribute("libro", new Libro());
        
        return "formLibros";
    }
    
    @PostMapping("/formLibros")
    public String nuevolibro(Libro libro){
        libroRepository.save(libro);
        
        return "redirect:/listarLibros";
    }
    
    @GetMapping("/editarLibro/{id}")
    public String editarLibro(@PathVariable int id, Model model){
        Optional <Libro> libro = libroRepository.findById(id);
        model.addAttribute("libro", libro);
        return "formLibros";
    }
    
    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro (@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/listarLibros";
    }
    
}
