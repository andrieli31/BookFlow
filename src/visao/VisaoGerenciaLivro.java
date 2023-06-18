package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.LivroDAO;
import controle.PessoaDAO;
import modelo.Livro;
import modelo.Pessoa;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;

public class VisaoGerenciaLivro extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel modelo;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtIsbn;
	private JTextField txtAno;
	private JTextField txtEditora;
	private JTable table;
	private JTextField txtNrEdicao;
	private static Livro livroEditar;

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

	public VisaoGerenciaLivro() {
		setTitle("Cadastro e listagem de livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 64, 128));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.NORTH);

		JButton btnVoltaTI = new JButton("Voltar a Tela Inicial");
		btnVoltaTI.setBackground(new Color(137, 27, 224));
		btnVoltaTI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltaTI.setForeground(new Color(255, 255, 255));
		btnVoltaTI.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltaTI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VisaoGerenciaLivro().dispose();
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}

		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(btnVoltaTI);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(137, 27, 224));
		panel_2.setBorder(new TitledBorder(null, "Dados dos Livros", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(137, 27, 224)));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Dados dos Livros");
		lblNewLabel_1.setBounds(35, 11, 236, 28);
		lblNewLabel_1.setForeground(new Color(137, 27, 224));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 38, 470, 218);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 11, 415, 20);
		panel.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitulo.setBounds(0, 0, 124, 18);
		panel_3.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setForeground(new Color(0, 0, 0));
		txtTitulo.setBounds(116, 0, 299, 20);
		panel_3.add(txtTitulo);
		txtTitulo.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 42, 415, 20);
		panel.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAutor.setBounds(0, 0, 124, 18);
		panel_4.add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(115, 0, 300, 20);
		panel_4.add(txtAutor);
		txtAutor.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(246, 140, 175, 20);
		panel.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ISBN:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(0, 0, 29, 18);
		panel_5.add(lblNewLabel_2);

		txtIsbn = new JTextField();
		txtIsbn.setBounds(39, 0, 136, 20);
		panel_5.add(txtIsbn);
		txtIsbn.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 104, 415, 20);
		panel.add(panel_6);
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(null);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setForeground(Color.BLACK);
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAno.setBounds(0, 0, 29, 18);
		panel_6.add(lblAno);

		txtAno = new JTextField();
		txtAno.setBounds(116, 0, 299, 20);
		panel_6.add(txtAno);
		txtAno.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(6, 73, 415, 20);
		panel.add(panel_7);
		panel_7.setBackground(Color.WHITE);
		panel_7.setLayout(null);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(Color.BLACK);
		lblEditora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEditora.setBounds(0, 0, 124, 18);
		panel_7.add(lblEditora);

		txtEditora = new JTextField();
		txtEditora.setBounds(115, 0, 300, 20);
		panel_7.add(txtEditora);
		txtEditora.setColumns(10);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(236, 171, 185, 38);
		panel.add(btnCadastro);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();

				LivroDAO dao = LivroDAO.getInstancia();

				String titulo = txtTitulo.getText();
				String editora = txtEditora.getText();
				String autor = txtAutor.getText();
				int numeroEdicao = Integer.parseInt(txtNrEdicao.getText());
				int anoLancamento = Integer.parseInt(txtAno.getText());
				Long isbn = Long.parseLong(txtIsbn.getText());

				livro.setAnoLancamento(anoLancamento);
				livro.setEditora(editora);
				livro.setAutor(autor);
				livro.setIsbn(isbn);
				livro.setNrEdicao(numeroEdicao);
				livro.setTitulo(titulo);

				dao.cadastrarLivro(livro);

				modelo.addRow(new Object[] { livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getNrEdicao(),
						livro.getEditora(), livro.getAnoLancamento() });

				txtTitulo.setText("");
				txtAutor.setText("");
				txtIsbn.setText("");
				txtAno.setText("");
				txtEditora.setText("");
				txtNrEdicao.setText("");
			}
		});

		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCadastro.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnCadastro.setBackground(new Color(137, 27, 224));

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setBounds(10, 169, 205, 38);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText("");
				txtAutor.setText("");
				txtIsbn.setText("");
				txtAno.setText("");
				txtEditora.setText("");
				txtNrEdicao.setText("");
			}
		});

		btnNewButton.setForeground(new Color(137, 27, 224));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBorder(new LineBorder(new Color(137, 27, 224)));
		btnNewButton.setBackground(new Color(255, 255, 255));
				
				JPanel panel_8 = new JPanel();
				panel_8.setForeground(new Color(255, 255, 255));
				panel_8.setBackground(new Color(255, 255, 255));
				panel_8.setBounds(10, 140, 226, 20);
				panel.add(panel_8);
				panel_8.setLayout(null);
		
				txtNrEdicao = new JTextField();
				txtNrEdicao.setBounds(113, 0, 113, 20);
				panel_8.add(txtNrEdicao);
				txtNrEdicao.setColumns(10);

		JLabel lblNrEdicao = new JLabel("Número Edição:");
		lblNrEdicao.setBounds(0, 2, 103, 18);
		panel_8.add(lblNrEdicao);
		lblNrEdicao.setForeground(Color.BLACK);
		lblNrEdicao.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		JButton btnExcluir = new JButton("Excluir ");
		btnExcluir.setBounds(748, 41, 207, 38);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				} else {
					DefaultTableModel tabelaLivro = (DefaultTableModel) table.getModel();
					tabelaLivro.removeRow(LinhaSelect);
					JOptionPane.showMessageDialog(null, "Livro excluído com sucesso");

				}
			}
		});
		btnExcluir.setForeground(new Color(247, 9, 68));
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnExcluir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(247, 9, 68), new Color(247, 9, 68), new Color(247, 9, 68), new Color(247, 9, 68)));
		btnExcluir.setBackground(new Color(255, 255, 255));
		panel_2.add(btnExcluir);

		JButton btnAltera = new JButton(" Alterar");
		btnAltera.setBounds(748, 90, 207, 38);
		btnAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				} else {
					long valorIsbn = (long) table.getValueAt(LinhaSelect, 2);
					LivroDAO dao = LivroDAO.getInstancia();

					livroEditar = dao.buscarLivroPorIsbn(valorIsbn);
					txtTitulo.setText(livroEditar.getTitulo());
					txtAutor.setText(livroEditar.getAutor());
					txtIsbn.setText(String.valueOf(livroEditar.getIsbn()));
					txtAno.setText(String.valueOf(livroEditar.getAnoLancamento()));
					txtEditora.setText(livroEditar.getEditora());
					txtNrEdicao.setText(String.valueOf(livroEditar.getNrEdicao()));

					txtIsbn.setEnabled(false);
				}

			}
		});
		btnAltera.setForeground(new Color(224, 169, 27));
		btnAltera.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAltera.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27)));
		btnAltera.setBackground(new Color(255, 255, 255));
		panel_2.add(btnAltera);

		JButton btnSalvaUpdate = new JButton("Salvar Alterações");
		btnSalvaUpdate.setBounds(748, 139, 207, 38);
		btnSalvaUpdate.setBackground(new Color(137, 27, 224));
		btnSalvaUpdate.setForeground(new Color(255, 255, 255));
		btnSalvaUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSalvaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO dao = LivroDAO.getInstancia();

				String titulo = txtTitulo.getText();
				String autor = txtAutor.getText();
				String isbn = txtIsbn.getText();
				String ano = txtAno.getText();
				String editora = txtEditora.getText();
				String nrEdicao = txtNrEdicao.getText();

				// completar - pronto
				livroEditar.setAnoLancamento(Integer.valueOf(ano));
				livroEditar.setAutor(autor);
				livroEditar.setEditora(editora);
				livroEditar.setIsbn(Long.parseLong(isbn));
				livroEditar.setNrEdicao(Integer.valueOf(nrEdicao));
				livroEditar.setTitulo(titulo);
				
				dao.alterarLivro(livroEditar);
				atualiza();
				txtIsbn.setEnabled(true);

			}
		});
		btnSalvaUpdate.setBorder(UIManager.getBorder("Button.border"));

		panel_2.add(btnSalvaUpdate);

		JPanel tableLivro = new JPanel();
		tableLivro.setBorder(new TitledBorder(null, "Lista de Livros", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(137, 27, 224)));
		tableLivro.setBackground(Color.WHITE);
		contentPane.add(tableLivro, BorderLayout.SOUTH);
		tableLivro.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableLivro.add(scrollPane, BorderLayout.SOUTH);

		table = new JTable();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Título", "Autor", "ISBN", "Número da edição", "Editora", "Ano lançamento" });
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}

	public static void atualiza() {

		LivroDAO dao = LivroDAO.getInstancia();
		ArrayList<Livro> livros = dao.listarLivros();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			modelo.addRow(new Object[] { livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getNrEdicao(),
					livro.getEditora(), livro.getAnoLancamento() });
		}
	}
}
