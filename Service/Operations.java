package project.ContactLog.Service;
import project.ContactLog.Repository.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import project.ContactLog.Entity.*;

@SuppressWarnings("resource")
public class Operations {
	
	public boolean isPresent(long phone) {
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && Database.db[i].phone == phone) {
				return true;
			}
		}
		return false;
	}
	
	//addition of new contact
	public void add() {
		Operations obj = new Operations();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter number: ");
		long phone = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter relation(optional): ");
		String relation = sc.nextLine();
		
		if(!isPresent(phone)) {
			if(relation != "") obj.addUser(name, phone, relation);
			else obj.addUser(name, phone);
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Contact Added");
			System.out.println("-----------------------------------------------------------------------------------------------");
		} else {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Duplicate phone number");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		
	}
	
	
	public void addUser(String name, long phone) {
		Scanner sc = new Scanner(System.in);
		Contact obj = new Contact(name,phone);
		int idx = -1;
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] == null) {
				idx = i;
				break;
			}
		}
		Database.setDb(obj,idx);
		
		System.out.println("Do you want to make it fav(y/n)? ");
		char ch = sc.next().charAt(0);
		if(ch == 'y') {
			idx = -1;
			for(int i = 0; i < Database.favs.length; i++) {
				if(Database.favs[i] == null) {
					idx = i;
					break;
				}
			}
			Database.setFavs(obj,idx);
		}
	}
	
	public void addUser(String name, long phone, String relation) {
		Scanner sc = new Scanner(System.in);
		Contact obj = new Contact(name,phone,relation);
		int idx = -1;
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] == null) {
				idx = i;
				break;
			}
		}
		Database.setDb(obj,idx);
		
		System.out.println("Do you want to make it fav(y/n)? ");
		char ch = sc.next().charAt(0);
		if(ch == 'y') {
			idx = -1;
			for(int i = 0; i < Database.favs.length; i++) {
				if(Database.favs[i] == null) {
					idx = i;
					break;
				}
			}
			Database.setFavs(obj,idx);
		}
	}
	
	
	//Searching 
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name to search: ");
		String name = sc.nextLine();
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		ArrayList<Contact> out = searchUsers(name);
		boolean f = false;
		for(Contact c : out) {
			if(c != null) {
				System.out.println("Name: " + c.name + "          Phone: " + c.phone);
				f = true;
			}
			System.out.println("-----------------------------------------------------------------------------------------------");

		} 
		if(!f) {
			System.out.println("Not Found");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	
	
	public ArrayList<Contact> searchUsers(String name) {
		ArrayList<Contact> user = new ArrayList<>();
 		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name.toLowerCase()).contains(name.toLowerCase())) {
				user.add(Database.db[i]);
			}
		}
		return user;
	}
	
	public Contact searchUser(String name) {
		Contact user = null;
 		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name).equalsIgnoreCase(name)) {
				user = Database.db[i];
				break;
			}
		}
		return user;
	}
	
	//edit user
	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name which you want to edit: ");
		String name = sc.nextLine();
		Contact out = searchUser(name);
		
		if(out != null) {
			System.out.print("You want to edit name/phone(n/p)? ");
			char e = sc.next().charAt(0);
			sc.nextLine();
			if(e == 'n') {
				System.out.print("Enter new name to edit: ");
				String newName = sc.nextLine();
				editUser(name, newName);
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Edited");
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			else if(e == 'p') {
				System.out.print("Enter new number to edit: ");
				long newNo = sc.nextInt();
				editUser(name, newNo);
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Edited");
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
		}
		else {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Not Found");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	
	public void editUser(String oldName, String newName) {
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name).equalsIgnoreCase(oldName)) {
				Database.db[i].name = newName;
				break;
			}
		}
	}
	public void editUser(String oldName, long newNo) {
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name).equalsIgnoreCase(oldName)) {
				Database.db[i].phone = newNo;
				break;
			}
		}
	}
	
	//delete user
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name you want to delete: ");
		String name = sc.nextLine();
		Contact out = searchUser(name);
		
		if(out != null) {
			deleteUser(name);
		}
		else {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Contact Not Present");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	
	public void deleteUser(String name) {
		int i = 0;
		for(; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name).equalsIgnoreCase(name)) {
				Database.db[i] = null;
				break;
			}
		}
		
		int idx = 0;
		for (int it = 0; it < Database.db.length; it++) {
	        if (Database.db[it] != null) {
	            Database.db[idx++] = Database.db[it];
	        }
	    }
		while (idx < Database.db.length) {
		    Database.db[idx++] = null;
		}  
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Contact Deleted");
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	public void showUsers() { 
		if(Database.db[0] == null) {
			System.out.println("No Contacts to show");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		
		Arrays.stream(Database.db).forEach((e)->{
			if(e != null) {
				System.out.println("Name: " + e.name + "          Phone: " + e.phone);
				if(e.relation != null) System.out.println("Relation: " + e.relation);
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			else return;
		});
	}
	
	public void callUser(String name) {
		Contact user = null;
		for(int i = 0; i < Database.db.length; i++) {
			if(Database.db[i] != null && (Database.db[i].name).equalsIgnoreCase(name)) {
				user=Database.db[i];
				break;
			}
		}	
		if(user != null) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Calling " + user.name + " ...");
			System.out.println("-----------------------------------------------------------------------------------------------");
			callLogs(user);
		}
		else {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Contact not found");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		
	}
	
	public void callLogs(Contact user) {
		int idx = -1;
		for(int i = 0; i < Database.logs.length; i++) {
			if(Database.logs[i] == null) {
				idx = i;
				break;
			}
		}
		Database.logs[idx] = user;
	}
	
	public void showCallLogs() {
		if(Database.logs[0] == null) {
			System.out.println("No Contacts history to show");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		else {
			for(Contact it : Database.logs) {
				if(it != null) {
					System.out.println("Name: " + it.name + "          Phone: " + it.phone);
					
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	public void showFavs() {
		if(Database.favs[0] == null) {
			System.out.println("No Favourits added");
//			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		else {
			for(Contact it : Database.favs) {
				if(it != null) {
					System.out.println("Name: " + it.name + "          Phone: " + it.phone);
					
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	
	
}
