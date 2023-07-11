package com.need4speed.api.controllers;

import com.need4speed.api.dtos.ProdutoDto;
import com.need4speed.api.models.Produto;
import com.need4speed.api.services.ProdutoService;
import com.need4speed.api.validators.ProdutoValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoValidator produtoValidator;
    private ProdutoService produtoService;

    public ProdutoController(ProdutoValidator produtoValidator, ProdutoService produtoService) {
        this.produtoValidator = produtoValidator;
        this.produtoService = produtoService;
    }

    @Transactional
    @PostMapping("/")
    public ResponseEntity<Object> inserirProduto(@RequestBody @Valid ProdutoDto produtoDto) {
        String response = produtoValidator.validarProduto(produtoDto);

        if (response != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.inserirProduto(produto));
    }

}
