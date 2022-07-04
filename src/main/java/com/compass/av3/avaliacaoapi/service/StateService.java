package com.compass.av3.avaliacaoapi.service;

import com.compass.av3.avaliacaoapi.config.validation.ApiRequestException;
import com.compass.av3.avaliacaoapi.dto.StateDTO;
import com.compass.av3.avaliacaoapi.dto.StateRequest;
import com.compass.av3.avaliacaoapi.model.State;
import com.compass.av3.avaliacaoapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<StateDTO> findStates() {
        List<State> findAll = stateRepository.findByOrderByPopulacaoDescAreaDesc();
        return StateDTO.converter(findAll);
    }

    public List<StateDTO> findStatesByRegion(String regiao) {
        List<State> findStatesByRegion = stateRepository.findByRegiaoOrderByPopulacaoDescAreaDesc(regiao);
        return StateDTO.converter(findStatesByRegion);
    }

    public StateDTO findById(Long id) {
        try {
            State stateId = stateRepository.getReferenceById(id);
            return new StateDTO(stateId);

        } catch (Exception e) {
            throw new ApiRequestException("Erro, estado não encontrado");
        }

    }

    public State save(StateRequest stateRequest) {
        try {
            State state = stateRequest.toState();

            return stateRepository.save(state);
        } catch (Exception e) {
            throw new ApiRequestException("Erro, de sintaxe");
        }

    }


    public State update(Long id, StateRequest stateRequest) {
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            State state = stateRequest.update(id, stateRepository);

            return state;
        }

        return null;
    }

    public Optional<State> delete(Long id) {
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            stateRepository.deleteById(id);
            return optional;
        }

        return Optional.empty();
    }

}
