package api.contacts;

public class EmailList{
	public boolean deleted;
	public String emailAddress;
	public boolean emailValidated;
	public boolean isBlackEmail;
	public boolean main;

	public EmailList(boolean deleted, String emailAddress, boolean emailValidated, boolean isBlackEmail, boolean main) {
		this.deleted = deleted;
		this.emailAddress = emailAddress;
		this.emailValidated = emailValidated;
		this.isBlackEmail = isBlackEmail;
		this.main = main;
	}
}
