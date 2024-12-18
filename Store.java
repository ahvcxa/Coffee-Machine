package CoffeeMachine;

import javax.swing.JOptionPane;

public class Store {

    private float COFFEE = 1000;
    private float WATER = 3000;
    private float MILK = 3000;

    // Function to show stock using JOptionPane
    public void showStock() {
        String stockInfo = 
                           "Coffee: " + COFFEE + " ml\n" +
                           "Water: " + WATER + " ml\n" +
                           "Milk: " + MILK + " ml";
        
        // Display stock information in a message dialog
        JOptionPane.showMessageDialog(null, stockInfo, "Stock Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // Function to add stock
    public void addStock() {
        try {
            // Ask user for the amounts to add
            String coffeeInput = JOptionPane.showInputDialog("Enter amount of coffee to add (ml):");
            String waterInput = JOptionPane.showInputDialog("Enter amount of water to add (ml):");
            String milkInput = JOptionPane.showInputDialog("Enter amount of milk to add (ml):");

            // Parse the inputs to float values
            float coffeeToAdd = Float.parseFloat(coffeeInput);
            float waterToAdd = Float.parseFloat(waterInput);
            float milkToAdd = Float.parseFloat(milkInput);

            // Add the entered amounts to the current stock
            COFFEE += coffeeToAdd;
            WATER += waterToAdd;
            MILK += milkToAdd;

            // Show success message
            JOptionPane.showMessageDialog(null, "Stock updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            // Handle invalid input
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getter methods (optional)
    public float getCOFFEE() {
        return COFFEE;
    }

    public float getWATER() {
        return WATER;
    }

    public float getMILK() {
        return MILK;
    }
}
