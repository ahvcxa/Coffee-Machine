package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class CoffeeMachineMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMachineMainFrame frame = new CoffeeMachineMainFrame();
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
	public CoffeeMachineMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoffeeMachine = new JLabel("COFFEE MACHINE\n");
		lblCoffeeMachine.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		lblCoffeeMachine.setFont(new Font("Nimbus Mono PS", Font.BOLD, 37));
		lblCoffeeMachine.setBounds(239, 115, 317, 65);
		contentPane.add(lblCoffeeMachine);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyFrame buyFrame = new BuyFrame();
				buyFrame.setVisible(true);
			}
		});
		btnBuy.setFont(new Font("Nimbus Mono PS", Font.BOLD, 21));
		btnBuy.setBackground(Color.LIGHT_GRAY);
		btnBuy.setBounds(274, 192, 225, 47);
		contentPane.add(btnBuy);
		
		
		JButton btnType = new JButton("TYPE");
		btnType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeFrame typeFrame = new TypeFrame();
				typeFrame.setVisible(true);
			}
		});
		btnType.setFont(new Font("Nimbus Mono PS", Font.BOLD, 21));
		btnType.setBackground(Color.LIGHT_GRAY);
		btnType.setBounds(274, 265, 225, 47);
		contentPane.add(btnType);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportFrame reportFrame = new ReportFrame();
				reportFrame.setVisible(true);
			}
		});
		btnReport.setFont(new Font("Nimbus Mono PS", Font.BOLD, 21));
		btnReport.setBackground(Color.LIGHT_GRAY);
		btnReport.setBounds(274, 340, 225, 47);
		contentPane.add(btnReport);
		
		
		JButton btnTurnOff = new JButton("TURN OFF");
		btnTurnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTurnOff.setFont(new Font("Nimbus Mono PS", Font.BOLD, 21));
		btnTurnOff.setBackground(Color.LIGHT_GRAY);
		btnTurnOff.setBounds(274, 417, 225, 47);
		contentPane.add(btnTurnOff);
		
		
		btnTurnOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	btnTurnOff.setBackground(Color.CYAN);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            	btnTurnOff.setBackground(Color.LIGHT_GRAY); 
            }
        });
		
		btnReport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	btnReport.setBackground(Color.CYAN);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            	btnReport.setBackground(Color.LIGHT_GRAY); 
            }
        });
		
		btnType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	btnType.setBackground(Color.CYAN);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            	btnType.setBackground(Color.LIGHT_GRAY); 
            }
        });
		
		
		btnBuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            	btnBuy.setBackground(Color.CYAN);  
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            	btnBuy.setBackground(Color.LIGHT_GRAY);
            }
        });
		
		
		
		
		
	}
}
