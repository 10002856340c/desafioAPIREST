package com.deg.clientservice.repository;

import com.deg.clientservice.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Long> {
}
