package com.Laskutusohjelma.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TyoRepository extends CrudRepository <Tyo, Long> {
	
	Optional<Tyo> findById(Long id);

}
