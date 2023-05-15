package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

public class VisaoCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
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
	public VisaoCadastroUsuario() {
		setTitle("Cadastro e listagem de usuários");
		setBackground(new Color(64, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][grow]", "[][][][][][][][][grow]"));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(lblNome, "cell 2 1,alignx center,aligny center");
		
		txNome = new JTextField();
		contentPane.add(txNome, "cell 4 1 2 1,growx");
		txNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setForeground(new Color(255, 255, 255));
		contentPane.add(lblSobrenome, "cell 2 2,alignx center,aligny center");
		
		txtSobrenome = new JTextField();
		contentPane.add(txtSobrenome, "cell 4 2 2 1,growx");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCpf.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCpf, "cell 2 3,alignx center,aligny center");
		
		txtCpf = new JTextField();
		contentPane.add(txtCpf, "cell 4 3 2 1,growx");
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setForeground(new Color(64, 128, 128));
		contentPane.add(btnCadastrar, "cell 2 5,alignx center,aligny center");
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(64, 128, 128));
		btnListar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnListar, "cell 4 5 2 1,alignx center,aligny center");
		
		table = new JTable();
		contentPane.add(table, "cell 2 7 4 2,grow");
	}

}
