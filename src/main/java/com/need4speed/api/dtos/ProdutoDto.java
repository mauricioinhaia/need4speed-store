package com.need4speed.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProdutoDto(@NotNull String descricao, @NotNull BigDecimal valor, @NotNull Boolean servico, Boolean inativo) {
}
