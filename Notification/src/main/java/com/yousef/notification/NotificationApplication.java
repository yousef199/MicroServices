package com.yousef.notification;

import com.yousef.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.yousef.notification",
                "com.yousef.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class , args);
    }

    CommandLineRunner commandLineRunner(RabbitMQMessageProducer rabbitMQMessageProducer , NotificationConfig notificationConfig){
        return args -> {
            rabbitMQMessageProducer.publish("foo" , notificationConfig.getInternalExchange() , notificationConfig.getRoutingKeys());
        };
    }
}
