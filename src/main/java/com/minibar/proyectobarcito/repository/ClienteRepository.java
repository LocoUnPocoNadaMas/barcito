package com.minibar.proyectobarcito.repository;

import com.minibar.proyectobarcito.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClientModel, Long> {
}
