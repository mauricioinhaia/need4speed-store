package com.need4speed.api.models;

import com.need4speed.api.enums.StatusPedido;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private StatusPedido status;
    @Transient
    private List<Produto> produtos;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensPedido> itensPedido;

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public LocalDate getData() {return data;}

    public void setData(LocalDate data) {this.data = data;}

    public StatusPedido getStatus() {return status;}

    public void setStatus(StatusPedido status) {this.status = status;}

    public List<Produto> getProdutos() {return produtos;}

    public void setProdutos(List<Produto> produtos) {this.produtos = produtos;}

    public List<ItensPedido> getItensPedido() {return itensPedido;}

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
