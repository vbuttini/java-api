package br.com.vbuttini.cars.controller;

import br.com.vbuttini.cars.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vinícius Buttini
 */
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsController {

    private final CarsService service;

    @GetMapping("/listCars")
    public ResponseEntity getCarsList(){
        return ResponseEntity.ok(service.findCarsList());
    }

}
