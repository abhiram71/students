package com.adfolks.student.projectStudentMS1;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQconfig {
    public static final String QUEUESAVE = "queue_save_student";
    public static final String QUEUEDELETE = "queue_delete_student";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY_SAVE = "queue_save_student";
    public static final String ROUTING_KEY_DELETE= "queue_delete_student";
    @Bean
    public Queue queueSave() {
        return new Queue(QUEUESAVE);
    }
    @Bean
    public Queue queueDelete() {
        return new Queue(QUEUEDELETE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Binding binding(Queue queueSave, TopicExchange exchange) {
        return BindingBuilder.bind(queueSave).to(exchange).with(ROUTING_KEY_SAVE);
    }

    @Bean
    public Binding bindingdelete(Queue queueDelete, TopicExchange exchange) {
        return BindingBuilder.bind(queueDelete).to(exchange).with(ROUTING_KEY_DELETE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
