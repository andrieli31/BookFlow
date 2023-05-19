package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class VisaoCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
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
		setTitle("Cadastro Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 1144);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Dados dos Usuários");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_2 = new JLabel("Sobrenome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));

		JButton btnNewButton = new JButton("Cadastrar Usuário");
		btnNewButton.setForeground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_1 = new JButton("Listar Usuários");
		btnNewButton_1.setForeground(new Color(0, 64, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		table = new JTable();

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 64, 128));

		JLabel lblNewLabel_4 = new JLabel("Selecione um Usuário");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_2 = new JButton("Excluir Usuário");
		btnNewButton_2.setForeground(new Color(0, 64, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnAlteraUser = new JButton("Alterar Usuário");
		btnAlteraUser.setForeground(new Color(0, 64, 128));
		btnAlteraUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PopUpAlteraUsuario frame = new PopUpAlteraUsuario();
				frame.setVisible(true);
				dispose();
			}
			
		});
		btnAlteraUser.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_4 = new JButton("Voltar a Tela Inicial");
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				 frame.setVisible(true);
				 dispose();
			}

		});
		btnNewButton_4.setForeground(new Color(0, 64, 128));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel("email:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		passwordField = new JPasswordField();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(62)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane
										.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 218,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane
														.createSequentialGroup().addComponent(btnNewButton_2)
														.addContainerGap())
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_3, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
														.addGroup(Alignment.TRAILING, gl_contentPane
																.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(btnNewButton)
																				.addPreferredGap(
																						ComponentPlacement.RELATED, 52,
																						Short.MAX_VALUE)
																				.addComponent(
																						btnNewButton_1,
																						GroupLayout.PREFERRED_SIZE, 141,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPane
																				.createSequentialGroup()
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(gl_contentPane
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										lblNewLabel_1,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										lblNewLabel_2,
																										Alignment.TRAILING,
																										GroupLayout.DEFAULT_SIZE,
																										122,
																										Short.MAX_VALUE))
																						.addComponent(lblNewLabel_6)
																						.addComponent(lblNewLabel_5))
																				.addGap(18)
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(textField_1,
																								GroupLayout.DEFAULT_SIZE,
																								194, Short.MAX_VALUE)
																						.addComponent(
																								textField,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								194, Short.MAX_VALUE)
																						.addComponent(
																								textField_2,
																								GroupLayout.DEFAULT_SIZE,
																								194, Short.MAX_VALUE)
																						.addComponent(
																								textField_3,
																								GroupLayout.DEFAULT_SIZE,
																								194, Short.MAX_VALUE)
																						.addComponent(passwordField,
																								GroupLayout.DEFAULT_SIZE,
																								194, Short.MAX_VALUE)))
																		.addComponent(btnAlteraUser,
																				GroupLayout.PREFERRED_SIZE, 139,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(197))
														.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 111,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 279,
																GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(table, GroupLayout.PREFERRED_SIZE, 531,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(btnNewButton_4,
																		GroupLayout.PREFERRED_SIZE, 198,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(163))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(93).addComponent(lblNewLabel).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1).addGap(24)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_2)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(21)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_3).addComponent(textField_2,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGap(24)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5))
								.addGap(25)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6))
								.addGap(48)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton).addComponent(btnNewButton_1))
								.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_2).addComponent(btnAlteraUser))
								.addGap(75)))
				.addGap(39).addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(316, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
