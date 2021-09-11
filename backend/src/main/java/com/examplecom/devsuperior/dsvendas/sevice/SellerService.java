package com.examplecom.devsuperior.dsvendas.sevice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplecom.devsuperior.dsvendas.dto.SellerDTO;
import com.examplecom.devsuperior.dsvendas.entities.Seller;
import com.examplecom.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
		
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		}
}
