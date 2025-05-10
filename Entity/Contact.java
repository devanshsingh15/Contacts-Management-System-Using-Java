package project.ContactLog.Entity;

public class Contact {
	public String name;
	public long phone;
	public String relation;
	public boolean isFav;
	
	public Contact(String name, long phone) {
		this.name = name;
		this.phone = phone;
		this.isFav = false;
	}
	
	public Contact(String name, long phone, String relation) {
		this(name, phone);
		this.relation = relation;
		this.isFav = false;
	}
}

