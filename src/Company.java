import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Company extends JFrame {

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldCompanyId;
	private JTextField fieldCompanyName;
	private JTextField fieldCompanyAddress;
	private JTextField fieldCompanyPhone;
	private JTextField fieldCompanyExperience;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Company frame = new Company();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Company() {
		setTitle("Pharmacy Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 153, 102));
		panel.setBounds(0, 0, 701, 428);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(125, 23, 576, 404);
		panel.add(panel_1);

		JLabel label = new JLabel("MANAGE MEDICINE");
		label.setForeground(new Color(102, 153, 102));
		label.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label.setBounds(184, 11, 200, 37);
		panel_1.add(label);

		JLabel label_1 = new JLabel("ID");
		label_1.setForeground(new Color(102, 153, 102));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(21, 80, 123, 31);
		panel_1.add(label_1);

		fieldCompanyId = new JTextField();
		fieldCompanyId.setColumns(10);
		fieldCompanyId.setBounds(152, 80, 123, 31);
		panel_1.add(fieldCompanyId);

		JLabel label_2 = new JLabel("NAME");
		label_2.setForeground(new Color(102, 153, 102));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(21, 143, 123, 31);
		panel_1.add(label_2);

		fieldCompanyName = new JTextField();
		fieldCompanyName.setColumns(10);
		fieldCompanyName.setBounds(152, 143, 123, 32);
		panel_1.add(fieldCompanyName);

		fieldCompanyAddress = new JTextField();
		fieldCompanyAddress.setColumns(10);
		fieldCompanyAddress.setBounds(152, 209, 123, 32);
		panel_1.add(fieldCompanyAddress);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(102, 153, 102));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddress.setBounds(21, 209, 123, 31);
		panel_1.add(lblAddress);

		JLabel lblExperence = new JLabel("EXPERIENCE");
		lblExperence.setForeground(new Color(102, 153, 102));
		lblExperence.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblExperence.setBounds(302, 117, 123, 31);
		panel_1.add(lblExperence);

		JButton buttonCompanyClear = new JButton("CLEAR");
		buttonCompanyClear.setBackground(new Color(102, 153, 102));
		buttonCompanyClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldCompanyAddress.setText("");
				fieldCompanyExperience.setText("");
				fieldCompanyId.setText("");
				fieldCompanyName.setText("");
				fieldCompanyPhone.setText("");
			}
		});
		buttonCompanyClear.setForeground(Color.BLACK);
		buttonCompanyClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonCompanyClear.setBounds(321, 300, 128, 35);
		panel_1.add(buttonCompanyClear);

		JButton buttonCompanyAdd = new JButton("ADD");
		buttonCompanyAdd.setBackground(new Color(102, 153, 102));
		buttonCompanyAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO COMPANY" + "(id,name,address,experience,phone) VALUES" + "(?,?,?,?,?)";
				try {
					Connection con = conn.connDb();
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, fieldCompanyId.getText());
					pst.setString(2, fieldCompanyName.getText());
					pst.setString(3, fieldCompanyExperience.getText());
					pst.setString(4, fieldCompanyPhone.getText());
					pst.executeUpdate();

				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonCompanyAdd.setForeground(new Color(0, 0, 0));
		buttonCompanyAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonCompanyAdd.setBounds(152, 299, 128, 35);
		panel_1.add(buttonCompanyAdd);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(new Color(102, 153, 102));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhone.setBounds(302, 180, 123, 31);
		panel_1.add(lblPhone);

		fieldCompanyPhone = new JTextField();
		fieldCompanyPhone.setColumns(10);
		fieldCompanyPhone.setBounds(433, 180, 123, 32);
		panel_1.add(fieldCompanyPhone);

		fieldCompanyExperience = new JTextField();
		fieldCompanyExperience.setColumns(10);
		fieldCompanyExperience.setBounds(433, 117, 123, 32);
		panel_1.add(fieldCompanyExperience);

		JLabel lblAgents = new JLabel("AGENTS");
		lblAgents.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Agents agents = new Agents();
				agents.setVisible(true);
				dispose();
			}
		});
		lblAgents.setForeground(Color.WHITE);
		lblAgents.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblAgents.setBounds(10, 82, 105, 37);
		panel.add(lblAgents);

		JLabel label_8 = new JLabel("MEDICINES");
		label_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Medicine medicine = new Medicine();
				medicine.setVisible(true);
				dispose();
			}
		});
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label_8.setBounds(10, 148, 105, 37);
		panel.add(label_8);

		JLabel label_9 = new JLabel("SELLING");
		label_9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Selling selling = new Selling();
				selling.setVisible(true);
				dispose();
			}
		});
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label_9.setBounds(10, 213, 105, 37);
		panel.add(label_9);
	}

}
