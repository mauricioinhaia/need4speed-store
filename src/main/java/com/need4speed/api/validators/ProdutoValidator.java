package com.need4speed.api.validators;

import com.need4speed.api.dtos.ProdutoDto;
import com.need4speed.api.exceptions.ProdutoException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProdutoValidator {

    public void validarProduto(ProdutoDto produtoDto) {
        if (produtoDto.descricao() == null || produtoDto.descricao().isEmpty()) {
            throw new ProdutoException("O produto não pode ser cadastrado sem descrição.");
        }

        if (produtoDto.valor().equals(BigDecimal.ZERO)) {
            throw new ProdutoException("O preço do produto deve ser maior que zero.");
        }

        if (produtoDto.servico() == null){
            throw new ProdutoException("Favor informar se e um serviço.");
        }
    }
}
