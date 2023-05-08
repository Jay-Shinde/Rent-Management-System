import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;



import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JMonthChooser;

public class Login_owner  {
	
	private JTable table;
	static String nm;
	static int tid;
	static int oid;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	static String Past_;
	
	
	private JMonthChooser monthChooser;
	Login_owner(int oid){
			JFrame f=new JFrame("Rent Management: Home_Page");
			f.setBackground(new Color(255, 255, 255));
			f.setBounds(100,100 , 1000, 700);
			f.setLocationRelativeTo(null);
			f.getContentPane().setLayout(null);
			
			JPanel panel_0 = new JPanel();
			panel_0.setBackground(new Color(230, 230, 250));
			panel_0.setBounds(0, 0, 1000, 663);
			f.getContentPane().add(panel_0);
			panel_0.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 117, 459, 402);
			panel_0.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					try {
					
						int row = table.getSelectedRow();
						nm=(table.getModel().getValueAt(row, 1)).toString();
						tid=(int) table.getModel().getValueAt(row, 0);
						Class.forName("com.mysql.cj.jdbc.Driver");
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
						Statement stmt=con.createStatement();
						String sql="select * from tenant_info where Name='"+ nm +"' ";
						
						stmt.execute(sql);
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							
							textField.setText(rs.getString("Name"));
							textField_1.setText(rs.getString("rent"));
							textField_2.setText(rs.getString("E_bill"));
							textField_3.setText(rs.getString("W_bill"));
							textField_4.setText(rs.getString("maint"));
							textField_5.setText(rs.getString("Past_due"));
							
							Past_=rs.getString("Past_due");
							
							
						}
						
						
						
