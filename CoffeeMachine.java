package CoffeeMachine;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class BaseFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public BaseFrame() {
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                resizeComponents();
            }
        });
    }

    public JPanel getContentPanePanel() {
        return contentPane;
    }

    private void resizeComponents() {
        for (Component component : contentPane.getComponents()) {
            if (component instanceof JComponent) {
                Rectangle bounds = component.getBounds();
                double widthScale = getWidth() / 782.0;
                double heightScale = getHeight() / 500.0;
                component.setBounds(
                    (int) (bounds.x * widthScale), 
                    (int) (bounds.y * heightScale), 
                    (int) (bounds.width * widthScale), 
                    (int) (bounds.height * heightScale)
                );
            }
        }
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

        JLabel lCoffeeMachine = createLabel("COFFEE MACHINE", 100, 50, 582, 47, 35);
        getContentPanePanel().add(lCoffeeMachine);

        JLabel moneyLabel = createLabel("Enter Your Money:", 200, 150, 200, 30, 18);
        getContentPanePanel().add(moneyLabel);

        JTextField moneyField = new JTextField();
        moneyField.setFont(new Font("Nimbus Mono PS", Font.PLAIN, 16));
        moneyField.setBounds(400, 150, 150, 30);
        getContentPanePanel().add(moneyField);

        JButton submitMoneyButton = createButton("SUBMIT", 570, 150, 100, 30, 14);
        submitMoneyButton.addActionListener(e -> {
            try {
                customerMoney = Double.parseDouble(moneyField.getText());
                JOptionPane.showMessageDialog(this, String.format("You entered $%.2f", customerMoney), "Money Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        getContentPanePanel().add(submitMoneyButton);

        JButton buyButton = createStyledButton("BUY COFFEE", 200, 250, 375, 50, 22, Color.GREEN);
        buyButton.addActionListener(e -> {
            CoffeeOptionsFrame coffeeOptions = new CoffeeOptionsFrame(this);
            coffeeOptions.setVisible(true);
        });
        getContentPanePanel().add(buyButton);

        JButton exitButton = createStyledButton("EXIT", 200, 330, 375, 50, 22, Color.RED);
        exitButton.addActionListener(e -> System.exit(0));
        getContentPanePanel().add(exitButton);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
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

    private JButton createStyledButton(String text, int x, int y, int width, int height, int fontSize, Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Nimbus Mono PS", Font.BOLD, fontSize));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
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
                JOptionPane.showMessageDialog(this, String.format("You bought coffee for $%.2f. Remaining balance: $%.2f", price, coffeeMachine.getCustomerMoney()), "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds. Please add more money.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No coffee type selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        dispose();
    }
}
