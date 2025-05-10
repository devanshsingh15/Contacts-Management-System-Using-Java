package project.ContactLog.Driver;
import java.util.*;
import project.ContactLog.Service.*;
public class ContactDriver {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Operations obj = new Operations();

		System.out.println("************************************CONTACTS***********************************************************");
		System.out.println("|  add-> add new contact       |  search-> search Contact      |  edit-> edit existing contact        |");
		System.out.println("|  delete-> delete contact     |  showall-> show all contacts  |  call-> call                         |");
		System.out.println("|  history-> show call history |  block-> Block contact        |  showblocked-> Show Blocked Contacts |");
		System.out.println("|  help-> List Features        |  favourites-> show favourites |  exit-> Exit                         |");
		System.out.println("*******************************************************************************************************");
		
		boolean flag = true;
		while(flag) {

			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("Enter your Choice: ");
			String ch = sc.nextLine();
			System.out.println("-----------------------------------------------------------------------------------------------");
			
			if(ch.equalsIgnoreCase("add")) obj.add();
			else if(ch.equalsIgnoreCase("search")) obj.search();
			else if(ch.equalsIgnoreCase("edit")) obj.edit();
			else if(ch.equalsIgnoreCase("delete")) obj.delete();
			else if(ch.equalsIgnoreCase("showall")) obj.showUsers();
			else if(ch.equalsIgnoreCase("call")) {
				System.out.print("Enter name to call: ");
				String name = sc.nextLine();
				obj.callUser(name);
			}
			else if(ch.equalsIgnoreCase("history")) obj.showCallLogs();
			else if(ch.equalsIgnoreCase("block")) {
				System.out.println("Under maintenance");
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			else if(ch.equalsIgnoreCase("showblocked")) {
				System.out.println("Under maintenance");
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			else if(ch.equalsIgnoreCase("favourites")) {
				obj.showFavs();
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			else if(ch.equalsIgnoreCase("exit")) flag = false;
			else if(ch.equalsIgnoreCase("help")) {
				String[] temp = {""};
				main(temp);
			}
			else {
				System.out.println("Wrong choice");
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
			
			System.out.print("Do you want to continue(y/n)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			if(c == 'n') flag = false; 	
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Thanks for using our Application");
		System.out.println("-----------------------------------------------------------------------------------------------");
	}

}
