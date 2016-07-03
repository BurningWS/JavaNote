package application;

import stack.StackArray;
                                                     
public class StackApplication {                        
	                                                 
	public static void main(String[] args) {         
		baseConvert(2007);     
		System.out.println(bracketMatch("{asd()[]}"));
		System.out.println(bracketMatch("{asd()[}"));
	}                                                
	                                                 
	static void baseConvert(int i) {                 
		StackArray s = new StackArray();             
		while (i != 0) {                             
			int j = i % 8;                           
			s.push(j);                               
			i /= 8;                                  
		}                                            
		while (!s.isEmpty()) {                       
			System.out.print(s.pop());               
		}                                
		System.out.println();
	}
	
	static boolean bracketMatch(String str) {
		StackArray s = new StackArray();
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			switch (a) {
			case '(':
			case '[':
			case '{':
				s.push(a);
				break;
			case ')':
				if (!s.isEmpty() && (char)s.pop() == '(') {
					break;
				}
				return false;
			case ']':
				if (!s.isEmpty() && (char)s.pop() == '[') {
					break;
				}
				return false;
			case '}':
				if (!s.isEmpty() && (char)s.pop() == '{') {
					break;
				}
				return false;
			default:
				break;
			}
		}
		if (!s.isEmpty()) {
			return false;
		}
		return true;
		
	}
}                                                    
                                                     