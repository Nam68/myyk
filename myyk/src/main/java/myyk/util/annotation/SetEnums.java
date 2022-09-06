package myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>이넘의 값들을 리퀘스트에 저장해주는 어노테이션.</p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetEnums {

	/**
	 * <p>리퀘스트에 저장하고 싶은 이넘을 설정한다.</p>
	 * <p>{enums.저장한 이넘의 이름}의 키값을 가지며, 리스트가 반환된다.</p>
	 */
	Class<?>[] values();
	
}
