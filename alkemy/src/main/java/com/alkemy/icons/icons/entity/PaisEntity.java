package com.alkemy.icons.icons.entity;

import java.util.*;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name ="pais")
@Getter
@Setter
public class PaisEntity {
	//la columna se va a llamar id
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String imagen;
	private String denominacion;
	
	//Como el nombre del atributo difiere del nombre en la BD se usa el @Column
	@Column(name = "cant_habitantes")
	private long cantidadHabitantes;
	
	private long superficie; //km2
	
	//Defino la relacion de 1 a muchos (muchos paises a un continente -linea 29-)
	//EAGER inicializacion temprana, cascade -todas las operaciones son consecuentes-
	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	//como joineo la tabla a continente, insertable y updatable son false porque los uso solamente para levantar informacion
	@JoinColumn(name = "continente_id", insertable= false, updatable= false)
	private ContinenteEntity continente;
	
	@Column(name= "continente_id", nullable=false)
	private long continenteId;
	
	/*aplico definicion de ManyToMany en paises porque "engloban" a los iconos
	cuando creo un pais puedo pasarle una lista de iconos*/
	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	//Defino el join entre ambas tablas creando una tabla intermedia (icon-pais)
	@JoinTable(
			name= "icon_pais",
			joinColumns = @JoinColumn(name="pais_id"),
			inverseJoinColumns = @JoinColumn(name="icon_id"))
	private Set<IconEntity> icons = new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(cantidadHabitantes, continente, continenteId, denominacion, icons, id, imagen, superficie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisEntity other = (PaisEntity) obj;
		return cantidadHabitantes == other.cantidadHabitantes && Objects.equals(continente, other.continente)
				&& continenteId == other.continenteId && Objects.equals(denominacion, other.denominacion)
				&& Objects.equals(icons, other.icons) && id == other.id && Objects.equals(imagen, other.imagen)
				&& superficie == other.superficie;
	}
	
	
	
}
