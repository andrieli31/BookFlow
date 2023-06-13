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
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 22));

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
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNome.setForeground(new Color(0, 0, 0));

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSobrenome.setForeground(new Color(0, 0, 0));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblCpf.setForeground(new Color(0, 0, 0));

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.addActionListener(new ActionListener() {
			/// colocar anos de edição dos livros e diminuir 1
			//int ano= LocalDate.now().getYear();
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
				String email = txtEmail.getText();

				pessoa.setNome(nome);
				pessoa.setSobrenome(sobrenome);
				pessoa.setCpf(cpf);
				pessoa.setEmail(email);
				pessoa.setSenha(senha);

				txtNome.setText(null);
				txtSobrenome.setText(null);
				txtCpf.setText(null);
				txtSenha.setText(null);
				txtEmail.setText(null);
				
				PessoaDAO dao = PessoaDAO.getInstancia();
				Boolean cadastrar = dao.cadastrarPessoa(pessoa);
				if(cadastrar) {
					JOptionPane.showMessageDialog(btnCadastrar, "Usuario cadastrado");
				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Usuario não foi cadastrado");
				}
				
			}

		});

		btnCadastrar.setForeground(new Color(0, 64, 128));

		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnListaUsuario = new JButton("Listar");
		btnListaUsuario.setForeground(new Color(0, 64, 128));

		btnListaUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atualiza();
			}

		});
		btnListaUsuario.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));

		
		JButton btnNewButton_2 = new JButton("Excluir Usuário");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));

		Pessoa pessoa = new Pessoa();
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				String cpfText = txtCpf.getText();
				cpfText = cpfText.replaceAll("[.-]", ""); // Remove pontos e traço da máscara
				Long cpf = Long.parseLong(cpfText);
				String senha = String.valueOf(txtSenha.getPassword());
				String email = txtEmail.getText();

				pessoa.setNome(nome);
				pessoa.setSobrenome(sobrenome);
				pessoa.setCpf(cpf);
				pessoa.setEmail(email);
				pessoa.setSenha(senha);

				txtNome.setText(null);
				txtSobrenome.setText(null);
				txtCpf.setText(null);
				txtSenha.setText(null);
				txtEmail.setText(null);
				
				PessoaDAO dao = PessoaDAO.getInstancia();
				Boolean cadastrar = dao.cadastrarPessoa(pessoa);
				if(cadastrar) {
					JOptionPane.showMessageDialog(btnCadastrar, "Usuario cadastrado");
				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Usuario não foi cadastrado");
				}


		JButton btnExcluir = new JButton("Excluir Usuário");
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
		        if (row != -1) { // Verifica se alguma linha foi selecionada
		            Object valorRow = table.getValueAt(row, 2); // Índice 2 é a coluna do CPF
		            Long cpf = Long.valueOf((String) valorRow); // Converte o valor do CPF para Long
		            PessoaDAO pessoaDAO = PessoaDAO.getInstancia();
		            pessoaDAO.deletarPessoa(null, cpf); // Exclui o usuário com o CPF correspondente
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.removeRow(row); // Remove a linha selecionada da tabela
		        } else {
		            JOptionPane.showMessageDialog(btnExcluir, "Nenhuma linha selecionada");
		        }
			}

		});
		btnExcluir.setForeground(new Color(117, 0, 32));
		btnExcluir.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnNewButton_3 = new JButton("Alterar Usuário");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setForeground(new Color(0, 64, 0));
		btnNewButton_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));

		JButton btnNewButton_4 = new JButton("Voltar a tela inicial");
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}

		});
		btnNewButton_4.setForeground(new Color(0, 64, 128));
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtSenha = new JPasswordField();

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		JLabel lblControleDosUsurios = new JLabel("Controle dos Usuários");
		lblControleDosUsurios.setForeground(new Color(0, 64, 128));
		lblControleDosUsurios.setFont(new Font("Segoe UI Black", Font.BOLD, 20));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnListaUsuario, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE))
						.addComponent(lblControleDosUsurios, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
					.addGap(98))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(852, Short.MAX_VALUE)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(241))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addComponent(lblNewLabel)
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(41)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSobrenome))
									.addGap(21)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCpf)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNome)))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6))
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCadastrar)
								.addComponent(btnListaUsuario))
							.addGap(85)
							.addComponent(lblControleDosUsurios, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnNewButton_3)))
					.addGap(37)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(302))
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
			modelo.addRow(new Object[] { p.getNome(), p.getSobrenome(), p.getCpf() });
		}
	}
}