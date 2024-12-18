package CoffeeMachine;

import javax.swing.JOptionPane;

public class Money {
	private float Money = 0;


public void showMoney() {
	System.out.println(Money);
}
	
public void addMoney() {
    try {
        String moneyInput = JOptionPane.showInputDialog("Enter amount of money to add:");     
        float moneyToAdd = Float.parseFloat(moneyInput);
        Money += moneyToAdd;      
        JOptionPane.showMessageDialog(null, "Money added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

public void spendMoney() {
	JOptionPane.showMessageDialog(null, "... bought. ... money remains.");
}
}
