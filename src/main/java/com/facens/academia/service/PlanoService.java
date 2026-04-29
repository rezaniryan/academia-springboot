package com.facens.academia.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.facens.academia.entity.Plano;
import com.facens.academia.repository.PlanoRepository;
import com.facens.academia.dto.request.PlanoRequest;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano criarPlano(PlanoRequest request) {
        Plano plano = new Plano();

        plano.setNome(request.nome);
        plano.setModalidade(request.modalidade);
        plano.setValorMensal(request.valorMensal);
        plano.setAtivo(true);

        return planoRepository.save(plano);
    }
}
