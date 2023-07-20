package com.need4speed.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

public class ItensPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;
    }

    public Pedido getPedido() {return pedido;}

    public void setPedido(Pedido pedido) {this.pedido = pedido;}

    public Produto getProduto() {return produto;}

    public void setProduto(Produto produto) {this.produto = produto;}
}
