package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VisaoGerenciamentoUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoGerenciamentoUsuario frame = new VisaoGerenciamentoUsuario();
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
	public VisaoGerenciamentoUsuario() {
		setBackground(new Color(0, 0, 0));
		setTitle("Gerenciamento de Usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnCadEList = new JButton("Cadastro e listagem");
		btnCadEList.setBackground(new Color(255, 255, 255));
		btnCadEList.setForeground(new Color(64, 128, 128));
		btnCadEList.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnAlteraDados = new JButton("Alteração de dados");
		btnAlteraDados.setBackground(new Color(255, 255, 255));
		btnAlteraDados.setForeground(new Color(64, 128, 128));
		btnAlteraDados.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnExcluiUsuario = new JButton("Excluir usuário");
		btnExcluiUsuario.setBackground(new Color(255, 255, 255));
		btnExcluiUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExcluiUsuario.setForeground(new Color(64, 128, 128));
		
		JButton btnSair = new JButton("Voltar à tela inicial");
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setForeground(new Color(128, 128, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(lblEscolherOpcao))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(btnCadEList))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(btnAlteraDados))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addComponent(btnExcluiUsuario))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(169)
					.addComponent(btnSair))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEscolherOpcao)
					.addGap(31)
					.addComponent(btnCadEList)
					.addGap(4)
					.addComponent(btnAlteraDados)
					.addGap(4)
					.addComponent(btnExcluiUsuario)
					.addGap(56)
					.addComponent(btnSair))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
