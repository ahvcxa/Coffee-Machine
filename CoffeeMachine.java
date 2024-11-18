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
					frame.setTitle("Coffee Machine");    // added name for the program title
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
		// added new font for button text
		buyButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(buyButton);
	
		// turnButton changed name as exitButton
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(274, 245, 225, 47);
		// added new font for button text
		exitButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(exitButton);
		
		// Buy Button Action
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create a new frame for coffee options
				JFrame coffeeOptionsFrame = new JFrame("Choose Your Coffee");
				coffeeOptionsFrame.setBounds(650, 300, 400, 300);
				coffeeOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				coffeeOptionsFrame.getContentPane().setLayout(null);
				
				// Label for instructions
				JLabel chooseLabel = new JLabel("Choose Your Coffee:");
				chooseLabel.setFont(new Font("Nimbus Mono PS", Font.BOLD, 18));
				chooseLabel.setBounds(100, 30, 200, 30);
				coffeeOptionsFrame.getContentPane().add(chooseLabel);
				
				// Button for Espresso
				JRadioButton espressoButton = new JRadioButton("Espresso");
				espressoButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
				espressoButton.setBounds(50, 100, 120, 50);
				coffeeOptionsFrame.getContentPane().add(espressoButton);

				// Button for Latte
				JRadioButton latteButton = new JRadioButton("Latte");
				latteButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
				latteButton.setBounds(200, 100, 120, 50);
				coffeeOptionsFrame.getContentPane().add(latteButton);
				
				// Add action listeners for buttons
				espressoButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Espresso Selected");
					}
				});

				latteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Latte Selected");
					}
				});
				
				// Display the frame
				coffeeOptionsFrame.setVisible(true);
			}
		});
		
		// 
	
	}
}
