package api.contacts;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Login {
	public String session;

	public void getLogin() {
		Response response = given()
				.auth()
				.preemptive()
				.basic("thadmin", "tickethub")
				.when()
				.post("login")
				.then().log().all()
				.extract().response();

		this.session = response.getSessionId();
	}
}
