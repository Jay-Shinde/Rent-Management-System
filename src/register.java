import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class register  {
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JTextField phoneno;
	private JPasswordField password;
	register(){
		JFrame f=new JFrame(" Registration Page ");
		f.getContentPane().setBackground(new Color(230, 230, 250));
		f.setBounds(100,100 , 488, 539);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		panel.setBounds(10, 62, 454, 329);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(101, 22, 59, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(69, 72, 91, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(74, 125, 91, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(107, 175, 53, 24);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone No:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(79, 228, 86, 13);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(198, 25, 246, 24);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(198, 75, 246, 24);
		panel.add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setBounds(198, 175, 246, 24);
		panel.add(email);
		email.setColumns(10);
		
		phoneno = new JTextField();
		phoneno.setBounds(198, 225, 246, 24);
		panel.add(phoneno);
		phoneno.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(198, 125, 246, 24);
		panel.add(password);
		
		JRadioButton b11 = new JRadioButton("is owner");
		b11.setFont(new Font("Tahoma", Font.BOLD, 15));
		b11.setBounds(198, 275, 104, 29);
		panel.add(b11);
		
	
		
		
		JButton LoginB = new JButton("SUBMIT");
		LoginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText().toString();
				String Email=email.getText();
				String mobno=phoneno.getText();
				String state;
	               if(b11.isSelected()) {
	            	 state= "Owner";
	            	 try {
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");

		                    String query = "INSERT INTO owner_login values('"+0+"', '" + Name + "','" + Username + "','" + Password + "','" + Email + "','" + mobno + "')";

		                    Statement sta = connection.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                    	JOptionPane.showMessageDialog(null, "Registration Unsuccessful");
		                    } else {
		                    	JOptionPane.showMessageDialog(null, "Welcome, "+ Name +"...Registration Successfull");
		                         f.setVisible(false);
	                         new Login_tab();
		                    }
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
	            	  
	              }
	              else {
	            	  state= "Tenant";
	            	  try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");

		                    String query = "INSERT INTO tenant_login values('"+0+"', '" + Name + "','" + Username + "','" + Password + "','" + Email + "','" + mobno + "')";

		                    Statement sta = connection.createStatement();
	            	  
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                    	JOptionPane.showMessageDialog(null, "Registration Unsuccessful");
		                    } else {
		                    	JOptionPane.showMessageDialog(null, "Welcome, "+ Name +"...Registration Successfull");
		                         f.setVisible(false);
		                         new Login_tab();
		                    }
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
	              }
				 
//	               try {
//	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");
//
//	                    String query = "INSERT INTO new_table values('"+0+"', '" + Name + "','" + Username + "','" + Password + "','" + Email + "','" + mobno + "','" + state + "')";
//
//	                    Statement sta = connection.createStatement();
//	                    int x = sta.executeUpdate(query);
//	                    if (x == 0) {
//	                    	JOptionPane.showMessageDialog(null, "Registration Unsuccessful");
//	                    } else {
//	                    	JOptionPane.showMessageDialog(null, "Welcome, "+ Name +"...Registration Successfull");
//	                         f.setVisible(false);
//	                         new Login_tab();
//	                    }
//	                    connection.close();
//	                } catch (Exception exception) {
//	                    exception.printStackTrace();
//	                }
	               
	               
	               
	               
	               
	               
	               
	               
	               
	               
			}
		});
		LoginB.setBackground(new Color(240, 230, 140));
		LoginB.setFont(new Font("Tahoma", Font.BOLD, 16));
		LoginB.setBounds(95, 433, 103, 33);
		f.getContentPane().add(LoginB);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
			
		});
		btnNewButton.setBackground(new Color(240, 230, 140));
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(289, 433, 103, 33);
		f.getContentPane().add(btnNewButton);
		
		f.setVisible(true);
		
	
		
		
	}
	
	public void reset() {
		
		name.setText("");
		username.setText("");
		email.setText("");
		phoneno.setText("");
		password.setText("");
		
	}
	
	
	public static void main(String[] args) {
		new register();
		
	}
}

