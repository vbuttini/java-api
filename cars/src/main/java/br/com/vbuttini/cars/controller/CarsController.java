package br.com.vbuttini.cars.controller;

import br.com.vbuttini.cars.entity.Car;
import br.com.vbuttini.cars.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Vinícius Buttini
 */
@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsController {

    private final CarsService service;

    @GetMapping("/listCars")
    public ResponseEntity<List<Car>> getCarsList(){
        return ResponseEntity.ok(service.findCarsList());
    }

    @PostMapping("/createCar")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        var carSaved = service.insertCar(car);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(carSaved.get_id()).toUri();
        return ResponseEntity.created(uri).body(carSaved);
    }

}
