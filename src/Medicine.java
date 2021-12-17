import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Medicine extends JFrame {

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldMedicineId;
	private JTextField fieldMedicineName;
	private JTextField fieldMedicinePrice;
	private JTextField fieldMedicineQuantity;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine frame = new Medicine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Medicine() {
		setTitle("Pharmacy Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(125, 24, 576, 404);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("MANAGE MEDICINE");
		label.setForeground(new Color(102, 153, 102));
		label.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		label.setBounds(184, 11, 200, 37);
		panel.add(label);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(102, 153, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(21, 80, 123, 31);
		panel.add(lblNewLabel_1);

		fieldMedicineId = new JTextField();
		fieldMedicineId.setBounds(152, 80, 123, 31);
		panel.add(fieldMedicineId);
		fieldMedicineId.setColumns(10);

		JLabel lblMedname = new JLabel("MEDNAME");
		lblMedname.setForeground(new Color(102, 153, 102));
		lblMedname.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMedname.setBounds(21, 143, 123, 31);
		panel.add(lblMedname);

		fieldMedicineName = new JTextField();
		fieldMedicineName.setColumns(10);
		fieldMedicineName.setBounds(152, 143, 123, 32);
		panel.add(fieldMedicineName);

		fieldMedicinePrice = new JTextField();
		fieldMedicinePrice.setColumns(10);
		fieldMedicinePrice.setBounds(152, 209, 123, 32);
		panel.add(fieldMedicinePrice);

		JLabel lblPrce = new JLabel("PRICE");
		lblPrce.setForeground(new Color(102, 153, 102));
		lblPrce.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrce.setBounds(21, 209, 123, 31);
		panel.add(lblPrce);

		fieldMedicineQuantity = new JTextField();
		fieldMedicineQuantity.setColumns(10);
		fieldMedicineQuantity.setBounds(152, 274, 123, 32);
		panel.add(fieldMedicineQuantity);

		JLabel lblQuantty = new JLabel("QUANTITY");
		lblQuantty.setForeground(new Color(102, 153, 102));
		lblQuantty.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQuantty.setBounds(21, 274, 123, 31);
		panel.add(lblQuantty);

		JLabel lblFabdate = new JLabel("FABDATE");
		lblFabdate.setForeground(new Color(102, 153, 102));
		lblFabdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFabdate.setBounds(300, 80, 123, 31);
		panel.add(lblFabdate);

		JLabel lblExpdate = new JLabel("EXPDATE");
		lblExpdate.setForeground(new Color(102, 153, 102));
		lblExpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblExpdate.setBounds(300, 166, 123, 31);
		panel.add(lblExpdate);

		JLabel lblCompany = new JLabel("COMPANY");
		lblCompany.setForeground(new Color(102, 153, 102));
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCompany.setBounds(300, 249, 123, 31);
		panel.add(lblCompany);

		final JDateChooser dateMedicineFab = new JDateChooser();
		dateMedicineFab.setBounds(433, 80, 121, 31);
		panel.add(dateMedicineFab);

		final JDateChooser dateMedicineExp = new JDateChooser();
		dateMedicineExp.setBounds(433, 166, 121, 31);
		panel.add(dateMedicineExp);

		final JComboBox comboboxMedicineCompany = new JComboBox();
		comboboxMedicineCompany.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		comboboxMedicineCompany.setForeground(new Color(102, 153, 102));
		comboboxMedicineCompany.setBounds(433, 249, 121, 29);
		panel.add(comboboxMedicineCompany);

		JButton buttonMedicineDelete = new JButton("CLEAR");
		buttonMedicineDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldMedicineId.setText("");
				fieldMedicineName.setText("");
				fieldMedicinePrice.setText("");
				fieldMedicineQuantity.setText("");
			}
		});
		buttonMedicineDelete.setBackground(new Color(102, 153, 102));
		buttonMedicineDelete.setForeground(Color.BLACK);
		buttonMedicineDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonMedicineDelete.setBounds(346, 334, 128, 35);
		panel.add(buttonMedicineDelete);

		JButton buttonMedicineAdd = new JButton("ADD");
		buttonMedicineAdd.setBackground(new Color(102, 153, 102));
		buttonMedicineAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String expDate, fabDate = "";
				String query = "INSERT INTO MEDICINES" + "(id,name,price, quantity, fab_date, exp_date, company) VALUES"
						+ "(?,?,?,?,?,?,?)";
				try {
					Connection con = conn.connDb();
					expDate = sdf.format(dateMedicineExp.getDate());
					fabDate = sdf.format(dateMedicineFab.getDate());
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, fieldMedicineId.getText());
					pst.setString(2, fieldMedicineName.getText());
					pst.setString(3, fieldMedicinePrice.getText());
					pst.setString(4, fieldMedicineQuantity.getText());
					pst.setString(5, fabDate);
					pst.setString(6, expDate);
					pst.setString(7, (String) comboboxMedicineCompany.getSelectedItem().toString());
					pst.executeUpdate();

				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonMedicineAdd.setForeground(Color.BLACK);
		buttonMedicineAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonMedicineAdd.setBounds(164, 334, 128, 35);
		panel.add(buttonMedicineAdd);

		JLabel lblNewLabel = new JLabel("COMPANY");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Company company = new Company();
				company.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 82, 105, 37);
		contentPane.add(lblNewLabel);

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
		lblAgents.setBounds(10, 148, 105, 37);
		contentPane.add(lblAgents);

		JLabel lblSellng = new JLabel("SELLING");
		lblSellng.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Selling selling = new Selling();
				selling.setVisible(true);
				dispose();
			}
		});
		lblSellng.setForeground(Color.WHITE);
		lblSellng.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblSellng.setBounds(10, 213, 105, 37);
		contentPane.add(lblSellng);
	}
}
