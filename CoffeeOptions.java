package CoffeeMachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SpringLayout;

public class CoffeeOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Money money = new Money();
	Ingredients ingredients = new Ingredients();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeOptions frame = new CoffeeOptions();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setBounds(600, 250, 782, 500);  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeOptions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CoffeeMachine coffeeMachine = new CoffeeMachine();
                coffeeMachine.setTitle("Coffee Machine"); 
                coffeeMachine.setVisible(true);
            }
        });
		setBounds(600, 250, 782, 500); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose your coffee:");
		lblNewLabel.setBounds(15, 48, 336, 42);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("01  Americano $4");
		lblNewLabel_1.setBounds(17, 128, 180, 33);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(662, 262, 76, 76);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 30));
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money.spendMoney3();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("2");
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setBounds(661, 175, 76, 78);
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2_1.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2_1.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnNewButton_2_1.setFont(new Font("Dialog", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				money.spendMoney2();
			}
		});
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("1");
		btnNewButton_2_2.setBounds(661, 89, 76, 76);
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2_2.setBackground(Color.YELLOW);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnNewButton_2_2.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnNewButton_2_2.setFont(new Font("Dialog", Font.BOLD, 30));
		btnNewButton_2_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				money.spendMoney1();
				ingredients.reduceIngredients("americano");
			}
		
		});
		contentPane.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("02  Espresso $5");
		lblNewLabel_1_1.setBounds(17, 171, 185, 34);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("03  Cappuccino $3");
		lblNewLabel_1_2.setBounds(16, 213, 197, 34);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Add Money");
		btnNewButton.setBounds(187, 359, 172, 56);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.GREEN);
			}
			
			@Override
            public void mouseExited(MouseEvent e) {
                // Reset button color to its original color when mouse leaves the button
                btnNewButton.setBackground(Color.LIGHT_GRAY);
            }
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money.addMoney();		
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnChangeMoney = new JButton("Change Money");
		btnChangeMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money.changeMoney();
				
			}
		});
		btnChangeMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		btnChangeMoney.setBackground(Color.LIGHT_GRAY);
		btnChangeMoney.setBounds(410, 359, 172, 56);
		contentPane.add(btnChangeMoney);
		
		
		
	}
}
