package br.com.vbuttini.cars.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class contain the order model
 *
 * @author Vinicius Buttini
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    private String _id;
    private String title;
    private String brand;
    private String price;
    private Integer age;
    private Integer __v;

}
