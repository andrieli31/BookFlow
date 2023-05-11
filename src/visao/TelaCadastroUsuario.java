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
		telaCadUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCadUsuario.setBackground(new Color(85, 170, 170));
		telaCadUsuario.setForeground(new Color(85, 170, 170));

		setContentPane(telaCadUsuario);
		telaCadUsuario.setLayout(new MigLayout("", "[64px][136px]", "[19px][19px][19px][19px][][19px]"));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblNome, "cell 0 0,alignx left,aligny center");
		
		txtNome = new JTextField();
		telaCadUsuario.add(txtNome, "cell 1 0,growx,aligny top");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setForeground(new Color(255, 255, 255));
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblSobrenome, "cell 0 1,alignx left,aligny center");
		
		txtSobrenome = new JTextField();
		telaCadUsuario.add(txtSobrenome, "cell 1 1,growx,aligny top");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telaCadUsuario.add(lblCpf, "cell 0 2,alignx left,aligny center");
		
		txtCpf = new JTextField();
		telaCadUsuario.add(txtCpf, "cell 1 2,growx,aligny top");
		txtCpf.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setForeground(new Color(255, 255, 255));
		telaCadUsuario.add(lblEmail, "cell 0 3,alignx left,aligny center");
		
		txtEmail = new JTextField();
		telaCadUsuario.add(txtEmail, "cell 1 3,growx,aligny top");
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		telaCadUsuario.add(lblSenha, "cell 0 4,alignx left,aligny center");
		
		txtSenha = new JTextField();
		telaCadUsuario.add(txtSenha, "cell 1 4,growx,aligny top");
		txtSenha.setColumns(10);
	}

}
