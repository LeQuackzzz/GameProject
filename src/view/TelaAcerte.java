package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAcerte extends JFrame {
	int tentativa=0;
	int maior = 0, menor = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnOk;

	/**
	 * Create the frame.
	 */
	public TelaAcerte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscolhaUmValor = new JLabel("Escolha um valor entre 1 e 1000: ");
		lblEscolhaUmValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscolhaUmValor.setBounds(82, 11, 236, 48);
		contentPane.add(lblEscolhaUmValor);

		textField = new JTextField();
		textField.setBounds(114, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnOk = new JButton("Ok");
		btnOk.setBounds(205, 76, 68, 23);
		contentPane.add(btnOk);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(166, 164, 68, 23);
		contentPane.add(btnVoltar);

		JLabel lblTentativas = new JLabel("Tentativas:");
		lblTentativas.setBounds(10, 191, 73, 14);
		contentPane.add(lblTentativas);

		JLabel label = new JLabel("");
		label.setBounds(75, 191, 46, 14);
		contentPane.add(label);

		JLabel lblMenorQue = new JLabel("Menor Que:");
		lblMenorQue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMenorQue.setBounds(57, 135, 76, 14);
		contentPane.add(lblMenorQue);

		JLabel lblMaiorQue = new JLabel("Maior Que:");
		lblMaiorQue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaiorQue.setBounds(57, 110, 64, 14);
		contentPane.add(lblMaiorQue);

		JLabel lblmaior = new JLabel("");
		lblmaior.setBounds(124, 110, 46, 14);
		contentPane.add(lblmaior);

		JLabel lblmenor = new JLabel("");
		lblmenor.setBounds(124, 135, 46, 14);
		contentPane.add(lblmenor);
		Random r = new Random();
		int aux = r.nextInt(1000)+1;


		ActionListener insert = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				confere(aux);
				tentativa++;
				label.setText(String.valueOf(tentativa));
				lblmaior.setText(String.valueOf(menor));
				lblmenor.setText(String.valueOf(maior));
			}

		};

		ActionListener v = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}

		};

		btnOk.addActionListener(insert);
		textField.addActionListener(insert);
		btnVoltar.addActionListener(v);



	}

	public void voltar() {
		TelaMenu tm = new TelaMenu();
		tm.setVisible(true);
		dispose();
	}

	public void confere(int aux) {
		if (!textField.getText().isEmpty()) {
			int num = Integer.parseInt(textField.getText());
			if(num > 0 && num < 1001) {
				if (num == aux) {
					TelaAcerto ta = new TelaAcerto(aux, tentativa);
					ta.setVisible(true);
					dispose();
				} else {
					if (num < aux) {
						if (num > menor) {
							menor = num;
						} else {
							
						}
					}else {
						maior = num;
					}
					textField.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Digite um Numero Válido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Digite um Numero!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
		}
	}
}
