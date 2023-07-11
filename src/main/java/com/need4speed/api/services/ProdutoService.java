package com.need4speed.api.services;

import com.need4speed.api.models.Produto;
import com.need4speed.api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Object inserirProduto (Produto produto){

        if (produto.getInativo() == null ) {
            produto.setInativo(false);
        }
        return produtoRepository.save(produto);
    }

}
