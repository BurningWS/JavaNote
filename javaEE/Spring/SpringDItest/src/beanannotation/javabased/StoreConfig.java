package beanannotation.javabased;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource("config-properties.xml")
public class StoreConfig {

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MyDriverManager myDriverManager() {
		return new MyDriverManager(url, username, password);
	}
	
	@Bean(name = "stringStore", initMethod = "init", destroyMethod = "destroy")
	public Store<String> stringStore() { // default: method's name is its id
		return new StringStore();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}
}