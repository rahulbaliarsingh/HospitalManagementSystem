package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EntityLayer.patient;
import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pregistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pname;
	private JTextField phone;
	private JTextField Pno;
	JTable table;
	public static String id;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregistration frame = new Pregistration();
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
	public Pregistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient Registration", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(255, 255, 0)));
		panel.setBackground(new Color(64, 0, 64));
		panel.setBounds(0, 0, 393, 368);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient No");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 71, 103, 27);
		panel.add(lblNewLabel);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setForeground(Color.WHITE);
		lblPatientName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPatientName.setBounds(10, 119, 103, 27);
		panel.add(lblPatientName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhone.setBounds(10, 177, 103, 27);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setBounds(10, 230, 103, 27);
		panel.add(lblAddress);
		
		pname = new JTextField();
		pname.setBounds(135, 120, 194, 27);
		panel.add(pname);
		pname.setColumns(10);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
				{
					phone.setEditable(true);
				}
				else
				{
					phone.setEditable(false);
				}
			}
		});
		phone.setColumns(10);
		phone.setBounds(135, 178, 194, 27);
		panel.add(phone);
		
		JTextArea address = new JTextArea();
		address.setBounds(135, 232, 194, 51);
		panel.add(address);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pno=Pno.getText();
				String Pname=pname.getText();
				int p=Integer.parseInt(phone.getText());
				String Phone=phone.getText();
				String Address=address.getText();
				
				if(Phone.length()!=10)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Phone number must be 10 digit");
				}
				
				else {
					int z=HDao.PAdd(pno,Pname, p, Address);
					if(z>0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Welcome", "Added Successfully", JOptionPane.INFORMATION_MESSAGE);
						Pno.setText("");
						pname.setText("");
						phone.setText("");
						address.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Invalid Entry");
					}
					
				Connection con=HDao.Connect();
				 try {
			           PreparedStatement ps=con.prepareStatement("select * from patient");
					   ResultSet rs=ps.executeQuery();
					   
					   table.setModel(DbUtils.resultSetToTableModel(rs));
					  
				 }catch(Exception e1)
				 {
					 e1.printStackTrace();
				 }
					
				
				
				
			}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(10, 313, 84, 34);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pno.setVisible(false);
				String ph=phone.getText();

                  if (ph.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Please enter a value");
                   return;
                     }
				patient p=new patient();
				p.setPatientNo(id);
				p.setPatientName(pname.getText());
				p.setPhone(Integer.parseInt(ph));
				p.setAddress(address.getText());
				int z=HDao.PUpdate(p);
				
				if(z>0)
				{
					JOptionPane.showMessageDialog(btnNewButton,  "Updated Successfully");
					Pno.setText("");
					pname.setText("");
					phone.setText("");
					address.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Entry");
				}
				try {
					  Connection con=HDao.Connect();
			           PreparedStatement ps=con.prepareStatement("select * from patient");
					   ResultSet rs=ps.executeQuery();
					   
					   table.setModel(DbUtils.resultSetToTableModel(rs));
					  
				 }catch(Exception e1)
				 {
					 
				 }
			
			 
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnUpdate.setBounds(104, 313, 84, 34);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=HDao.Connect();
					PreparedStatement ps=con.prepareStatement("delete from patient where patientno=?");
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
				    PreparedStatement ps=c.prepareStatement("select * from patient");
				    ResultSet r=ps.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(r));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnDelete.setBounds(198, 313, 84, 34);
		panel.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RHome rh=new RHome();
				rh.setVisible(true);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnExit.setBounds(299, 313, 84, 34);
		panel.add(btnExit);
		
		Pno = new JTextField();
		
		Pno.setColumns(10);
		Pno.setBounds(135, 76, 194, 27);
		panel.add(Pno);
		
		JLabel lblNewLabel_1 = new JLabel("Patient No");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(135, 71, 103, 27);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(403, 10, 390, 344);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pno.setVisible(false);
				
				int row = table.getSelectedRow(); 
				
				 id=table.getValueAt(row, 0).toString();
				 
				 
				 lblNewLabel_1.setText(id);
				 
		        pname.setText(table.getValueAt(row, 1).toString());
		        phone.setText(table.getValueAt(row, 2).toString());
		        address.setText(table.getValueAt(row, 3).toString());
		        
			}
		});
		table.setBounds(50, 50, 50, 50);
		scrollPane.setViewportView(table);
		

	}
}

