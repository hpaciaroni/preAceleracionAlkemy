package com.alkemy.icons.icons.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;

//Es de tipo componente generico, no es de servicio o com.alkemy.icons.icons.repository
@Component
//Mapper convierte los com.alkemy.icons.icons.dto en entidades y entidades en com.alkemy.icons.icons.dto
public class ContinenteMapper {
	
	// le llega un com.alkemy.icons.icons.dto y lo pasa a com.alkemy.icons.icons.entity
	public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
		ContinenteEntity continenteEntity = new ContinenteEntity();
		continenteEntity.setImagen(dto.getImagen());
		continenteEntity.setDenominacion(dto.getDenominacion());
		return continenteEntity;
	}
	// metodo inverso al que esta arriba
	public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
		ContinenteDTO dto = new ContinenteDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		return dto;
		
	}
	public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities) {
		List<ContinenteDTO> dtos = new ArrayList<>();
		for(ContinenteEntity entity : entities) {
			dtos.add(this.continenteEntity2DTO(entity));
		}
		return dtos;
	}
}
