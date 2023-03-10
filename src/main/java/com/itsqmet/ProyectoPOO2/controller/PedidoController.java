package com.itsqmet.ProyectoPOO2.controller;

import com.itsqmet.ProyectoPOO2.entidad.Pedido;
import com.itsqmet.ProyectoPOO2.repositorio.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoController {
    
    @Autowired
    PedidoRepository pedidoRepository;
    
    //CRUD - CREATE
    @GetMapping("/listarPedidos")
    public String listar(Model model){
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "verPedidos";
    }
    
    @GetMapping("/formPedidos")
    public String formulario(Model model){
        model.addAttribute("pedido", new Pedido());
        
        return "formPedidos";
    }
    
    @PostMapping("/formPedidos")
    public String nuevoPedido(Pedido pedido){
        pedidoRepository.save(pedido);
        
        return "redirect:/listarPedidos";
    }
    
    @GetMapping("/editarPedido/{idPedido}")
    public String editarPedido(@PathVariable int idPedido, Model model){
        Optional <Pedido> pedido = pedidoRepository.findById(idPedido);
        model.addAttribute("pedido", pedido);
        return "formPedidos";
    }
    
    @GetMapping("/eliminarPedido/{idPedido}")
    public String eliminarLibro (@PathVariable int idPedido){
        pedidoRepository.deleteById(idPedido);
        return "redirect:/listarPedidos";
    }
    
}
