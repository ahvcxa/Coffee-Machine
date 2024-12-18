package CoffeeMachine;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OwnerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Store store = new Store();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerFrame frame = new OwnerFrame();
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
	public OwnerFrame() {
		setResizable(false);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);  
		
		JLabel lblOwnerMenu = new JLabel("OWNER MENU");
		lblOwnerMenu.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		lblOwnerMenu.setFont(new Font("Nimbus Mono PS", Font.BOLD, 35));
		lblOwnerMenu.setBounds(268, 103, 244, 47);
		contentPane.add(lblOwnerMenu);
		
		JButton checkButton = new JButton("CHECK");
		checkButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkButton.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				store.showStock();
				
			}
		});
		checkButton.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		checkButton.setBackground(Color.LIGHT_GRAY);
		checkButton.setBounds(277, 170, 225, 47);
		contentPane.add(checkButton);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.addStock();
			}
		});
		btnAdd.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(277, 240, 225, 47);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnExit.setFont(new Font("Nimbus Mono PS", Font.BOLD, 19));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(277, 309, 225, 47);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CoffeeMachine coffeeMachine = new CoffeeMachine();
				coffeeMachine.setTitle("Coffee Machine"); 
				coffeeMachine.setVisible(true);
				
				dispose();
				
			}
		});
	}
}