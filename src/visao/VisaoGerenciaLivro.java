package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.LivroDAO;
import modelo.Livro;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import java.awt.Component;

public class VisaoGerenciaLivro extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtTitulo;
	private JTextField txtEditora;
	private JTextField txtNumEdicao;
	private JTextField txtISBN;
	private JTextField txtAno;
	private JTable table;
	private static DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoGerenciaLivro frame = new VisaoGerenciaLivro();
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
	public VisaoGerenciaLivro() {
		setTitle("Cadastro e listagem de livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 64, 128));
		panel_1.setBackground(new Color(0, 64, 128));
		panel.add(panel_1, BorderLayout.NORTH);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(new Color(255, 255, 255));
		lblEditora.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtEditora = new JTextField();
		txtEditora.setColumns(10);

		JLabel lblNumEdicao = new JLabel("Número da edição:");
		lblNumEdicao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEdicao.setForeground(new Color(255, 255, 255));

		txtNumEdicao = new JTextField();
		txtNumEdicao.setColumns(10);

		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setForeground(new Color(255, 255, 255));
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtISBN = new JTextField();
		txtISBN.setColumns(10);

		JLabel lblAno = new JLabel("Ano de lançamento:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno.setForeground(new Color(255, 255, 255));

		txtAno = new JTextField();
		txtAno.setColumns(10);

		JButton btnCadastro = new JButton("Cadastrar Livro");
		btnCadastro.setForeground(new Color(0, 64, 128));
		btnCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();

				LivroDAO dao = LivroDAO.getInstancia();

				String titulo = txtTitulo.getText();
				String editora = txtEditora.getText();
				int numeroEdicao = Integer.parseInt(txtNumEdicao.getText());
				int anoLancamento = Integer.parseInt(txtAno.getText());
				Long isbn = Long.parseLong(txtISBN.getText());

				livro.setAnoLancamento(anoLancamento);
				livro.setEditora(editora);
				livro.setIsbn(isbn);
				livro.setNrEdicao(numeroEdicao);
				livro.setTitulo(titulo);

				txtTitulo.setText(null);
				txtEditora.setText(null);
				txtAno.setText(null);
				txtNumEdicao.setText(null);
				txtISBN.setText(null);

				dao.cadastrarLivro(livro);

			}

		});

		JButton btnListagem = new JButton("Listar Livro");
		btnListagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListagem.setForeground(new Color(0, 64, 128));
		btnListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualiza();

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);

		JLabel lblNewLabel = new JLabel("Selecione um Livro:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 64, 128));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Livro 1", "Livro 2",
				"Livro 3", "Livro 4", "Livro 5" }));

		JButton btnExcluiLivro = new JButton("Excluir Livro");
		btnExcluiLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluiLivro.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {						
					}
					
				});
			}
		});
		btnExcluiLivro.setForeground(new Color(0, 64, 128));
		
		btnExcluiLivro.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1 = new JLabel("Dados dos Livros");
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(255, 0, 128));

		JButton btnNewButton_1 = new JButton("Voltar a Tela Inicial");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}

		});
		btnNewButton_1.setForeground(new Color(0, 64, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnAlteraLivro = new JButton("Alterar Livro");
		btnAlteraLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpAlteraLivro frame = new PopUpAlteraLivro();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnAlteraLivro.setForeground(new Color(0, 64, 128));
		btnAlteraLivro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlteraLivro.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(50)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 236,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														verticalBox, GroupLayout.PREFERRED_SIZE, 1,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup().addGap(9)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addComponent(lblTitulo).addComponent(lblISBN)
																.addComponent(lblNumEdicao).addComponent(lblEditora)
																.addComponent(lblAno)))
												.addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 140,
														GroupLayout.PREFERRED_SIZE))
												.addGap(10)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(btnListagem, GroupLayout.PREFERRED_SIZE, 123,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE, 245,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtTitulo, GroupLayout.PREFERRED_SIZE, 245,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panel_1.createSequentialGroup().addGap(140)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(txtISBN, GroupLayout.DEFAULT_SIZE,
																				105, Short.MAX_VALUE)
																		.addComponent(txtNumEdicao,
																				GroupLayout.DEFAULT_SIZE, 105,
																				Short.MAX_VALUE)
																		.addComponent(txtAno,
																				GroupLayout.PREFERRED_SIZE, 105,
																				GroupLayout.PREFERRED_SIZE)))))
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(btnExcluiLivro)
												.addGap(28).addComponent(btnAlteraLivro))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 257,
												GroupLayout.PREFERRED_SIZE))
								.addGap(313)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)))
				.addGap(227)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(147, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 1,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1))
										.addGap(32)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(16)
														.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(17)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																.addComponent(txtNumEdicao, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblNumEdicao))
														.addGap(16)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblISBN)))
												.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblTitulo)
														.addGap(18).addComponent(lblEditora)))
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup().addGap(17).addComponent(
														txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblAno)))
										.addGap(16)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnListagem, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnCadastro, GroupLayout.DEFAULT_SIZE, 33,
														Short.MAX_VALUE))
										.addGap(88).addComponent(lblNewLabel).addGap(16)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(17)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnExcluiLivro, GroupLayout.PREFERRED_SIZE, 29,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAlteraLivro, GroupLayout.DEFAULT_SIZE, 28,
														Short.MAX_VALUE))
										.addGap(37)))
						.addGap(32)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(141)));
		panel_1.setLayout(gl_panel_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setForeground(new Color(255, 0, 128));
		horizontalStrut.setFont(null);
		horizontalStrut.setBackground(new Color(255, 0, 128));
		panel.add(horizontalStrut, BorderLayout.WEST);
		modelo.addColumn("Título");
		modelo.addColumn("Editora");
		modelo.addColumn("Número da edição");
		modelo.addColumn("ISBN");
		modelo.addColumn("Ano de lançamento");
	}

	public static void atualiza() {

		LivroDAO dao = LivroDAO.getInstancia();
		ArrayList<Livro> listaLivros = dao.listarLivros();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < listaLivros.size(); i++) {
			Livro p = listaLivros.get(i);
			modelo.addRow(
					new Object[] { p.getTitulo(), p.getEditora(), p.getNrEdicao(), p.getIsbn(), p.getAnoLancamento() });
		}
	}
}
