package CoffeeMachine;

import javax.swing.JOptionPane;

public class Money {
	private float Money = 0;


public void showMoney() {
	System.out.println(Money);
}
	
public void addMoney() {
    try {
        // Ask the user for the amount of money to add
        String moneyInput = JOptionPane.showInputDialog("Enter amount of money to add:");

        // Check for null or empty input
        if (moneyInput == null || moneyInput.trim().isEmpty()) {
            throw new NumberFormatException("Money input is empty.");
        }

        // Parse the input to a float value
        float moneyToAdd = Float.parseFloat(moneyInput);

        // Validate that the input is not negative
        if (moneyToAdd < 0) {
            JOptionPane.showMessageDialog(null, "Amount cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add the entered amount to the current balance
        Money += moneyToAdd;

        // Show the updated balance
        JOptionPane.showMessageDialog(null, "New balance: " + Money, "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        // Handle invalid input
        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


public void spendMoney1() {
    Prices price = new Prices(); // Assuming Prices has a method to fetch a price.
    float itemPrice = price.getPrice1(); // Replace getPrice() with the actual method to retrieve the price.

    if (Money < itemPrice) {
        JOptionPane.showMessageDialog(null, "Not enough money. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if there's not enough money.
    }

    Money -= itemPrice; // Deduct the price from the balance.
    JOptionPane.showMessageDialog(null, "Item bought! $" + Money + " remains.", "Success", JOptionPane.INFORMATION_MESSAGE);
}

public void spendMoney2() {
    Prices price = new Prices(); // Assuming Prices has a method to fetch a price.
    float itemPrice = price.getPrice2(); // Replace getPrice() with the actual method to retrieve the price.

    if (Money < itemPrice) {
        JOptionPane.showMessageDialog(null, "Not enough money. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if there's not enough money.
    }

    Money -= itemPrice; // Deduct the price from the balance.
    JOptionPane.showMessageDialog(null, "Item bought! $" + Money + " remains.", "Success", JOptionPane.INFORMATION_MESSAGE);
}

public void spendMoney3() {
    Prices price = new Prices(); // Assuming Prices has a method to fetch a price.
    float itemPrice = price.getPrice3(); // Replace getPrice() with the actual method to retrieve the price.

    if (Money < itemPrice) {
        JOptionPane.showMessageDialog(null, "Not enough money. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if there's not enough money.
    }

    Money -= itemPrice; // Deduct the price from the balance.
    JOptionPane.showMessageDialog(null, "Item bought! $" + Money + " remains.", "Success", JOptionPane.INFORMATION_MESSAGE);
}

public void changeMoney() {
	if(Money==0) {
		JOptionPane.showMessageDialog(null, "No money to give back.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else {
		JOptionPane.showMessageDialog(null,"$" + Money + " successfully given back.", "Success", JOptionPane.INFORMATION_MESSAGE);
		Money = 0;
	}
}

}