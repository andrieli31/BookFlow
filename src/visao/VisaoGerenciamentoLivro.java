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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setBackground(new Color(0, 0, 0));
		setTitle("Gerenciamento de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 930, 897);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnCadEList = new JButton("Cadastro e listagem");
		btnCadEList.setBackground(new Color(255, 255, 255));
		btnCadEList.setForeground(new Color(0, 0, 0));
		btnCadEList.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnAtualizacao = new JButton("Atualização de dados");
		btnAtualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizacao.setBackground(new Color(255, 255, 255));
		btnAtualizacao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAtualizacao.setForeground(new Color(0, 0, 0));
		
		JButton btnExclusao = new JButton("Exclusão");
		btnExclusao.setBackground(new Color(255, 255, 255));
		btnExclusao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExclusao.setForeground(new Color(0, 0, 0));
		
		JButton btnSair = new JButton("Voltar à tela inicial");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setForeground(new Color(28, 28, 28));
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(343)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addComponent(lblEscolherOpcao))
								.addComponent(btnAtualizacao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExclusao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCadEList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(358)
							.addComponent(btnSair)))
					.addContainerGap(398, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(306)
					.addComponent(lblEscolherOpcao)
					.addGap(31)
					.addComponent(btnCadEList)
					.addGap(4)
					.addComponent(btnAtualizacao)
					.addGap(4)
					.addComponent(btnExclusao)
					.addGap(41)
					.addComponent(btnSair)
					.addContainerGap(331, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
