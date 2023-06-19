package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class VisaoTelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoTelaInicial frame = new VisaoTelaInicial();
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
	public VisaoTelaInicial() {
		setBackground(new Color(0, 64, 128));
		setForeground(new Color(0, 0, 0));
		setTitle("TELA INICIAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1576, 1455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 1, 108));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(357, 380, 256, 256);
		lblNewLabel_1.setIcon(new ImageIcon("img/user-interface.png"));

		JButton btnNewButton = new JButton("Gerenciar Usuários");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
				frame.setVisible(true);
				frame.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}

		});
		btnNewButton.setBounds(357, 679, 256, 29);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 64, 128));

		JLabel lblNewLabel_2 = new JLabel("Bem-Vindo ao BookFlow!");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(73, 66, 675, 65);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(801, 380, 256, 256);
		lblNewLabel.setIcon(new ImageIcon("img/livro.png"));
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Gerenciar Livros");
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoGerenciaLivro frame = new VisaoGerenciaLivro();
				 frame.setVisible(true);
				 frame.setExtendedState(MAXIMIZED_BOTH);
				 dispose();
				
			}
			
		});
		btnNewButton_1.setBounds(801, 679, 256, 29);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(0, 64, 128));
		contentPane.add(btnNewButton_1);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Gerenciar Categoria");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 64, 128));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_2.setBounds(1246, 679, 256, 29);
		contentPane.add(btnNewButton_2);
	}
}
