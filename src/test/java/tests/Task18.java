package tests;

import database.DataBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Task18 {
	protected static DataBase managers = new DataBase();

	@Test
	public static void selectManagersWithContactData() throws SQLException, ClassNotFoundException {
		// Select the Full name from the table on Managers page where phone is not empty and email contains @gmail.com
		System.out.println(managers.getManager("select concat(manager.first_name, ' ', manager.last_name) as full_name,\n" +
				"       phone,\n" +
				"       email\n" +
				"from manager\n" +
				"where phone is not null\n" +
				"  and email like '%@gmail.com';"));
	}

	@Test
	public static void selectManagerWithDepartmentName() throws SQLException, ClassNotFoundException {
		// Select the Full name from the table on Managers page where Department = "Комната добра"
		System.out.println(managers.getFullName("select concat(manager.first_name, ' ', manager.last_name) as full_name,\n" +
				"       department.name\n" +
				"from manager join department\n" +
				"    on manager.department_id = department.id\n" +
				"where department.name = 'Комната добра';").values());
	}

	@Test
	public static void selectIdOfFinanceCategory() throws SQLException, ClassNotFoundException {
		// Select the ID from the table on Dashboard page -> Done Deadline tab where Created from 19.04.2018 to 03.05.2018 and Category = "Финансы"
		System.out.println(managers.getId("select ticket.id, category.name\n" +
				"from ticket join category\n" +
				"    on ticket.category_id = category.id\n" +
				"           and ticket.done_deadline between '19.04.2018' and '03.05.2018'\n" +
				"           and category.name = 'Финансы';"));
	}

	@Test
	public static void selectTicketTitle() throws SQLException, ClassNotFoundException {
		// Select the Title from table on Dashboard page -> Done Deadline tab where Priority = P4 and Assigned = "Татьяна Алимова"
		System.out.println(managers.getTitle("select ticket.title, ticket.priority, manager.first_name, manager.last_name\n" +
				"from ticket join manager\n" +
				"    on ticket.assignee_id = manager.id\n" +
				"           and ticket.done_deadline is not null\n" +
				"           and manager.first_name = 'Татьяна'\n" +
				"           and manager.last_name = 'Алымова';"));
	}

	@Test
	public static void selectDepartmentTitle() throws SQLException, ClassNotFoundException {
		// Search the Title on the Departments page
		System.out.print(managers.getDepartmentTitle("select name from department;"));
	}

	@Test
	public static void selectRandomManager() throws SQLException, ClassNotFoundException {
		// Select random Full name from the table on Managers page
		System.out.println(managers.getRandomManager("select first_name, last_name\n" +
				"from manager\n" +
				"order by random()\n" +
				"limit 1;"));
	}
}