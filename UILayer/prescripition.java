package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import EntityLayer.doctor;
import ServiceLayer.HDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class prescripition extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pn;
	private JTextField dt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prescripition frame = new prescripition();
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
	public prescripition() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new TitledBorder(null, "Prescription", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prescription No");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 53, 117, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblChannelNo = new JLabel("Apointment No");
		lblChannelNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblChannelNo.setBounds(34, 108, 117, 26);
		contentPane.add(lblChannelNo);
		
		JLabel lblDeseaseType = new JLabel("Desease Type");
		lblDeseaseType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeseaseType.setBounds(34, 172, 117, 26);
		contentPane.add(lblDeseaseType);
		
		JLabel lblDescription = new JLabel("Description ");
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDescription.setBounds(34, 235, 117, 26);
		contentPane.add(lblDescription);
		
		pn = new JTextField();
		pn.setBounds(167, 55, 221, 26);
		contentPane.add(pn);
		pn.setColumns(10);
		
		dt = new JTextField();
		dt.setColumns(10);
		dt.setBounds(167, 177, 221, 26);
		contentPane.add(dt);
		
		JTextArea d = new JTextArea();
		d.setBounds(167, 237, 221, 60);
		contentPane.add(d);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=HDao.Connect();
					PreparedStatement ps=c.prepareStatement("insert into prescription(pid,apointmentno,deseasename,description)values(?,?,?,?)");
					ps.setString(1, pn.getText());
					ps.setString(2, viewchannel.cno);
					ps.setString(3, dt.getText());
					ps.setString(4,d.getText());
					int x=ps.executeUpdate();
					
					if(x>0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Prescription Created");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "error");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(295, 340, 84, 33);
		contentPane.add(btnNewButton);
		
		System.out.println(viewchannel.cno);
		
		JLabel lblHii = new JLabel(viewchannel.cno);
		lblHii.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHii.setBounds(170, 108, 117, 26);
		contentPane.add(lblHii);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(Login.role=="Doctor") {
					DHome dh=new DHome();
					dh.setVisible(true);
				}
				else
				{
					RHome rh=new RHome();
					rh.setVisible(true);
				}
				
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnExit.setBounds(397, 340, 84, 33);
		contentPane.add(btnExit);

	}
}
