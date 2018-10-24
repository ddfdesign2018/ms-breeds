package com.ddfdesign.msbreeds.service;

import com.ddfdesign.msbreeds.rest.dto.BreedDTO;

import java.util.List;

public interface IGestionBreeds {

   List<BreedDTO> getAllBreeds();
   BreedDTO getBreedById(Long idBreed);
   BreedDTO createBreedById(BreedDTO specyDTO);
   boolean deleteBreedById(Long idBreed);
   boolean updateBreedById(BreedDTO breedDTO);
}
