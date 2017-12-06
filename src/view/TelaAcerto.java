package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaAcerto extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1262819907007652582L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaAcerto(int aux, int t) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParabnsVocAcertou = new JLabel("Parab\u00E9ns, voc\u00EA acertou o n\u00FAmero!");
		lblParabnsVocAcertou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblParabnsVocAcertou.setBounds(83, 11, 282, 44);
		contentPane.add(lblParabnsVocAcertou);
		
		JLabel lblNmero = new JLabel("N\u00FAmero: "+aux);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmero.setBounds(175, 73, 110, 31);
		contentPane.add(lblNmero);
		
		JButton btnJogarNovamente = new JButton("Jogar Novamente");
		btnJogarNovamente.setBounds(83, 162, 138, 37);
		contentPane.add(btnJogarNovamente);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBounds(231, 162, 134, 37);
		contentPane.add(btnMenuPrincipal);
		
		JLabel lblTentativas = new JLabel("Tentativas: "+t++);
		lblTentativas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTentativas.setBounds(175, 115, 80, 14);
		contentPane.add(lblTentativas);
		
		ActionListener insert = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Denovo();
				
			}	
		};
		
		ActionListener menu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu();
				
			}	
		};
		
		btnJogarNovamente.addActionListener(insert);
		btnMenuPrincipal.addActionListener(menu);
	
	}
	
	public void Denovo() {
		TelaAcerte t1 = new TelaAcerte();
		t1.setVisible(true);
		dispose();
	}
	
	public void Menu() {
		TelaMenu tm = new TelaMenu();
		tm.setVisible(true);
		dispose();
	}
}
