package br.com.vbuttini.cars.service;

import br.com.vbuttini.cars.dto.LogDto;
import br.com.vbuttini.cars.entity.Car;
import br.com.vbuttini.cars.factory.LocalDateTimeFactory;
import br.com.vbuttini.cars.service.exception.DataBaseException;
import br.com.vbuttini.cars.util.ObjectConverterUtil;
import lombok.RequiredArgsConstructor;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

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
        var carSaved = restTemplate.postForEntity(url, car, Car.class).getBody();

        if (Objects.isNull(carSaved)) {
            throw new DataBaseException("Carro não retornado");
        }

        var logDto = LogDto.builder()
                .carId(carSaved.get_id())
                .dateTime(LocalDateTimeFactory.now())
                .build();

        var logJson = objectConverterUtil.toJson(logDto);
        producerTemplateLog.sendBody(logJson);

        return carSaved;
    }
}