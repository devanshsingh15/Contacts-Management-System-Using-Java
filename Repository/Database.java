package project.ContactLog.Repository;
import project.ContactLog.Entity.*;
public class Database {
	
	public static Contact[] db = new Contact[10];
	public static Contact[] logs = new Contact[10];  
	public static Contact[] blocked = new Contact[10];
	public static Contact[] favs = new Contact[10];
	
	static {
		db[0] = new Contact("Devansh", 9458255608L, "Own");
		db[1] = new Contact("Ayush", 9458255609L, "Friend");
		db[2] = new Contact("Vishesh", 9458255610L, "Friend");
		db[3] = new Contact("Virat", 9458255611L, "Friend");
		db[4] = new Contact("Mahi", 9458255612L, "Enemy");
	}
	
 	
	public static void setDb(Contact user, int idx) {
		db[idx] = user;
	}
	
	public static void setFavs(Contact user, int idx) {
		favs[idx] = user;
	}
	
	
	
}
