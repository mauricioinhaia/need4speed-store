package com.need4speed.api.validators;

import com.need4speed.api.dtos.ProdutoDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProdutoValidator {

    public String validarProduto(ProdutoDto produtoDto) {
        String erro = null;
        if (produtoDto.descricao() == null || produtoDto.descricao().isEmpty()) {
            erro = "O produto não pode ser cadastrado sem descrição.";
        }

        if (produtoDto.valor().equals(BigDecimal.ZERO)) {
            erro = "O preço do produto deve ser maior que zero.";
        }

        if (produtoDto.servico() == null){
            erro = "Favor informar se e um serviço.";
        }
        return erro;
    }
}
