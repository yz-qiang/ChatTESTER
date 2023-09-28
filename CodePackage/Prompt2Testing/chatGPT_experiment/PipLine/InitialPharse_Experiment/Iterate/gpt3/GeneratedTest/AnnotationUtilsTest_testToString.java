package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testToString
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.CURLY;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.LARRY;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.MOE;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.SHEMP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class AnnotationUtilsTest_testToString {
    @Retention(RUNTIME)
    @Target(FIELD)
    public @interface Stooge {
        String value() default "";
        int age() default 0;
        Stooge[] friends() default {};
        enum HairColor { BALD, BLONDE, BROWN, BLACK, RED, GREY };
        HairColor hairColor() default HairColor.BALD;
        Stooge[] enemies() default { SHEMP };
        public static final Stooge MOE = null;
        public static final Stooge LARRY = null;
        public static final Stooge CURLY = null;
    }
    @Test
    public void testToString() {
        @Stooge(value = "Moe Howard", age = 77, hairColor = Stooge.HairColor.BROWN, friends = { LARRY, CURLY })
        class Moe {
            @Stooge("Larry Fine")
            private Stooge larry;
            @Stooge(value = "Curly Howard", hairColor = Stooge.HairColor.BLONDE, enemies = { MOE })
            private Stooge curly;
            @Stooge("Shemp Howard")
            private Stooge shemp;
            @Override
            public String toString() {
                return AnnotationUtils.toString(getClass().getAnnotation(Stooge.class));
            }
        }
        Moe moe = new Moe();
        String expected = "@Stooge(value=Moe Howard, age=77, hairColor=BROWN, friends=[@Stooge(value=Larry Fine), @Stooge(value=Curly Howard, hairColor=BLONDE, enemies=[@Stooge(value=Moe Howard)])], enemies=[@Stooge(value=Shemp Howard)])";
        Assert.assertEquals(expected, moe.toString());
    }
}