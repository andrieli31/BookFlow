package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

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
		setBackground(new Color(64, 128, 128));
		setForeground(new Color(0, 0, 0));
		setTitle("Tela inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[183px][4px][183px]", "[20px][25px][23px]"));
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblEscolherOpcao, "cell 0 0 3 1,alignx center,aligny top");
		
		JButton btnGerenciaLivro = new JButton("Gerenciamento de livros");
		btnGerenciaLivro.setBackground(new Color(255, 255, 255));
		btnGerenciaLivro.setForeground(new Color(64, 128, 128));
		btnGerenciaLivro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnGerenciaLivro, "cell 0 1,alignx left,aligny top");
		
		JButton btnGerenciaUsuario = new JButton("Gerenciamento de livros");
		btnGerenciaUsuario.setBackground(new Color(255, 255, 255));
		btnGerenciaUsuario.setForeground(new Color(64, 128, 128));
		btnGerenciaUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnGerenciaUsuario, "cell 2 1,alignx left,aligny top");
		
		JButton btnSair = new JButton("Finalizar");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setForeground(new Color(128, 128, 128));
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnSair, "cell 0 2 3 1,alignx center,aligny top");
	}

}
