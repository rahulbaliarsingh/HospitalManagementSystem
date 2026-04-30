package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import EntityLayer.doctor;
import EntityLayer.user;
import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.List;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dregistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField did;
	private JTextField dn;
	private JTextField sp;
	private JTextField qf;
	private JTextField cf;
	private JTextField ph;
	private JTable table;
     public static int lid;
     public static String id;
     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dregistration frame = new Dregistration();
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
	public Dregistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(36, 37, 38));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Doctor Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0)));
		panel.setBackground(new Color(9, 9, 9));
		panel.setBounds(10, 59, 435, 328);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(195, 20, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Id:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 40, 93, 18);
		panel.add(lblNewLabel_1);
		
		did = new JTextField();
		did.setBounds(125, 41, 228, 18);
		panel.add(did);
		did.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Doctor Name:");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 80, 93, 18);
		panel.add(lblNewLabel_1_1);
		
		dn = new JTextField();
		dn.setColumns(10);
		dn.setBounds(126, 81, 227, 18);
		panel.add(dn);
		
		JLabel lblNewLabel_1_1_1 =new JLabel("Specialization");
		lblNewLabel_1_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(20, 119, 93, 18);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Qualification");
		lblNewLabel_1_1_2.setForeground(Color.YELLOW);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(20, 157, 93, 18);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Channel fee");
		lblNewLabel_1_1_3.setForeground(Color.YELLOW);
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(20, 195, 93, 18);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Phone");
		lblNewLabel_1_1_4.setForeground(Color.YELLOW);
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_4.setBounds(20, 236, 93, 18);
		panel.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Room No");
		lblNewLabel_1_1_5.setForeground(Color.YELLOW);
		lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_5.setBounds(20, 267, 93, 18);
		panel.add(lblNewLabel_1_1_5);
		
		sp = new JTextField();
		sp.setColumns(10);
		sp.setBounds(125, 120, 228, 18);
		panel.add(sp);
		
		qf = new JTextField();
		qf.setColumns(10);
		qf.setBounds(125, 158, 228, 18);
		panel.add(qf);
		
		cf = new JTextField();
		cf.setColumns(10);
		cf.setBounds(125, 196, 228, 18);
		panel.add(cf);
		
		ph = new JTextField();
		ph.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
				{
					ph.setEditable(true);
				}
				else
				{
					ph.setEditable(false);
				}
			}
			
		});
		ph.setColumns(10);
		ph.setBounds(125, 237, 228, 18);
		panel.add(ph);
		
		JSpinner rn = new JSpinner();
		rn.setBounds(125, 268, 45, 20);
		panel.add(rn);
		
		System.out.println(id);
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String P=ph.getText();
				
				if(P.length()!=10)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Phone Number must have 10 digit");
				     System.out.println(P.length());
				}
				else {
	              doctor d=new doctor();
	              user u=new user();
	              d.setDoctorid(did.getText());
	              d.setName(dn.getText());
	              d.setSpecialization(sp.getText());
	              d.setQualification(qf.getText());
	              d.setChannelfee(cf.getText());
	              d.setPhone(ph.getText());
	              d.setRoom( rn.getValue().toString());
	              System.out.println(Login.newid);
	              d.setLogid(Login.newid);
				int z=HDao.DAdd(d);
				
				if(z>0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Doctor Added");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Entry");
				}
				
				try {
					Connection c=HDao.Connect();
				    PreparedStatement ps=c.prepareStatement("select * from doctor");
				    ResultSet r=ps.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(r));
				    
				    
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(32, 397, 84, 31);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				doctor d=new doctor();
				  d.setName(dn.getText());
	              d.setSpecialization(sp.getText());
	              d.setQualification(qf.getText());
	              d.setChannelfee(cf.getText());
	              d.setPhone(ph.getText());
	              d.setRoom( rn.getValue().toString());
	              d.setLogid(lid);
	              int z=HDao.DUpdate(d);
	              
	              if(z>0)
	              {
	            	    JOptionPane.showMessageDialog(btnUpdate, "Update Successfully");
	              }
	              else
	              {
	            	  JOptionPane.showMessageDialog(btnUpdate, "Error in update");
	              }
	              try {
						Connection c=HDao.Connect();
					    PreparedStatement ps=c.prepareStatement("select * from doctor");
					    ResultSet r=ps.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(r));
					} catch (Exception e2) {
						// TODO: handle exception
					}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnUpdate.setBounds(140, 397, 84, 31);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1_2 = new JLabel();
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(126, 40, 93, 18);
		panel.add(lblNewLabel_1_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=HDao.Connect();
					PreparedStatement ps=con.prepareStatement("delete from doctor where doctorid=?");
					ps.setString(1, id);
					int z=ps.executeUpdate();
					
					if(z>0)
					{
						JOptionPane.showMessageDialog(btnDelete, "Information deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(btnDelete, "Error in Delete");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					Connection c=HDao.Connect();
				    PreparedStatement ps=c.prepareStatement("select * from doctor");
				    ResultSet r=ps.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(r));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnDelete.setBounds(250, 397, 84, 31);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(Login.role=="Doctor")
				{
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
		btnExit.setBounds(361, 397, 84, 31);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 57, 572, 322);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setEnabled(false);
				did.setVisible(false);
				
				int row = table.getSelectedRow(); 
				
				 id=table.getValueAt(row, 0).toString();
				 lid=(int) table.getValueAt(row, 7);
				 
				 lblNewLabel_1_2.setText(id);
				 
		        dn.setText(table.getValueAt(row, 1).toString());
		        sp.setText(table.getValueAt(row, 2).toString());
		        qf.setText(table.getValueAt(row, 3).toString());
		        cf.setText(table.getValueAt(row, 4).toString());
		        ph.setText(table.getValueAt(row, 5).toString());
		        rn.setValue(table.getValueAt(row, 6).toString());
			}
		});
		scrollPane.setRowHeaderView(table);
		scrollPane.setViewportView(table);
		
		

	}
}
