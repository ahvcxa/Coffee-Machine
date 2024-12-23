package CoffeeMachine;

import javax.swing.JOptionPane;

public class Storage {

    private static float COFFEE = 100;
    private static float WATER = 1000;
    private static float MILK = 1000;

    public static void showStock() {
        String stockInfo = 
                           "Coffee: " + getCOFFEE() + " ml\n" +
                           "Water: " + getWATER() + " ml\n" +
                           "Milk: " + getMILK() + " ml";
        
        JOptionPane.showMessageDialog(null, stockInfo, "Stock Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void addStock() {
        try {
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

            float coffeeToAdd = Float.parseFloat(coffeeInput);
            float waterToAdd = Float.parseFloat(waterInput);
            float milkToAdd = Float.parseFloat(milkInput);

            if (coffeeToAdd < 0 || waterToAdd < 0 || milkToAdd < 0) {
                JOptionPane.showMessageDialog(null, "Amounts cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            COFFEE += coffeeToAdd;
            WATER += waterToAdd;
            MILK += milkToAdd;

            JOptionPane.showMessageDialog(null, "Stock updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } 
         catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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