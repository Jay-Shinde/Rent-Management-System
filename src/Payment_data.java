import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Payment_data  {
	private JTextField textField;
	private JTextField textField_1;
	private JDateChooser dateChooser;
		
	 Payment_data (){
		JFrame f=new JFrame("Rent Management: Home_Page");
		f.setBackground(new Color(255, 255, 255));
		f.setBounds(100,100 , 378, 407);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(230, 230, 250));
		panel_0.setBounds(0, 0, 364, 370);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(159, 151, 195, 29);
		panel_0.add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(159, 101, 195, 32);
		panel_0.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 100, 139, 29);
		panel_0.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(87, 151, 51, 29);
		panel_0.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(0, 0, 255));
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		textField_1.setBounds(159, 43, 195, 29);
		panel_0.add(textField_1);
		textField_1.setColumns(10);
		
		
		try {
			
			String date="0";
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");
			Statement stmt=con.createStatement();
			String sql="select * from monthly_rent where paidDate='"+ date +"' ";
			
			stmt.execute(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				
				textField_1.setText(rs.getString("Name"));
				
				
				
			}
			
			
			
	        con.close();
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}	
		
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
				    	
					 
				    	
						
					 Class.forName("com.mysql.cj.jdbc.Driver");
					
	                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");

	                 String query = "Update monthly_rent set monthRent='"+textField.getText()+"', paidDate='"+dateChooser.getDate()+"'  where Name='"+ textField_1.getText() +"' and monthRent='"+"0"+"' and paidDate='"+"0"+"'";

	                 Statement sta = connection.createStatement();
	                 sta.execute(query);
	                 connection.close();
	                 
	                 
	             } catch (Exception exception) {
	                 exception.printStackTrace();
	             }	
				 
				 
				f.setVisible(false);
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(97, 267, 156, 32);
		panel_0.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(87, 40, 51, 29);
		panel_0.add(lblName);
		
		
		
		
		
		
		
		
		
		f.setVisible(true);
	 }

	 
	
	 
	public static void main(String[] args) {
		new Payment_data();
		
	}
}
