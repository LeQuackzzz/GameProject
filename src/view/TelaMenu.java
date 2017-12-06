package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6061702248138255912L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemvindo = new JLabel("Bem Vindo!");
		lblBemvindo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBemvindo.setBounds(164, 11, 108, 44);
		contentPane.add(lblBemvindo);
		
		JLabel lblEscolhaUmaDas = new JLabel("Escolha um dos jogos abaixo: ");
		lblEscolhaUmaDas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscolhaUmaDas.setBounds(119, 62, 272, 21);
		contentPane.add(lblEscolhaUmaDas);
		
		JButton btnAdvinheONmero = new JButton("Advinhe o N\u00FAmero");
		btnAdvinheONmero.setBounds(130, 117, 173, 26);
		contentPane.add(btnAdvinheONmero);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setBounds(207, 154, 46, 14);
		contentPane.add(lblOu);
		
		JButton btnNewButton = new JButton("Encontre a Bolinha");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCopo tc = new TelaCopo();
				tc.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(130, 181, 173, 26);
		contentPane.add(btnNewButton);
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jogo1();
				
			}
			
		};
		
		btnAdvinheONmero.addActionListener(al);
	
	}
	
	public void jogo1() {
		TelaAcerte t1 = new TelaAcerte();
		t1.setVisible(true);
		dispose();
	}

}
