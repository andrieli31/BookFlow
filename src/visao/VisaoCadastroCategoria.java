package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.CategoriaDAO;
import controle.LivroDAO;
import modelo.Categoria;
import modelo.Livro;

public class VisaoCadastroCategoria extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel modelo;
	private JTextField txtTitulo;
	private JTextField txtIdioma;
	private JTextField txtQuantPaginas;
	private JTextField txtGenero;
	private JTextField txtEditora;
	private JTable table;
	private JTextField txtNrEdicao;
	private static Categoria categoriaEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroCategoria frame = new VisaoCadastroCategoria();
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
	public VisaoCadastroCategoria() {

		setTitle("Cadastro e listagem de categorias");
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
		btnVoltaTI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltaTI.setForeground(new Color(0, 64, 128));
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
		panel_1.add(btnVoltaTI);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Dados das categorias", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 64, 128)));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Dados das categorias");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 11, 236, 28);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(35, 50, 349, 20);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTitulo.setBounds(0, 0, 124, 18);
		panel_3.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setForeground(new Color(0, 0, 0));
		txtTitulo.setBounds(144, 0, 205, 20);
		panel_3.add(txtTitulo);
		txtTitulo.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(35, 81, 349, 20);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lbldioma = new JLabel("Idioma");
		lbldioma.setForeground(Color.BLACK);
		lbldioma.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbldioma.setBounds(0, 0, 124, 18);
		panel_4.add(lbldioma);

		txtIdioma = new JTextField();
		txtIdioma.setBounds(144, 0, 205, 20);
		panel_4.add(txtIdioma);
		txtIdioma.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(35, 112, 349, 20);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblquantPaginas = new JLabel("Quant. Paginas");
		lblquantPaginas.setForeground(Color.BLACK);
		lblquantPaginas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblquantPaginas.setBounds(0, 0, 124, 18);
		panel_5.add(lblquantPaginas);

		txtQuantPaginas = new JTextField();
		txtQuantPaginas.setBounds(144, 0, 205, 20);
		panel_5.add(txtQuantPaginas);
		txtQuantPaginas.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(35, 143, 349, 20);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGenero.setBounds(0, 0, 124, 18);
		panel_6.add(lblGenero);

		txtGenero = new JTextField();
		txtGenero.setBounds(144, 0, 205, 20);
		panel_6.add(txtGenero);
		txtGenero.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(35, 174, 349, 20);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria();

				CategoriaDAO dao = CategoriaDAO.getInstancia();

				String titulo = txtTitulo.getText();
				String idioma = txtIdioma.getText();
				String qntPag = txtQuantPaginas.getText();
				String genero = txtGenero.getText();

				categoria.setNomeCategoria(titulo);
				categoria.setIdioma(idioma);
				categoria.setQuantPaginas(Integer.valueOf(qntPag));
				categoria.setGenero(genero);

				dao.cadastarCategoria(categoria);

				modelo.addRow(new Object[] { categoria.getNomeCategoria(), categoria.getGenero(),
						categoria.getQuantPaginas(), categoria.getIdioma() });

				txtTitulo.setText("");
				txtIdioma.setText("");
				txtQuantPaginas.setText("");
				txtGenero.setText("");

			}
		});

		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCadastro.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnCadastro.setBackground(new Color(0, 64, 128));
		btnCadastro.setBounds(439, 112, 160, 38);
		panel_2.add(btnCadastro);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText("");
				txtIdioma.setText("");
				txtQuantPaginas.setText("");
				txtGenero.setText("");
			}
		});

		btnNewButton.setForeground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(811, 81, 160, 38);
		panel_2.add(btnNewButton);

		JButton btnExcluir = new JButton("Excluir ");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				} else {
					DefaultTableModel tabelaCategoria = (DefaultTableModel) table.getModel();
					tabelaCategoria.removeRow(LinhaSelect);
					JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso");

				}
			}
		});
		btnExcluir.setForeground(new Color(0, 64, 128));
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnExcluir.setBorder(UIManager.getBorder("Button.border"));
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setBounds(439, 50, 160, 38);
		panel_2.add(btnExcluir);

		JButton btnAltera = new JButton(" Alterar");
		btnAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				} else {

					int valorId = (int) table.getValueAt(LinhaSelect, 2);
					// validar se esse DAO ta certo
					CategoriaDAO dao = CategoriaDAO.getInstancia();

					categoriaEditar = dao.buscarCategoriaPorID(valorId);
					txtTitulo.setText(categoriaEditar.getNomeCategoria());
					txtIdioma.setText(categoriaEditar.getIdioma());
					txtQuantPaginas.setText(String.valueOf(categoriaEditar.getQuantPaginas()));
					txtGenero.setText(categoriaEditar.getGenero());

					
					//txtTitulo.setText(livroEditar.getTitulo());
//					txtIdioma.setText(livroEditar.getAutor());
//					txtQuantPaginas.setText(String.valueOf(livroEditar.getIsbn()));
//					txtGenero.setText(String.valueOf(livroEditar.getAnoLancamento()));
//					txtEditora.setText(livroEditar.getEditora());
//					txtNrEdicao.setText(String.valueOf(livroEditar.getNrEdicao()));

					//txtQuantPaginas.setEnabled(false);
				}

			}
		});
		btnAltera.setForeground(new Color(0, 64, 128));
		btnAltera.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAltera.setBorder(UIManager.getBorder("Button.border"));
		btnAltera.setBackground(new Color(255, 255, 255));
		btnAltera.setBounds(615, 50, 160, 38);
		panel_2.add(btnAltera);

		JButton btnSalvaUpdate = new JButton("Salvar Alterações");
		btnSalvaUpdate.setBackground(new Color(255, 255, 255));
		btnSalvaUpdate.setForeground(new Color(0, 0, 160));
		btnSalvaUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSalvaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaDAO dao = CategoriaDAO.getInstancia();


				String titulo = txtTitulo.getText();
				String idioma = txtIdioma.getText();
				String quantPaginas = txtQuantPaginas.getText();
				String genero = txtGenero.getText();
		
				categoriaEditar.setNomeCategoria(titulo);
				categoriaEditar.setIdioma(idioma);
				categoriaEditar.setQuantPaginas(Integer.parseInt(quantPaginas));
				categoriaEditar.setGenero(genero);

				dao.alterarCategoria(categoriaEditar);

				atualiza();
				txtQuantPaginas.setEnabled(true);

			}
		});
		btnSalvaUpdate.setBounds(615, 109, 160, 38);
		btnSalvaUpdate.setBorder(UIManager.getBorder("Button.border"));

		panel_2.add(btnSalvaUpdate);

		JPanel tableCategoria = new JPanel();
		tableCategoria.setBorder(new TitledBorder(null, "Lista de Categorias", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 64, 128)));

		tableCategoria.setBackground(Color.WHITE);
		contentPane.add(tableCategoria, BorderLayout.SOUTH);
		tableCategoria.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableCategoria.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Idioma", "Quant. Páginas", "Gênero" });
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}

	public static void atualiza() {

		CategoriaDAO dao = CategoriaDAO.getInstancia();
		ArrayList<Categoria> categorias = dao.listarCategorias();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < categorias.size(); i++) {
			Categoria categoria = categorias.get(i);
			modelo.addRow(new Object[] { categoria.getNomeCategoria(), categoria.getGenero(), categoria.getIdioma(),
					categoria.getQuantPaginas() });
		}
	}
}
