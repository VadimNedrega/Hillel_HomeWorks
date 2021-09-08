package vadim_nedrega.HW15_Annotations.MyAnnotations;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    Author [] author() default {};
    Deprecated info();
}
