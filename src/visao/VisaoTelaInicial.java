package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class VisaoTelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoTelaInicial frame = new VisaoTelaInicial();
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
	public VisaoTelaInicial() {
		setBackground(new Color(0, 64, 128));
		setForeground(new Color(0, 0, 0));
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1576, 1455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setBounds(91, 358, 191, 24);
		lblEscolherOpcao.setForeground(new Color(137, 27, 224));
		lblEscolherOpcao.setFont(new Font("Segoe UI", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(868, 160, 256, 256);
		lblNewLabel_1.setIcon(new ImageIcon("img/user-interface.png"));

		JButton btnNewButton = new JButton("Gerenciar Usuários");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
				frame.setVisible(true);
				dispose();
			}

		});
		btnNewButton.setBounds(868, 388, 256, 29);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 64, 128));

		JLabel lblNewLabel_2 = new JLabel("Bem-Vindo ao BookFlow!");
		lblNewLabel_2.setBounds(93, 282, 675, 65);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(137, 27, 224));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(868, 610, 256, 256);
		lblNewLabel.setIcon(new ImageIcon("img/livro.png"));
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Gerenciar Livros");
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoGerenciaLivro frame = new VisaoGerenciaLivro();
				 frame.setVisible(true);
				 dispose();
				
			}
			
		});
		btnNewButton_1.setBounds(868, 877, 256, 29);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(0, 64, 128));
		contentPane.add(btnNewButton_1);
		contentPane.add(lblEscolherOpcao);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Já possui uma conta? Clique aqui!");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoLogin frame = new VisaoLogin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnLogin.setBackground(new Color(137, 27, 224));
		btnLogin.setBounds(91, 393, 256, 23);
		contentPane.add(btnLogin);
	}
}
