
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class history{
	private JTable table;
	
	public history(){
		JFrame f=new JFrame("RENT MANAGEMENT SYSTEM");
		f.getContentPane().setBackground(SystemColor.menu);
		f.setFont(new Font("Arial Black", Font.BOLD, 12));
		f.getContentPane().setForeground(SystemColor.activeCaption);
		f.setBounds(100, 100, 663, 700);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(230, 230, 250));
		panel_0.setBounds(0, 0, 649, 678);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 122, 415, 423);
		panel_0.add(scrollPane);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(208, 585, 167, 35);
		panel_0.add(btnNewButton);
				
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_user", "root","Satara@11");
			Statement stmt=con.createStatement();
			String sql="Select Name,monthRent,paidDate from monthly_rent";
			ResultSet rs=stmt.executeQuery(sql);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			con.close();
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	   
	    
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new history();
	}
}
