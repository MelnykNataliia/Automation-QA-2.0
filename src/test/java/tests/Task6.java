package tests;

import org.junit.jupiter.api.Test;
import testdata.User;
import testdata.UserService;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task6 {
	@Test

	// Check the number of users
	public void usersNumberIfUserAdded() {
		var userService = new UserService();
		userService.add(new User());
		userService.add(new User());
		userService.add(new User());

		List<User> users;
		users = userService.getAll();

		int expectedUsersNumber = 3;
		int actualUsersNumber = users.size();

		assertEquals(expectedUsersNumber, actualUsersNumber);
	}
}
