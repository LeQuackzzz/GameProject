package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class TelaCopo extends JFrame {
	int dinheiro=10;
	int aposta=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4486421322235722042L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaCopo() {
		int i=1;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("");
		label.setBounds(70, 59, 83, 86);

		ImageIcon img = new ImageIcon(TelaCopo.class.getResource("/img/copos.png"));
		Image imag = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		label.setIcon(new ImageIcon(imag));
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(169, 59, 83, 86);

		ImageIcon img2 = new ImageIcon(TelaCopo.class.getResource("/img/copos.png"));
		Image imag2 = img2.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		label_1.setIcon(new ImageIcon(imag2));
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(272, 59, 83, 86);

		ImageIcon img3 = new ImageIcon(TelaCopo.class.getResource("/img/copos.png"));
		Image imag3 = img3.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);

		label_2.setIcon(new ImageIcon(imag3));

		contentPane.add(label_2);

		JButton btnCopo = new JButton("Copo 1");
		btnCopo.setBounds(70, 156, 83, 23);
		contentPane.add(btnCopo);

		JButton btnCopo_1 = new JButton("Copo 2");
		btnCopo_1.setBounds(169, 156, 83, 23);
		contentPane.add(btnCopo_1);

		JButton btnCopo_2 = new JButton("Copo 3");
		btnCopo_2.setBounds(272, 156, 83, 23);
		contentPane.add(btnCopo_2);

		JLabel lblEmQualCopo = new JLabel("Em qual copo est\u00E1 a bolinha?");
		lblEmQualCopo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmQualCopo.setBounds(115, 11, 205, 23);
		contentPane.add(lblEmQualCopo);

		JLabel lblDInheiro = new JLabel("Seu Dinheiro:  R$");
		lblDInheiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDInheiro.setBounds(10, 234, 110, 14);
		contentPane.add(lblDInheiro);

		JLabel lblT = new JLabel(" ");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblT.setBounds(107, 234, 46, 14);
		contentPane.add(lblT);
		lblT.setText(String.valueOf(dinheiro));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(338, 231, 72, 23);
		contentPane.add(btnVoltar);

		ActionListener alV = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu();
			}
		};
		btnVoltar.addActionListener(alV);

		//botao1
		ActionListener al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dinheiro=verifica(i);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				lblT.setText(String.valueOf(dinheiro));
			}
		};
		btnCopo.addActionListener(al1);

		//botao 2
		ActionListener al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dinheiro=verifica(i+1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				lblT.setText(String.valueOf(dinheiro));
			}
		};
		btnCopo_1.addActionListener(al2);

		//botao 3
		ActionListener al3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dinheiro=verifica(i+2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				lblT.setText(String.valueOf(dinheiro));
			}
		};
		btnCopo_2.addActionListener(al3);

	}

	public int verifica(int i) throws IOException {
		int d = dinheiro;
		int a = aposta;
		Random r = new Random();
		int bolinha = r.nextInt(3)+1;
		
		while(a > d || a < 1) {
			try {
				a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da aposta: "));
			}catch(NumberFormatException e){
				
			}
			if (a > d)
				JOptionPane.showMessageDialog(null, "Você não tem esse dinheiro...", "ERRO", JOptionPane.ERROR_MESSAGE);
			if (a<1)
				JOptionPane.showMessageDialog(null, "Digite apenas números inteiros positivos!");
		}
		if (bolinha == i) {
			JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou R$"+a+"\n\n Os copos serão embaralhados novamente.");
			d = d + a;
			return d;
		} else {
			JOptionPane.showMessageDialog(null, "Você perdeu R$"+a+"\n\n Os copos serão embaralhados novamente.");
			d = d - a;
			if (d<1) {
				TelaDerrota td = new TelaDerrota();
				td.setVisible(true);
				dispose();
			}
			return d;
		}
	}

	public void Menu() {
		TelaMenu tm = new TelaMenu();
		tm.setVisible(true);
		dispose();
	}
}
