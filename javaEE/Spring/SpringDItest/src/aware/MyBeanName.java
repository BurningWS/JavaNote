package aware;

import org.springframework.beans.factory.BeanNameAware;

public class MyBeanName implements BeanNameAware {

	private String beanName;

	@Override
	public void setBeanName(String name) {		// DI beanName, bean id is its value
		this.beanName = name;
		System.out.println("MoocBeanName : " + name);
	}

	
}
