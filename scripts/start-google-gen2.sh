#!/bin/sh

cd ../storage-functions-framework &&
  mvn function:run -Drun.functionTarget=io.github.clarauso.storage.fnframework.SecondGenFunction