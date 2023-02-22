package api.contacts;

public class Company {
	public String email;
	public boolean fakeCompany;
	public String name;
	public Integer plan;
	public String ticketPrefix;

	public Company(String email, boolean fakeCompany, String name, Integer plan, String ticketPrefix) {
		this.email = email;
		this.fakeCompany = fakeCompany;
		this.name = name;
		this.plan = plan;
		this.ticketPrefix = ticketPrefix;
	}
}
