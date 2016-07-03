package aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContext implements ApplicationContextAware {

    private ApplicationContext con;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("MyApplicationContext : "
                + applicationContext.getBean("myapp")
                .hashCode());

        con = applicationContext;   // DI con, so we can use con do other things..
    }

}
