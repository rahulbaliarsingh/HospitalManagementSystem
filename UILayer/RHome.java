package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityLayer.user;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RHome frame = new RHome();
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
	public RHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 68, 267, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Show Appointment");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewchannel vc=new viewchannel();
				vc.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_6.setBounds(46, 517, 140, 35);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("Doctor");
		btnNewButton.setBounds(46, 61, 145, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Dregistration dr=new Dregistration();
				dr.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnNewButton_7 = new JButton("Patient");
		btnNewButton_7.setBounds(46, 131, 140, 35);
		panel.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Pregistration obj=new Pregistration();
				obj.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Appointment");
		btnNewButton_1.setBounds(46, 195, 140, 35);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Channelcreation ch=new Channelcreation();
				ch.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnNewButton_5 = new JButton("View Doctor");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewpatient vd=new viewpatient();
				vd.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(46, 255, 140, 35);
		panel.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("View Presription");
		btnNewButton_2.setBounds(46, 327, 140, 35);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewprescription vp=new viewprescription();
				vp.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("Create Item");
		btnNewButton_3.setBounds(46, 393, 140, 35);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				createitem ci=new createitem();
				ci.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnNewButton_4 = new JButton("Create User");
		btnNewButton_4.setBounds(46, 453, 140, 35);
		panel.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Usercreation o=new Usercreation();
				o.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton_6_1 = new JButton("Logout\r\n");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_6_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_6_1.setBounds(46, 583, 140, 35);
		panel.add(btnNewButton_6_1);
		
		
		JLabel lblNewLabel = new JLabel("Welcome  Mr."+new user().getUName());
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(0, -25, 522, 94);
		contentPane.add(lblNewLabel);

	}
}
