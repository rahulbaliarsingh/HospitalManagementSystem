package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityLayer.user;
import ServiceLayer.HDao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usercreation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JTextField email;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usercreation frame = new Usercreation();
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
	public Usercreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 59, 627, 407);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:-");
		lblNewLabel_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		lblNewLabel_1.setBounds(116, 79, 112, 31);
		panel.add(lblNewLabel_1);
		
		uname = new JTextField();
		uname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		uname.setBounds(218, 78, 225, 28);
		panel.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Email:-");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(116, 140, 112, 31);
		panel.add(lblNewLabel_1_1);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.BOLD, 14));
		email.setColumns(10);
		email.setBounds(218, 140, 225, 28);
		panel.add(email);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Create Password:-");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(70, 196, 158, 31);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("User Type:-");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 128));
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(116, 263, 112, 31);
		panel.add(lblNewLabel_1_1_2);
		
		JComboBox utype = new JComboBox();
		utype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		utype.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Receptionist", "Pharmacist"}));
		utype.setBounds(218, 256, 225, 39);
		panel.add(utype);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=uname.getText();
				String Email=email.getText();
				String pass=password.getText();
				String type=utype.getSelectedItem().toString();
				int z=HDao.UAdd(name, Email, pass, type);
				
				if(z>0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "User Entered", "Welcome", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Entry", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(383, 333, 84, 31);
		panel.add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RHome rh=new RHome();
				rh.setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnCancle.setBounds(497, 333, 84, 31);
		panel.add(btnCancle);
		
		password = new JTextField();
		password.setFont(new Font("Times New Roman", Font.BOLD, 14));
		password.setColumns(10);
		password.setBounds(218, 194, 225, 28);
		panel.add(password);
		
		JLabel lblNewLabel = new JLabel("User Creation");
		lblNewLabel.setForeground(new Color(64, 0, 128));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(221, 10, 160, 39);
		contentPane.add(lblNewLabel);

	}
}
