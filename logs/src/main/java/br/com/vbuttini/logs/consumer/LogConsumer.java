package br.com.vbuttini.logs.consumer;

import br.com.vbuttini.logs.entity.Log;
import br.com.vbuttini.logs.service.LogService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * This class consume the log queue on the RabbitMQ server.
 * @author Vinicius Buttini
 */
@Component
public class LogConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("{{log.endpoint}}")
                .log("Received message: ${body}")
                .unmarshal().json(Log.class)
                .bean(LogService.class, "insertLog");
    }
}
