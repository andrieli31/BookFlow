package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class VisaoLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeDeUsurio;
	private JTextField txtPassword;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoLogin frame = new VisaoLogin();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisaoLogin() {
		setTitle("LOGIN ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 897);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mende\\Downloads\\login (3).png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 138, 210));
		
		JLabel lblNewLabel_3 = new JLabel("Já possui uma conta? Entrar");
		lblNewLabel_3.setForeground(new Color(85, 138, 210));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(449)
							.addComponent(lblNewLabel)
							.addGap(56)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(295)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(360, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(20, 82, 106, 21);
		panel.add(txtPassword);
		txtPassword.setForeground(new Color(0, 64, 128));
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtPassword.setText("password");
		txtPassword.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBackground(new Color(0, 64, 128));
		lblNewLabel_2.setBounds(20, 20, 58, 17);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		txtNomeDeUsurio = new JTextField();
		txtNomeDeUsurio.setBounds(20, 36, 106, 21);
		panel.add(txtNomeDeUsurio);
		txtNomeDeUsurio.setForeground(new Color(0, 64, 128));
		txtNomeDeUsurio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtNomeDeUsurio.setText("@email.com");
		txtNomeDeUsurio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBackground(new Color(0, 64, 128));
		lblNewLabel_1.setBounds(20, 67, 62, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Remember-me");
		rdbtnNewRadioButton.setBounds(23, 109, 103, 23);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(85, 138, 210));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.setLayout(gl_contentPane);
	}
}
