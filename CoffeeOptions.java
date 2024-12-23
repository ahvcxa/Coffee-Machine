package CoffeeMachine;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CoffeeOptions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private Money money = new Money();
    private static Ingredients ingredients = new Ingredients();

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

    public CoffeeOptions() {
    	setTitle("Coffee Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CoffeeMachine coffeeMachine = new CoffeeMachine();
                coffeeMachine.setVisible(true);
            }
        });
        
        setBounds(600, 250, 782, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel choice = new JLabel("Choose your coffee:");
        choice.setBounds(27, 82, 336, 42);
        choice.setForeground(new Color(245, 222, 179));
        choice.setFont(new Font("Dialog", Font.BOLD, 30));
        contentPane.add(choice);

        JLabel americanoText = new JLabel("01  Americano $5");
        americanoText.setBounds(29, 162, 180, 33);
        americanoText.setFont(new Font("Dialog", Font.PLAIN, 22));
        americanoText.setForeground(new Color(245, 222, 179));
        contentPane.add(americanoText);

        JLabel espressoText = new JLabel("02  Espresso $3");
        espressoText.setBounds(29, 205, 185, 34);
        espressoText.setFont(new Font("Dialog", Font.PLAIN, 22));
        espressoText.setForeground(new Color(245, 222, 179));
        contentPane.add(espressoText);

        JLabel cappuccinoText = new JLabel("03  Cappuccino $8");
        cappuccinoText.setBounds(28, 247, 197, 34);
        cappuccinoText.setFont(new Font("Dialog", Font.PLAIN, 22));
        cappuccinoText.setForeground(new Color(245, 222, 179));
        contentPane.add(cappuccinoText);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(593, 82, 101, 27);
        contentPane.add(list);
        updateList();

        JButton btn1 = new JButton("$1");
        btn1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btn1.setBackground(Color.YELLOW);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btn1.setBackground(Color.LIGHT_GRAY);
        	}
        });
        btn1.setFont(new Font("Dialog", Font.BOLD, 13));
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                money.addMoney(1);
                updateList();
            }
        });
        btn1.setBounds(664, 120, 56, 55);
        contentPane.add(btn1);

        JButton btn5 = new JButton("$5");
        btn5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btn5.setBackground(Color.YELLOW);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btn5.setBackground(Color.LIGHT_GRAY);
        	}
        });
        btn5.setFont(new Font("Dialog", Font.BOLD, 13));
        btn5.setBackground(Color.LIGHT_GRAY);
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                money.addMoney(2);
                updateList();
            }
        });
        btn5.setBounds(664, 183, 56, 55);
        contentPane.add(btn5);

        JButton btn10 = new JButton("$10");
        btn10.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btn10.setBackground(Color.YELLOW);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btn10.setBackground(Color.LIGHT_GRAY);
        	}
        });
        btn10.setFont(new Font("Dialog", Font.BOLD, 13));
        btn10.setBackground(Color.LIGHT_GRAY);
        btn10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                money.addMoney(3);
                updateList();
            }
        });
        btn10.setBounds(664, 246, 56, 55);
        contentPane.add(btn10);

        JButton btnChangeMoney = new JButton("Return");
        btnChangeMoney.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnChangeMoney.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e) {
                btnChangeMoney.setBackground(Color.LIGHT_GRAY);
            }
        });
        btnChangeMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                money.changeMoney();
                updateList();
            }
        });

        btnChangeMoney.setFont(new Font("Dialog", Font.BOLD, 13));
        btnChangeMoney.setBackground(Color.LIGHT_GRAY);
        btnChangeMoney.setBounds(549, 309, 81, 56);
        contentPane.add(btnChangeMoney);

        JButton exitButton = new JButton("Back");
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
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CoffeeMachine coffeeMachine = new CoffeeMachine();
                coffeeMachine.setVisible(true);
            }
        });
        exitButton.setFont(new Font("Dialog", Font.BOLD, 13));
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setBounds(650, 309, 81, 56);
        contentPane.add(exitButton);
        
        JButton selectAmericano = new JButton("1");
		selectAmericano.setBounds(563, 120, 56, 55);
		selectAmericano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectAmericano.setBackground(Color.YELLOW);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				 selectAmericano.setBackground(Color.LIGHT_GRAY);
			}
		});
		selectAmericano.setFont(new Font("Dialog", Font.BOLD, 30));
		selectAmericano.setBackground(Color.LIGHT_GRAY);
		selectAmericano.setForeground(Color.BLACK);
		selectAmericano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = 1;
				money.spendMoney(choice);
				updateList();
				ingredients.reduceManager("americano");
			}
		
		});
		
		contentPane.add(selectAmericano);
		
		 JButton selectEspresso = new JButton("2");
			selectEspresso.setForeground(Color.BLACK);
			selectEspresso.setBounds(563, 183, 56, 55);
			selectEspresso.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					selectEspresso.setBackground(Color.YELLOW);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					selectEspresso.setBackground(Color.LIGHT_GRAY);
				}
			});
			selectEspresso.setFont(new Font("Dialog", Font.BOLD, 30));
			selectEspresso.setBackground(Color.LIGHT_GRAY);
			selectEspresso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int choice = 2;
					money.spendMoney(choice);
					updateList();
					ingredients.reduceManager("espresso");
				}
			});
			
			contentPane.add(selectEspresso);
        
        JButton selectCappuccino = new JButton("3");
		selectCappuccino.setForeground(Color.BLACK);
		selectCappuccino.setBounds(563, 246, 56, 55);
		selectCappuccino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectCappuccino.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectCappuccino.setBackground(Color.LIGHT_GRAY);
			}
		});
		selectCappuccino.setFont(new Font("Dialog", Font.BOLD, 30));
		selectCappuccino.setBackground(Color.LIGHT_GRAY);
		selectCappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = 3;
				money.spendMoney(choice);
				updateList();
				ingredients.reduceManager("cappuccino");
			}
		});
		
		contentPane.add(selectCappuccino);}
        
    private void updateList() {
        listModel.clear();
        listModel.addElement("Total: $" + Money.Money);
    }
}
