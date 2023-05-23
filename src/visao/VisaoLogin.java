package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaoLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
	
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/login.png"));
		
		JLabel lblNome = new JLabel("BookFlow+");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JLabel lblSlogan1 = new JLabel("<html><p style=\"width:120px\">"+"Gerencie sua biblioteca de forma fácil e inteligente com BookFlow: organize, explore e mergulhe no mundo dos livros."+"</p></html>");
		lblSlogan1.setForeground(Color.WHITE);
		lblSlogan1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JButton btnVolta = new JButton("Voltar a Tela Inicial");
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolta.setForeground(new Color(0, 64, 128));
		btnVolta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(143)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSlogan1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(147)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(950, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(856, Short.MAX_VALUE)
					.addComponent(btnVolta)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNome)
							.addGap(32)
							.addComponent(lblSlogan1)
							.addGap(27)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
					.addComponent(btnVolta))
		);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Bem-vindo novamente!");
		lblLogin.setForeground(new Color(0, 64, 128));
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblLogin.setBounds(35, 44, 395, 47);
		double x = 50;
		double y = 50;

		panel_1.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Nome de usuário");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 64, 128));

		lblNewLabel.setBounds(35, 117, 158, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(35, 147, 395, 31);
		textField.setForeground(new Color(0, 64, 128));
		textField.setText("@email.com");
		textField.setColumns(10);
		
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSenha.setForeground(new Color(0, 64, 128));

		lblSenha.setBounds(35, 220, 46, 14);
		panel_1.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnEntrar.setBackground(new Color(0, 64, 128));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEntrar.setBounds(145, 335, 147, 37);
		panel_1.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setForeground(new Color(0, 64, 128));
		passwordField.setBounds(35, 245, 395, 37);
		panel_1.add(passwordField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Remember me");
		rdbtnNewRadioButton.setForeground(new Color(0, 64, 128));
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(35, 289, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		contentPane.setLayout(gl_contentPane);
	}
}

