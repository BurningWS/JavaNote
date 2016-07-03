package schema.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;


@Component
public class MoocAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("MoocAfterReturningAdvice : " + method.getName()
				+ "     " + target.getClass().getName() + "       "
				+ returnValue);
	}

}
