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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtSenha;
	private JTextField txtNome;
	private JTextField textField;

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
		setBackground(new Color(189, 183, 107));
		setResizable(false);
		setTitle("Cadastro de Clientes - Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 205);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(230, 51, 86, 20);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblSenha.setBounds(230, 84, 70, 15);
		contentPane.add(lblSenha);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Ubuntu", Font.BOLD, 14));
		txtNome.setForeground(SystemColor.desktop);
		txtNome.setBounds(312, 52, 114, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			// Programa evento ao pressionar tecla determinada;
		
		});
		txtSenha.setBounds(312, 83, 114, 19);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			
		});
		btnEntrar.setForeground(new Color(0, 128, 0));
		btnEntrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEntrar.requestFocus();
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnEntrar.setBounds(312, 121, 95, 25);
		contentPane.add(btnEntrar);

		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(LoginCadastro.class.getResource("/img/KeyChainAccess_37052.png")));
		lblNewLabel_1.setBounds(47, 27, 128, 119);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(312, 53, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(310, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
