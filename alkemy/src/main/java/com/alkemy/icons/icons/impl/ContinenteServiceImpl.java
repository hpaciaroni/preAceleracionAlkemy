package com.alkemy.icons.icons.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;

//componente tipo servicio
@Service
public class ContinenteServiceImpl implements ContinenteService{
	
	@Autowired
	private ContinenteMapper continenteMapper;
	@Autowired
	private ContinenteRepository continenteRepository;
	
	public ContinenteDTO save (ContinenteDTO dto) {
		/*
		ContinenteEntity entity = ContinenteMapper.continenteDTO2Entity(dto);
		ContinenteEntity entitySaved = continenteRepository.save(entity);
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
		return result;
				 */
		return null;
	}
	public 	List<ContinenteDTO> getAllContinentes(){
		List<ContinenteEntity> entities = continenteRepository.findAll();
		List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
		return result;
	}

}