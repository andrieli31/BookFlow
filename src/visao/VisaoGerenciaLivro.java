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
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

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
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, BorderLayout.WEST);

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(255, 0, 128));
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		
				JButton btnNewButton_1 = new JButton("Voltar a Tela Inicial");
				btnNewButton_1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						VisaoTelaInicial frame = new VisaoTelaInicial();
						frame.setVisible(true);
						dispose();
					}

				});
				btnNewButton_1.setForeground(new Color(0, 0, 0));
				btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(4355, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(891))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 881, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
							.addGap(17))))
		);
		panel_2.setLayout(null);
						
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(255, 255, 255));
						panel_3.setBounds(54, 71, 517, 33);
						panel_2.add(panel_3);
						panel_3.setLayout(null);
				
						JLabel lblTitulo = new JLabel("Título:");
						lblTitulo.setBounds(0, 5, 124, 18);
						panel_3.add(lblTitulo);
						lblTitulo.setForeground(new Color(0, 0, 0));
						lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
						
								txtTitulo = new JTextField();
								txtTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
								txtTitulo.setBounds(235, 1, 282, 29);
								panel_3.add(txtTitulo);
								txtTitulo.setColumns(10);
										
										JPanel panel_4 = new JPanel();
										panel_4.setBackground(new Color(255, 255, 255));
										panel_4.setBounds(54, 115, 517, 33);
										panel_2.add(panel_4);
										panel_4.setLayout(null);
								
										JLabel lblEditora = new JLabel("Editora:");
										lblEditora.setBounds(0, 5, 124, 18);
										panel_4.add(lblEditora);
										lblEditora.setForeground(new Color(0, 0, 0));
										lblEditora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
										
												txtEditora = new JTextField();
												txtEditora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
												txtEditora.setBounds(234, 0, 283, 30);
												panel_4.add(txtEditora);
												txtEditora.setColumns(10);
														
														JPanel panel_5 = new JPanel();
														panel_5.setBackground(new Color(255, 255, 255));
														panel_5.setBounds(54, 159, 517, 33);
														panel_2.add(panel_5);
														panel_5.setLayout(null);
												
														JLabel lblNumEdicao = new JLabel("Número da edição:");
														lblNumEdicao.setBounds(0, 5, 124, 18);
														panel_5.add(lblNumEdicao);
														lblNumEdicao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
														lblNumEdicao.setForeground(new Color(0, 0, 0));
														
																txtNumEdicao = new JTextField();
																txtNumEdicao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																txtNumEdicao.setBounds(234, 0, 283, 31);
																panel_5.add(txtNumEdicao);
																txtNumEdicao.setColumns(10);
																		
																		JPanel panel_6 = new JPanel();
																		panel_6.setBackground(new Color(255, 255, 255));
																		panel_6.setBounds(54, 203, 517, 33);
																		panel_2.add(panel_6);
																		panel_6.setLayout(null);
																
																		JLabel lblISBN = new JLabel("ISBN:");
																		lblISBN.setBounds(0, 5, 124, 18);
																		panel_6.add(lblISBN);
																		lblISBN.setForeground(new Color(0, 0, 0));
																		lblISBN.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																		
																				txtISBN = new JTextField();
																				txtISBN.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																				txtISBN.setBounds(234, 0, 283, 30);
																				panel_6.add(txtISBN);
																				txtISBN.setColumns(10);
																						
																						JPanel panel_7 = new JPanel();
																						panel_7.setBackground(new Color(255, 255, 255));
																						panel_7.setBounds(54, 247, 517, 33);
																						panel_2.add(panel_7);
																						panel_7.setLayout(null);
																				
																						JLabel lblAno = new JLabel("Ano de lançamento:");
																						lblAno.setBounds(0, 6, 124, 18);
																						panel_7.add(lblAno);
																						lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																						lblAno.setForeground(new Color(0, 0, 0));
																						
																								txtAno = new JTextField();
																								txtAno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																								txtAno.setBounds(235, 0, 282, 32);
																								panel_7.add(txtAno);
																								txtAno.setColumns(10);
																								
																										JButton btnCadastro = new JButton("Cadastrar Livro");
																										btnCadastro.setBounds(54, 291, 236, 33);
																										panel_2.add(btnCadastro);
																										btnCadastro.setForeground(new Color(137, 27, 224));
																										btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 12));
																										
																												JButton btnListagem = new JButton("Listar Livro");
																												btnListagem.setBackground(new Color(137, 27, 224));
																												btnListagem.setBounds(303, 291, 268, 33);
																												panel_2.add(btnListagem);
																												btnListagem.setFont(new Font("Segoe UI", Font.BOLD, 12));
																												btnListagem.setForeground(new Color(255, 255, 255));
																												
																														JLabel lblNewLabel = new JLabel("Selecione um Livro:");
																														lblNewLabel.setBounds(54, 366, 257, 28);
																														panel_2.add(lblNewLabel);
																														lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
																														lblNewLabel.setForeground(new Color(67, 1, 108));
																														
																																JComboBox comboBox = new JComboBox();
																																comboBox.setBounds(54, 405, 517, 28);
																																panel_2.add(comboBox);
																																comboBox.setForeground(new Color(0, 0, 0));
																																comboBox.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
																																comboBox.setModel(new DefaultComboBoxModel(new String[] { "Livro 1", "Livro 2",
																																		"Livro 3", "Livro 4", "Livro 5" }));
																																
																																		JButton btnExcluiLivro = new JButton("Excluir Livro");
																																		btnExcluiLivro.setBounds(54, 444, 236, 38);
																																		panel_2.add(btnExcluiLivro);
																																		btnExcluiLivro.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent e) {
																																				btnExcluiLivro.addActionListener(new ActionListener() {

																																					@Override
																																					public void actionPerformed(ActionEvent e) {						
																																					}
																																					
																																				});
																																			}
																																		});
																																		btnExcluiLivro.setForeground(new Color(137, 27, 224));
																																		
																																		btnExcluiLivro.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
																																		
																																				JButton btnAlteraLivro = new JButton("Alterar Livro");
																																				btnAlteraLivro.setBounds(303, 444, 268, 38);
																																				panel_2.add(btnAlteraLivro);
																																				btnAlteraLivro.addActionListener(new ActionListener() {
																																					public void actionPerformed(ActionEvent e) {
																																						PopUpAlteraLivro frame = new PopUpAlteraLivro();
																																						frame.setVisible(true);
																																						dispose();
																																						
																																					}
																																				});
																																				btnAlteraLivro.setForeground(new Color(255, 255, 255));
																																				btnAlteraLivro.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
																																				btnAlteraLivro.setBackground(new Color(137, 27, 224));
																																						
																																								JLabel lblNewLabel_1 = new JLabel("Dados dos Livros");
																																								lblNewLabel_1.setBounds(54, 32, 236, 28);
																																								panel_2.add(lblNewLabel_1);
																																								lblNewLabel_1.setBackground(new Color(0, 0, 128));
																																								lblNewLabel_1.setForeground(new Color(67, 1, 108));
																																								lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
																												btnListagem.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent e) {
																														atualiza();

																													}
																												});
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
		panel_1.setLayout(gl_panel_1);
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
