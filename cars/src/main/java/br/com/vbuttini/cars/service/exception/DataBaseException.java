package br.com.vbuttini.cars.service.exception;

/**
 * @author Vinícius Buttini
 */
public class DataBaseException extends RuntimeException {
    public DataBaseException(String msg) {
        super(msg);
    }
}
