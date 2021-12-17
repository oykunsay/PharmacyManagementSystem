import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setTitle("Pharmacy Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(255, 102, 144, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setForeground(new Color(102, 153, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(69, 102, 122, 35);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(102, 153, 102));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(70, 152, 122, 35);
		contentPane.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(257, 150, 141, 35);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(102, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicine medicine = new Medicine();
				medicine.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(70, 206, 140, 35);
		contentPane.add(btnNewButton);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(102, 153, 102));
		btnClear.setBounds(258, 206, 140, 35);
		contentPane.add(btnClear);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 102));
		panel.setBounds(-1, -1, 462, 86);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("LOGIN PAGE");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 39));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(139, 20, 170, 43);
		panel.add(lblNewLabel_1);
	}
}
