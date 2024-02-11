package io.github.clarauso.storage.fnframework;

import com.google.cloud.functions.CloudEventsFunction;
import com.google.events.cloud.storage.v1.StorageObjectData;
import com.google.protobuf.util.JsonFormat;
import io.cloudevents.CloudEvent;

import java.nio.charset.StandardCharsets;

public class SecondGenFunction implements CloudEventsFunction {
  @Override
  public void accept(CloudEvent cloudEvent) throws Exception {
    String cloudEventData = new String(cloudEvent.getData().toBytes(), StandardCharsets.UTF_8);
    StorageObjectData.Builder builder = StorageObjectData.newBuilder();
    JsonFormat.parser().merge(cloudEventData, builder);
    // TODO can this be used with v1?
    StorageObjectData data = builder.build();

    System.out.println("Triggered gen2");
    System.out.println(data.getBucket());
  }
}
