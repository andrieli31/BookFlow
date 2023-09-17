package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
import java.awt.event.ActionEvent;

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
		contentPane.setBackground(new Color(67, 1, 108));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 25, 412, 63);
		panel_1.setForeground(new Color(0, 64, 128));
		panel_1.setBackground(new Color(67, 1, 108));
		contentPane.add(panel_1);

		RoundedButton btnVoltaTI = new RoundedButton("Voltar a Tela Inicial");
		btnVoltaTI.setBounds(23, 11, 147, 36);
		btnVoltaTI.setBackground(new Color(255, 255, 255));
		btnVoltaTI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial telaInicial = new VisaoTelaInicial();
				telaInicial.setVisible(true);
				telaInicial.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnVoltaTI.setForeground(new Color(137, 27, 224));
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
		panel_1.setLayout(null);
		panel_1.add(btnVoltaTI);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 90, 741, 699);
		panel_2.setForeground(new Color(137, 27, 224));
		panel_2.setBackground(new Color(67, 1, 108));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		RoundedPanel panelCadastro = new RoundedPanel(100, Color.WHITE);
		panelCadastro.setBounds(10, 21, 470, 534);
		panelCadastro.setBackground(new Color(67, 1, 108));
		panel_2.add(panelCadastro);
		panelCadastro.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(14, 114, 440, 50);
		panelCadastro.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitulo.setBounds(0, 0, 62, 18);
		panel_3.add(lblTitulo);
		
				txtTitulo = new JTextField();
				txtTitulo.setBounds(0, 23, 440, 27);
				panel_3.add(txtTitulo);
				txtTitulo.setForeground(new Color(0, 0, 0));
				txtTitulo.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(14, 174, 440, 46);
		panelCadastro.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAutor.setBounds(0, 0, 124, 18);
		panel_4.add(lblAutor);
		
				txtAutor = new JTextField();
				txtAutor.setBounds(0, 20, 440, 26);
				panel_4.add(txtAutor);
				txtAutor.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(239, 351, 215, 55);
		panelCadastro.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ISBN:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(0, 0, 29, 18);
		panel_5.add(lblNewLabel_2);
		
				txtIsbn = new JTextField();
				txtIsbn.setBounds(0, 28, 215, 27);
				panel_5.add(txtIsbn);
				txtIsbn.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(14, 290, 440, 44);
		panelCadastro.add(panel_6);
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(null);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setForeground(Color.BLACK);
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAno.setBounds(0, 0, 29, 18);
		panel_6.add(lblAno);
		
				txtAno = new JTextField();
				txtAno.setBounds(0, 21, 440, 23);
				panel_6.add(txtAno);
				txtAno.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(14, 230, 440, 50);
		panelCadastro.add(panel_7);
		panel_7.setBackground(Color.WHITE);
		panel_7.setLayout(null);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(Color.BLACK);
		lblEditora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEditora.setBounds(0, 0, 124, 18);
		panel_7.add(lblEditora);
		
				txtEditora = new JTextField();
				txtEditora.setBounds(0, 24, 440, 26);
				panel_7.add(txtEditora);
				txtEditora.setColumns(10);

		RoundedButton btnCadastro = new RoundedButton("Cadastrar");
		btnCadastro.setBounds(253, 441, 201, 38);
		panelCadastro.add(btnCadastro);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();

				LivroDAO dao = new LivroDAO();

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

				dao.inserir(livro);

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

		RoundedButton btnLimpar = new RoundedButton("Limpar");
		btnLimpar.setBounds(10, 441, 205, 38);
		panelCadastro.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText("");
				txtAutor.setText("");
				txtIsbn.setText("");
				txtAno.setText("");
				txtEditora.setText("");
				txtNrEdicao.setText("");
			}
		});

		btnLimpar.setForeground(new Color(137, 27, 224));
		btnLimpar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLimpar.setBorder(new LineBorder(new Color(137, 27, 224)));
		btnLimpar.setBackground(new Color(240, 240, 240));
				
				JPanel panel_8 = new JPanel();
				panel_8.setForeground(new Color(255, 255, 255));
				panel_8.setBackground(new Color(255, 255, 255));
				panel_8.setBounds(14, 351, 201, 55);
				panelCadastro.add(panel_8);
				panel_8.setLayout(null);
				
						JLabel lblNrEdicao = new JLabel("Número Edição:");
						lblNrEdicao.setBounds(0, 0, 103, 18);
						panel_8.add(lblNrEdicao);
						lblNrEdicao.setForeground(Color.BLACK);
						lblNrEdicao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
				txtNrEdicao = new JTextField();
				txtNrEdicao.setBounds(0, 28, 201, 27);
				panel_8.add(txtNrEdicao);
				txtNrEdicao.setColumns(10);
				
						JLabel lblNewLabel_1 = new JLabel("Dados Livros");
						lblNewLabel_1.setBackground(new Color(67, 1, 108));
						lblNewLabel_1.setBounds(21, 44, 236, 28);
						panelCadastro.add(lblNewLabel_1);
						lblNewLabel_1.setForeground(new Color(67, 1, 108));
						lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 30));

		RoundedButton btnExcluir = new RoundedButton("Excluir ");
		btnExcluir.setBounds(508, 44, 207, 38);
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
		btnExcluir.setBackground(new Color(240, 240, 240));
		panel_2.add(btnExcluir);

		RoundedButton btnAltera = new RoundedButton(" Alterar");
		btnAltera.setBounds(508, 101, 207, 38);
		btnAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				} else {
					long valorIsbn = (long) table.getValueAt(LinhaSelect, 2);
					LivroDAO dao = new LivroDAO();

					livroEditar = dao.buscarLivroPorIsbn(valorIsbn);
					
					if(livroEditar != null) {
					txtTitulo.setText(livroEditar.getTitulo());
					txtAutor.setText(livroEditar.getAutor());
					txtIsbn.setText(String.valueOf(livroEditar.getIsbn()));
					txtAno.setText(String.valueOf(livroEditar.getAnoLancamento()));
					txtEditora.setText(livroEditar.getEditora());
					txtNrEdicao.setText(String.valueOf(livroEditar.getNrEdicao()));

					txtIsbn.setEnabled(false);
					}else {
				        JOptionPane.showMessageDialog(null, "Livro não encontrado para o ISBN selecionado");

					}
				}

			}
		});
		btnAltera.setForeground(new Color(224, 169, 27));
		btnAltera.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAltera.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27), new Color(224, 169, 27)));
		btnAltera.setBackground(new Color(240, 240, 240));
		panel_2.add(btnAltera);

		RoundedButton btnSalvaUpdate = new RoundedButton("Salvar Alterações");
		btnSalvaUpdate.setBounds(508, 160, 207, 38);
		btnSalvaUpdate.setBackground(new Color(137, 27, 224));
		btnSalvaUpdate.setForeground(new Color(255, 255, 255));
		btnSalvaUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSalvaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO dao = new LivroDAO();

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
				
				dao.atualizar(livroEditar);
				atualiza();
				txtIsbn.setEnabled(true);

			}
		});
		btnSalvaUpdate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(137, 27, 224), new Color(137, 27, 224), new Color(137, 27, 224), new Color(137, 27, 224)));

		panel_2.add(btnSalvaUpdate);

		JPanel tableLivro = new JPanel();
		tableLivro.setBounds(761, 10, 769, 825);
		tableLivro.setBackground(new Color(67, 1, 108));
		contentPane.add(tableLivro);
		tableLivro.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableLivro.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Título", "Autor", "ISBN", "Número da edição", "Editora", "Ano lançamento" });
		table.setModel(modelo);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(67, 1, 100));
		scrollPane.setViewportView(table);
		table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(Color.LIGHT_GRAY);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
        
            
	}

	public static void atualiza() {

		LivroDAO dao = new LivroDAO();
		ArrayList<Livro> livros = dao.listar();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			modelo.addRow(new Object[] { livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getNrEdicao(),
					livro.getEditora(), livro.getAnoLancamento() });
		}
	}
}
