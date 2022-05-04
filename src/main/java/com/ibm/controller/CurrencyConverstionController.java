package com.ibm.controller;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ibm.model.CurrencyConversion;
import com.ibm.service.CurrencyConverstionService;


@RestController
@RequestMapping("/currency")
public class CurrencyConverstionController {
	
	@Autowired
	CurrencyConverstionService currencyConversionService;
	
	
	
	  @GetMapping("/{countryCode}") 
	  public CurrencyConversion getCurrnecyConvertionByCountryCode(@PathVariable String countryCode) {
	  
		  CurrencyConversion currencyConverstionModel=currencyConversionService.getCurrnecyConvertionByCountryCode(countryCode);
	  if(currencyConverstionModel.equals(null))
	  {
		  throw new NullPointerException();
	  }
		  return currencyConversionService.getCurrnecyConvertionByCountryCode(countryCode);
	  }
	 
	
	
	@PostMapping
	public ResponseEntity<CurrencyConversion>  addCurrencyConverstion(@Valid @RequestBody CurrencyConversion currencyConversion)
	{
		CurrencyConversion result = currencyConversionService.addConversionConvert(currencyConversion);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getCountryCode()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CurrencyConversion> updateCurrencyFactor(@PathVariable UUID id,@Valid  @RequestBody CurrencyConversion currencyConversion)
	{
		CurrencyConversion result = currencyConversionService.updateCurrencyById(currencyConversion);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getCountryCode()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	
	

}
