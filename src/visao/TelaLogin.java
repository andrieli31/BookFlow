package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setBackground(new Color(64, 128, 128));
		setResizable(false);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 452, 205);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new MigLayout("", "[][128px][grow][]", "[36px][][][][][]"));

		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1, "cell 1 0,grow");
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblUsuario, "cell 1 1,alignx center,aligny center");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(txtUsuario, "cell 2 1,growx,aligny center");
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblSenha, "cell 1 3,alignx center,aligny center");
		
		txtSenha = new JTextField();
		contentPane.add(txtSenha, "cell 2 3,growx,aligny center");
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setForeground(new Color(64, 128, 128));
		contentPane.add(btnCadastrar, "cell 1 5,alignx center,aligny center");
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setForeground(new Color(64, 128, 128));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLogin.setBackground(new Color(255, 255, 255));
		contentPane.add(btnLogin, "cell 2 5,alignx center,aligny center");
	}
}
