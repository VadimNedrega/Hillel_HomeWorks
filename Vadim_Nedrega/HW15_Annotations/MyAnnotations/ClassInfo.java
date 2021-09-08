package vadim_nedrega.HW15_Annotations.MyAnnotations;

import java.lang.annotation.*;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClassInfo {
    Author [] author () default {};
    Version version();
}
