package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroUsuario extends JFrame {

	private JPanel telaCadUsuario;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setTitle("Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		telaCadUsuario = new JPanel();
		telaCadUsuario.setBackground(new Color(85, 170, 170));
		telaCadUsuario.setForeground(new Color(85, 170, 170));
		telaCadUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(telaCadUsuario);
		telaCadUsuario.setLayout(new MigLayout("", "[][][][][grow][][grow][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblNome, "cell 1 1");
		
		txtNome = new JTextField();
		telaCadUsuario.add(txtNome, "cell 4 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setForeground(new Color(255, 255, 255));
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblSobrenome, "cell 1 3");
		
		txtSobrenome = new JTextField();
		telaCadUsuario.add(txtSobrenome, "cell 4 3,growx");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblCpf, "cell 1 5");
		
		txtCpf = new JTextField();
		telaCadUsuario.add(txtCpf, "cell 4 5,growx");
		txtCpf.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setForeground(new Color(255, 255, 255));
		telaCadUsuario.add(lblEmail, "cell 1 7");
		
		txtEmail = new JTextField();
		telaCadUsuario.add(txtEmail, "cell 4 7,growx");
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		telaCadUsuario.add(lblSenha, "cell 1 9");
		
		txtSenha = new JTextField();
		telaCadUsuario.add(txtSenha, "cell 4 9,growx");
		txtSenha.setColumns(10);
	}

}
