package com.examplecom.devsuperior.dsvendas.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examplecom.devsuperior.dsvendas.dto.SaleDTO;
import com.examplecom.devsuperior.dsvendas.dto.SaleSumDTO;
import com.examplecom.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.examplecom.devsuperior.dsvendas.entities.Sale;
import com.examplecom.devsuperior.dsvendas.repositories.SaleRepository;
import com.examplecom.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
		}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupdBySeller(){
	return repository.amountGroupdBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupdBySeller(){
	return repository.successGroupdBySeller();
	}
}
