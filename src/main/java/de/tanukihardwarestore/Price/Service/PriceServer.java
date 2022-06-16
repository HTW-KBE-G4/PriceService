package de.tanukihardwarestore.Price.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

public class PriceServer {

    @RabbitListener(queues = "tanuki.currency.requests")
    @SendTo("tanuki.currency.replies")
    public Result receive(List<HardwareComponent> req) {
        double res = PriceCalculator.addPrices(req);
        return new Result(res);
    }

}
