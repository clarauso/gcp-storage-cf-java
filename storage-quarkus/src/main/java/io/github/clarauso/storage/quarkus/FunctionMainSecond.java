package io.github.clarauso.storage.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import com.google.cloud.functions.CloudEventsFunction;

import io.cloudevents.CloudEvent;

@Named("functionMainSecond")
@ApplicationScoped
public class FunctionMainSecond implements CloudEventsFunction {

  private final EventConsumer consumer;

  public FunctionMainSecond(EventConsumer consumer) {
    this.consumer = consumer;
  }

  @Override
  public void accept(CloudEvent cloudEvent) {
    consumer.accept(cloudEvent);
  }
}
