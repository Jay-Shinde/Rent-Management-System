import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Details{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnNewButton;
	public Details(String nm){
		JFrame f=new JFrame("RENT MANAGEMENT SYSTEM");
		f.getContentPane().setBackground(SystemColor.menu);
		f.setFont(new Font("Arial Black", Font.BOLD, 12));
		f.getContentPane().setForeground(SystemColor.activeCaption);
		f.setBounds(100, 100, 830, 700);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(230, 230, 250));
		panel_0.setBounds(0, 0, 828, 678);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(284, 64, 309, 41);
		panel_0.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(284, 135, 309, 41);
		panel_0.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(284, 210, 309, 41);
		panel_0.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(284, 284, 309, 41);
		panel_0.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(284, 370, 309, 41);
		panel_0.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(284, 455, 309, 41);
		panel_0.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(284, 541, 309, 41);
		panel_0.add(textField_6);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				f.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(382, 609, 117, 34);
		panel_0.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 72, 149, 25);
		panel_0.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(35, 135, 149, 25);
		panel_0.add(lblAddress);
		
		JLabel lblFamilyMembers = new JLabel("Family Members");
		lblFamilyMembers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFamilyMembers.setBounds(35, 215, 149, 25);
		panel_0.add(lblFamilyMembers);
		
		JLabel lblAgreementDateFrom = new JLabel("Agreement Date From");
		lblAgreementDateFrom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAgreementDateFrom.setBounds(35, 300, 149, 25);
		panel_0.add(lblAgreementDateFrom);
		
		JLabel lblAgreementDateTo = new JLabel("Agreement Date To");
		lblAgreementDateTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAgreementDateTo.setBounds(35, 386, 149, 25);
		panel_0.add(lblAgreementDateTo);
		
		JLabel lblDipositAmount = new JLabel("Diposit Amount ");
		lblDipositAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDipositAmount.setBounds(35, 471, 149, 25);
		panel_0.add(lblDipositAmount);
		
		JLabel lblValidDocument = new JLabel("Valid Document");
		lblValidDocument.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValidDocument.setBounds(35, 557, 149, 25);
		panel_0.add(lblValidDocument);
		
		try {
			
			
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
			Statement stmt=con.createStatement();
			String sql="select * from tenant_info where Name='"+ nm +"' ";
			
			stmt.execute(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				
				textField.setText(rs.getString("Name"));
				textField_1.setText(rs.getString("add"));
				textField_2.setText(rs.getString("family_no"));
				textField_3.setText(rs.getString("agree_date_from"));
				textField_4.setText(rs.getString("agree_date_to"));
				textField_5.setText(rs.getString("dipo_amount"));
				
				textField_6.setText(rs.getString("valid_doc"));
				
				
			}
			
			
			
	        con.close();
			
			
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}	
	   
	    
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Details(null);
	}
}

