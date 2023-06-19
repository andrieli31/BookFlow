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
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.CategoriaDAO;
import controle.LivroDAO;
import modelo.Categoria;
import modelo.Livro;
import javax.swing.border.BevelBorder;

public class VisaoCadastroCategoria extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel modelo;
	private JTextField txtIdioma;
	private JTextField txtQuantPaginas;
	private JTextField txtGenero;
	private JTextField txtEditora;
	private JTable table;
	private JTextField txtNrEdicao;
	private static Categoria categoriaEditar;
	private JTextField txtIdCategoria;

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
		btnVoltaTI.setBackground(new Color(255, 255, 255));
		btnVoltaTI.setForeground(new Color(137, 27, 224));
		btnVoltaTI.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltaTI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VisaoGerenciaLivro().dispose();
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				frame.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}

		});
		panel_1.add(btnVoltaTI);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Dados das categorias", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(137, 27, 224)));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Dados das categorias");
		lblNewLabel_1.setForeground(new Color(137, 27, 224));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 11, 236, 28);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(35, 50, 349, 20);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
				txtGenero = new JTextField();
				txtGenero.setBounds(144, 0, 205, 20);
				panel_3.add(txtGenero);
				txtGenero.setColumns(10);
				
						JLabel lblGenero = new JLabel("Gênero");
						lblGenero.setBounds(0, 0, 124, 18);
						panel_3.add(lblGenero);
						lblGenero.setForeground(Color.BLACK);
						lblGenero.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(35, 81, 349, 20);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lbldioma = new JLabel("Idioma");
		lbldioma.setForeground(Color.BLACK);
		lbldioma.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
		lblquantPaginas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblquantPaginas.setBounds(0, 0, 124, 18);
		panel_5.add(lblquantPaginas);

		txtQuantPaginas = new JTextField();
		txtQuantPaginas.setBounds(144, 0, 205, 20);
		panel_5.add(txtQuantPaginas);
		txtQuantPaginas.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(35, 202, 349, 20);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria();

				CategoriaDAO dao = CategoriaDAO.getInstancia();

				String idioma = txtIdioma.getText();
				String qntPag = txtQuantPaginas.getText();
				String genero = txtGenero.getText();
				String id = txtIdCategoria.getText();

				categoria.setIdioma(idioma);
				categoria.setQuantPaginas(Integer.valueOf(qntPag));
				categoria.setGenero(genero);
				categoria.setIdCategoria(Integer.valueOf(id));

				dao.cadastarCategoria(categoria);

				modelo.addRow(new Object[] { categoria.getGenero(),
						categoria.getQuantPaginas(), categoria.getIdioma(), categoria.getIdCategoria() });

				txtIdioma.setText("");
				txtQuantPaginas.setText("");
				txtGenero.setText("");
				txtIdCategoria.setText("");

			}
		});

		btnCadastro.setForeground(new Color(137, 27, 224));
		btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCadastro.setBorder(new LineBorder(new Color(137, 27, 224)));
		btnCadastro.setBackground(new Color(255, 255, 255));
		btnCadastro.setBounds(439, 112, 160, 38);
		panel_2.add(btnCadastro);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdioma.setText("");
				txtQuantPaginas.setText("");
				txtGenero.setText("");
			}
		});

		btnNewButton.setForeground(new Color(137, 27, 224));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBorder(new LineBorder(new Color(137, 27, 224)));
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
		btnExcluir.setForeground(new Color(247, 9, 68));
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnExcluir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(247, 9, 68), new Color(247, 9, 68), new Color(247, 9, 68), new Color(247, 9, 68)));
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

					int valorId = (int) table.getValueAt(LinhaSelect, 4);
					// validar se esse DAO ta certo
					CategoriaDAO dao = CategoriaDAO.getInstancia();

					categoriaEditar = dao.buscarCategoriaPorID(valorId);
					txtIdioma.setText(categoriaEditar.getIdioma());
					txtQuantPaginas.setText(String.valueOf(categoriaEditar.getQuantPaginas()));
					txtGenero.setText(categoriaEditar.getGenero());
					txtIdCategoria.setText(String.valueOf(categoriaEditar.getIdCategoria()));
					

					txtIdCategoria.setEnabled(false);
				}

			}
		});
		btnAltera.setForeground(new Color(224, 169, 27));
		btnAltera.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAltera.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27)));
		btnAltera.setBackground(new Color(255, 255, 255));
		btnAltera.setBounds(615, 50, 160, 38);
		panel_2.add(btnAltera);

		JButton btnSalvaUpdate = new JButton("Salvar Alterações");
		btnSalvaUpdate.setBackground(new Color(137, 27, 224));
		btnSalvaUpdate.setForeground(new Color(255, 255, 255));
		btnSalvaUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSalvaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaDAO dao = CategoriaDAO.getInstancia();


				String idioma = txtIdioma.getText();
				String quantPaginas = txtQuantPaginas.getText();
				String genero = txtGenero.getText();
				String id = txtIdCategoria.getText();
		
				categoriaEditar.setIdioma(idioma);
				categoriaEditar.setQuantPaginas(Integer.parseInt(quantPaginas));
				categoriaEditar.setGenero(genero);
				categoriaEditar.setIdCategoria(Integer.parseInt(id));

				dao.alterarCategoria(categoriaEditar);
				atualiza();
				txtIdCategoria.setEnabled(true);

			}
		});
		btnSalvaUpdate.setBounds(615, 112, 160, 38);
		btnSalvaUpdate.setBorder(UIManager.getBorder("Button.border"));

		panel_2.add(btnSalvaUpdate);
		
		txtIdCategoria = new JTextField();
		txtIdCategoria.setForeground(Color.BLACK);
		txtIdCategoria.setColumns(10);
		txtIdCategoria.setBounds(179, 143, 205, 20);
		panel_2.add(txtIdCategoria);
		
		JLabel lblIdCategoria = new JLabel("IdCategoria:");
		lblIdCategoria.setForeground(Color.BLACK);
		lblIdCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblIdCategoria.setBounds(35, 143, 124, 18);
		panel_2.add(lblIdCategoria);

		JPanel tableCategoria = new JPanel();
		tableCategoria.setBorder(new TitledBorder(null, "Lista de Categorias", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(137, 27, 224)));
		tableCategoria.setBackground(Color.WHITE);
		contentPane.add(tableCategoria, BorderLayout.SOUTH);
		tableCategoria.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableCategoria.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Gênero", "Idioma", "Quant. Páginas", "Id Categoria" });
		table.setModel(modelo);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(67, 1, 100));
		scrollPane.setViewportView(table);
		table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(Color.LIGHT_GRAY);
	}

	public static void atualiza() {

		CategoriaDAO dao = CategoriaDAO.getInstancia();
		ArrayList<Categoria> categorias = dao.listarCategorias();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < categorias.size(); i++) {
			Categoria categoria = categorias.get(i);
			modelo.addRow(new Object[] {  categoria.getGenero(), categoria.getIdioma(),
					categoria.getQuantPaginas() });
		}
	}
}
