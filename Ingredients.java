package CoffeeMachine;

import javax.swing.JOptionPane;

public class Ingredients {
Prices prices = new Prices();
    public void reduceManager(String drinkType) {
    	float itemPrice = 0;
    		   switch (drinkType.toLowerCase()) {
               case "americano":
            	   reduceIngredients(1,itemPrice);
            	   break;
               case "espresso":
            	   reduceIngredients(2,itemPrice);
            	   break;
               case "cappuccino":
            	   reduceIngredients(3,itemPrice);
            	   break;
             default:
            	 break;
           }
    }
    
    public boolean checkIngredients(int choice) {
    	switch(choice) {
    	case 1:
    		if (Storage.getCOFFEE() >= 10 && Storage.getWATER() >= 100) {
    			return true;
    		}
    	case 2:
    		if (Storage.getCOFFEE() >= 9 && Storage.getWATER() >= 60) {
    			return true;
    		}
    	case 3:
    		if (Storage.getCOFFEE() >= 5 && Storage.getWATER() >= 50 && Storage.getMILK() >= 60) {
    			return true;
    		}
    	default:
    		return false;
    	}
    }
    
    public void preparedMessage(int choice) {
    	switch(choice) {
    	case 1:
    		JOptionPane.showMessageDialog(null, "Americano prepared.", "Success", JOptionPane.INFORMATION_MESSAGE);
    		break;
    	case 2:
    		JOptionPane.showMessageDialog(null, "Espresso prepared.", "Success", JOptionPane.INFORMATION_MESSAGE);
    		break;
    	case 3:
    		JOptionPane.showMessageDialog(null, "Cappuccino prepared.", "Success", JOptionPane.INFORMATION_MESSAGE);
    		break;
    	default:
    		return;
    	}
    }
    
    public void reduceIngredients(int choice, float itemPrice) {
    	switch(choice) {
    	case 1:
    	   itemPrice = prices.getAmericanoPrice();
     	   if(Money.Money > itemPrice) {
     		   if (Storage.getCOFFEE() >= 10 && Storage.getWATER() >= 100) {
                    Storage.setCOFFEE(Storage.getCOFFEE() - 10);
                    Storage.setWATER(Storage.getWATER() - 100);
                  
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Not enough ingredients for Americano.", "Error", JOptionPane.ERROR_MESSAGE);
                }
     	   }
     	   
    	case 2:
    		itemPrice = prices.getEspressoPrice();
     	   if(Money.Money > itemPrice) {
     		   if (Storage.getCOFFEE() >= 9 && Storage.getWATER() >= 60) {
                    Storage.setCOFFEE(Storage.getCOFFEE() - 9);
                    Storage.setWATER(Storage.getWATER() - 60);
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Not enough ingredients for Espresso.", "Error", JOptionPane.ERROR_MESSAGE);
                }
     	   }

    		
    	case 3:
    		 if(Money.Money > itemPrice) {
    			 itemPrice = prices.getCappuccinoPrice();
      		   if (Storage.getCOFFEE() >= 5 && Storage.getWATER() >= 50 && Storage.getMILK() >= 60) {
                     Storage.setCOFFEE(Storage.getCOFFEE() - 5);
                     Storage.setWATER(Storage.getWATER() - 50);
                     Storage.setMILK(Storage.getMILK() - 60);
                 } 
                 else {
                     JOptionPane.showMessageDialog(null, "Not enough ingredients for Cappuccino.", "Error", JOptionPane.ERROR_MESSAGE);
                 }
      	   }
    		
        default:
        	return;
    			
    	}
    }
}