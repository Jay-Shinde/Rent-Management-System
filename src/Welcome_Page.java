


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class Welcome_Page{
	public Welcome_Page(){
		JFrame f=new JFrame("RENT MANAGEMENT SYSTEM");
		f.getContentPane().setBackground(SystemColor.menu);
		f.setFont(new Font("Arial Black", Font.BOLD, 12));
		f.getContentPane().setForeground(SystemColor.activeCaption);
		f.setBounds(100, 100, 1000, 700);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBounds(0, 0, 1000, 700);
		f.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		JLabel lab0 = new JLabel("");
		lab0.setBounds(-11, 0, 1001, 664);
		//f.getContentPane().add(lab0);
		ImageIcon icon=new ImageIcon("D:\\java\\MINI PROJECT\\home.jpeg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lab0.getWidth(), lab0.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon newImc=new ImageIcon(newImg);
		
	    lab0.setIcon(newImc);
	    panel_0.add(lab0);
	    
	    
	    JButton btnMore = new JButton("more...");
	    btnMore.setForeground(new Color(255, 255, 255));
	    btnMore.setBackground(new Color(255, 215, 0));
	    btnMore.setBounds(183, 451, 102, 40);
	    panel_0.add(btnMore);
	    btnMore.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new Login_tab();
	    		f.setVisible(false);
	    	}
	    });
	    btnMore.setFont(new Font("Tahoma", Font.BOLD, 16));
	    
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Welcome_Page();
	}
}
