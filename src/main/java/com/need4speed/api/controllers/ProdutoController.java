package com.need4speed.api.controllers;

import com.need4speed.api.dtos.ProdutoDto;
import com.need4speed.api.exceptions.ProdutoException;
import com.need4speed.api.models.Produto;
import com.need4speed.api.services.ProdutoService;
import com.need4speed.api.validators.ProdutoValidator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoValidator produtoValidator;
    private ProdutoService produtoService;

    public ProdutoController(ProdutoValidator produtoValidator, ProdutoService produtoService) {
        this.produtoValidator = produtoValidator;
        this.produtoService = produtoService;
    }

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

    @GetMapping("/")
    public ResponseEntity<List<Produto>> listarProdutos (){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto (@PathVariable(value = "id") UUID id){
       try {
           Object produto =  produtoService.buscarProduto(id);
           return ResponseEntity.status(HttpStatus.OK).body(produto);
       } catch (ProdutoException erro) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o produto!");
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto (@PathVariable(value = "id") UUID id){
        try {
           produtoService.excluirProduto(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto Excluido com Sucesso");
        } catch (ProdutoException erro) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o produto!");
        }
    }
}
