package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaoGerenciamentoLivro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoGerenciamentoLivro frame = new VisaoGerenciamentoLivro();
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
	public VisaoGerenciamentoLivro() {
		setBackground(new Color(64, 128, 128));
		setTitle("Gerenciamento de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][]"));
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblEscolherOpcao, "cell 3 1,alignx center,aligny center");
		
		JButton btnCadEList = new JButton("Cadastro e listagem");
		btnCadEList.setBackground(new Color(255, 255, 255));
		btnCadEList.setForeground(new Color(64, 128, 128));
		btnCadEList.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnCadEList, "cell 3 3,alignx center,aligny center");
		
		JButton btnAtualizacao = new JButton("Atualização de dados");
		btnAtualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizacao.setBackground(new Color(255, 255, 255));
		btnAtualizacao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAtualizacao.setForeground(new Color(64, 128, 128));
		contentPane.add(btnAtualizacao, "cell 3 4,alignx center,aligny center");
		
		JButton btnExclusao = new JButton("Exclusão");
		btnExclusao.setBackground(new Color(255, 255, 255));
		btnExclusao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExclusao.setForeground(new Color(64, 128, 128));
		contentPane.add(btnExclusao, "cell 3 5,alignx center,aligny center");
		
		JButton btnSair = new JButton("Voltar à tela inicial");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setForeground(new Color(128, 128, 128));
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnSair, "cell 3 8,alignx center,aligny center");
	}

}
