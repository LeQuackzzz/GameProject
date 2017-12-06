package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaDerrota extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public TelaDerrota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVocPerdeuTudo = new JLabel("Voc\u00EA Perdeu Tudo!");
		lblVocPerdeuTudo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVocPerdeuTudo.setBounds(140, 11, 223, 29);
		contentPane.add(lblVocPerdeuTudo);

		JButton btnJogarNovamente = new JButton("Jogar Novamente");
		btnJogarNovamente.setBounds(67, 194, 145, 29);
		contentPane.add(btnJogarNovamente);

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBounds(218, 194, 145, 29);
		contentPane.add(btnMenuPrincipal);
		
		JLabel label = new JLabel("");
		label.setBounds(150, 56, 126, 112);
		ImageIcon img = new ImageIcon(TelaCopo.class.getResource("/img/pobre.png"));
		Image imag = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		label.setIcon(new ImageIcon(imag));
		contentPane.add(label);

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
		TelaCopo tc = new TelaCopo();
		tc.setVisible(true);
		dispose();
	}

	public void Menu() {
		TelaMenu tm = new TelaMenu();
		tm.setVisible(true);
		dispose();
	}


}

