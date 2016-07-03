package beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsrService {

	@Resource
	private JsrDAO jsrDAO;   // use @Autowired instead..
	
//	@Resource
	public void setJsrDAO(JsrDAO jsrDAO) {
		System.out.println("setJsrDAO(JsrDAO jsrDAO)..");
		this.jsrDAO = jsrDAO;
	}

	@PostConstruct
	public void init() {
		System.out.println("JsrServie init.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("JsrServie destroy.");
	}

	public void save() {
		jsrDAO.save();
	}

}
