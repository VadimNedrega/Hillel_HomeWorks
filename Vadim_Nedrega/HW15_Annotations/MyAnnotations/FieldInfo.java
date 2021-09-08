package vadim_nedrega.HW15_Annotations.MyAnnotations;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FieldInfo {
    Author [] author() default {};
    String usingInfo() default "Use";
}
