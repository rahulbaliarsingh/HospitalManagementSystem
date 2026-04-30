package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityLayer.doctor;
import EntityLayer.user;
import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class viewchannel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	public static String cno;
	
	public static void showappointment(JTable t, String doctorName)
	{
	    try {
	       	System.out.println(doctorName);
	        Connection c = HDao.Connect();
	        PreparedStatement ps = c.prepareStatement("select * from appointment where doctorname=?");

	        ps.setString(1, doctorName);  

	        ResultSet r = ps.executeQuery();
	        t.setModel(DbUtils.resultSetToTableModel(r));

	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewchannel frame = new viewchannel();
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
	public viewchannel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(41, 22, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		System.out.println(cno);
		scrollPane.setBounds(87, 32, 503, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				 cno=table.getValueAt(row, 0).toString();
			}
		});
		scrollPane.setViewportView(table);
		
		user u=new user();
		String name=u.getUName();
		
		
		//System.out.println(name);
		
		showappointment(table,name);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DHome dh=new DHome();
				dh.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(554, 346, 84, 32);
		contentPane.add(btnNewButton);
		
		JButton btnPrescription = new JButton("Prescription");
		btnPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				prescripition p=new prescripition();
				p.setVisible(true);
				
				
			}
		});
		
		btnPrescription.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnPrescription.setBounds(291, 346, 109, 32);
		contentPane.add(btnPrescription);
		
		btnPrescription.setVisible(false);
		if(Login.role=="Doctor")
		{
			btnPrescription.setVisible(true);
		}
		
		
		

	}
}
