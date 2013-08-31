package com.javax0.scriapt.domain;

import java.util.HashMap;
import java.util.Map;

public class Klass {

  private Map<String, Annotation> annotationMap = new HashMap<>();

  public void put(String name, Annotation annotation) {
    annotationMap.put(name, annotation);
  }
}
