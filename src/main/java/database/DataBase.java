package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DataBase {
	Connection con;

	// Database connection method
	public void connection() throws ClassNotFoundException {
		try {
			InputStream input = new FileInputStream("src/main/java/database/DBConfig.properties");
			Properties prop = new Properties();
			prop.load(input);

			String db_name = prop.getProperty("db_name");
			String db_user = prop.getProperty("db_user");
			String db_pass = prop.getProperty("db_pass");
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(db_name, db_user, db_pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// SQL request method that return String
	public String getManager(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder managersFullName = new StringBuilder();

		while (resultSet.next()) {
			String manager = resultSet.getString("full_name");
			String phone = resultSet.getString("phone");
			String email = resultSet.getString("email");

			managersFullName.append(manager).append(" ").append(phone).append(" ").append(email);
		}

		return managersFullName.toString();
	}

	// SQL request method that return Map
	public Map<String, String> getFullName(String sql) throws ClassNotFoundException, SQLException {
		Map<String, String> map = new HashMap<>();
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) map.put(resultSet.getString("name"), resultSet.getString("full_name"));

		return map;
	}

	// SQL request method that return List
	public List<String> getId(String sql) throws ClassNotFoundException, SQLException {
		List<String> financeId = new ArrayList<>();
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String category = resultSet.getString("name");

			financeId.add(id);
			financeId.add(category);
		}

		return financeId;
	}

	// SQL request method that return List
	public List<String> getTitle(String sql) throws ClassNotFoundException, SQLException {
		List<String> ticketTitle = new ArrayList<>();
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String title = resultSet.getString("title");
			String priority = resultSet.getString("priority");
			String managerFirstName = resultSet.getString("first_name");
			String managerLastName = resultSet.getString("last_name");

			ticketTitle.add(title);
			ticketTitle.add(priority);
			ticketTitle.add(managerFirstName);
			ticketTitle.add(managerLastName);
		}

		return ticketTitle;
	}

	// SQL request method that return String
	public String getDepartmentTitle(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder departmentName = new StringBuilder();

		while (resultSet.next()) {
			String department = resultSet.getString("name");

			departmentName.append(department);
		}

		return departmentName.toString();
	}

	// SQL request method that return String
	public String getRandomManager(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder managersFullName = new StringBuilder();

		while (resultSet.next()) {
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");

			managersFullName.append(firstName).append(" ").append(lastName);
		}

		return managersFullName.toString();
	}

	// SQL request method that return String
	public String ticketTitle(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketTitle = new StringBuilder();

		while (resultSet.next()) {
			String title = resultSet.getString("title");

			ticketTitle.append(title);
		}
		return ticketTitle.toString();
	}

	// SQL request method that return String
	public String ticketCategory(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketCategory = new StringBuilder();

		while (resultSet.next()) {
			String category = resultSet.getString("name");

			ticketCategory.append(category);

		}
		return  ticketCategory.toString();
	}

	// SQL request method that return String
	public String ticketStage(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketStage = new StringBuilder();

		while (resultSet.next()) {
			String stage = resultSet.getString("name");

			ticketStage.append(stage);

		}
		return  ticketStage.toString();
	}

	// SQL request method that return String
	public String ticketContact(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketCategory = new StringBuilder();

		while (resultSet.next()) {
			String contact = resultSet.getString("full_name");

			ticketCategory.append(contact);

		}
		return  ticketCategory.toString();
	}

	// SQL request method that return String
	public String ticketCompany(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketCompany = new StringBuilder();

		while (resultSet.next()) {
			String contact = resultSet.getString("name");

			ticketCompany.append(contact);

		}
		return  ticketCompany.toString();
	}

	// SQL request method that return String
	public String ticketPriority(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketPriority = new StringBuilder();

		while (resultSet.next()) {

			String priority = resultSet.getString("priority");

			ticketPriority.append(priority);
		}
		return  ticketPriority.toString();
	}

	// SQL request method that return String
	public String ticketInnerTitle(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder ticketInnerTitle = new StringBuilder();

		while (resultSet.next()) {
			String title = resultSet.getString("title");

			ticketInnerTitle.append(title);
		}
		return ticketInnerTitle.toString();
	}

	// SQL request method that return String
	public String companyTitle(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder newCompanyTitle = new StringBuilder();

		while (resultSet.next()) {
			String title = resultSet.getString("name");

			newCompanyTitle.append(title);
		}
		return newCompanyTitle.toString();
	}

	// SQL request method that return String
	public String managerFirstName(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder managerName = new StringBuilder();

		while (resultSet.next()) {
			String firstName = resultSet.getString("first_name");

			managerName.append(firstName);
		}
		return managerName.toString();
	}

	// SQL request method that return String
	public String managerLastName(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder managerName = new StringBuilder();

		while (resultSet.next()) {
			String lastName = resultSet.getString("last_name");

			managerName.append(lastName);
		}
		return managerName.toString();
	}

	// SQL request method that return String
	public String managerDepartment(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder department = new StringBuilder();

		while (resultSet.next()) {
			String departmentName = resultSet.getString("name");

			department.append(departmentName);
		}
		return department.toString();
	}

	// SQL request method that return String
	public String newCategory(String sql) throws ClassNotFoundException, SQLException {
		this.connection();

		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		StringBuilder category = new StringBuilder();

		while (resultSet.next()) {
			String categoryTitle = resultSet.getString("name");

			category.append(categoryTitle);
		}
		return category.toString();
	}
}

