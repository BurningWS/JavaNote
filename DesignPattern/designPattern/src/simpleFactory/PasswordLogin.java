package simpleFactory;
public class PasswordLogin implements Login {

    @Override
    public boolean verify(String name, String password) {
    	System.out.println(name+" "+password+" PasswordLogin");
    	/**
         * business logic
         */
        return true;
    }

}