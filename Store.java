package CoffeeMachine;

import javax.swing.JOptionPane;

public class Store {

    // Make these static to keep their values persistent across method calls
    private static float COFFEE = 100;
    private static float WATER = 1000;
    private static float MILK = 1000;

    // Function to show stock using JOptionPane
    public static void showStock() {
        String stockInfo = 
                           "Coffee: " + COFFEE + " ml\n" +
                           "Water: " + WATER + " ml\n" +
                           "Milk: " + MILK + " ml";
        
        // Display stock information in a message dialog
        JOptionPane.showMessageDialog(null, stockInfo, "Stock Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // Function to add stock
    public static void addStock() {
        try {
            // Ask user for the amounts to add
            String coffeeInput = JOptionPane.showInputDialog("Enter amount of coffee to add (ml):");
            if (coffeeInput == null || coffeeInput.trim().isEmpty()) {
                throw new NumberFormatException("Coffee input is empty.");
            }

            String waterInput = JOptionPane.showInputDialog("Enter amount of water to add (ml):");
            if (waterInput == null || waterInput.trim().isEmpty()) {
                throw new NumberFormatException("Water input is empty.");
            }

            String milkInput = JOptionPane.showInputDialog("Enter amount of milk to add (ml):");
            if (milkInput == null || milkInput.trim().isEmpty()) {
                throw new NumberFormatException("Milk input is empty.");
            }

            // Parse the inputs to float values
            float coffeeToAdd = Float.parseFloat(coffeeInput);
            float waterToAdd = Float.parseFloat(waterInput);
            float milkToAdd = Float.parseFloat(milkInput);

            // Validate that the inputs are not negative
            if (coffeeToAdd < 0 || waterToAdd < 0 || milkToAdd < 0) {
                JOptionPane.showMessageDialog(null, "Amounts cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

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
    public static float getCOFFEE() {
        return COFFEE;
    }

    public static float getWATER() {
        return WATER;
    }

    public static float getMILK() {
        return MILK;
    }

    public static void setCOFFEE(float f) {
        COFFEE = f;
    }
    
    public static void setWATER(float f) {
        WATER = f;
    }
    
    public static void setMILK(float f) {
        MILK = f;
    }
}
