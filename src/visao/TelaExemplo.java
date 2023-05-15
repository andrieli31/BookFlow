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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.LivroDAO;
import modelo.Livro;
import net.miginfocom.swing.MigLayout;

public class TelaExemplo extends JFrame {

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
	public TelaExemplo() {
		setTitle("Cadastro e listagem de livros");
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
		panel_1.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]"));

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblTitulo, "cell 3 1,alignx center,aligny center");

		txtTitulo = new JTextField();
		panel_1.add(txtTitulo, "cell 6 1 2 1,growx");
		txtTitulo.setColumns(10);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(new Color(255, 255, 255));
		lblEditora.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblEditora, "cell 3 2,alignx center,aligny center");

		txtEditora = new JTextField();
		panel_1.add(txtEditora, "cell 6 2 2 1,growx");
		txtEditora.setColumns(10);

		JLabel lblNumEdicao = new JLabel("Número da edição:");
		lblNumEdicao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEdicao.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNumEdicao, "cell 3 3,alignx center,aligny center");

		txtNumEdicao = new JTextField();
		panel_1.add(txtNumEdicao, "cell 6 3 2 1,growx");
		txtNumEdicao.setColumns(10);

		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setForeground(new Color(255, 255, 255));
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblISBN, "cell 3 4,alignx center,aligny center");

		txtISBN = new JTextField();
		panel_1.add(txtISBN, "cell 6 4 2 1,growx");
		txtISBN.setColumns(10);

		JLabel lblAno = new JLabel("Ano de lançamento:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno.setForeground(new Color(255, 255, 255));
		panel_1.add(lblAno, "cell 3 5,alignx center,aligny center");

		txtAno = new JTextField();
		panel_1.add(txtAno, "cell 6 5 2 1,growx");
		txtAno.setColumns(10);

		JButton btnListagem = new JButton("Listar");
		btnListagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListagem.setForeground(new Color(64, 128, 128));
		btnListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualiza();

			}
		});
		
		JButton btnGerenciaUsuario = new JButton("Gerenciamento de livros");
		btnGerenciaUsuario.setForeground(new Color(64, 128, 128));
		btnGerenciaUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGerenciaUsuario.setBackground(Color.WHITE);
		panel_1.add(btnGerenciaUsuario, "cell 3 6");
		panel_1.add(btnListagem, "cell 6 6 2 1,alignx center,aligny center");
		
		JButton btnSair = new JButton("Finalizar");
		btnSair.setForeground(Color.GRAY);
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSair.setBackground(Color.WHITE);
		panel_1.add(btnSair, "cell 4 7");

		JScrollPane scrollPane = new JScrollPane();

		panel_1.add(scrollPane, "cell 2 8 8 8,grow");
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
