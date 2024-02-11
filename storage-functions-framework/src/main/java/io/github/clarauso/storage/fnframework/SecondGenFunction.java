package io.github.clarauso.storage.fnframework;

import com.google.cloud.functions.CloudEventsFunction;
import com.google.events.cloud.storage.v1.StorageObjectData;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.logging.Logger;

public class SecondGenFunction implements CloudEventsFunction {

  private static final Logger logger = Logger.getLogger(SecondGenFunction.class.getName());

  @Override
  public void accept(CloudEvent cloudEvent) throws InvalidProtocolBufferException {
    String dataString =
        Optional.ofNullable(cloudEvent.getData())
            .map(CloudEventData::toBytes)
            .map(bytes -> new String(bytes, StandardCharsets.UTF_8))
            .orElse("");

    StorageObjectData.Builder builder = StorageObjectData.newBuilder();
    JsonFormat.parser().merge(dataString, builder);

    StorageObjectData data = builder.build();

    final var msg = String.format("Event on bucket=%s name=%s", data.getBucket(), data.getName());

    logger.info(msg);
  }
}
