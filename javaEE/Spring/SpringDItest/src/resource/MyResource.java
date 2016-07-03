package resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MyResource implements ApplicationContextAware {

	private ApplicationContext con;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		con = applicationContext;
	}

	public void testResource() throws IOException {
		Resource r = con.getResource("http://ask.csdn.net/questions/160360"); // "classpath:config.txt"
		// "file:D:\\jWorkPlace\\SpringDItest\\Resource\\config.txt"
		System.out.println(r.getFilename());
		System.out.println(r.contentLength());
	}
}
