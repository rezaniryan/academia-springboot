package com.facens.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facens.academia.entity.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
