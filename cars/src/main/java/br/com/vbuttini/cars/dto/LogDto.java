package br.com.vbuttini.cars.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * This class is a DTO from Log class.
 * @author Vinicius Buttini
 */
@Getter
@Setter
@Builder
public class LogDto {

    private String id;

    private LocalDateTime dateTime;

    private String carId;

}
