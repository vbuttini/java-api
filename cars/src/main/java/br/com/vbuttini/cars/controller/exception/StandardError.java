package br.com.vbuttini.cars.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vinícius Buttini
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
