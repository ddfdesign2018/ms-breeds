package com.ddfdesign.msbreeds.rest;


import com.ddfdesign.msbreeds.feign.Specy;
import com.ddfdesign.msbreeds.feign.dto.SpecyDTO;
import com.ddfdesign.msbreeds.rest.dto.BreedDTO;
import com.ddfdesign.msbreeds.service.IGestionBreeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class BreedResource {

    @Autowired
    IGestionBreeds gestionBreeds;

    @Autowired
    Specy specy;

    @RequestMapping(value = "breed", method = RequestMethod.GET)
    public ResponseEntity<List<BreedDTO>> getAllBreeds() {
        List<BreedDTO> listaBreeds = gestionBreeds.getAllBreeds();
        System.out.println("Antes");
        System.out.println(specy.saludo());
        System.out.println("Despues");
        return ResponseEntity.ok(listaBreeds);
    }

    @RequestMapping(value = "breed/{idBreed}", method = RequestMethod.GET)
    public ResponseEntity<BreedDTO> getBreedByIdBreed(@PathVariable Long idBreed) {
        BreedDTO listaBreed = gestionBreeds.getBreedById(idBreed);
        return ResponseEntity.ok(listaBreed);
    }

    @RequestMapping(value = "breed", method = RequestMethod.POST)
    public ResponseEntity<Void> createBreed(@RequestBody BreedDTO breedDTO) {
        BreedDTO resultado = gestionBreeds.createBreedById(breedDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "breed/{idBreed}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBreed(@PathVariable Long idBreed) {
        String resultado = "";
        if (gestionBreeds.deleteBreedById(idBreed))
            resultado = "La breed con id " + idBreed + " Ha sido eliminado correctamente";
        else
            resultado = "La breed con id " + idBreed + " No se ha podido borrar";
        return ResponseEntity.ok(resultado);
    }

    @RequestMapping(value = "breed", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateBreed(@RequestBody BreedDTO breedDTO) {
        boolean resultado = gestionBreeds.updateBreedById(breedDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "breedList", method = RequestMethod.GET)
    public List<BreedDTO> getAllBreedsList() {
        List<BreedDTO> listaBreeds = gestionBreeds.getAllBreeds();
        return listaBreeds;
    }
}
