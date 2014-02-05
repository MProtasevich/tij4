package annotations.ex01;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotations.Constraints;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLLong {
    String name() default "";

    Constraints constraints() default @Constraints;
}
