package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controle.PessoaDAO;
import modelo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class VisaoLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

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
					System.err.println("Failed to initialize Laf");
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
		panel_1.setBorder(new CompoundBorder(UIManager.getBorder("CheckBoxMenuItem.border"),
				UIManager.getBorder("CheckBoxMenuItem.border")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/login.png"));

		JLabel lblNome = new JLabel("BookFlow+");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 48));

		JButton btnVolta = new JButton("Voltar a Tela Inicial");

		JLabel lblSlogan1 = new JLabel("<html><p style=\"width:120px\">"
				+ "Gerencie sua biblioteca de forma fácil e inteligente com BookFlow: organize, explore e mergulhe no mundo dos livros."
				+ "</p></html>");
		lblSlogan1.setForeground(Color.WHITE);
		lblSlogan1.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(143)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 219,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSlogan1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))
						.addGap(147).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(42, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(856, Short.MAX_VALUE)
						.addComponent(btnVolta).addContainerGap()));
		gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
				.addGap(143)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblSlogan1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGap(117).addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 219,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(155, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(64)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNome).addGap(37)
								.addComponent(lblSlogan1).addPreferredGap(ComponentPlacement.RELATED).addComponent(
										lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE).addComponent(btnVolta))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(212).addComponent(lblNome)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(6).addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(lblSlogan1))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(161)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(252, Short.MAX_VALUE))));
		panel_1.setLayout(null);

		btnVolta.setBounds(35, 365, 179, 37);
		panel_1.add(btnVolta);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolta.setForeground(new Color(0, 64, 128));
		btnVolta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		contentPane.setLayout(gl_contentPane);

		JLabel lblLogin = new JLabel("Bem-vindo novamente!");
		lblLogin.setForeground(new Color(0, 64, 128));
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblLogin.setBounds(35, 44, 395, 47);
		double x = 50;
		double y = 50;

		panel_1.add(lblLogin);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf.setForeground(new Color(0, 64, 128));

		lblCpf.setBounds(35, 136, 158, 14);
		panel_1.add(lblCpf);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(35, 161, 395, 31);
		txtEmail.setForeground(new Color(0, 64, 128));
		txtEmail.setColumns(10);

		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSenha.setForeground(new Color(0, 64, 128));

		lblSenha.setBounds(35, 220, 46, 14);
		panel_1.add(lblSenha);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(146, 355, 147, 37);
		btnNewButton.setBounds(274, 365, 147, 37);

//		btnNewButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				String msgErro = "";
//
//				String email = txtEmail.getText();
//				String senha = txtSenha.getText();
//
//				if (txtEmail.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(btnNewButton, "COLOQUE O EMAIL");
//					txtEmail.requestFocus();
//				}
//
//				if (txtSenha.getText().isEmpty()) {
//				    JOptionPane.showMessageDialog(btnNewButton, "COLOQUE A SENHA");
//				    txtSenha.requestFocus();
//				}
//				
//				PessoaDAO dao = PessoaDAO.getInstancia();
//				Boolean efetuarPessoa = dao.efetuarLogin(ps);
//			    Pessoa efetuarPessoa = dao.efetuarLogin(email, senha);
//
//				if(efetuarPessoa == true) {
//					VisaoTelaInicial frame = new VisaoTelaInicial();
//					frame.setVisible(true);
//					frame.setExtendedState(MAXIMIZED_BOTH);
//					dispose();
//				}
//
//				if (!msgErro.isEmpty()) {
//				    JOptionPane.showMessageDialog(null, msgErro);
//				}
//				
//				
//
//				
//			}
//
//		});
		panel_1.add(btnNewButton);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSenha.setForeground(new Color(0, 64, 128));
		txtSenha.setBounds(35, 245, 395, 37);
		panel_1.add(txtSenha);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lembre de mim");
		rdbtnNewRadioButton.setForeground(new Color(0, 64, 128));
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(35, 289, 123, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JToggleButton btnSenha = new JToggleButton("");
		btnSenha.setIcon(new ImageIcon("img/olhocerto.png"));
		btnSenha.setBounds(394, 293, 27, 23);
		panel_1.add(btnSenha);

	}
}