package io.github.clarauso.storage.fnframework;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import io.github.clarauso.generated.StorageObjectData;
import java.util.logging.Logger;

public class FirstGenFunction implements BackgroundFunction<StorageObjectData> {

  private static final Logger logger = Logger.getLogger(FirstGenFunction.class.getName());

  @Override
  public void accept(StorageObjectData data, Context context) {

    final var msg = String.format("Event on bucket=%s name=%s", data.getBucket(), data.getName());

    logger.info(msg);
  }
}
