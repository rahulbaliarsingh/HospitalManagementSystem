package UILayer;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ServiceLayer.HDao;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class viewprescription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	 public static String pid;
	 private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewprescription frame = new viewprescription();
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
	public viewprescription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 60, 474, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				
				 pid=table.getValueAt(row, 0).toString();
				 System.out.println(pid);
			}
		});
		scrollPane.setViewportView(table);
		
		try {
			Connection c=HDao.Connect();
			PreparedStatement ps=c.prepareStatement("select * from prescription");
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			btnNewButton_1 = new JButton("Shop");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					shop s=new shop();
					s.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(417, 333, 84, 21);
			contentPane.add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("Prescription");
			lblNewLabel.setForeground(new Color(255, 255, 128));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(165, 10, 181, 29);
			contentPane.add(lblNewLabel);
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		btnNewButton_1.setVisible(false);
		if(Login.role=="pharmacist")
		{
			btnNewButton_1.setVisible(true);
		}

	}
}
