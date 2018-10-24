package com.ddfdesign.msbreeds.service;

import com.ddfdesign.msbreeds.entity.Breed;
import com.ddfdesign.msbreeds.repository.IBreedsRepository;
import com.ddfdesign.msbreeds.rest.dto.BreedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionBreeds implements IGestionBreeds{

    @Autowired
    IBreedsRepository breedsRepository;

    @Override
    public List<BreedDTO> getAllBreeds () {
        List<BreedDTO> lista = breedsRepository.findAll()
                .stream()
                .map(
                        breedEntity -> new BreedDTO(
                                breedEntity.getId(),
                                breedEntity.getName(),
                                breedEntity.getJunior_price(),
                                breedEntity.getAdult_price(),
                                breedEntity.getSpecy()
                        )
                ).collect(Collectors.toList());
        return lista;
    }

    @Override
    public BreedDTO getBreedById(Long idBreed){
        Optional<Breed> breedOptional = breedsRepository.findById(idBreed);
        Breed breed = breedOptional.get();
        BreedDTO breedDTO = new BreedDTO(
                breed.getId(),
                breed.getName(),
                breed.getJunior_price(),
                breed.getAdult_price(),
                breed.getSpecy()
        );
        return breedDTO;
    }

    @Override
    public BreedDTO createBreedById(BreedDTO breedDTO){
        Breed breed = new Breed(
                null,
                breedDTO.getName(),
                breedDTO.getJunior_price(),
                breedDTO.getAdult_price(),
                breedDTO.getSpecy()
        );
        Breed resultado = breedsRepository.save(breed);
        return new BreedDTO(resultado.getId(),
                resultado.getName(),
                resultado.getJunior_price(),
                resultado.getAdult_price(),
                resultado.getSpecy()
        );
    }

    @Override
    public boolean deleteBreedById(Long idBreed){
        boolean resultado = false;
        breedsRepository.deleteById(idBreed);
        Optional<Breed> breedOptional = breedsRepository.findById(idBreed);
        if (!breedOptional.isPresent())
            resultado = true;
        return resultado;
    }

    @Override
    public boolean updateBreedById(BreedDTO breedDTO){
        Breed breed = new Breed(
                breedDTO.getId(),
                breedDTO.getName(),
                breedDTO.getJunior_price(),
                breedDTO.getAdult_price(),
                breedDTO.getSpecy()
        );
        breedsRepository.save(breed);
        return true;
    }
}
