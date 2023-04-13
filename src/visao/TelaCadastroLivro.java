package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtEditora;
	private JTextField txtEdicao;
	private JTextField txtIsbn;
	private JTextField txtAnoLancamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLivro frame = new TelaCadastroLivro();
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
	public TelaCadastroLivro() {
		setTitle("Cadastro Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 182, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(31, 87, 157, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEditora.setForeground(new Color(255, 255, 255));
		lblEditora.setBounds(31, 137, 157, 14);
		contentPane.add(lblEditora);
		
		JLabel lblNrEdicao = new JLabel("Numero da edição:");
		lblNrEdicao.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNrEdicao.setForeground(new Color(255, 255, 255));
		lblNrEdicao.setBounds(31, 182, 157, 14);
		contentPane.add(lblNrEdicao);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIsbn.setForeground(new Color(255, 255, 255));
		lblIsbn.setBounds(31, 230, 157, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblAnoLancamento = new JLabel("Ano de lançamento :");
		lblAnoLancamento.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAnoLancamento.setForeground(new Color(255, 255, 255));
		lblAnoLancamento.setBounds(31, 277, 157, 14);
		contentPane.add(lblAnoLancamento);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(198, 84, 86, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(198, 134, 86, 20);
		contentPane.add(txtEditora);
		txtEditora.setColumns(10);
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(198, 179, 86, 20);
		contentPane.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(198, 227, 86, 20);
		contentPane.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		txtAnoLancamento = new JTextField();
		txtAnoLancamento.setBounds(198, 274, 86, 20);
		contentPane.add(txtAnoLancamento);
		txtAnoLancamento.setColumns(10);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar");
		btnCadastrarLivro.setForeground(new Color(255, 255, 255));
		btnCadastrarLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrarLivro.setBackground(new Color(64, 128, 128));
		btnCadastrarLivro.setBounds(268, 346, 139, 23);
		contentPane.add(btnCadastrarLivro);
		
		JButton btnListagem = new JButton("Listar Livros");
		btnListagem.setForeground(new Color(255, 255, 255));
		btnListagem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnListagem.setBackground(new Color(64, 128, 128));
		btnListagem.setBounds(445, 346, 139, 23);
		contentPane.add(btnListagem);
	}
}
