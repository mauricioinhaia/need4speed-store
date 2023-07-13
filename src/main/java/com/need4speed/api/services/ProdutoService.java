package com.need4speed.api.services;

import com.need4speed.api.exceptions.ProdutoException;
import com.need4speed.api.models.Produto;
import com.need4speed.api.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Object inserirProduto (Produto produto){

        if (produto.getInativo() == null ) {
            produto.setInativo(false);
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos () {
        return produtoRepository.findAll();
    }

    public Object buscarProduto (UUID id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (!produtoOptional.isPresent()){
            throw new ProdutoException("Produto Nao Encontrado!");
        }
        return produtoOptional.get();
    }

    @Transactional
    public void excluirProduto (UUID id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (!produtoOptional.isPresent()){
            throw new ProdutoException("Produto Nao Encontrado!");
        }
        //Adicionar Verificacao Associacao a Pedidos
        produtoRepository.delete(produtoOptional.get());
    }

}
