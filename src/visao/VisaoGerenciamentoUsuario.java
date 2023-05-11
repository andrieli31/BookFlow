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
		setBackground(new Color(64, 128, 128));
		setTitle("Gerenciamento de Usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][][]"));
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblEscolherOpcao, "cell 5 1,alignx center,aligny center");
		
		JButton btnCadEList = new JButton("Cadastro e listagem");
		btnCadEList.setBackground(new Color(64, 128, 128));
		btnCadEList.setForeground(new Color(64, 128, 128));
		btnCadEList.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnCadEList, "cell 5 3,alignx center,aligny center");
		
		JButton btnAlteraDados = new JButton("Alteração de dados");
		btnAlteraDados.setBackground(new Color(64, 128, 128));
		btnAlteraDados.setForeground(new Color(64, 128, 128));
		btnAlteraDados.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnAlteraDados, "cell 5 4,alignx center,aligny center");
		
		JButton btnExcluiUsuario = new JButton("Excluir usuário");
		btnExcluiUsuario.setBackground(new Color(64, 128, 128));
		btnExcluiUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExcluiUsuario.setForeground(new Color(64, 128, 128));
		contentPane.add(btnExcluiUsuario, "cell 5 5,alignx center,aligny center");
		
		JButton btnSair = new JButton("Voltar à tela inicial");
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSair.setBackground(new Color(64, 128, 128));
		btnSair.setForeground(new Color(128, 128, 128));
		contentPane.add(btnSair, "cell 5 8,alignx center,aligny center");
	}

}
