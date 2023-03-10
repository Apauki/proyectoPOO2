package com.itsqmet.ProyectoPOO2.controller;

import com.itsqmet.ProyectoPOO2.entidad.Afiliado;
import com.itsqmet.ProyectoPOO2.repositorio.AfiliadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AfiliadoController {
    
    @Autowired
    AfiliadoRepository afiliadoRepository;
    
    //CRUD - CREATE
    @GetMapping("/listarAfiliados")
    public String listar(Model model){
        List<Afiliado> afiliados = afiliadoRepository.findAll();
        model.addAttribute("afiliados", afiliados);
        return "verAfiliados";
    }
    
    @GetMapping("/formAfiliados")
    public String formulario(Model model){
        model.addAttribute("afiliado", new Afiliado());
        
        return "formAfiliados";
    }
    
    @PostMapping("/formAfiliados")
    public String nuevoAfiliado(Afiliado afiliado){
        afiliadoRepository.save(afiliado);
        
        return "redirect:/listarAfiliados";
    }
    
    @GetMapping("/editarAfiliado/{id}")
    public String editarAfiliado(@PathVariable int id, Model model){
        Optional <Afiliado> afiliado = afiliadoRepository.findById(id);
        model.addAttribute("afiliado", afiliado);
        return "formAfiliados";
    }
    
    @GetMapping("/eliminarAfiliado/{id}")
    public String eliminarAfiliado (@PathVariable int id){
        afiliadoRepository.deleteById(id);
        return "redirect:/listarAfiliados";
    }
    
}
