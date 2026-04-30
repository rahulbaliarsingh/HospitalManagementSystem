package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EntityLayer.user;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DHome frame = new DHome();
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
	public DHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 128));
		panel.setBounds(0, 64, 528, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 554, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		user u=new user();
		
		JLabel lblNewLabel = new JLabel("Welcome "+"Mr "+u.getUName());
		lblNewLabel.setBounds(0, 10, 641, 34);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		
		
		JButton btnNewButton = new JButton("Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Dregistration dr=new Dregistration();
				dr.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(183, 89, 157, 42);
		panel.add(btnNewButton);
		
		JButton btnViewChannel = new JButton("View Appointment");
		btnViewChannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewchannel vc=new viewchannel();
				vc.setVisible(true);
			}
		});
		btnViewChannel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnViewChannel.setBounds(183, 160, 157, 42);
		panel.add(btnViewChannel);
		
		JButton btnViewDoctor = new JButton("View Doctor");
		btnViewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewpatient vd=new viewpatient();
				vd.setVisible(true);
			}
		});
		btnViewDoctor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnViewDoctor.setBounds(183, 234, 157, 42);
		panel.add(btnViewDoctor);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnLogout.setBounds(183, 304, 157, 42);
		panel.add(btnLogout);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(516, 0, 139, 34);
		contentPane.add(lblDoctor);
		lblDoctor.setFont(new Font("Segoe UI", Font.BOLD, 25));

	}
}
