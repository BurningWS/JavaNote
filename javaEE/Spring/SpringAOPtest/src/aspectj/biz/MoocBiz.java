package aspectj.biz;

import org.springframework.stereotype.Component;

import aspectj.MoocMethod;

@Component
public class MoocBiz {
	
	@MoocMethod("MoocBiz save with MoocMethod.")
	public String save(String arg) {
		System.out.println("MoocBiz save : " + arg);
		return " Save success!";
	}

	public void throwException() {
		throw new RuntimeException(" Save failed!");
	}
}