package CoffeeMachine;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class BaseFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public BaseFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public JPanel getContentPanePanel() {
        return contentPane;
    }
}

public class CoffeeMachine extends BaseFrame {
    private static final long serialVersionUID = 1L;
    private double customerMoney = 0.00;

    public static void main(String[] args) {
        CoffeeMachine frame = new CoffeeMachine();
        frame.setVisible(true);
        frame.setTitle("Coffee Machine");
    }

    public CoffeeMachine() {
        setBounds(600, 250, 782, 500);

        JLabel lCoffeeMachine = createLabel("COFFEE MACHINE", 231, 50, 308, 47, 35);
        getContentPanePanel().add(lCoffeeMachine);

        JLabel moneyLabel = createLabel("Enter your money:", 231, 120, 200, 30, 16);
        getContentPanePanel().add(moneyLabel);

        JTextField moneyField = new JTextField();
        moneyField.setBounds(430, 120, 100, 30);
        getContentPanePanel().add(moneyField);

        JButton submitMoneyButton = createButton("SUBMIT", 550, 120, 100, 30, 14);
        submitMoneyButton.addActionListener(e -> {
            try {
                customerMoney = Double.parseDouble(moneyField.getText());
                JOptionPane.showMessageDialog(this, String.format("You entered $%.2f", customerMoney));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        getContentPanePanel().add(submitMoneyButton);

        JButton buyButton = createButton("BUY", 274, 200, 225, 47, 19);
        buyButton.addActionListener(e -> {
            CoffeeOptionsFrame coffeeOptions = new CoffeeOptionsFrame(this);
            coffeeOptions.setVisible(true);
        });
        getContentPanePanel().add(buyButton);

        JButton exitButton = createButton("EXIT", 274, 270, 225, 47, 19);
        exitButton.addActionListener(e -> System.exit(0));
        getContentPanePanel().add(exitButton);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
        label.setFont(new Font("Nimbus Mono PS", Font.BOLD, fontSize));
        label.setBounds(x, y, width, height);
        return label;
    }

    private JButton createButton(String text, int x, int y, int width, int height, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Nimbus Mono PS", Font.BOLD, fontSize));
        return button;
    }

    public double getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(double customerMoney) {
        this.customerMoney = customerMoney;
    }
}

class CoffeeOptionsFrame extends BaseFrame {
    private static final long serialVersionUID = 1L;
    private JRadioButton espressoButton;
    private JRadioButton latteButton;
    private JRadioButton cappuccinoButton;
    private JRadioButton americanoButton;

    private final double ESPRESSO_PRICE = 5.00;
    private final double LATTE_PRICE = 6.50;
    private final double CAPPUCCINO_PRICE = 7.00;
    private final double AMERICANO_PRICE = 4.50;

    private CoffeeMachine coffeeMachine;

    public CoffeeOptionsFrame(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;

        setBounds(650, 300, 450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Choose Your Coffee");

        JLabel label = createLabel("Choose Your Coffee", 90, 30, 220, 30, 20);
        getContentPanePanel().add(label);

        espressoButton = createRadioButton("Espresso - $5.00", 90, 80, 200, 40);
        getContentPanePanel().add(espressoButton);

        latteButton = createRadioButton("Latte - $6.50", 90, 120, 200, 40);
        getContentPanePanel().add(latteButton);

        cappuccinoButton = createRadioButton("Cappuccino - $7.00", 90, 160, 200, 40);
        getContentPanePanel().add(cappuccinoButton);

        americanoButton = createRadioButton("Americano - $4.50", 90, 200, 200, 40);
        getContentPanePanel().add(americanoButton);

        ButtonGroup coffeeGroup = new ButtonGroup();
        coffeeGroup.add(espressoButton);
        coffeeGroup.add(latteButton);
        coffeeGroup.add(cappuccinoButton);
        coffeeGroup.add(americanoButton);

        JButton confirmButton = createButton("CONFIRM", 125, 260, 150, 40, 16);
        confirmButton.addActionListener(e -> handleSelection());
        getContentPanePanel().add(confirmButton);
    }

    private JRadioButton createRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, width, height);
        radioButton.setBackground(Color.DARK_GRAY);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
        return radioButton;
    }

    private JButton createButton(String text, int x, int y, int width, int height, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Nimbus Mono PS", Font.BOLD, fontSize));
        return button;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
        label.setFont(new Font("Nimbus Mono PS", Font.BOLD, fontSize));
        label.setBounds(x, y, width, height);
        return label;
    }

    private void handleSelection() {
        double price = 0;
        if (espressoButton.isSelected()) {
            price = ESPRESSO_PRICE;
        } else if (latteButton.isSelected()) {
            price = LATTE_PRICE;
        } else if (cappuccinoButton.isSelected()) {
            price = CAPPUCCINO_PRICE;
        } else if (americanoButton.isSelected()) {
            price = AMERICANO_PRICE;
        }

        if (price > 0) {
            double currentMoney = coffeeMachine.getCustomerMoney();
            if (currentMoney >= price) {
                coffeeMachine.setCustomerMoney(currentMoney - price);
                JOptionPane.showMessageDialog(this, String.format("You bought coffee for $%.2f. Remaining balance: $%.2f", price, coffeeMachine.getCustomerMoney()));
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No coffee type selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        dispose();
    }
}
