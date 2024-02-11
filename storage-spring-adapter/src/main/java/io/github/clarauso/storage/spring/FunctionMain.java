package io.github.clarauso.storage.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.events.cloud.storage.v1.StorageObjectData;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.json.JacksonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MessageConverter;

@SpringBootApplication
public class FunctionMain {

  final Logger logger = LoggerFactory.getLogger(FunctionMain.class);

  public static void main(String[] args) {
    SpringApplication.run(FunctionMain.class, args);
  }

  @Bean
  public Consumer<Message<StorageObjectData>> consumer() {
    return message -> {
      StorageObjectData storageObjectData = message.getPayload();
      logger.info(
          "Event on bucket={} name={}", storageObjectData.getBucket(), storageObjectData.getName());
    };
  }

  @Bean
  public MessageConverter messageConverter() {
    return new StorageObjectDataMessageConverter(new JacksonMapper(new ObjectMapper()));
  }
}
