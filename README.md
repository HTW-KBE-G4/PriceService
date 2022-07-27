
# PriceService

Takes a Component List and sums up each Component price

## Price sum calculator

This Service listens on Rabbit RPC-Queues defined in the following file: [RabbitMQConfig](src/main/java/de/tanukihardwarestore/Price/Service/RabbitMQConfig.java).

Following Request is expected: `List<HardwareComponent`.
 
The Result is described in the following file: [Result](src/main/java/de/tanukihardwarestore/Price/Service/Result.java)
