package br.com.vbuttini.cars.service;

import br.com.vbuttini.cars.entity.Car;
import br.com.vbuttini.cars.util.ObjectConverterUtil;
import lombok.RequiredArgsConstructor;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
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

    @EndpointInject("{{log.endpoint}}")
    private final ProducerTemplate producerTemplateLog;

    private final String ENDPOINT_URI = "/api/cars";

    private final ObjectConverterUtil objectConverterUtil;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Car> findCarsList() {
        var url = externalApiUrl + ENDPOINT_URI;
        return restTemplate.getForObject(url, List.class);
    }

    public Car insertCar(Car car) {
        var url = externalApiUrl + ENDPOINT_URI;
        var carSaved = restTemplate.postForObject(url, car, Car.class);

        var json = objectConverterUtil.toJson(carSaved);
        producerTemplateLog.sendBody(json);
        return carSaved;
    }
}