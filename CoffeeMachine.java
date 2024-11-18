package CoffeeMachine;

import java.awt.Color;
import java.awt.EventQueue;
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

public class CoffeeMachine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMachine frame = new CoffeeMachine();
					frame.setVisible(true);
					frame.setTitle("Coffee Machine"); // added name for the program title
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeMachine() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 782, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Label
		JLabel lCoffeeMachine = new JLabel("COFFEE MACHINE");
		lCoffeeMachine.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		lCoffeeMachine.setFont(new Font("Nimbus Mono PS", Font.BOLD, 35));
		lCoffeeMachine.setBounds(231, 93, 308, 47);
		contentPane.add(lCoffeeMachine);

		// Buy Button
		JButton buyButton = new JButton("BUY");
		buyButton.setBounds(274, 175, 225, 47);
		buyButton.setBackground(Color.LIGHT_GRAY);
		buyButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(buyButton);

		// Exit Button
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(274, 245, 225, 47);
		exitButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(exitButton);

		// Exit Button Action
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Terminates the program
			}
		});

		// Buy Button Action
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame coffeeOptionsFrame = new JFrame("Choose Your Coffee");
				coffeeOptionsFrame.setBounds(650, 300, 400, 300);
				coffeeOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				coffeeOptionsFrame.setLayout(null);

				JPanel panel = new JPanel();
				panel.setBackground(Color.DARK_GRAY);
				panel.setBounds(0, 0, 400, 300);
				panel.setLayout(null);
				coffeeOptionsFrame.add(panel);

				JLabel label = new JLabel("Choose Your Coffee");
				label.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
				label.setFont(new Font("Nimbus Mono PS", Font.BOLD, 20));
				label.setBounds(90, 30, 220, 30);
				panel.add(label);

				// Espresso Button
				JRadioButton espressoButton = new JRadioButton("Espresso");
				espressoButton.setBounds(110, 100, 150, 40);
				espressoButton.setBackground(Color.DARK_GRAY);
				espressoButton.setForeground(Color.WHITE);
				espressoButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
				panel.add(espressoButton);

				// Latte Button
				JRadioButton latteButton = new JRadioButton("Latte");
				latteButton.setBounds(110, 160, 150, 40);
				latteButton.setBackground(Color.DARK_GRAY);
				latteButton.setForeground(Color.WHITE);
				latteButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
				panel.add(latteButton);

				// Group the radio buttons to allow only one selection
				ButtonGroup coffeeGroup = new ButtonGroup();
				coffeeGroup.add(espressoButton);
				coffeeGroup.add(latteButton);

				// Confirm Button
				JButton confirmButton = new JButton("CONFIRM");
				confirmButton.setBounds(110, 220, 150, 40);
				confirmButton.setBackground(Color.LIGHT_GRAY);
				confirmButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
				panel.add(confirmButton);

				// Confirm Button Action
				confirmButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (espressoButton.isSelected()) {
							System.out.println("Espresso selected.");
						} else if (latteButton.isSelected()) {
							System.out.println("Latte selected.");
						} else {
							System.out.println("No coffee type selected.");
						}
					}
				});

				// Display the frame
				coffeeOptionsFrame.setVisible(true);
			}
		});
	}
}
