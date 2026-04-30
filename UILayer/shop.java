package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class shop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static JSpinner qty;
	public static JLabel lblNewLabel_3;
	public static double totalcost=0;
	public static String iname;
	private JTextField dt;
	private JTable table;
	
	public static void itemdetails(String iname) {
	    try {
	        Connection c = HDao.Connect();

	        PreparedStatement ps = c.prepareStatement(
	            "SELECT qty, sellprice FROM item WHERE itemname=?"
	        );
	        ps.setString(1, iname);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int currentqty = rs.getInt("qty");
	            int price = rs.getInt("sellprice");

	            int Qty = (Integer) qty.getValue();

	            if (Qty > currentqty) {
	                JOptionPane.showMessageDialog(null, "Available Item: " + currentqty);
	                JOptionPane.showMessageDialog(null, "Quantity is not enough");
	            } else {
	                double cost = price * Qty;
	                totalcost += cost;

	                lblNewLabel_3.setText(String.valueOf(totalcost));
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public static void loaditem(JComboBox comboBox) {
	    try {
	        ResultSet rs = HDao.getitem();
	        
	        while (rs.next()) {
	            comboBox.addItem(rs.getString("itemname")); 
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
					shop frame = new shop();
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
	public shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prescription Id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 128));
		lblNewLabel.setBounds(26, 56, 116, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setForeground(new Color(255, 255, 128));
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblItemName.setBounds(26, 107, 116, 24);
		contentPane.add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 255, 128));
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(26, 157, 116, 24);
		contentPane.add(lblQuantity);
		
		JComboBox in = new JComboBox();
		in.setBounds(152, 110, 148, 20);
		contentPane.add(in);
		loaditem(in);
		
		
		 qty = new JSpinner();
		qty.setBounds(152, 161, 46, 20);
		contentPane.add(qty);
		
		JLabel lblNewLabel_1 = new JLabel(viewprescription.pid);
		lblNewLabel_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(155, 56, 116, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iname = in.getSelectedItem().toString();
				itemdetails(iname);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(370, 154, 74, 31);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 226, 470, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Total Cost");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setBounds(49, 446, 93, 24);
		contentPane.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setForeground(new Color(255, 255, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(155, 446, 116, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPay = new JLabel("Pay");
		lblPay.setForeground(new Color(255, 255, 128));
		lblPay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPay.setBounds(49, 480, 116, 24);
		contentPane.add(lblPay);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setForeground(new Color(255, 255, 128));
		lblChange.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChange.setBounds(346, 446, 116, 24);
		contentPane.add(lblChange);
		
		textField = new JTextField();
		textField.setBounds(94, 485, 116, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(422, 451, 121, 18);
		contentPane.add(textField_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				        double pay = Double.parseDouble(textField.getText());

				        if (pay < totalcost) {
				            JOptionPane.showMessageDialog(null, "Insufficient amount!");
				            return;
				        }

				        double change = pay - totalcost;

				        textField_1.setText(String.valueOf(change));

				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				 
				 try {
					Connection c=HDao.Connect();
					PreparedStatement ps=c.prepareStatement("insert into bill(prescriptionid,itemname,Quantity,totalamount,date)values(?,?,?,?,?)");
					ps.setString(1,viewprescription.pid );
					ps.setString(2, iname);
					ps.setInt(3,(Integer)qty.getValue() );
					ps.setDouble(4, totalcost);
					ps.setDate(5, java.sql.Date.valueOf(dt.getText()));
					ps.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				 try {
						Connection c=HDao.Connect();
					    PreparedStatement ps=c.prepareStatement("select prescriptionid,itemname,Quantity,totalamount,date from bill");
					    ResultSet r=ps.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(r));
					} catch (Exception e2) {
						// TODO: handle exception
					}
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCreate.setBounds(370, 498, 74, 31);
		contentPane.add(btnCreate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(255, 255, 128));
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDate.setBounds(328, 56, 116, 24);
		contentPane.add(lblDate);
		
		dt = new JTextField();
		dt.setColumns(10);
		dt.setBounds(375, 60, 116, 18);
		contentPane.add(dt);

	}
}
