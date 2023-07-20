package com.need4speed.api.services;

import com.need4speed.api.models.ItensPedido;
import com.need4speed.api.models.Pedido;
import com.need4speed.api.models.Produto;
import com.need4speed.api.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public Object inserirPedido(Pedido pedido){
        List<Produto> produtos = pedido.getProdutos();
        for (Produto produto : produtos) {
            ItensPedido itemPedido = new ItensPedido(pedido, produto);
            pedido.getItensPedido().add(itemPedido);
        }
        return pedidoRepository.save(pedido);
    }

}
