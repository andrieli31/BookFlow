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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VisaoCadastroCategoria extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel modelo;
	private JTextField txtIdioma;
	private JTextField txtGenero;
	private JTextField txtEditora;
	private JTable table;
	private JTextField txtNrEdicao;
	private static Categoria categoriaEditar;
	private JTextField txtIdCategoria;
	private JTextField txtQuantPaginas;

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
		contentPane.setBackground(new Color(56, 0, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel tableCategoria = new JPanel();
		tableCategoria.setBorder(new TitledBorder(null, "Lista de Categorias", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(137, 27, 224)));
		tableCategoria.setBackground(Color.WHITE);
		tableCategoria.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableCategoria.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setForeground(new Color(255, 0, 128));
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
        
        		RoundedButton btnAltera = new RoundedButton(" Alterar");
        		btnAltera.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {

        				int LinhaSelect = table.getSelectedRow();
        				if (LinhaSelect == -1) {
        					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
        				} else {

        					int valorId = (int) table.getValueAt(LinhaSelect, 3);
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
        
        		RoundedButton btnExcluir = new RoundedButton("Excluir ");
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
        
        		RoundedButton btnSalvaUpdate = new RoundedButton("Salvar Alterações");
        		btnSalvaUpdate.setBackground(new Color(128, 0, 255));
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
        		btnSalvaUpdate.setBorder(UIManager.getBorder("Button.border"));
        
        RoundedPanel panel = new RoundedPanel(50, Color.WHITE);
        panel.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(64, 0, 128));
        
        		RoundedButton btnVoltaTI = new RoundedButton("Voltar a Tela Inicial");
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
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnSalvaUpdate, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        						.addComponent(btnAltera, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        						.addComponent(btnExcluir, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        					.addGap(18))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnVoltaTI, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(tableCategoria, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(179)
        					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnAltera, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnSalvaUpdate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(25)
        					.addComponent(btnVoltaTI, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
        				.addComponent(tableCategoria, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        		RoundedButton btnCadastro = new RoundedButton("Cadastrar");
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
        		
        				btnCadastro.setForeground(new Color(255, 255, 255));
        				btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
        				btnCadastro.setBorder(new LineBorder(new Color(137, 27, 224)));
        				btnCadastro.setBackground(new Color(128, 0, 255));
        				
        						RoundedButton btnNewButton = new RoundedButton("Limpar");
        						btnNewButton.addActionListener(new ActionListener() {
        							public void actionPerformed(ActionEvent e) {
        								txtIdioma.setText("");
        								txtQuantPaginas.setText("");
        								txtGenero.setText("");
        							}
        						});
        						
        								btnNewButton.setForeground(new Color(128, 0, 255));
        								btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        								btnNewButton.setBorder(new LineBorder(new Color(137, 27, 224)));
        								btnNewButton.setBackground(new Color(224, 224, 224));
        				
        						JLabel lblGenero = new JLabel("Gênero:");
        						lblGenero.setForeground(Color.BLACK);
        						lblGenero.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        				
        						txtGenero = new JTextField();
        						txtGenero.setColumns(10);
        				
        						JLabel lbldioma = new JLabel("Idioma:");
        						lbldioma.setForeground(Color.BLACK);
        						lbldioma.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        				
        						txtIdioma = new JTextField();
        						txtIdioma.setColumns(10);
        				
        						JLabel lblquantPaginas = new JLabel("Quant. Paginas:");
        						lblquantPaginas.setForeground(Color.BLACK);
        						lblquantPaginas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        				
        				JLabel lblIdCategoria = new JLabel("IdCategoria:");
        				lblIdCategoria.setForeground(Color.BLACK);
        				lblIdCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        				
        				txtIdCategoria = new JTextField();
        				txtIdCategoria.setForeground(Color.BLACK);
        				txtIdCategoria.setColumns(10);
        				
        						JLabel lblNewLabel_1 = new JLabel("Dados das categorias");
        						lblNewLabel_1.setForeground(new Color(137, 27, 224));
        						lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        				
        				txtQuantPaginas = new JTextField();
        				txtQuantPaginas.setColumns(10);
        				GroupLayout gl_panel = new GroupLayout(panel);
        				gl_panel.setHorizontalGroup(
        					gl_panel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel.createSequentialGroup()
        							.addGap(28)
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblIdCategoria, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblquantPaginas, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblGenero, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbldioma, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
        								.addGroup(gl_panel.createSequentialGroup()
        									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
        									.addComponent(txtIdCategoria, Alignment.LEADING)
        									.addComponent(txtQuantPaginas, Alignment.LEADING)
        									.addComponent(txtIdioma, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
        							.addContainerGap())
        				);
        				gl_panel.setVerticalGroup(
        					gl_panel.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_panel.createSequentialGroup()
        							.addGap(40)
        							.addComponent(lblNewLabel_1)
        							.addGap(28)
        							.addComponent(lblGenero, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lbldioma, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtIdioma, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblquantPaginas, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtQuantPaginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblIdCategoria, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtIdCategoria, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        							.addGap(62)
        							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(btnCadastro, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
        							.addGap(68))
        				);
        				panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
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
