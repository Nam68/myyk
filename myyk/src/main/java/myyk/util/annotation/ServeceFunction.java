package myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import myyk.util.enumeration.ServiceFunction;

/**
 * <p>해당 기능의 카테고리를 부여하는 어노테이션.</p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServeceFunction {
	
	/**
	 * <p>해당 기능의 카테고리를 {@link ServiceFunction}을 통해 설정한다.</p>
	 * 
	 * @return ServiceFunction
	 */
	ServiceFunction value() default ServiceFunction.HOME;
	
}
