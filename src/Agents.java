import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Agents extends JFrame {

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldAgentId;
	private JTextField fieldAgentName;
	private JTextField fieldAgentAge;
	private JTextField fieldAgentPassword;
	private JTextField fieldAgentPhone;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agents frame = new Agents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Agents() {
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
		panel_1.setBounds(125, 24, 576, 404);
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

		fieldAgentId = new JTextField();
		fieldAgentId.setColumns(10);
		fieldAgentId.setBounds(152, 80, 123, 31);
		panel_1.add(fieldAgentId);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(102, 153, 102));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblName.setBounds(21, 143, 123, 31);
		panel_1.add(lblName);

		fieldAgentName = new JTextField();
		fieldAgentName.setColumns(10);
		fieldAgentName.setBounds(152, 143, 123, 32);
		panel_1.add(fieldAgentName);

		fieldAgentAge = new JTextField();
		fieldAgentAge.setColumns(10);
		fieldAgentAge.setBounds(152, 209, 123, 32);
		panel_1.add(fieldAgentAge);

		JLabel lblAge = new JLabel("AGE");
		lblAge.setForeground(new Color(102, 153, 102));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAge.setBounds(21, 209, 123, 31);
		panel_1.add(lblAge);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(new Color(102, 153, 102));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhone.setBounds(300, 80, 123, 31);
		panel_1.add(lblPhone);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(new Color(102, 153, 102));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGender.setBounds(300, 209, 123, 31);
		panel_1.add(lblGender);

		final JComboBox comboboxGender = new JComboBox();
		comboboxGender.setModel(new DefaultComboBoxModel(new String[] { "MALE", "FEMALE" }));
		comboboxGender.setForeground(new Color(102, 153, 102));
		comboboxGender.setBounds(433, 209, 121, 29);
		panel_1.add(comboboxGender);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldAgentAge.setText("");
				fieldAgentId.setText("");
				fieldAgentName.setText("");
				fieldAgentPassword.setText("");
				fieldAgentPhone.setText("");
			}
		});
		btnClear.setBackground(new Color(102, 153, 102));
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(365, 297, 128, 35);
		panel_1.add(btnClear);

		JButton button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO AGENTS" + "(id,name,age,phone,password,gender) VALUES" + "(?,?,?,?,?,?)";
				try {
					Connection con = conn.connDb();
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, fieldAgentId.getText());
					pst.setString(2, fieldAgentName.getText());
					pst.setString(3, fieldAgentAge.getText());
					pst.setString(4, fieldAgentPassword.getText());
					pst.setString(5, comboboxGender.getSelectedItem().toString());
					pst.executeUpdate();

				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setBackground(new Color(102, 153, 102));
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(196, 296, 128, 35);
		panel_1.add(button_1);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(102, 153, 102));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(300, 143, 123, 31);
		panel_1.add(lblPassword);

		fieldAgentPassword = new JTextField();
		fieldAgentPassword.setColumns(10);
		fieldAgentPassword.setBounds(431, 143, 123, 32);
		panel_1.add(fieldAgentPassword);

		fieldAgentPhone = new JTextField();
		fieldAgentPhone.setColumns(10);
		fieldAgentPhone.setBounds(431, 80, 123, 32);
		panel_1.add(fieldAgentPhone);

		JLabel label_8 = new JLabel("COMPANY");
		label_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Company company = new Company();
				company.setVisible(true);
				dispose();
			}
		});
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label_8.setBounds(10, 82, 105, 37);
		panel.add(label_8);

		JLabel lblMedcnes = new JLabel("MEDICINES");
		lblMedcnes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Medicine medicine = new Medicine();
				medicine.setVisible(true);
				dispose();
			}
		});
		lblMedcnes.setForeground(Color.WHITE);
		lblMedcnes.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblMedcnes.setBounds(10, 148, 105, 37);
		panel.add(lblMedcnes);

		JLabel label_10 = new JLabel("SELLING");
		label_10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Selling selling = new Selling();
				selling.setVisible(true);
				dispose();
			}
		});
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label_10.setBounds(10, 213, 105, 37);
		panel.add(label_10);
	}
}
