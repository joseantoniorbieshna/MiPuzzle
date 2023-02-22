package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MyButton;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UI extends JFrame {
	private MyButton botones[][] = new MyButton[3][3];

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 414, 206);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("PUZZLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 22);
		contentPane.add(lblNewLabel);
		
		//BOTONES
		for(int y=0;y<botones.length;y++) {
			for(int x=0;x<botones[0].length;x++) {
				botones[y][x] = new MyButton(y,x);
				panel.add(botones[y][x]);
				
			}
		}
	}

	public MyButton[][] getBotones() {
		return botones;
	}
	
}
