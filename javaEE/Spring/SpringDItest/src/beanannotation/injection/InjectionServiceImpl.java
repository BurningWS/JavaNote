package beanannotation.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService {
	
	@Autowired  
	private InjectionDAO injectionDAO;  // could have no set method..
	
//	public InjectionServiceImpl(InjectionDAO injectionDAO) {
//		System.out.println("InjectionServiceImpl(InjectionDAO injectionDAO)");
//		this.injectionDAO = injectionDAO;
//	}
	
	public void setInjectionDAO(InjectionDAO injectionDAO) {
		System.out.println("setInjectionDAO...");
		this.injectionDAO = injectionDAO;
	}

	public void save(String arg) {
		//妯℃嫙涓氩姟鎿崭綔
		System.out.println("Service鎺ユ敹鍙傛暟锛? + arg);
		arg = arg + ":" + this.hashCode();
		injectionDAO.save(arg);
	}
	
}
