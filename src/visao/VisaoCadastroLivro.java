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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VisaoCadastroLivro extends JFrame {

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
					VisaoCadastroLivro frame = new VisaoCadastroLivro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisaoCadastroLivro() {
		setTitle("Cadastro e listagem de livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
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

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.setForeground(new Color(64, 128, 128));
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

		JButton btnListagem = new JButton("Listar");
		btnListagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListagem.setForeground(new Color(64, 128, 128));
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(177)
							.addComponent(lblTitulo)
							.addGap(155)
							.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(173)
							.addComponent(lblEditora)
							.addGap(150)
							.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(138)
							.addComponent(lblNumEdicao)
							.addGap(115)
							.addComponent(txtNumEdicao, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(180)
							.addComponent(lblISBN)
							.addGap(158)
							.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(134)
							.addComponent(lblAno)
							.addGap(111)
							.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(153)
							.addComponent(btnCadastro)
							.addGap(158)
							.addComponent(btnListagem))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(69)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(899, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTitulo))
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEditora))
						.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNumEdicao))
						.addComponent(txtNumEdicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblISBN))
						.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblAno))
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastro)
						.addComponent(btnListagem))
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
		);
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