				        con.close();
						
						
						
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}	
					
					
					
					
					
					
				}
			});
			scrollPane.setViewportView(table);
			
			JButton btn_delete = new JButton("Delete");
			btn_delete.setForeground(Color.RED);
			btn_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int action=JOptionPane.showConfirmDialog(null,"Please confirm delete operation !", "Delete",JOptionPane.YES_NO_OPTION);
					if(action==0) {
					try {
						
					
						Class.forName("com.mysql.cj.jdbc.Driver");
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
						Statement stmt=con.createStatement();
						String sql="delete from tenant_info where Name='"+ nm +"' ";
						
				    	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");
						Statement stmt1=con1.createStatement();
						String sql1="delete from register_user.tenant_login where tenant_id='"+ tid +"'";
						String sql2="delete from register_user.owner_tenants where tenant_id='"+ tid +"'";
						
//						String sql1="delete from register_user.owner_login where password='"+ 123 +"'";
						
						stmt.execute(sql);
						stmt1.execute(sql1);
						stmt1.execute(sql2);
						
						
						  con.close();
						  con1.close();
						
						
						
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					}
					Refresh_data();
					
				}
			});
			btn_delete.setBackground(new Color(255, 215, 0));
			btn_delete.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn_delete.setBounds(307, 557, 130, 42);
			panel_0.add(btn_delete);
			
			JButton btn_Add = new JButton("Add");
			btn_Add.setForeground(Color.WHITE);
			btn_Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new add_new_tenant(oid);
					f.setVisible(false);
					
				}
				
				
				
			});
			btn_Add.setBackground(new Color(255, 215, 0));
			btn_Add.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn_Add.setBounds(72, 557, 130, 42);
			panel_0.add(btn_Add);
			
			JButton btnNewButton = new JButton("Refresh Data");
			btnNewButton.setBackground(new Color(255, 215, 0));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					Refresh_data();
					
				    
					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton.setBounds(87, 78, 167, 29);
			panel_0.add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(504, 106, 148, 35);
			panel_0.add(lblNewLabel);
			
			JLabel lblElectricityBill = new JLabel("Electricity Bill");
			lblElectricityBill.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblElectricityBill.setBounds(504, 194, 148, 35);
			panel_0.add(lblElectricityBill);
			
			JLabel lblWaterBill = new JLabel("Water Bill");
			lblWaterBill.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblWaterBill.setBounds(504, 253, 148, 35);
			panel_0.add(lblWaterBill);
			
			JLabel lblMaintenance = new JLabel("Maintenance");
			lblMaintenance.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMaintenance.setBounds(504, 303, 148, 35);
			panel_0.add(lblMaintenance);
			
			JLabel lblPastDues = new JLabel("Past Dues");
			lblPastDues.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPastDues.setBounds(504, 366, 148, 35);
			panel_0.add(lblPastDues);
			
			JLabel lblMonthRent = new JLabel("Month Rent");
			lblMonthRent.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMonthRent.setBounds(504, 149, 148, 35);
			panel_0.add(lblMonthRent);
			
			JLabel lblStatus = new JLabel("status");
			lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblStatus.setBounds(504, 503, 130, 35);
			panel_0.add(lblStatus);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(690, 106, 287, 25);
			panel_0.add(textField);
			
			JRadioButton R1 = new JRadioButton("Paid");
			R1.setBounds(664, 512, 103, 21);
			panel_0.add(R1);
			
			JRadioButton R3 = new JRadioButton("Not Paid");
			R3.setBounds(874, 512, 103, 21);
			panel_0.add(R3);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(690, 148, 287, 25);
			panel_0.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(690, 191, 287, 25);
			panel_0.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(690, 253, 287, 25);
			panel_0.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(690, 303, 287, 25);
			panel_0.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			textField_5.setBounds(690, 366, 287, 25);
			panel_0.add(textField_5);
			
			
			
			JLabel lblForMonth = new JLabel("For Month");
			lblForMonth.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblForMonth.setBounds(504, 447, 148, 35);
			panel_0.add(lblForMonth);
			
			JRadioButton R2 = new JRadioButton("Yet to Pay");
			R2.setBounds(769, 512, 103, 21);
			panel_0.add(R2);
			
			ButtonGroup bg=new ButtonGroup();
			bg.add(R1);
			bg.add(R2);
			bg.add(R3);
			
			
			
			
			
			
			/*if(R1.isSelected())	{
				
				int action=JOptionPane.showConfirmDialog(null,"Please press 'Yes' if and only if  the Payment is successfull ...", "Delete",JOptionPane.YES_NO_OPTION);
				if(action==0) {
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");

	                String query = "INSERT INTO monthly_rent values('" + nm + "','" + "0" + "','" + "0"+ "')";

	                Statement sta = connection.createStatement();
	                 sta.executeUpdate(query);
	                 connection.close();
					
					
				} catch (Exception exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
				}
				 
			}	
				
			*/	
					
			
			
			JButton btn_Add_1 = new JButton("Update");
			btn_Add_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			 try {
			    	
				 String a=textField_1.getText();
					String s=textField_2.getText();	
					String d=textField_3.getText();
					String f=textField_4.getText();
					String date_=Integer.toString(monthChooser.getMonth()+1) ;
					String status=new String();
					
					
					int n= (Integer.parseInt(a)+Integer.parseInt(s)+Integer.parseInt(d)+Integer.parseInt(f)+Integer.parseInt(Past_));
					 
					   
				if(R1.isSelected())	{
					
					 try {
					    	
					    	
					    	
							
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");

		                    String query = "INSERT INTO monthly_rent values('" + nm + "','" + "0" + "','" + "0"+ "')";

		                    Statement sta = connection.createStatement();
		                     sta.executeUpdate(query);
		                   
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
					 
						
						
					status="Paid";
						Past_="0";
						s="0";
						d="0";
						f="0";
					
						new Payment_data();
				}	
					
					
					
					
				
				if(R2.isSelected()) {
						status=" Yet To Pay...";
						
				}	
						
						
			
				    
					
					
					
				if(R3.isSelected()) {
				    	status=" Not Paid !";
					   
				    Past_=Integer.toString(n);
				    
			      }
			    	
					
				
				
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");

                 String query = "Update tenant_info set E_bill='"+s+"', W_bill='"+d+"', maint='"+f+"' , Past_due='"+Past_+"' , month='"+date_+"' , Pay_status='"+status+"'  where Name='"+ nm +"'";

                 Statement sta = connection.createStatement();
                 sta.execute(query);
                 connection.close();
                 
                 
             } catch (Exception exception) {
                 exception.printStackTrace();
             }	
			    
			
				Refresh_data();	
					
					
				}
			});
			btn_Add_1.setForeground(Color.WHITE);
			btn_Add_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn_Add_1.setBackground(new Color(255, 215, 0));
			btn_Add_1.setBounds(761, 557, 130, 42);
			panel_0.add(btn_Add_1);
			
			
			
			 monthChooser = new JMonthChooser();
			monthChooser.setBounds(671, 463, 130, 25);
			panel_0.add(monthChooser);
			
			JButton btn_Add_1_1 = new JButton("Details");
			btn_Add_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 new Details(nm);
					
					
				}
			});
			btn_Add_1_1.setForeground(Color.WHITE);
			btn_Add_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn_Add_1_1.setBackground(new Color(255, 215, 0));
			btn_Add_1_1.setBounds(584, 557, 130, 42);
			panel_0.add(btn_Add_1_1);
			
			JButton btnPaymentHistory = new JButton("Payment History");
			btnPaymentHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new history();
					
				}
			});
			btnPaymentHistory.setForeground(Color.WHITE);
			btnPaymentHistory.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnPaymentHistory.setBackground(new Color(255, 215, 0));
			btnPaymentHistory.setBounds(288, 78, 167, 29);
			panel_0.add(btnPaymentHistory);
			
			
			f.setVisible(true);
			
		}
	
	public void Refresh_data() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","Satara@11");
			Statement stmt=con.createStatement();
			String sql="Select tenant_id, Name,month,Pay_status from tenant_info ";
					//+ "where tenant_id IN ( Select tenant_id from register_user.owner_tenants where owner_id ='"+ oid +"') ";
			ResultSet rs=stmt.executeQuery(sql);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			con.close();
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
		
		
		public static void main(String[] args) {
			new Login_owner(0);
		}
}
