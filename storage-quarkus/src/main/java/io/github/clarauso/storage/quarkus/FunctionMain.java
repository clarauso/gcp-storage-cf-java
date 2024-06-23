package io.github.clarauso.storage.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;

@Named("functionMain")
@ApplicationScoped
public class FunctionMain implements BackgroundFunction<FunctionMain.StorageEvent> {

  @Override
  public void accept(StorageEvent event, Context context) throws Exception {
    System.out.println("Receive event: " + event);
  }

  //
  public static class StorageEvent {
    public String name;

    @Override
    public String toString() {
      return "StorageEvent{" + "name='" + name + '\'' + '}';
    }
  }
}
