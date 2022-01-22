package com.alkemy.icons.icons.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name = "icon")
	@Getter
	@Setter
// @Sof tDelete (diferente a Hard Delete)
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
// Determino los que realmente fueron borrados y los que no
@Where(clause= "deleted=false")
public class IconEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String denominacion;
	
	@Column(name = "fecha_creacion")
	//defino patron de fecha
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaCreacion;
	private Long altura;
	private String historia;

	private boolean deleted = Boolean.FALSE;

	@ManyToMany(mappedBy= "icons", cascade= CascadeType.ALL)
	private List<PaisEntity> paises = new ArrayList<>();
	

	//Add and remove paises
	public void addPais(PaisEntity pais) {this.paises.add(pais); }
	
	public void removePais(PaisEntity pais) {this.paises.remove(pais); }

}
