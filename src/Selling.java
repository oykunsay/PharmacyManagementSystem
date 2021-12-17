import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selling extends JFrame {
	
	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldSellingId;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selling frame = new Selling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Selling() {
		setTitle("Pharmacy Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("COMPANY");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Company company = new Company();
				company.setVisible(true);
				dispose();
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label.setBounds(10, 66, 105, 37);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("MEDICINES");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Medicine medicine = new Medicine();
				medicine.setVisible(true);
				dispose();
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label_1.setBounds(10, 132, 105, 37);
		contentPane.add(label_1);
		
		JLabel lblInformaton = new JLabel("INFORMATION");
		lblInformaton.setForeground(Color.WHITE);
		lblInformaton.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblInformaton.setBounds(10, 197, 133, 37);
		contentPane.add(lblInformaton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(153, 48, 490, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		fieldSellingId = new JTextField();
		fieldSellingId.setColumns(10);
		fieldSellingId.setBounds(241, 37, 123, 31);
		panel.add(fieldSellingId);
		
		JLabel label_2 = new JLabel("ID");
		label_2.setForeground(new Color(102, 153, 102));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(110, 37, 123, 31);
		panel.add(label_2);
		
		JButton btnFnd = new JButton("FIND");
		btnFnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				  {
				      String url = " jdbc:h2:tcp://localhost/~/pharmacy";
				      String user = "root";
				      String password = "1234";
				    
				      Connection con = DriverManager.getConnection(url, user, password);
				    
				      String selectedId = fieldSellingId.getText();
				      String query = "SELECT * FROM MEDICINES WHERE ID='" + selectedId + "'";
				    
				      Statement stm = con.createStatement();
				      ResultSet res = stm.executeQuery(query);
				    
				      String columns[] = { "ID", "Name", "Price", "Quantity", "Fab_Date", "Exp_Date", "Company"};
				      String data[][] = new String[1][6];
				      int i = 0;
				      while (res.next()) {
				        String name = res.getString("NAME");
				        String price = res.getString("PRICE");
				        String quantity = res.getString("QUANTITY");
				        String fabDate = res.getString("FAB_DATE");
				        String expDate = res.getString("EXP_DATE");
				        String company = res.getString("COMPANY");
				        
				        data[i][0] = selectedId + "";
				        data[i][1] = name;
				        data[i][2] = price;
				        data[i][3] = quantity;
				        data[i][4] = fabDate;
				        data[i][5] = expDate;
				        data[i][6] = company;  
				        i++;
				      }
				    
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      JFrame f = new JFrame("ID Based Table");
				      JPanel panel = new JPanel();
				      panel.add(pane);
				      f.getContentPane().add(panel);
				      f.setSize(500, 250);
				      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				      f.setVisible(true);
				    
				    } catch(SQLException e2) {
				      e2.printStackTrace();
				    }
			}
		});
		btnFnd.setForeground(Color.BLACK);
		btnFnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFnd.setBackground(new Color(102, 153, 102));
		btnFnd.setBounds(144, 114, 179, 35);
		panel.add(btnFnd);
		
		JLabel lblNewLabel = new JLabel("To Show All Medicines Click Here:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(105, 176, 259, 31);
		panel.add(lblNewLabel);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				  {
				String url = " jdbc:h2:tcp://localhost/~/pharmacy";
			      String user = "root";
			      String password = "1234";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			    
			      String query = "SELECT * FROM MEDICINES";
			    
			      Statement st = con.createStatement();
			      ResultSet rs = st.executeQuery(query);
			    
			      String columns[] = { "ID", "Name", "Price", "Quantity", "Fab_Date", "Exp_Date", "Company"};
			      String data[][] = new String[1][6];
			      int i = 0;
			      while (rs.next()) {
			    	int id = rs.getInt("ID");
			        String name = rs.getString("NAME");
			        String price = rs.getString("PRICE");
			        String quantity = rs.getString("QUANTITY");
			        String fabDate = rs.getString("FAB_DATE");
			        String expDate = rs.getString("EXP_DATE");
			        String company = rs.getString("COMPANY");
			        
			        data[i][0] = id + "";
			        data[i][1] = name;
			        data[i][2] = price;
			        data[i][3] = quantity;
			        data[i][4] = fabDate;
			        data[i][5] = expDate;
			        data[i][6] = company;  
			        i++;
			      }
			    
			      DefaultTableModel model = new DefaultTableModel(data, columns);
			      JTable table = new JTable(model);
			      table.setShowGrid(true);
			      table.setShowVerticalLines(true);
			      JScrollPane pane = new JScrollPane(table);
			      JFrame f = new JFrame("Medicine Table");
			      JPanel panel = new JPanel();
			      panel.add(pane);
			      f.getContentPane().add(panel);
			      f.setSize(500, 250);
			      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      f.setVisible(true);
			    
			    } catch(SQLException e3) {
			      e3.printStackTrace();
			    }
		}
		});
		btnShow.setForeground(Color.BLACK);
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShow.setBackground(new Color(102, 153, 102));
		btnShow.setBounds(144, 227, 179, 35);
		panel.add(btnShow);
	}
}

