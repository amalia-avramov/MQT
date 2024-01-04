package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class WorkQueueConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(WorkQueueConsumer.class);
    private final static String QUEUE_NAME = "helloQueue";
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        LOG.info("aaaaaaaaaaa Work consumer: waiting for messages. aaaaaaaaaaaaaa");
        System.out.println("bbbbbbbbbbbbbb Work consumer: Waiting for messages. bbbbbbbbbbbbbbbb");

        DeliverCallback deliverCallback = ((consumerTag, message) -> {
            String receivedMessage = new String(message.getBody(), StandardCharsets.UTF_8);
            LOG.info("--------- Work consumer: work queue  RECEIVED  {} -----------------", receivedMessage);
            try {
                    doWork(receivedMessage);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                LOG.info("--------- work queue message {} processed -----------------", receivedMessage);
            }
        });
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }

    private static void doWork(String task) throws InterruptedException{
        for (char ch: task.toCharArray()){
            if (ch == '.')
                Thread.sleep(1000);
        }
    }
}
