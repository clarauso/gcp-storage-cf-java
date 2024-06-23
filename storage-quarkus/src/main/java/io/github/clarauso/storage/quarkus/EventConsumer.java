package io.github.clarauso.storage.quarkus;

import io.cloudevents.CloudEvent;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Consumer;

@ApplicationScoped
public class EventConsumer implements Consumer<CloudEvent> {

  @Override
  public void accept(CloudEvent cloudEvent) {
    System.out.println("Receive event Id: " + cloudEvent.getId());
    System.out.println("Receive event Subject: " + cloudEvent.getSubject());
    System.out.println("Receive event Type: " + cloudEvent.getType());
    System.out.println("Receive event Data: " + new String(cloudEvent.getData().toBytes()));
  }
}
