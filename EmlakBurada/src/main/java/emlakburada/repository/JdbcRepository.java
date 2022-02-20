package emlakburada.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class JdbcRepository implements DatabaseRepository {
	
	private String dbUrl = "localhost";

	@Override
	public void connect() {
		// TODO connect to db with jdbc
		
	}

}
