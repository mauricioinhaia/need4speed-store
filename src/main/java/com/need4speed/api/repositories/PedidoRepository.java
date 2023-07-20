package com.need4speed.api.repositories;

import com.need4speed.api.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository <Pedido, UUID> {
}
