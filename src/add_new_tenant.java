import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class add_new_tenant  {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	//private JTextField textField_5;
	private JTextField textField_6;
	private JDateChooser dateChooser_1;
    private JDateChooser dateChooser;
	static String valid_doc;
	private JTextField textField_3;
	
	    add_new_tenant(int oid){
		JFrame f=new JFrame("Rent Management: Add New Tenant");
		f.setBounds(100,100 , 1000, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(230, 230, 250));
		panel_0.setBounds(0, 0, 1000, 700);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		JLabel lblNew_name = new JLabel("Full Name");
		lblNew_name.setBackground(Color.WHITE);
		lblNew_name.setForeground(Color.BLACK);
		lblNew_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNew_name.setBounds(191, 78, 100, 36);
		panel_0.add(lblNew_name);
		
		JLabel lblNew_name_1 = new JLabel("Tenant ID");
		lblNew_name_1.setForeground(Color.BLACK);
		lblNew_name_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNew_name_1.setBackground(Color.WHITE);
		lblNew_name_1.setBounds(191, 128, 95, 36);
		panel_0.add(lblNew_name_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(339, 130, 174, 36);
		panel_0.add(textField_3);
		
		JLabel lblNew_no = new JLabel("No. of Family Members");
		lblNew_no.setBackground(Color.WHITE);
		lblNew_no.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNew_no.setBounds(77, 176, 214, 36);
		panel_0.add(lblNew_no);
		
		JLabel lblNewaddress = new JLabel("Address");
		lblNewaddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewaddress.setBounds(209, 233, 81, 36);
		panel_0.add(lblNewaddress);
		
		JLabel lbl_agreementDate = new JLabel("Date Of Rent-Agreement");
		lbl_agreementDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_agreementDate.setBounds(57, 279, 239, 36);
		panel_0.add(lbl_agreementDate);
		
		JLabel lbl_deposit = new JLabel("Deposit Amount");
		lbl_deposit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_deposit.setBounds(135, 381, 155, 36);
		panel_0.add(lbl_deposit);
		
		JLabel lbl_validation = new JLabel("Validation Document");
		lbl_validation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_validation.setBounds(91, 441, 195, 36);
		panel_0.add(lbl_validation);
		
		JLabel lbl_rent = new JLabel("Monthly Rent");
		lbl_rent.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_rent.setBounds(158, 498, 132, 36);
		panel_0.add(lbl_rent);
		
		textField = new JTextField();
		textField.setBounds(339, 78, 363, 36);
		panel_0.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(339, 176, 363, 36);
		panel_0.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(339, 222, 363, 36);
		panel_0.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(339, 385, 363, 36);
		panel_0.add(textField_4);
		
		//textField_5 = new JTextField();
		//textField_5.setColumns(10);
		//textField_5.setBounds(339, 431, 363, 19);
		//panel_0.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(339, 498, 363, 36);
		panel_0.add(textField_6);
		
		JLabel lblNew_from = new JLabel("From :");
		lblNew_from.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNew_from.setBounds(382, 286, 57, 25);
		panel_0.add(lblNew_from);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTo.setBounds(401, 321, 38, 25);
		panel_0.add(lblTo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(339, 435, 363, 36);
		panel_0.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Documents");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Aadhaar Card");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valid_doc="Aadhaar Card";
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ration Card");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valid_doc="Ration Card";
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Voter ID");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valid_doc="Voter ID";	
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Pan Card");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valid_doc="Pan Card";
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				
			    try {
			    	
			    	
			    	String Name=textField.getText();
					String No_of_F=textField_1.getText();
					String Address=textField_2.getText();
					String tid=textField_3.getText();
					String Diposit=textField_4.getText();
					//String valid_doc=textField_5.getText();
					String rent=textField_6.getText();
					String from_date=dateChooser_1.getDate().toString();
				    String to_date=dateChooser.getDate().toString();
					
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
                    Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");

                    String query = "INSERT INTO tenant_info values('" + tid + "','" + Name + "','" + No_of_F + "','" + Address + "','" + from_date + "','" + to_date + "','" + Diposit + "','"+ valid_doc +"','"+ rent +"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"')";
                    String q1 =   "INSERT INTO owner_tenants values('" + tid + "','" + oid + "')";
                    Statement sta = connection.createStatement();
                    Statement sta1 = connection1.createStatement();
                    sta1.executeUpdate(q1);
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                    	JOptionPane.showMessageDialog(null, "Erorr generated !!! try again");
                    } else {
                    	JOptionPane.showMessageDialog(null, "New tenant info added successfully...");
                         f.setVisible(false);
                         new Login_owner(oid);
                    }
                    connection.close();
                    connection1.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
					      
			      
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(210, 596, 137, 36);
		panel_0.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(218, 165, 32));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(376, 596, 137, 36);
		panel_0.add(btnReset);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(472, 321, 230, 25);
		panel_0.add(dateChooser_1);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(472, 279, 230, 25);
		panel_0.add(dateChooser);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login_owner(oid);
				f.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(218, 165, 32));
		btnBack.setBounds(546, 596, 137, 36);
		panel_0.add(btnBack);
		
		
		
		
		
		
		f.setVisible(true);
		
	}
	  public void reset() {
		  
		  textField.setText("");
		  textField_1.setText("");
		  textField_2.setText("");
		  
		  textField_4.setText("");
		  valid_doc="";
		  textField_6.setText("");
		  dateChooser.setDate(null);
		  dateChooser_1.setDate(null);
	  }
	  
	
	
	public static void main(String[] args) {
		new add_new_tenant(0);
		
	}
}

