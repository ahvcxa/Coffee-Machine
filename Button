package week3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		JLabel LCoffeeMachine = new JLabel("COFFEE MACHINE\n");
		LCoffeeMachine.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		LCoffeeMachine.setFont(new Font("Nimbus Mono PS",Font.BOLD, 25));
		LCoffeeMachine.setBounds(270, 120, 225, 47);
		contentPane.add(LCoffeeMachine);
		
		
		
		JButton buyButton = new JButton("BUY");
		buyButton.setBounds(274, 180, 225, 47);
		buyButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(buyButton);
		buyButton.setVisible(true);
		
		
		JButton typeButton = new JButton("TYPE");
		typeButton.setBackground(Color.LIGHT_GRAY);
		typeButton.setBounds(274, 250, 225, 47);
		contentPane.add(typeButton);
		
		
		JButton turnButton = new JButton("TURF OFF");
		turnButton.setBackground(Color.LIGHT_GRAY);
		turnButton.setBounds(274, 320, 225, 47);
		contentPane.add(turnButton);
		

		
	}

}
