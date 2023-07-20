package com.need4speed.api.controllers;

import com.need4speed.api.models.Pedido;
import com.need4speed.api.services.PedidoService;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> inserirProduto (@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.inserirPedido(pedido));
    }

}
