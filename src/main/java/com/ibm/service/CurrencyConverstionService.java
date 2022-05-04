package com.ibm.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.model.CurrencyConversion;
import com.ibm.repository.CurrencyConverstionRepository;

@Service
public class CurrencyConverstionService {

	@Autowired
	CurrencyConverstionRepository currencyConverstionRepository;
	
	public CurrencyConversion getCurrnecyConvertionByCountryCode(String countryCode) {
		return currencyConverstionRepository.findByCountryCode(countryCode);
	}


	public CurrencyConversion updateCurrencyById(@Valid CurrencyConversion currencyConversion) {
		return currencyConverstionRepository.saveAndFlush(currencyConversion);
	}

	public CurrencyConversion addConversionConvert(@Valid CurrencyConversion currencyConversion) {
		return currencyConverstionRepository.saveAndFlush(currencyConversion);
	}

	
	
	

}
