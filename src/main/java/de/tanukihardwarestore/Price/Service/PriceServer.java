package de.tanukihardwarestore.Price.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class PriceServer {

    @RabbitListener(queues = "price")
    public String receive(List<HardwareComponent> req) {
        double res = PriceCalculator.addPrices(req);
        String resultString = "";
        Result result = new Result(res);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            resultString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return resultString;
    }

}
