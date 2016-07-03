package autowiring;
public class AutoWiringService {
	
	private AutoWiringDAO autoWiringDAO;  // must have relevant set method to realize auto-wiring!
	
	public AutoWiringService() {
		System.out.println("AutoWiringService()...");
	}
	
	public AutoWiringService(AutoWiringDAO autoWiringDAO) {
		System.out.println("AutoWiringService(AutoWiringDAO autoWiringDAO)...");
		this.autoWiringDAO = autoWiringDAO;
	}

	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {  
		System.out.println("setAutoWiringDAO");
		this.autoWiringDAO = autoWiringDAO;
	}
	
	public void say(String word) {
		this.autoWiringDAO.say(word);
	}

}
