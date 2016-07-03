package beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)  // only effective to List
@Component
public class BeanImplOne implements BeanInterface {
	private BeanImplOne() {
		System.out.println("BeanImplOne()..");
	}
}