package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.LivroDAO;
import controle.PessoaDAO;
import modelo.Livro;
import modelo.Pessoa;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class VisaoCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JPasswordField txtSenha;
	private static DefaultTableModel modelo;
	private JTable table;
	private static Pessoa pessoaEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
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
	public VisaoCadastroUsuario() {
		setTitle("Cadastro Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 1144);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 1, 108));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		PessoaDAO daoPessoa = PessoaDAO.getInstancia();

		MaskFormatter mascaraCpf = null;

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();
		table.setModel(modelo);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(251, 245, 255));
		scrollPane.setViewportView(table);
		table.getTableHeader().setForeground(Color.BLACK);
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(Color.WHITE);

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		JButton btnNewButton_4 = new JButton("Voltar a Tela Inicial");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setForeground(new Color(137, 27, 224));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(67, 1, 108));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(67, 1, 108));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(445, Short.MAX_VALUE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)))
		);
		panel_6.setLayout(null);
		
		JButton btnNewButton_41 = new JButton("Voltar a Tela Inicial");
		btnNewButton_41.setBounds(23, 11, 147, 36);
		panel_6.add(btnNewButton_41);
		btnNewButton_41.setForeground(new Color(137, 27, 224));
		btnNewButton_41.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.setLayout(null);
				
				visao.RoundedPanel painelCadastro = new visao.RoundedPanel(100, Color.WHITE);
				//JPanel painelCadastro = new JPanel();
				painelCadastro.setBackground(new Color(67, 1, 108));
				painelCadastro.setBounds(10, 11, 377, 492);
				panel.add(painelCadastro);
				painelCadastro.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Dados Usuário");
				lblNewLabel.setBounds(21, 34, 284, 28);
				painelCadastro.add(lblNewLabel);
				lblNewLabel.setForeground(new Color(67, 1, 108));
				lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
						
						JPanel panel_3 = new JPanel();
						panel_3.setBounds(21, 73, 346, 55);
						painelCadastro.add(panel_3);
						panel_3.setBackground(new Color(255, 255, 255));
						panel_3.setLayout(null);
				
						JLabel lblNome = new JLabel("Nome: ");
						lblNome.setBounds(0, 2, 83, 16);
						panel_3.add(lblNome);
						lblNome.setFont(new Font("Segoe UI", Font.BOLD, 12));
						lblNome.setForeground(new Color(0, 0, 0));
						
								txtNome = new JTextField();
								txtNome.setBounds(0, 29, 346, 26);
								panel_3.add(txtNome);
								txtNome.setColumns(10);
										
										JPanel panel_2 = new JPanel();
										panel_2.setBounds(21, 139, 346, 62);
										painelCadastro.add(panel_2);
										panel_2.setBackground(new Color(255, 255, 255));
										panel_2.setLayout(null);
								
										JLabel lblSobrenome = new JLabel("Sobrenome:");
										lblSobrenome.setBounds(0, 2, 83, 16);
										panel_2.add(lblSobrenome);
										lblSobrenome.setFont(new Font("Segoe UI", Font.BOLD, 12));
										lblSobrenome.setForeground(new Color(0, 0, 0));
										
												txtSobrenome = new JTextField();
												txtSobrenome.setBounds(0, 29, 346, 26);
												panel_2.add(txtSobrenome);
												txtSobrenome.setColumns(10);
												
												JPanel panel_1 = new JPanel();
												panel_1.setBounds(21, 212, 346, 62);
												painelCadastro.add(panel_1);
												panel_1.setBackground(new Color(255, 255, 255));
												panel_1.setLayout(null);
												
														JLabel lblCpf = new JLabel("CPF:");
														lblCpf.setBounds(0, 1, 83, 16);
														panel_1.add(lblCpf);
														lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 12));
														lblCpf.setForeground(new Color(0, 0, 0));
														
																txtCpf = new JFormattedTextField(mascaraCpf);
																txtCpf.setBounds(0, 28, 346, 26);
																panel_1.add(txtCpf);
																txtCpf.setColumns(10);
																
																JPanel panel_4 = new JPanel();
																panel_4.setBounds(21, 284, 346, 55);
																painelCadastro.add(panel_4);
																panel_4.setBackground(new Color(255, 255, 255));
																panel_4.setLayout(null);
																
																		JLabel lblNewLabel_6 = new JLabel("Senha:");
																		lblNewLabel_6.setBounds(0, 1, 81, 16);
																		panel_4.add(lblNewLabel_6);
																		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
																		lblNewLabel_6.setForeground(new Color(0, 0, 0));
																		
																				txtSenha = new JPasswordField();
																				txtSenha.setBounds(0, 28, 336, 26);
																				panel_4.add(txtSenha);
																				
																						JButton btnListaUsuario = new JButton("Listar Usuários");
																						btnListaUsuario.setBounds(21, 375, 167, 38);
																						painelCadastro.add(btnListaUsuario);
																						btnListaUsuario.setForeground(new Color(137, 27, 224));
																						
																								btnListaUsuario.addActionListener(new ActionListener() {
																						
																									@Override
																									public void actionPerformed(ActionEvent e) {
																										// TODO Auto-generated method stub
																										atualiza();
																									}
																						
																								});
																								btnListaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
																								
																										JButton btnCadastrar = new JButton("Cadastrar Usuário");
																										btnCadastrar.setBounds(198, 374, 168, 39);
																										painelCadastro.add(btnCadastrar);
																										btnCadastrar.setBackground(new Color(137, 27, 224));
																										
																												btnCadastrar.addActionListener(new ActionListener() {
																													/// colocar anos de edição dos livros e diminuir 1
																													// int ano= LocalDate.now().getYear();
																													// for(int i = 0; i<ano; i++) {
																													// cbNomes.addItem(String.valueOf(ano));
																													// }
																													@Override
																													public void actionPerformed(ActionEvent e) {
																														Pessoa pessoa = new Pessoa();
																										
																														String nome = txtNome.getText();
																														String sobrenome = txtSobrenome.getText();
																														String cpfText = txtCpf.getText();
																														cpfText = cpfText.replaceAll("[.-]", ""); // Remove pontos e traço da máscara
																														Long cpf = Long.parseLong(cpfText);
																														String senha = String.valueOf(txtSenha.getPassword());
																										
																														pessoa.setNome(nome);
																														pessoa.setSobrenome(sobrenome);
																														pessoa.setCpf(cpf);
																														pessoa.setSenha(senha);
																										
																														txtNome.setText(null);
																														txtSobrenome.setText(null);
																														txtCpf.setText(null);
																														txtSenha.setText(null);
																										
																														PessoaDAO dao = PessoaDAO.getInstancia();
																														Boolean cadastrar = dao.cadastrarPessoa(pessoa);
																														if (cadastrar) {
																															JOptionPane.showMessageDialog(btnCadastrar, "Usuario cadastrado");
																														} else {
																															JOptionPane.showMessageDialog(btnCadastrar, "Usuario não foi cadastrado");
																														}
																										
																													}
																										
																												});
																												
																														btnCadastrar.setForeground(new Color(255, 255, 255));
																														
																																btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
												
														RoundedButton btnExcluir = new RoundedButton("Excluir Usuário"); //arredonda bordas do botão
							
														
														
														btnExcluir.setBounds(411, 32, 155, 35);
														panel.add(btnExcluir);
														btnExcluir.setBackground(Color.WHITE);
														btnExcluir.addActionListener(new ActionListener() {

															@Override
															public void actionPerformed(ActionEvent e) {
																int linhaSelect = table.getSelectedRow();
																if (linhaSelect == -1) {
																	JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
																} else {
																	DefaultTableModel tabelapessoa = (DefaultTableModel) table.getModel();
																	tabelapessoa.removeRow(linhaSelect);
																}
															}

														});
														btnExcluir.setForeground(new Color(247, 9, 68));
														btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
														
																JButton btnNewButton_3 = new JButton("Alterar Usuário");
																btnNewButton_3.setBounds(411, 81, 155, 32);
																panel.add(btnNewButton_3);
																btnNewButton_3.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		int LinhaSelect = table.getSelectedRow();
																		if (LinhaSelect == -1) {
																			JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
																		} else {
																			long valorCpf = (long) table.getValueAt(LinhaSelect, 2); // seleciona linha estatica
																			PessoaDAO dao = PessoaDAO.getInstancia();

																			pessoaEditar = dao.buscarPessoaCpf(valorCpf);

																			txtNome.setText(pessoaEditar.getNome());
																			txtSobrenome.setText(pessoaEditar.getSobrenome());
																			txtCpf.setText(String.valueOf(pessoaEditar.getCpf()));
																			txtSenha.setText(pessoaEditar.getSenha());

																			txtCpf.setEnabled(false);

																		}

																	}
																});
																btnNewButton_3.setBackground(new Color(255, 255, 255));
																btnNewButton_3.setForeground(new Color(224, 169, 27));
																btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
																
																		JButton btnSalvaUpdate = new JButton("Salvar alterações"); //nao ta salvendano essa bomba
																		btnSalvaUpdate.setBackground(new Color(255, 255, 255));
																		btnSalvaUpdate.setBounds(411, 136, 155, 30);
																		panel.add(btnSalvaUpdate);
																		btnSalvaUpdate.setFont(new Font("Segoe UI", Font.BOLD, 12));
																		btnSalvaUpdate.setForeground(new Color(0, 128, 128));
																		btnSalvaUpdate.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				PessoaDAO dao = PessoaDAO.getInstancia();

																				String nome = txtNome.getText();
																				String sobrenome = txtSobrenome.getText();
																				
																				String cpf = txtCpf.getText();
																				cpf = cpf.replaceAll("[.-]", ""); // Remove pontos e traço da máscara
																				pessoaEditar.setCpf(Long.parseLong(cpf));
																				
																				String senha = txtSenha.getText();

																				
																				pessoaEditar.setNome(nome);
																				pessoaEditar.setSobrenome(sobrenome);
																				pessoaEditar.setCpf(Long.parseLong(cpf));
																				pessoaEditar.setSenha(senha);

																				dao.alterarPessoa(pessoaEditar);
																				atualiza();
																				txtCpf.setEnabled(true);

																			}
																		});
		contentPane.setLayout(gl_contentPane);

		modelo.addColumn("Nome");
		modelo.addColumn("Sobrenome");
		modelo.addColumn("CPF");

	}

	public static void atualiza() {

		PessoaDAO dao = PessoaDAO.getInstancia();
		ArrayList<Pessoa> listaPessoas = dao.listarPessoas();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < listaPessoas.size(); i++) {
			Pessoa p = listaPessoas.get(i);
			modelo.addRow(new Object[] { p.getNome(), p.getSobrenome(), p.getCpf(), p.getSenha() });
		}
	}
}