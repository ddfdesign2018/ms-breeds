package com.ddfdesign.msbreeds.repository;

import com.ddfdesign.msbreeds.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBreedsRepository extends JpaRepository<Breed, Long> {
}
