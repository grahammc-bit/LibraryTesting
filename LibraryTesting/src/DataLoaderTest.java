import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@Before
	public void setup() {
		userList.clear();
		userList.add(new User("Amy", "Smith", "asmith", 19, "803-454-3344"));
		userList.add(new User("Bob", "White", "bwhite", 23, "803-333-3544"));
		DataWriter.saveUsers();
	}
	
	@After
	public void tearDown() {
		userList.clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testGetUsersSize() {
		userList = DataLoader.getUsers();
		assertEquals(2, userList.size());
	}

}
