package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityLayer.user;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class pharmHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pharmHome frame = new pharmHome();
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
	public pharmHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 66, 209));
		panel_1.setBounds(0, 0, 490, 95);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		user u=new user();
		
		JLabel lblNewLabel = new JLabel("Welcome Mr "+u.getUName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 55, 386, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Our Hospital");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(136, 0, 260, 35);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("View Prescription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewprescription p=new viewprescription();
				p.setVisible(true);
			}
			  
		});
		btnNewButton.setBounds(155, 105, 123, 34);
		contentPane.add(btnNewButton);
		
		JButton btnCreateItem = new JButton("Create item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				createitem ci=new createitem();
				ci.setVisible(true);
			}
		});
		btnCreateItem.setBounds(155, 149, 123, 34);
		contentPane.add(btnCreateItem);
		
		JButton btnViewDoctor = new JButton("View Doctor");
		btnViewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewpatient vd=new viewpatient();
				vd.setVisible(true); 
				
				
			}
		});
		btnViewDoctor.setBounds(155, 203, 123, 34);
		contentPane.add(btnViewDoctor);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setBounds(155, 261, 123, 34);
		contentPane.add(btnLogout);

	}
}
