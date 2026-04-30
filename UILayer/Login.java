package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityLayer.user;
import ServiceLayer.Data;
import ServiceLayer.HDao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	static int newid;
	static String role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 64));
		panel.setBounds(0, 0, 574, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wellcome To Our Hospital");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(104, 24, 345, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(159, 120, 78, 31);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(159, 150, 183, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(159, 173, 78, 31);
		contentPane.add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(159, 203, 183, 31);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("User Type");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(159, 244, 78, 31);
		contentPane.add(lblNewLabel_1_1_1);
		
		JComboBox usertype = new JComboBox();
		usertype.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Receptionist", "pharmacist"}));
		usertype.setBounds(159, 271, 183, 31);
		contentPane.add(usertype);
		
		user obj=new user();
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="";
				try {
					Connection con=HDao.Connect();
					PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=? and utype=?");
					ps.setString(1,email.getText());
					ps.setString(2,password.getText());
					ps.setString(3, usertype.getSelectedItem().toString());
					ResultSet rs=ps.executeQuery();
					
					user u=new user();
					
					
					if(rs.next())
					{
						newid=rs.getInt("uid");
						u.setUId(newid);
						System.out.println(newid);
						name=rs.getString("uname"); 
						 role=usertype.getSelectedItem().toString();
						u.setUName(name);
						 System.out.println(role); 
						if(role=="Doctor")
						{
							setVisible(false);
							JOptionPane.showMessageDialog(btnNewButton, "Welcome Doctor");
							DHome o=new DHome();
							o.setVisible(true);
						}
						else if(role=="Receptionist")
						{
							setVisible(false);
						   RHome obj=new RHome();
						   obj.setVisible(true);
						}
						else
						{
							setVisible(false);
							pharmHome ph=new pharmHome();
							ph.setVisible(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Invalid Entry");
					}
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBackground(new Color(64, 0, 0));
		btnNewButton.setForeground(new Color(255, 128, 64));
		btnNewButton.setBounds(208, 323, 84, 34);
		contentPane.add(btnNewButton);
		
		

	}
}
