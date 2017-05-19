package alogorithms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.security.KeyPair;
import java.security.acl.Group;
import java.awt.event.ActionEvent;

public class CeasarAlgorithm {

	private JFrame frmCeasarAlgorithm;
	private JTextField textField_inputKey;

	/**
	 * Launch the application.
	 */

	public static int chProcess = 0;

	ButtonGroup buttonGroup_process = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CeasarAlgorithm window = new CeasarAlgorithm();
					window.frmCeasarAlgorithm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CeasarAlgorithm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCeasarAlgorithm = new JFrame();
		frmCeasarAlgorithm.setResizable(false);
		frmCeasarAlgorithm.getContentPane().setBackground(Color.GRAY);
		frmCeasarAlgorithm.setTitle("Ceasar Algorithm");
		frmCeasarAlgorithm.setBounds(100, 100, 519, 312);
		frmCeasarAlgorithm.setLocation(250, 150);
		frmCeasarAlgorithm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCeasarAlgorithm.getContentPane().setLayout(null);

		JTextArea textArea_input = new JTextArea();
		textArea_input.setWrapStyleWord(true);
		textArea_input.setLineWrap(true);
		textArea_input.setBounds(10, 70, 235, 126);
		frmCeasarAlgorithm.getContentPane().add(textArea_input);

		JTextArea textArea_output = new JTextArea();
		textArea_output.setWrapStyleWord(true);
		textArea_output.setLineWrap(true);
		textArea_output.setEditable(false);
		textArea_output.setBounds(258, 70, 235, 127);
		frmCeasarAlgorithm.getContentPane().add(textArea_output);

		JButton button_copy = new JButton("Copy");
		button_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textArea_output.getText() != null && textArea_output.getText().trim().length() > 0) {
					String myString = textArea_output.getText();
					StringSelection stringSelection = new StringSelection(myString);
					Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
					clpbrd.setContents(stringSelection, null);
					JOptionPane.showMessageDialog(null, "the String  Copied to your clipboard ");
				}
			}
		});
		button_copy.setBounds(428, 40, 65, 23);
		frmCeasarAlgorithm.getContentPane().add(button_copy);

		JButton button_startProcess = new JButton("Start Process");
		button_startProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_output.setText("");
				int keyValue;

				if (textField_inputKey == null || textField_inputKey.getText().trim().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter Key  ");
				} else if (chProcess == 0) {
					JOptionPane.showMessageDialog(null, "Select your operation encryption or decryption ");
				}

				else if (textArea_input.getText() == null || textArea_input.getText().trim().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter Your  Text  ");
				} else {

					try {
						keyValue = Integer.parseInt(textField_inputKey.getText());
					} catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Enter Valid Key ");
						return ;
					}
					String output = "";
					if(chProcess == 1){
						output = Processes.ceasarEncrypt(textArea_input.getText(), keyValue);
					}else if(chProcess == 2){
						output = Processes.ceaserDecrypt(textArea_input.getText(), keyValue);
					}
					
					textArea_output.setText(output);
				}

			}
		});
		button_startProcess.setForeground(Color.RED);
		button_startProcess.setFont(new Font("Tahoma", Font.ITALIC, 20));
		button_startProcess.setBackground(new Color(0, 128, 128));
		button_startProcess.setBounds(58, 207, 237, 33);
		frmCeasarAlgorithm.getContentPane().add(button_startProcess);

		JLabel lblEnterKey = new JLabel("Enter Key");
		lblEnterKey.setForeground(Color.RED);
		lblEnterKey.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEnterKey.setBackground(Color.BLACK);
		lblEnterKey.setBounds(10, 11, 114, 14);
		frmCeasarAlgorithm.getContentPane().add(lblEnterKey);

		JRadioButton radioButton_encryption = new JRadioButton("Encryption");
		radioButton_encryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chProcess = 1;
			}
		});
		radioButton_encryption.setBounds(152, 40, 100, 23);
		frmCeasarAlgorithm.getContentPane().add(radioButton_encryption);

		JRadioButton radioButton_decryption = new JRadioButton("Decryption");
		radioButton_decryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chProcess = 2;
			}
		});
		radioButton_decryption.setBounds(258, 40, 100, 23);
		frmCeasarAlgorithm.getContentPane().add(radioButton_decryption);

		buttonGroup_process.add(radioButton_encryption);
		buttonGroup_process.add(radioButton_decryption);

		JLabel lblSelect = new JLabel("Select Process");
		lblSelect.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSelect.setForeground(new Color(139, 0, 0));
		lblSelect.setBounds(20, 44, 126, 14);
		frmCeasarAlgorithm.getContentPane().add(lblSelect);

		textField_inputKey = new JTextField();
		textField_inputKey.setBounds(96, 10, 65, 20);
		frmCeasarAlgorithm.getContentPane().add(textField_inputKey);
		textField_inputKey.setColumns(10);

		JLabel label = new JLabel("mohammedsalah12371@gmail.com");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Black", Font.ITALIC, 14));
		label.setBackground(Color.WHITE);
		label.setBounds(243, 251, 260, 15);
		frmCeasarAlgorithm.getContentPane().add(label);
	}
}
