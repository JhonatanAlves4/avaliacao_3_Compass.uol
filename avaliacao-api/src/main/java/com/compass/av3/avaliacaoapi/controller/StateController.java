package com.compass.av3.avaliacaoapi.controller;

import com.compass.av3.avaliacaoapi.config.validation.ApiRequestException;
import com.compass.av3.avaliacaoapi.dto.StateDTO;
import com.compass.av3.avaliacaoapi.dto.StateRequest;
import com.compass.av3.avaliacaoapi.model.State;
import com.compass.av3.avaliacaoapi.model.StateRegion;
import com.compass.av3.avaliacaoapi.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Convert;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateDTO> findStates(@RequestParam(required = false) String regiao) {
        if (regiao == null) {
            return stateService.findStates();
        } else {
            return stateService.findStatesByRegion(regiao);
        }
    }

    @GetMapping("/{id}")
    public StateDTO findById(@PathVariable Long id) {
        return stateService.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateDTO> save(@RequestBody StateRequest stateRequest, UriComponentsBuilder uriComponentsBuilder) {
        State state = stateService.save(stateRequest);

        URI uri = uriComponentsBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDTO(state));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDTO> update(@PathVariable Long id, @RequestBody StateRequest stateRequest) {
        State state = stateService.update(id, stateRequest);
        if (state != null) {
            return ResponseEntity.ok(new StateDTO(state));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<State> optional = stateService.delete(id);

        if (optional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
