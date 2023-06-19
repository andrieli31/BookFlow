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

public class VisaoCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtEmail;
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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		PessoaDAO daoPessoa = PessoaDAO.getInstancia();

		JLabel lblNewLabel = new JLabel("Dados dos Usuários");
		lblNewLabel.setForeground(new Color(67, 1, 108));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);

		MaskFormatter mascaraCpf = null;

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(0, 0, 62, 18);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSobrenome.setForeground(new Color(0, 0, 0));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCpf.setForeground(new Color(0, 0, 0));

		JButton btnCadastrar = new JButton("Cadastrar Usuário");
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

		JButton btnListaUsuario = new JButton("Listar Usuários");
		btnListaUsuario.setForeground(new Color(137, 27, 224));

		btnListaUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atualiza();
			}

		});
		btnListaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnExcluir = new JButton("Excluir Usuário");
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
		btnExcluir.setForeground(new Color(137, 27, 224));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_3 = new JButton("Alterar Usuário");
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
		btnNewButton_3.setBackground(new Color(137, 27, 224));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtSenha = new JPasswordField();

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();
		table.setModel(modelo);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(67, 1, 100));
		scrollPane.setViewportView(table);
		table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(Color.LIGHT_GRAY);

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);

		JButton btnSalvaUpdate = new JButton("Salvar alterações"); //nao ta salvendano essa bomba
		btnSalvaUpdate.setForeground(new Color(137, 27, 224));
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
		
		JButton btnNewButton_4 = new JButton("Voltar a Tela Inicial");
		btnNewButton_4.setForeground(new Color(137, 27, 224));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1271, Short.MAX_VALUE)
							.addGap(1345))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
									.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblCpf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSobrenome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtSobrenome)
											.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
										.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
										.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
								.addComponent(btnListaUsuario, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
							.addGap(446)
							.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalvaUpdate, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
							.addGap(1552))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addContainerGap(1249, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addContainerGap(1246, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(669)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1759, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSobrenome)
								.addComponent(txtSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnListaUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(btnSalvaUpdate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(150)))
					.addGap(90)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
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