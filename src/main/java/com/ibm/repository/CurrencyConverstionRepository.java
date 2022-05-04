package com.ibm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.CurrencyConversion;

@Repository
public interface CurrencyConverstionRepository extends JpaRepository<CurrencyConversion, UUID> {


	CurrencyConversion findByCountryCode(String countryCode);

}
