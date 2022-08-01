package br.com.vbuttini.cars.factory;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * This class generate the current date and time.
 * Can not be instantiated.
 * @author Vinicius Buttini
 */
public class LocalDateTimeFactory {

    private LocalDateTimeFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
