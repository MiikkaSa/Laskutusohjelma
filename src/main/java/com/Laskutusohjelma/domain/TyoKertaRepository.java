package com.Laskutusohjelma.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TyoKertaRepository extends CrudRepository <TyoKerta, Long> {
	
	List<TyoKerta> findBytyoId(Long tyoId);

}
