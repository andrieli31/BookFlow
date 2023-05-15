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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBackground(new Color(64, 128, 128));
		setForeground(new Color(0, 0, 0));
		setTitle("Tela inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 941, 870);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[183px][4px][183px][][][][][grow]", "[20px][25px][23px][][][][][][][][][][grow]"));
		
		JLabel lblEscolherOpcao = new JLabel("Escolha uma opção:");
		lblEscolherOpcao.setForeground(new Color(255, 255, 255));
		lblEscolherOpcao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblEscolherOpcao, "cell 5 10 2 1,alignx center,aligny top");
		
		JButton btnGerenciaLivro = new JButton("Gerenciamento de livros");
		btnGerenciaLivro.setBackground(new Color(255, 255, 255));
		btnGerenciaLivro.setForeground(new Color(64, 128, 128));
		btnGerenciaLivro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnGerenciaLivro, "cell 5 11,alignx left,aligny top");
		
		JButton btnSair = new JButton("Finalizar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnGerenciaUsuario = new JButton("Gerenciamento de livros");
		btnGerenciaUsuario.setBackground(new Color(255, 255, 255));
		btnGerenciaUsuario.setForeground(new Color(64, 128, 128));
		btnGerenciaUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnGerenciaUsuario, "cell 6 11,alignx left,aligny top");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setForeground(new Color(128, 128, 128));
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnSair, "cell 5 12 2 1,alignx center,aligny top");
	}

}
