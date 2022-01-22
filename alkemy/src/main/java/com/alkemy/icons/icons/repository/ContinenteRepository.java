package com.alkemy.icons.icons.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



import com.alkemy.icons.icons.entity.ContinenteEntity;


@Repository
public interface ContinenteRepository extends JpaRepository<ContinenteEntity, Long>{

}
