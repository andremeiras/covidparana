package br.com.andremeiras.covidparana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andremeiras.covidparana.model.CasosEObitos;

@Repository
public interface CasosEObitosRepository extends JpaRepository<CasosEObitos, Long> {
    
}
