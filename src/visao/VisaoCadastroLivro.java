package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.LivroDAO;
import modelo.Livro;

import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("",
				"[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]",
				"[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]"));

		JLabel lblTitulo = new JLabel("Título:");
		panel_1.add(lblTitulo, "cell 3 1");

		txtTitulo = new JTextField();
		panel_1.add(txtTitulo, "cell 7 1,growx");
		txtTitulo.setColumns(10);

		JLabel lblEditora = new JLabel("Editora:");
		panel_1.add(lblEditora, "cell 3 2");

		txtEditora = new JTextField();
		panel_1.add(txtEditora, "cell 7 2,growx");
		txtEditora.setColumns(10);

		JLabel lblNumEdicao = new JLabel("Número da edição:");
		panel_1.add(lblNumEdicao, "cell 3 3");

		txtNumEdicao = new JTextField();
		panel_1.add(txtNumEdicao, "cell 7 3,growx");
		txtNumEdicao.setColumns(10);

		JLabel lblISBN = new JLabel("ISBN:");
		panel_1.add(lblISBN, "cell 3 4");

		txtISBN = new JTextField();
		panel_1.add(txtISBN, "cell 7 4,growx");
		txtISBN.setColumns(10);

		JLabel lblAno = new JLabel("Ano de lançamento:");
		panel_1.add(lblAno, "cell 3 5");

		txtAno = new JTextField();
		panel_1.add(txtAno, "cell 7 5,growx");
		txtAno.setColumns(10);

		JButton btnCadastro = new JButton("Cadastrar");
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
				atualiza();
			}

		});
		panel_1.add(btnCadastro, "cell 3 6");

		JButton btnListagem = new JButton("Listar");
		btnListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualiza();

			}
		});
		panel_1.add(btnListagem, "cell 7 6");

		JScrollPane scrollPane = new JScrollPane();

		panel_1.add(scrollPane, "cell 3 8 6 8,grow");
		modelo = new DefaultTableModel();
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);
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
