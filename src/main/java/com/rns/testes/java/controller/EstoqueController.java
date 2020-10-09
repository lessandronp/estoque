package com.rns.testes.java.controller;

import javax.ws.rs.FormParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.exception.ValidationException;
import com.rns.testes.java.service.IEstoqueService;

@CrossOrigin
@RestController
@RequestMapping
public class EstoqueController {

    private static final String BASE_URL = "estoque/";
    private static final Logger logger = LoggerFactory.getLogger(EstoqueController.class);

    @Autowired
    IEstoqueService service;

    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> findAll() {
	try {
	    return ResponseEntity.ok(service.buscaEstoques());
	} catch (ValidationException e) {
	    logger.error(e.getMessage());
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }

    @PutMapping(value = BASE_URL + "updateProdutoFilial", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> updateProdutoFilial(@FormParam("codProd") String codProd,
	    @FormParam("cnpjFilialOrig") String cnpjFilialOrig,
	    @FormParam("cnpjFilialDest") String cnpjFilialDest) {
	try {
	    EstoqueDto estoqueDto = service.updateProdutoFilial(codProd, cnpjFilialOrig, cnpjFilialDest);
	    return ResponseEntity.ok(estoqueDto);
	} catch (ValidationException e) {
	    logger.error(e.getMessage());
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }
}
