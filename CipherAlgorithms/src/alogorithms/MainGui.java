package alogorithms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class MainGui {

	private JFrame frmC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmC.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmC = new JFrame();
		frmC.getContentPane().setBackground(Color.GRAY);
		frmC.setTitle("Caesar and Hill Algorithms");
		frmC.setResizable(false);
		frmC.setBounds(200, 200, 450, 300);
		frmC.setLocation(270, 150);
		frmC.setSize(450, 246);
		frmC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmC.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Kind of Alogrithm  ...");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 25, 424, 40);
		frmC.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Caesar Algorithm");
		btnNewButton.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setForeground(Color.RED);
		
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CeasarAlgorithm.main(null);
			}
		});
		btnNewButton.setBounds(24, 104, 200, 40);
		frmC.getContentPane().add(btnNewButton);
		
		JButton btnHillAlgorithm = new JButton("Hill Algorithm");
		btnHillAlgorithm.setForeground(Color.RED);
		btnHillAlgorithm.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 15));
		btnHillAlgorithm.setBackground(Color.DARK_GRAY);
		btnHillAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HillAlgorithm hillAlgorithm = new HillAlgorithm();
				hillAlgorithm.main(null);
			}
		});
		btnHillAlgorithm.setBounds(234, 104, 200, 40);
		frmC.getContentPane().add(btnHillAlgorithm);
		
		JLabel label = new JLabel("mohammedsalah12371@gmail.com");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Black", Font.ITALIC, 14));
		label.setBackground(Color.WHITE);
		label.setBounds(174, 195, 260, 15);
		frmC.getContentPane().add(label);
	}
}
