package br.com.vbuttini.cars.service;

import br.com.vbuttini.cars.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vinicius Buttini
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsService {

    @Value("${external.api.url}")
    private String externalApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Car> findCarsList() {
        var url = externalApiUrl + "/api/cars";
        return restTemplate.getForObject(url, List.class);
    }
}
