import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;


public class Login_tab  {
	private JTextField username1;
	private JPasswordField password1;
	private String sta;
	Login_tab(){
		JFrame f=new JFrame(" Login Page");
		f.getContentPane().setBackground(new Color(230, 230, 250));
		f.setBounds(100,100 , 400, 477);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(10, 53, 366, 244);
		f.getContentPane().add(panel);
	    panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      Usesr ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 44, 96, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("     Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(0, 115, 104, 24);
		panel.add(lblNewLabel_1);
		
		username1 = new JTextField();
		username1.setBounds(114, 44, 242, 24);
		panel.add(username1);
		username1.setColumns(10);
		
		password1 = new JPasswordField();
		password1.setBounds(114, 118, 242, 24);
		panel.add(password1);
		
		JRadioButton R1 = new JRadioButton("Owner");
		R1.setBackground(new Color(250, 240, 230));
		R1.setFont(new Font("Tahoma", Font.BOLD, 12));
		R1.setBounds(126, 182, 103, 21);
		panel.add(R1);
		
		JRadioButton R2 = new JRadioButton("Tenant");
		R2.setBackground(new Color(250, 240, 230));
		R2.setFont(new Font("Tahoma", Font.BOLD, 12));
		R2.setBounds(253, 182, 103, 21);
		panel.add(R2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(R1);
		bg.add(R2);
		
		if(R1.isSelected()) {
			 sta="Owner";
		}
		
		else {
			 sta="Tenant";
		}
		JButton LoginB = new JButton("Login");
		
		LoginB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(R1.isSelected()){
					
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						
//						Class.forName("com.mysql.cj.jdbc.Driver");
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user","root","Satara@11");
						Statement stmt=con.createStatement();
						String sql="Select * from owner_login where username='"+username1.getText()+"' and password='"+password1.getText().toString()+"' ";//and state='"+sta+"'
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							
							if(R1.isSelected()) {
								int id = rs.getInt(1);
								JOptionPane.showMessageDialog(null, "Login Sucessful");
								new Login_owner(id);
								f.setVisible(false);
							}
							
							else 
								JOptionPane.showMessageDialog(null, "select any one option");
								
						}
						else
							JOptionPane.showMessageDialog(null, "Incorrect Inputs");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
				}
				if(R2.isSelected()) {
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						
//						Class.forName("com.mysql.cj.jdbc.Driver");
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user","root","Satara@11");
						Statement stmt=con.createStatement();
						String sql="Select * from tenant_login where username='"+username1.getText()+"' and password='"+password1.getText().toString()+"' ";//and state='"+sta+"'
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							
							if(R2.isSelected()) {
								JOptionPane.showMessageDialog(null, "Login Sucessful");
								//String name=rs.getString("name");
								int tenant_id = rs.getInt("tenant_id");
								
								new Login_Tenant(tenant_id);
								f.setVisible(false);
							}
							
							else 
								JOptionPane.showMessageDialog(null, "select any one option");
								
						}
						else
							JOptionPane.showMessageDialog(null, "Incorrect Inputs");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					
////					Class.forName("com.mysql.cj.jdbc.Driver");
//				
//					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user","root","Satara@11");
//					Statement stmt=con.createStatement();
//					String sql="Select * from new_table where username='"+username1.getText()+"' and password='"+password1.getText().toString()+"' ";//and state='"+sta+"'
//					ResultSet rs=stmt.executeQuery(sql);
//					if(rs.next()) {
//						
//						if(R1.isSelected()) {
//							JOptionPane.showMessageDialog(null, "Login Sucessful");
//							new Login_owner();
//							f.setVisible(false);
//						}
//						else if(R2.isSelected()) {
//							JOptionPane.showMessageDialog(null, "Login Sucessful");
//							String name=rs.getString("name");
//							
//							new Login_Tenant(name);
//							
//							f.setVisible(false);
//						}
//						else 
//							JOptionPane.showMessageDialog(null, "select any one option");
//							
//					}
//					else
//						JOptionPane.showMessageDialog(null, "Incorrect Inputs");
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
				
				
				
				
			}
		});
		LoginB.setForeground(new Color(255, 255, 255));
		
			
		
		LoginB.setBackground(new Color(255, 215, 0));
		LoginB.setBounds(10, 335, 154, 33);
		LoginB.setFont(new Font("Tahoma", Font.BOLD, 16));
		f.getContentPane().add(LoginB);
		
		JButton regi = new JButton(" New Register");
		regi.setForeground(new Color(255, 255, 255));
		regi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
					new register();
					f.setVisible(false);
				
				
			}
		});
		regi.setBackground(new Color(255, 215, 0));
		regi.setBounds(222, 335, 154, 33);
		regi.setFont(new Font("Tahoma", Font.BOLD, 16));
		f.getContentPane().add(regi);
		
		f.setVisible(true);
		
	
		
		
	}
	
	
	    public static void main(String[] args) {
		new Login_tab();
		
	}
}
