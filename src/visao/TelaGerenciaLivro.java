package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.LivroDAO;
import modelo.Livro;

public class TelaGerenciaLivro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciaLivro frame = new TelaGerenciaLivro();
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
	public TelaGerenciaLivro() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		LivroDAO dao = LivroDAO.getInstancia();
		
		ArrayList<Livro> listaLivros = dao.listarLivros();
		//percorrer a lista dentro do jtable
		
		// jtable.set(

		setContentPane(contentPane);
		
		
	}

}
