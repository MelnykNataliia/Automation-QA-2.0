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
}

