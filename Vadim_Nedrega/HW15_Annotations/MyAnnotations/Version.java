package vadim_nedrega.HW15_Annotations.MyAnnotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Version {
    int value() default 0;
}
