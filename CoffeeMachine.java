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
		
		buyButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19)); // added new font for button text
		contentPane.add(buyButton);
	
		
		JButton exitButton = new JButton("EXIT"); // turnButton changed name as exitButton
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(274, 245, 225, 47);
		
		exitButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19)); // added new font for button text
		contentPane.add(exitButton);
		
		JButton ownerButton = new JButton("OWNER");
		ownerButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		ownerButton.setBackground(Color.LIGHT_GRAY);
		ownerButton.setBounds(274, 314, 225, 47);
		contentPane.add(ownerButton);
		
	}
}
