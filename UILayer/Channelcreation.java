package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Channelcreation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ano;
	private JTextField date;
	private JTable table;
	
	public static void loadDoctors(JComboBox comboBox) {
	    try {
	        ResultSet rs = HDao.getDoctors();
	        
	        while (rs.next()) {
	            comboBox.addItem(rs.getString("name")); // add doctor name
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public static void loadPatient(JComboBox comboBox) {
	    
	    	try {
		        ResultSet rs = HDao.getPatient();
		        
		        while (rs.next()) {
		            comboBox.addItem(rs.getString("patientname")); // add doctor name
		        }
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        }
	    	}
		    
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Channelcreation frame = new Channelcreation();
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
	public Channelcreation() {
		setBackground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Appointment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 64)));
		panel.setBackground(new Color(70, 104, 185));
		panel.setBounds(25, 29, 381, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment No");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 64));
		lblNewLabel.setBounds(10, 44, 102, 21);
		panel.add(lblNewLabel);
		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setForeground(new Color(0, 0, 64));
		lblDoctorName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDoctorName.setBounds(10, 96, 102, 21);
		panel.add(lblDoctorName);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setForeground(new Color(0, 0, 64));
		lblPatientName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPatientName.setBounds(10, 156, 102, 21);
		panel.add(lblPatientName);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setForeground(new Color(0, 0, 64));
		lblRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRoomNo.setBounds(10, 210, 102, 21);
		panel.add(lblRoomNo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 64));
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDate.setBounds(10, 262, 102, 21);
		panel.add(lblDate);
		
		ano = new JTextField();
		ano.setBounds(134, 46, 156, 18);
		panel.add(ano);
		ano.setColumns(10);
		
		JComboBox dn = new JComboBox();
		dn.setBounds(134, 86, 156, 20);
		panel.add(dn);
		loadDoctors(dn);
		
		
		JComboBox pn = new JComboBox();
		pn.setBounds(134, 157, 156, 20);
		panel.add(pn);
		loadPatient(pn);
		
		JSpinner rn = new JSpinner();
		rn.setBounds(137, 212, 43, 20);
		panel.add(rn);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(134, 264, 156, 18);
		panel.add(date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 29, 389, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=HDao.Connect();
					PreparedStatement ps=c.prepareStatement("insert into appointment (appointmentno,doctorname,patientname,roomno,date) values(?,?,?,?,?)");
					ps.setString(1, ano.getText());
					ps.setString(2, dn.getSelectedItem().toString());
					ps.setString(3, pn.getSelectedItem().toString());
					ps.setString(4, rn.getValue().toString());
					String d = date.getText();
					ps.setDate(5, java.sql.Date.valueOf(d));
					int z=ps.executeUpdate();
					
					if(z>0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Appointment Created");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Error :(");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				try {
					Connection c=HDao.Connect();
				    PreparedStatement ps=c.prepareStatement("select * from appointment");
				    ResultSet r=ps.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(r));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(231, 369, 84, 35);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RHome rh=new RHome();
				rh.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnCancel.setBounds(322, 368, 84, 35);
		contentPane.add(btnCancel);

	}
}
