package CoffeeMachine;

import javax.swing.JOptionPane;

public class Ingredients {
    private Store store = new Store();

    public void reduceIngredients(String drinkType) {
        switch (drinkType.toLowerCase()) {
            case "americano":
                if (store.COFFEE >= 10 && store.getWATER() >= 100) {
                    store.setCOFFEE(store.getCOFFEE() - 10);
                    store.setWATER(store.getWATER() - 100);
                    JOptionPane.showMessageDialog(null,"Americano prepared. Remaining ingredients: ", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                	JOptionPane.showMessageDialog(null, "Not enough ingredients for Americano.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "espresso":
                if (store.getCOFFEE() >= 9 && store.getWATER() >= 60) {
                    store.setCOFFEE(store.getCOFFEE() - 9);
                    store.setWATER(store.getWATER() - 60);
                    JOptionPane.showMessageDialog(null,"Espresso prepared. Remaining ingredients: ", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                	JOptionPane.showMessageDialog(null, "Not enough ingredients for Espresso.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "cappuccino":
                if (store.getCOFFEE() >= 5 && store.getWATER() >= 50 && store.getMILK() >= 60) {
                    store.setCOFFEE(store.getCOFFEE() - 5);
                    store.setWATER(store.getWATER() - 50);
                    store.setMILK(store.getMILK() - 60);
                    JOptionPane.showMessageDialog(null,"Cappucino prepared. Remaining ingredients: ", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                	JOptionPane.showMessageDialog(null, "Not enough ingredients for Cappuccino.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            default:
            	JOptionPane.showMessageDialog(null, "Invalid drink type.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}