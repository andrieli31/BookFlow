package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import modelo.Autor;
import modelo.Livro;
import javax.swing.SwingConstants;

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
		panel_2.setBorder(new TitledBorder(null, "Dados dos Livros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 64, 128)));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Dados dos Livros");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 11, 236, 28);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(35, 50, 349, 20);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTitulo.setBounds(0, 0, 124, 18);
		panel_3.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(144, 0, 205, 20);
		panel_3.add(txtTitulo);
		txtTitulo.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(35, 81, 349, 20);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblAutor.setBounds(0, 0, 124, 18);
		panel_4.add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(144, 0, 205, 20);
		panel_4.add(txtAutor);
		txtAutor.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(35, 112, 349, 20);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ISBN");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setBounds(0, 0, 124, 18);
		panel_5.add(lblNewLabel_2);

		txtIsbn = new JTextField();
		txtIsbn.setBounds(144, 0, 205, 20);
		panel_5.add(txtIsbn);
		txtIsbn.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(35, 143, 349, 20);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setForeground(Color.BLACK);
		lblAno.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblAno.setBounds(0, 0, 124, 18);
		panel_6.add(lblAno);

		txtAno = new JTextField();
		txtAno.setBounds(144, 0, 205, 20);
		panel_6.add(txtAno);
		txtAno.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(35, 174, 349, 20);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(Color.BLACK);
		lblEditora.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEditora.setBounds(0, 0, 124, 18);
		panel_7.add(lblEditora);

		txtEditora = new JTextField();
		txtEditora.setBounds(144, 0, 205, 20);
		panel_7.add(txtEditora);
		txtEditora.setColumns(10);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Livro livro = new Livro();
				
				LivroDAO dao = LivroDAO.getInstancia();
				
				String titulo = txtTitulo.getText();
				String editora = txtEditora.getText();
				int numeroEdicao = Integer.parseInt(txtNrEdicao.getText());
				int anoLancamento = Integer.parseInt(txtAno.getText());
				Long isbn = Long.parseLong(txtIsbn.getText());
				

				livro.setAnoLancamento(anoLancamento);
				livro.setEditora(editora);
				livro.setIsbn(isbn);
				livro.setNrEdicao(numeroEdicao);
				livro.setTitulo(titulo);

		        dao.cadastrarLivro(livro);

		        modelo.addRow(new Object[] { livro.getTitulo(), livro.getAutores(), livro.getIsbn(), livro.getNrEdicao(), livro.getEditora(), livro.getAnoLancamento() });

		        txtTitulo.setText("");
		        txtAutor.setText("");
		        txtIsbn.setText("");
		        txtAno.setText("");
		        txtEditora.setText("");
		        txtNrEdicao.setText("");
		    }
		});

		btnCadastro.setForeground(Color.WHITE);
		btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCadastro.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnCadastro.setBackground(new Color(0, 64, 128));
		btnCadastro.setBounds(94, 251, 103, 23);
		panel_2.add(btnCadastro);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText("");
				txtAutor.setText("");
				txtIsbn.setText("");
				txtAno.setText("");
				txtEditora.setText("");
			}
		});
		
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setBounds(207, 251, 103, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNrEdicao = new JLabel("Número Edição:");
		lblNrEdicao.setForeground(Color.BLACK);
		lblNrEdicao.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNrEdicao.setBounds(35, 203, 124, 18);
		panel_2.add(lblNrEdicao);
		
		txtNrEdicao = new JTextField();
		txtNrEdicao.setColumns(10);
		txtNrEdicao.setBounds(179, 204, 205, 20);
		panel_2.add(txtNrEdicao);
		
		JButton btnExcluir = new JButton("Excluir ");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int LinhaSelect = table.getSelectedRow();
				if (LinhaSelect == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
				}else {
					DefaultTableModel tabelaLivro = 
							(DefaultTableModel)table.getModel();
					tabelaLivro.removeRow(LinhaSelect);
					
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnExcluir.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(471, 50, 103, 23);
		panel_2.add(btnExcluir);
		
		JButton btnAltera = new JButton(" Alterar ");
		btnAltera.setHorizontalAlignment(SwingConstants.LEADING);
		btnAltera.setForeground(Color.WHITE);
		btnAltera.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAltera.setBorder(new LineBorder(new Color(0, 64, 128)));
		btnAltera.setBackground(new Color(0, 64, 128));
		btnAltera.setBounds(471, 96, 103, 23);
		panel_2.add(btnAltera);

		JPanel tableLivro = new JPanel();
		tableLivro.setBorder(new TitledBorder(null, "Lista de Livros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 64, 128)));
		tableLivro.setBackground(Color.WHITE);
		contentPane.add(tableLivro, BorderLayout.SOUTH);
		tableLivro.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tableLivro.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		modelo = new DefaultTableModel(
			new Object[][] {},
			new String[] { "Título", "Autor", "ISBN", "Número da edição", "Editora", "Ano lançamento" }
		);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}
}
