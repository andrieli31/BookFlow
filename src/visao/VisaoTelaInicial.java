package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setTitle("TELA INICIAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1576, 1455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 1, 108));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(210, 330, 256, 256);
		lblNewLabel_1.setIcon(new ImageIcon("img/user-interface.png"));

		RoundedButton btnGerenciarUsuarios = new RoundedButton("Gerenciar Usuários");
		btnGerenciarUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
				frame.setVisible(true);
				frame.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}

		});
		btnGerenciarUsuarios.setBounds(210, 629, 256, 29);
		btnGerenciarUsuarios.setBackground(new Color(255, 255, 255));
		btnGerenciarUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnGerenciarUsuarios.setForeground(new Color(0, 64, 128));

		JLabel lblNewLabel_2 = new JLabel("Bem-Vindo ao BookFlow!");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(73, 66, 675, 65);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(654, 330, 256, 256);
		lblNewLabel.setIcon(new ImageIcon("img/livro.png"));
		contentPane.add(lblNewLabel);
		contentPane.add(btnGerenciarUsuarios);
		contentPane.add(lblNewLabel_2);

		RoundedButton btnGerenciarLivros = new RoundedButton("Gerenciar Livros");
		
		btnGerenciarLivros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoGerenciaLivro frame = new VisaoGerenciaLivro();
				 frame.setVisible(true);
				 frame.setExtendedState(MAXIMIZED_BOTH);
				 dispose();
				
			}
			
		});
		btnGerenciarLivros.setBounds(654, 629, 256, 29);
		btnGerenciarLivros.setBackground(new Color(255, 255, 255));
		btnGerenciarLivros.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnGerenciarLivros.setForeground(new Color(0, 64, 128));
		contentPane.add(btnGerenciarLivros);
		contentPane.add(lblNewLabel_1);
		
		RoundedButton btnGerenciarCategoria = new RoundedButton("Gerenciar Categoria");
		btnGerenciarCategoria.setBackground(new Color(255, 255, 255));
		btnGerenciarCategoria.setForeground(new Color(0, 64, 128));
		btnGerenciarCategoria.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnGerenciarCategoria.setBounds(1099, 629, 256, 29);
		contentPane.add(btnGerenciarCategoria);
	}
}
