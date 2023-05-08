import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Demo_login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo_login frame = new Demo_login();
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
	public Demo_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setBounds(114, 23, 207, 29);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(65, 77, 114, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(65, 139, 96, 23);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(189, 78, 158, 29);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(189, 140, 158, 29);
		contentPane.add(password);
		
		JButton login = new JButton("LOGIN");
		login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		login.setBounds(163, 207, 114, 34);
		contentPane.add(login);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/owner_login","root","Satara@11");
				Statement stmt=con.createStatement();
				String sql="Select * from new_login where username='"+username.getText()+"' and password='"+password.getText().toString()+"'";
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null, "Login Sucessful");
				else
					JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
	}
}
