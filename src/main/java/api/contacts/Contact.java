package api.contacts;

import java.util.ArrayList;

public class Contact{
	public Integer companyId;
	public ArrayList<EmailList> emailList;
	public String firstName;
	public String lastName;
	public String login;

	public Contact(Integer companyId, ArrayList<EmailList> emailList, String firstName, String lastName, String login) {
		this.companyId = companyId;
		this.emailList = emailList;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
	}
}

