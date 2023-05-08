import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login_Tenant  {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
	    Login_Tenant(int tenant_id){
		JFrame f=new JFrame("Rent Management:Home Page");
		f.setBounds(100,100 , 703, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(230, 230, 250));
		panel_0.setBounds(0, 0, 689, 700);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(323, 48, 282, 35);
		panel_0.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(323, 109, 282, 35);
		panel_0.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(323, 168, 282, 35);
		panel_0.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(323, 232, 282, 35);
		panel_0.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(323, 296, 282, 35);
		panel_0.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(323, 360, 282, 35);
		panel_0.add(textField_5);
		
		JButton btnNewButton = new JButton("Refresh Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
					Statement stmt=con.createStatement();
					String sql="select * from tenant_info where tenant_id ='"+ tenant_id +"' ";
					
					stmt.execute(sql);
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						
						textField.setText(rs.getString("Name"));
						textField_1.setText(rs.getString("rent"));
						textField_2.setText(rs.getString("E_bill"));
						textField_3.setText(rs.getString("W_bill"));
						textField_4.setText(rs.getString("maint"));
						textField_5.setText(rs.getString("Past_due"));
						textField_6.setText(rs.getString("month"));
						textField_7.setText(rs.getString("Pay_status"));
						
						
					}
					
					
					
			        con.close();
					
					
					
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}	
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(262, 586, 158, 35);
		panel_0.add(btnNewButton);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(323, 423, 282, 35);
		panel_0.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(323, 484, 282, 35);
		panel_0.add(textField_7);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(166, 48, 57, 35);
		panel_0.add(lblNewLabel);
		
		JLabel lblMonthlyRent = new JLabel("Monthly Rent");
		lblMonthlyRent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonthlyRent.setBounds(102, 109, 121, 35);
		panel_0.add(lblMonthlyRent);
		
		JLabel lblElecBill = new JLabel("Elec. Bill");
		lblElecBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElecBill.setBounds(135, 168, 79, 35);
		panel_0.add(lblElecBill);
		
		JLabel lblWaterBill = new JLabel("Water Bill");
		lblWaterBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWaterBill.setBounds(122, 232, 92, 35);
		panel_0.add(lblWaterBill);
		
		JLabel lblMaintanance = new JLabel("Maintenance");
		lblMaintanance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaintanance.setBounds(101, 296, 113, 35);
		panel_0.add(lblMaintanance);
		
		JLabel lblPastDue = new JLabel("Past Due");
		lblPastDue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPastDue.setBounds(130, 360, 84, 35);
		panel_0.add(lblPastDue);
		
		JLabel lblMonthOfRent = new JLabel("Month of Rent");
		lblMonthOfRent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonthOfRent.setBounds(87, 423, 127, 35);
		panel_0.add(lblMonthOfRent);
		
		JLabel lblPayStatus = new JLabel("Pay Status");
		lblPayStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPayStatus.setBounds(116, 484, 98, 35);
		panel_0.add(lblPayStatus);
		//f.getContentPane().add(lab0);
		
		
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Login_Tenant(0);
		
	}
}

