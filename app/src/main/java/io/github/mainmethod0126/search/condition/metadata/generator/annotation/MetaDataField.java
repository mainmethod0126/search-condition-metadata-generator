package io.github.mainmethod0126.search.condition.metadata.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is an annotation that allows you to directly specify the field values of
 * the generated metadata.
 * 
 * Note: The metadata field annotation is only applied to the last
 * primitive-type field of the domain object. If the annotation is added to a
 * non-primitive type, it will not work and will be ignored.
 * 
 * Here is an example of its usage.
 *
 *
 * Cases of Proper Functioning
 * public class TestUser {
 * \@MetaDataField(name = "pk", type = "number", operators = {"=", "!="})
 * private Long id;
 * }
 * 
 * 
 * Ignored Cases
 * public class TestOrder {
 * \@MetaDataField(name = "king", type = "string", operators = {"=", "!="})
 * private TestCustomer customer;
 * }
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetaDataField {

    String name() default "";

    String type() default "";

    String[] operators() default {};

}
