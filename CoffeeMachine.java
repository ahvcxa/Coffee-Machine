package CoffeeMachine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;

// Base class for shared properties and methods
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

// CoffeeMachine class for main frame
public class CoffeeMachine extends BaseFrame {
    private static final long serialVersionUID = 1L;
    private double customerMoney = 20.00; // Customer starts with $20.00

    public static void main(String[] args) {
        CoffeeMachine frame = new CoffeeMachine();
        frame.setVisible(true);
        frame.setTitle("Coffee Machine");
    }

    public CoffeeMachine() {
        setBounds(600, 250, 782, 500);

        JLabel lCoffeeMachine = createLabel("COFFEE MACHINE", 231, 93, 308, 47, 35);
        getContentPanePanel().add(lCoffeeMachine);

        JButton buyButton = createButton("BUY", 274, 175, 225, 47, 19);
        buyButton.addActionListener(e -> {
            CoffeeOptionsFrame coffeeOptions = new CoffeeOptionsFrame(this);
            coffeeOptions.setVisible(true);
        });
        getContentPanePanel().add(buyButton);

        JButton exitButton = createButton("EXIT", 274, 245, 225, 47, 19);
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

// CoffeeOptionsFrame class for the coffee selection window
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

        // Increase the size of the frame to fit everything
        setBounds(650, 300, 450, 400);  // Increased width and height
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
                System.out.printf("You bought coffee for $%.2f. Remaining balance: $%.2f\n", price, coffeeMachine.getCustomerMoney());
            } else {
                System.out.println("Insufficient funds. Please add more money.");
            }
        } else {
            System.out.println("No coffee type selected.");
        }

        // Close the coffee options window after confirming selection
        dispose();  // This closes the "Choose Your Coffee" window
    }
}
