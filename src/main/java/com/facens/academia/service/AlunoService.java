package com.facens.academia.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.facens.academia.entity.Aluno;
import com.facens.academia.entity.Plano;
import com.facens.academia.repository.AlunoRepository;
import com.facens.academia.repository.PlanoRepository;
import com.facens.academia.dto.request.AlunoRequest;
import com.facens.academia.exception.RegraNegocioException;
import com.facens.academia.exception.RecursoNaoEncontradoException;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public Aluno cadastrarAluno(AlunoRequest request) {

        if (alunoRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegraNegocioException("Email já cadastrado");
        }

        Plano plano = planoRepository.findById(request.getPlanoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado"));

        Aluno aluno = new Aluno();

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setIdade(request.getIdade());
        aluno.setTelefone(request.getTelefone());
        aluno.setSituacao(request.getSituacao());
        aluno.setPlano(plano);

        return alunoRepository.save(aluno);
    }
}