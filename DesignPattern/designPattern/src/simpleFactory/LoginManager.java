package simpleFactory;

/***
 * 我们还需要一个工厂类LoginManager，根据调用者不同的要求，创建出不同的登录对象并返回。而如果碰到不合法的要求，会返回一个Runtime异常。
 */
public class LoginManager {
	public static Login factory(String type) {
		if (type.equals("password")) {

			return new PasswordLogin();

		} else if (type.equals("passcode")) {

			return new DomainLogin();

		} else {
			throw new RuntimeException("can't find such a method");
		}
	}
}