# ☕ Coffee Machine Application

## 📌 Project Description

This is a **Java Swing-based Coffee Machine Simulation Application** developed using object-oriented programming principles.

The application simulates a basic coffee vending machine with:

* Customer interface
* Owner login system
* Stock management
* Price management
* Money handling system

It follows a layered structure using:

* `main` → Application entry point
* `ui` → User interface (Swing frames)
* `model` → Data models
* `service` → Business logic

---

## 👥 Team Members
- Ali Yılmaz
- Mehmet Kaya
- Ayşe Demir

---

## 🏗 Project Structure

```
CoffeeMachine
│
├── main
│   └── Main_Frame.java
│
├── model
│   ├── Ingredients.java
│   ├── Money.java
│   ├── Prices.java
│   └── Storage.java
│
├── service
│   └── UserManager.java
│
└── ui
    ├── CoffeeOptions.java
    ├── LoginFrame.java
    └── OwnerFrame.java
```

---

## 🖥 Application Screens

### 1️⃣ Main Frame

* Main coffee machine interface
* Access to coffee options
* Owner login access

### 2️⃣ Coffee Options

* Americano
* Espresso
* Cappuccino
* Handles ingredient control and payment

### 3️⃣ Owner Login

* Username/password authentication
* Default credentials:

  ```
  Username: owner
  Password: 1234
  ```

### 4️⃣ Owner Panel

* Check current stock
* Add stock
* Return to main menu

---

## ⚙️ Features

✔️ Coffee selection system
✔️ Ingredient tracking
✔️ Stock control
✔️ Owner authentication
✔️ Money handling
✔️ GUI built with Java Swing
✔️ Organized package structure

---

## 🧠 Technologies Used

* Java
* Java Swing (GUI)
* Object-Oriented Programming
* HashMap (for user management)

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/coffee-machine.git
   ```

2. Open the project in **Eclipse IDE**

3. Make sure the package structure is correct:

   * `CoffeeMachine.main`
   * `CoffeeMachine.model`
   * `CoffeeMachine.service`
   * `CoffeeMachine.ui`

4. Run:

   ```
   Main_Frame.java
   ```

---

## 🔐 Authentication System

The `UserManager` class uses a simple `HashMap` to validate login credentials.

```java
users.put("owner", "1234");
```

This can be extended to support:

* Multiple users
* Database integration
* Role-based access

---

## 📦 Future Improvements

* Database integration (MySQL / SQLite)
* Dynamic price updates
* Better UI design
* Admin dashboard improvements
* Persistent stock storage (file/database)
* Unit testing

---

## 👨‍💻 Author

Developed as a Java GUI practice project to improve:

* Swing development skills
* OOP design
* Package organization
* Project structuring in Eclipse
