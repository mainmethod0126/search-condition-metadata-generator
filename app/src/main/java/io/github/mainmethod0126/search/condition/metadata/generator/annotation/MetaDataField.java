package io.github.mainmethod0126.search.condition.metadata.generator.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetaDataField {

    String name() default "";

    String type() default "";

    String[] operators() default {};

}
