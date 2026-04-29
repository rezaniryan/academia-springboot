package com.facens.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facens.academia.entity.Aluno;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);
}