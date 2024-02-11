package io.github.clarauso.storage.fnframework;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;


public class FirstGenFunction implements BackgroundFunction<String> {

  @Override
  public void accept(String storageObjectData, Context context) {

    //System.out.println(storageObjectData.getBucket());
  }
}
