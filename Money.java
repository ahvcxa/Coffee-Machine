package CoffeeMachine;

import javax.swing.JOptionPane;

public class Money {
	public static float Money = 0;
	Ingredients ingredients = new Ingredients();

public void addMoney(int choice) {
	switch(choice) {
	case 1:
		Money += 1;
		break;
	case 2:
		Money += 5;
		break;
	case 3:
		Money += 10;
		break;
	default:
		return;
	}
} 

public void notEnoughMoney() {
	JOptionPane.showMessageDialog(null, "Not enough money. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
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

public void checkMoney(int choice, float itemPrice) {
	 if (Money < itemPrice) {
	    	notEnoughMoney();
	        return;
	    }
	    else {
	    	ingredients.preparedMessage(choice);
         Money -= itemPrice;
	    }
}

public void spendMoney(int choice) {
    Prices price = new Prices();
    Ingredients ingredients = new Ingredients();
    float itemPrice;
        switch (choice) {
        case 1:
        	if (ingredients.checkIngredients(choice)) {
        		itemPrice = price.getAmericanoPrice();
        		checkMoney(choice,itemPrice);
        	   
        	}
        	 break;
        case 2:
        	if (ingredients.checkIngredients(choice)) {
                itemPrice = price.getEspressoPrice();
                checkMoney(choice,itemPrice);
        	}
        	 break;
        case 3:
        	if (ingredients.checkIngredients(choice)) {
        		itemPrice = price.getCappuccinoPrice();
        		checkMoney(choice,itemPrice);
        	}
        	break;
        default:
            return;
        }
    }
}