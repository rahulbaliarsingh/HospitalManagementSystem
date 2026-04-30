package UILayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Dregistration1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField did;
	public JTextField dn;
	public JTextField cf;
	public JTextField sp;
	public JTextField ph;
	public JTextField qf;
	public JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dregistration1 frame = new Dregistration1();
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
	public Dregistration1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // FULL SCREEN

		contentPane = new JPanel();
		contentPane.setBackground(new Color(236, 240, 241)); // soft background
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder()));
		panel.setBackground(new Color(44, 62, 80)); // modern dark blue
		panel.setBounds(10, 59, 435, 328);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(195, 20, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Id:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 40, 100, 18);
		panel.add(lblNewLabel_1);
		
		did = new JTextField();
		did.setBounds(125, 40, 228, 22);
		did.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(did);
		
		JLabel lblNewLabel_1_1 = new JLabel("Doctor Name:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(20, 80, 120, 18);
		panel.add(lblNewLabel_1_1);
		
		dn = new JTextField();
		dn.setBounds(125, 80, 228, 22);
		dn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(dn);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Specialization");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(20, 120, 120, 18);
		panel.add(lblNewLabel_1_1_1);
		
		sp = new JTextField();
		sp.setBounds(125, 120, 228, 22);
		sp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(sp);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Qualification");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(20, 160, 120, 18);
		panel.add(lblNewLabel_1_1_2);
		
		qf = new JTextField();
		qf.setBounds(125, 160, 228, 22);
		qf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(qf);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Channel fee");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(20, 200, 120, 18);
		panel.add(lblNewLabel_1_1_3);
		
		cf = new JTextField();
		cf.setBounds(125, 200, 228, 22);
		cf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(cf);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Phone");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_4.setBounds(20, 240, 120, 18);
		panel.add(lblNewLabel_1_1_4);
		
		ph = new JTextField();
		ph.setBounds(125, 240, 228, 22);
		ph.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(ph);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Room No");
		lblNewLabel_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_5.setBounds(20, 270, 120, 18);
		panel.add(lblNewLabel_1_1_5);
		
		JSpinner rn = new JSpinner();
		rn.setBounds(125, 270, 60, 22);
		panel.add(rn);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(46, 204, 113));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(32, 397, 100, 35);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(52, 152, 219));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(140, 397, 100, 35);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1_2 = new JLabel();
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(126, 40, 120, 18);
		panel.add(lblNewLabel_1_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDelete.setBackground(new Color(231, 76, 60));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(250, 397, 100, 35);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnExit.setBackground(Color.GRAY);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(360, 397, 100, 35);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 65, 700, 400); // bigger table
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		scrollPane.setViewportView(table);

	}

}
