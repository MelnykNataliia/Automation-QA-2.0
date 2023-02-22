package api.contacts;

public class NewContactDto {
	public final Company company;
	public final Contact contact;

	public NewContactDto(Company company, Contact contact) {
		this.company = company;
		this.contact = contact;
	}
}
