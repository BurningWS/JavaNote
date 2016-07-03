package beanannotation.injection;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDAOImpl implements InjectionDAO {

	public void save(String arg) {
		// 妯℃嫙鏁版嵁搴扑缭瀛樻搷浣?
		System.out.println("淇濆瓨鏁版嵁锛? + arg);
	}

}