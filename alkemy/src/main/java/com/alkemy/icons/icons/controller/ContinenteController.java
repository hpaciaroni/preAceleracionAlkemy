package com.alkemy.icons.icons.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;



//Componente tipo com.alkemy.icons.icons.controller
@RestController
//base para acceder (el path) al com.alkemy.icons.icons.controller, en plural
@RequestMapping("continentes")
public class ContinenteController {
	// com.alkemy.icons.icons.service guarda a continente (linea 28). Spring inicializa con la anotacion autowired
	@Autowired
	public ContinenteService continenteService;
	
	@GetMapping
	public ResponseEntity<List<ContinenteDTO>> getAll(){
		List<ContinenteDTO> continentes = continenteService.getAllContinentes();
		return ResponseEntity.ok().body(continentes);
	}
	
	//Por cada endPoint va un verbo, en este caso Post
	@PostMapping
	public ResponseEntity<ContinenteDTO> save (@RequestBody ContinenteDTO continente){
		ContinenteDTO continenteGuardado = continenteService.save(continente);
		//devuelvo el status 201 y en el body el continenteGuardado
		return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
	}
}

