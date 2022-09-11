package com.lucasmaraia.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasmaraia.dsmeta.entidades.Sale;
import com.lucasmaraia.dsmeta.repositorios.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales(String minDate, String maxDate,Pageable pageable) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? hoje.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max,pageable);
	}
	
	

}
