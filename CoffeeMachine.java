package coffeemachine;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		lCoffeeMachine.setFont(new Font("Nimbus Mono PS", Font.BOLD, 37));
		lCoffeeMachine.setBounds(235, 93, 308, 47);  
		contentPane.add(lCoffeeMachine);
		
		// Buy Button
		JButton buyButton = new JButton("BUY");
		buyButton.setBounds(274, 175, 225, 47);  
		buyButton.setBackground(Color.LIGHT_GRAY);
		// added new font for button text
		buyButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(buyButton);
	
		
		// Type Button
		JButton typeButton = new JButton("TYPE");
		typeButton.setBackground(Color.LIGHT_GRAY);
		typeButton.setBounds(274, 245, 225, 47);
		// added new font for button text
		typeButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(typeButton);
		
		// turnButton changed name as exitButton
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(274, 315, 225, 47);
		// added new font for button text
		exitButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		contentPane.add(exitButton);
		
		
		
		// These are just view for buttons when mouse top on the button they change their color		
		
		buyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	buyButton.setBackground(Color.green);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            	buyButton.setBackground(Color.LIGHT_GRAY); 
            }
        });
		
	
		
		typeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	typeButton.setBackground(Color.orange);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            	typeButton.setBackground(Color.LIGHT_GRAY); 
            }
        });
		
		
		exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	exitButton.setBackground(Color.gray);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            	exitButton.setBackground(Color.LIGHT_GRAY);
            }
        });
	}
}
