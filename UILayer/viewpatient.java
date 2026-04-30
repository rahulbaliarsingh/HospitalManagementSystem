package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewpatient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewpatient frame = new viewpatient();
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
	public viewpatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(0, 0, 864, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Details");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(326, 21, 145, 32);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 844, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		try {
	       	
	        Connection c = HDao.Connect();
	        PreparedStatement ps = c.prepareStatement("select * from doctor");
	        ResultSet r = ps.executeQuery();
	        table.setModel(DbUtils.resultSetToTableModel(r));

	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.role=="Doctor")
				{
					DHome dh=new DHome();
					dh.setVisible(false);
				}
				else if(Login.role=="Receptionist")
				{
					RHome rh=new RHome();
					rh.setVisible(true);
				}
				else
				{
					pharmHome ph=new pharmHome();
					ph.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBounds(363, 409, 84, 27);
		contentPane.add(btnNewButton);

	}
}
