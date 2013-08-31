package com.javax0.scriapt.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.javax0.aptools.Environment;
import com.javax0.scriapt.domain.Annotation;
import com.javax0.scriapt.domain.Klass;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ScriaptProcessor extends AbstractProcessor {

  private final Map<String, Klass> classes = new HashMap<>();

  private void processAnnotation(AnnotationMirror annotationMirror, Annotation annotation){
    
  }
  
  private void processClass(Element element, Klass klass) {
    for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
      Annotation annotation = new Annotation();
      processAnnotation(annotationMirror, annotation);
      String annotationName = annotationMirror.getAnnotationType().toString();
      klass.put(annotationName,annotation);
    }
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Environment.set(processingEnv);
    for (Element rootElement : roundEnv.getRootElements()) {
      String className = rootElement.getSimpleName().toString();
      Klass klass = new Klass();
      classes.put(className, klass);
      processClass(rootElement, klass);
    }
    return false;
  }
}
