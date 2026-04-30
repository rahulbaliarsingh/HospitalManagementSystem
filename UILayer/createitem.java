package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import EntityLayer.item;
import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class createitem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField iid;
	private JTextField in;
	private JTextField des;
	private JTextField sp;
	private JTextField bp;
	private JTextField qty;
	private JTable table;
	
	public static String no;
	
	static JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createitem frame = new createitem();
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
	public createitem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(10, 56, 701, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item Id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 29, 63, 21);
		panel.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblItemName.setBounds(10, 73, 82, 21);
		panel.add(lblItemName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDescription.setBounds(10, 120, 82, 21);
		panel.add(lblDescription);
		
		JLabel lblSellprice = new JLabel("SellPrice");
		lblSellprice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSellprice.setBounds(10, 151, 63, 21);
		panel.add(lblSellprice);
		
		JLabel lblBuyprice = new JLabel("BuyPrice");
		lblBuyprice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBuyprice.setBounds(10, 191, 63, 21);
		panel.add(lblBuyprice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuantity.setBounds(10, 227, 63, 21);
		panel.add(lblQuantity);
		
		
		
		iid = new JTextField();
		iid.setBounds(95, 31, 173, 18);
		panel.add(iid);
		iid.setColumns(10);
		
		in = new JTextField();
		in.setColumns(10);
		in.setBounds(95, 75, 173, 18);
		panel.add(in);
		
		des = new JTextField();
		des.setColumns(10);
		des.setBounds(95, 122, 173, 18);
		panel.add(des);
		
		sp = new JTextField();
		sp.setColumns(10);
		sp.setBounds(95, 153, 173, 18);
		panel.add(sp);
		
		bp = new JTextField();
		bp.setColumns(10);
		bp.setBounds(95, 193, 173, 18);
		panel.add(bp);
		
		qty = new JTextField();
		qty.setColumns(10);
		qty.setBounds(95, 229, 173, 18);
		panel.add(qty);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 29, 402, 224);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow(); 
				
				iid.setVisible(false);
				
				 no=table.getValueAt(row, 0).toString();
				 
				 lblNewLabel_1.setText(no);
				 
				 
				
				 
		        in.setText(table.getValueAt(row, 1).toString());
		        des.setText(table.getValueAt(row, 2).toString());
		        sp.setText(table.getValueAt(row, 3).toString());
		        bp.setText(table.getValueAt(row, 4).toString());
		        qty.setText(table.getValueAt(row, 5).toString());
		        
			}
		});
		scrollPane.setRowHeaderView(table);
		
	    lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(95, 29, 63, 21);
		panel.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item i=new item();
				i.setId(iid.getText());
				i.setIname(in.getText());
				i.setDes(des.getText());
				i.setSellp(Integer.parseInt(sp.getText()));
				i.setBuyp(Integer.parseInt(bp.getText()));
				i.setQty(Integer.parseInt(qty.getText()));
				
				int z=HDao.additem(i);
				
				if(z>0)
				{
					JOptionPane.showMessageDialog(btnNewButton,"Item Added");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Error");
				}
				try {
			       
			        Connection c = HDao.Connect();
			        PreparedStatement ps = c.prepareStatement("select * from item");
			        ResultSet r = ps.executeQuery();
			        table.setModel(DbUtils.resultSetToTableModel(r));

			    } catch (Exception e2) {
			        
			    }
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(38, 347, 69, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				item i=new item(); 
				i.setIname(in.getText());
				i.setDes(des.getText());
				i.setSellp(Integer.parseInt(sp.getText()));
				i.setBuyp(Integer.parseInt(bp.getText()));
				i.setQty(Integer.parseInt(qty.getText()));
				i.setId(no);
				int x=HDao.updateitem(i);
				
				if(x>0)
				{
					JOptionPane.showMessageDialog(btnUpdate, "Updated");
				}
				else
				{
					JOptionPane.showMessageDialog(btnUpdate, "error");
				}
				try {
				      
			        Connection c = HDao.Connect();
			        PreparedStatement ps = c.prepareStatement("select * from item");
			        ResultSet r = ps.executeQuery();
			        table.setModel(DbUtils.resultSetToTableModel(r));

			    } catch (Exception e2) {
			        
			    }
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnUpdate.setBackground(new Color(245, 245, 220));
		btnUpdate.setBounds(117, 347, 69, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=HDao.Connect();
				PreparedStatement ps=con.prepareStatement("delete from item where itemid=?");
				ps.setString(1, no);
				int z=ps.executeUpdate();
				
				if(z>0)
				{
					JOptionPane.showMessageDialog(btnDelete, "Item deleted");
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
			    PreparedStatement ps=c.prepareStatement("select * from item");
			    ResultSet r=ps.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(r));
			} catch (Exception e2) {
				// TODO: handle exception
			}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnDelete.setBackground(new Color(245, 245, 220));
		btnDelete.setBounds(196, 347, 69, 29);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(Login.role=="Receptionist") {
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
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExit.setBackground(new Color(245, 245, 220));
		btnExit.setBounds(278, 347, 69, 29);
		contentPane.add(btnExit);

	}
}
