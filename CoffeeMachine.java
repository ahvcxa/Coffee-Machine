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
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CoffeeMachine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMachine frame = new CoffeeMachine();
					frame.setVisible(true);
					frame.setTitle("Coffee Machine");
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeMachine() {
		setTitle("Coffee Machine");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 782, 500);  
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buyButton = new JButton("BUY");
		buyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buyButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buyButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		
		 buyButton.addActionListener(e -> {
			    dispose();
	            CoffeeOptions coffeeOptions = new CoffeeOptions();
	            coffeeOptions.setTitle("Coffee Options");
	            coffeeOptions.setVisible(true);
	        });
		buyButton.setBounds(274, 175, 225, 47);  
		buyButton.setBackground(Color.LIGHT_GRAY);
		
		buyButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(buyButton);
	
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		
		exitButton.addActionListener(e -> System.exit(0));
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(274, 315, 225, 47);
		
		exitButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(exitButton);
		
		JButton ownerButton = new JButton("OWNER");
		ownerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ownerButton.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ownerButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		ownerButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		ownerButton.setBackground(Color.LIGHT_GRAY);
		ownerButton.setBounds(274, 245, 225, 47);
		contentPane.add(ownerButton);
		
		JLabel lblTitle = new JLabel("COFFEE MACHINE");
		lblTitle.setForeground(new Color(245, 222, 179));
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 35));
		lblTitle.setBounds(230, 97, 317, 47);
		contentPane.add(lblTitle);
		ownerButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setTitle("Login");
				loginFrame.setVisible(true);
			}
		});
		
	}
}