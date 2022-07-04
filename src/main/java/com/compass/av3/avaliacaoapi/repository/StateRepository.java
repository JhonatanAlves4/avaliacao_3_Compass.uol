package com.compass.av3.avaliacaoapi.repository;

import com.compass.av3.avaliacaoapi.model.State;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByOrderByPopulacaoDescAreaDesc();
    List<State> findByRegiaoOrderByPopulacaoDescAreaDesc(String regiao);

}
