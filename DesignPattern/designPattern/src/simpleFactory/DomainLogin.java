package simpleFactory;
public class DomainLogin implements Login {

    @Override
    public boolean verify(String name, String password) {
    	System.out.println(name+" "+password+" DomainLogin");
    	/**
         * business logic
         */
        return true;
    }

}