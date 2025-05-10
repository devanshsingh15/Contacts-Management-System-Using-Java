# 📞 Contact Management System - Java Console Application

A simple and interactive **Contact Log Manager** built using Java!  
Manage your contacts, call logs, favorites, and more – all from a console interface.

---

## 🚀 Features

- ➕ Add new contacts with name, number, and optional relation.
- 🔍 Search contacts by name.
- 📝 Edit contact details (name or phone number).
- ❌ Delete existing contacts.
- 📋 Show all saved contacts.
- 📞 Simulate calling a contact.
- 🕓 View call history.
- ❤️ Mark contacts as favourites and view them.
- 🛠 Blocked contacts & viewing feature (under development).
- 🆘 Help menu to list all commands.


## 📂 Project Structure
```pgsql
│
├── ContactLog/
│ ├── Driver/ # Main application driver
│ │ └── ContactDriver.java
│ ├── Entity/ # Contact entity definition
│ │ └── Contact.java
│ ├── Repository/ # In-memory database (Contact arrays)
│ │ └── Database.java
│ └── Service/ # Core operations like add, search, delete, call
│ └── Operations.java
```

## 🧑‍💻 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/contact-log-java.git
   
2. Open the project in your Java IDE (like Eclipse or IntelliJ).

3. Run the ContactDriver.java file to launch the application.

## 🛠 Technologies Used
Java (JDK 8 or higher)

Console-based interaction (no external libraries)

## 📸 Sample Output

![image](https://github.com/user-attachments/assets/4bdb82c6-221f-4b46-8ecd-f354cfcb6f99)

### 🔧 To-Do (Future Enhancements)
1. Implement contact blocking and showing blocked contacts
2. Save contacts and call history persistently (e.g., using file or database)
3. Add UI (Swing/JavaFX) for a visual experience
4. Add import/export contact features

## 📚 What You’ll Learn

This project is a great way to practice and learn core Java concepts. By exploring or contributing to this project, you will:

- ✅ Understand **object-oriented programming (OOP)** in Java through classes, objects, and encapsulation.
- ✅ Learn to manage **data using arrays and collections** for contact storage.
- ✅ Explore how to **create reusable services** like add, delete, and search logic.
- ✅ Practice **modular programming** by separating logic into packages (Entity, Service, Repository, Driver).
- ✅ Improve your skills in **input validation and user interaction** via console-based programs.
- ✅ Understand **data flow and control structures** in real-world applications.
- ✅ Get hands-on with **basic CRUD operations** and call simulations.

This project is ideal for Java beginners who want to build a complete, functional, and organized application.



## 📜 License
This project is open-source and free to use for educational purposes.

## 👨‍🎓 Author
Devansh
devanshdmp15@gmail.com

