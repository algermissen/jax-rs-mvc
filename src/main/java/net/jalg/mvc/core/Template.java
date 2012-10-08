package net.jalg.mvc.core;
import java.lang.annotation.*;

import javax.ws.rs.NameBinding;


@NameBinding
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Template {
        String value() default "";
}

