package com.need4speed.api.repositories;

import com.need4speed.api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, UUID>{
}
