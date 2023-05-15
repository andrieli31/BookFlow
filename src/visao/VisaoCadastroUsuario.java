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
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(99, 43, 35, 16);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(lblNome);
		
		txNome = new JTextField();
		txNome.setBounds(252, 41, 170, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(84, 67, 65, 16);
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setForeground(new Color(255, 255, 255));
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(252, 65, 170, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(105, 91, 23, 16);
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCpf.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(252, 89, 170, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(74, 142, 85, 23);
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setForeground(new Color(64, 128, 128));
		contentPane.add(btnCadastrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(306, 142, 63, 23);
		btnListar.setForeground(new Color(64, 128, 128));
		btnListar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnListar);
		
		table = new JTable();
		table.setBounds(74, 198, 348, 51);
		contentPane.add(table);
	}

}
