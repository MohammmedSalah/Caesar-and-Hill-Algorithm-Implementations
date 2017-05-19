package alogorithms;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;

public class HillAlgorithm {

	private JFrame frmHillAlogorithm;

	/**
	 * Launch the application.
	 */
	public static int chKey = 0;
	public static int chProcess = 0;
	ButtonGroup buttonGroup_process = new ButtonGroup();
	JTextArea textArea_input = new JTextArea();
	JTextArea textArea_output = new JTextArea();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HillAlgorithm window = new HillAlgorithm();
					window.frmHillAlogorithm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HillAlgorithm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHillAlogorithm = new JFrame();
		frmHillAlogorithm.setResizable(false);
		frmHillAlogorithm.setTitle("Hill Alogorithm");
		frmHillAlogorithm.getContentPane().setBackground(Color.GRAY);
		frmHillAlogorithm.setBounds(100, 100, 536, 371);
		frmHillAlogorithm.setLocation(250, 150);
		frmHillAlogorithm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHillAlogorithm.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 37, 510, 268);
		frmHillAlogorithm.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		JLabel lblSelectProcess = new JLabel("Select Process ");
		lblSelectProcess.setForeground(new Color(139, 0, 0));
		lblSelectProcess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSelectProcess.setBounds(10, 11, 113, 14);
		panel.add(lblSelectProcess);

		JRadioButton encryptRadioButton = new JRadioButton("Encryption");
		encryptRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				chProcess = 1;
			}
		});
		encryptRadioButton.setBounds(129, 7, 109, 23);
		panel.add(encryptRadioButton);

		JRadioButton decrypRadioButton = new JRadioButton("Decryption");
		decrypRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chProcess = 2;
			}
		});
		decrypRadioButton.setBounds(249, 7, 109, 23);
		panel.add(decrypRadioButton);

		
		buttonGroup_process.add(encryptRadioButton);
		buttonGroup_process.add(decrypRadioButton);

		JLabel lblEnterTextHer = new JLabel("enter text here");
		lblEnterTextHer.setForeground(new Color(139, 0, 0));
		lblEnterTextHer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEnterTextHer.setBounds(10, 51, 127, 14);
		panel.add(lblEnterTextHer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 237, 128);
		panel.add(scrollPane);

		
		scrollPane.setViewportView(textArea_input);
		textArea_input.setLineWrap(true);
		textArea_input.setWrapStyleWord(true);

		
		textArea_output.setEditable(false);
		textArea_output.setWrapStyleWord(true);
		textArea_output.setLineWrap(true);
		textArea_output.setBounds(255, 77, 235, 127);
		panel.add(textArea_output);

		JButton btnStartProcess = new JButton("Start Process");
		btnStartProcess.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnStartProcess.setBackground(new Color(0, 128, 128));
		btnStartProcess.setForeground(Color.RED);
		try {
			btnStartProcess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea_output.setText("");
				
					if (chProcess == 0) {
						JOptionPane.showMessageDialog(null, "Select your operation encryption or decryption ");
					}
					else if (textArea_input.getText() == null || textArea_input.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Enter Your  Text  ");
					}
					else {
						String output = "";

						if (chKey == 1) {
							if (chProcess == 1)
								output = Processes.encryptProcess_2_2(textArea_input.getText());
							else if (chProcess == 2) {
								output = Processes.decrypt_2_2(textArea_input.getText());
								for(int i=0 ; i<2 ; i++){
									if(output.charAt(output.length()-1) == '~')
										output = output.substring(0, output.length()-1);
								}
							}
						}

						else if (chKey == 2) {
							if (chProcess == 1)
								output = Processes.encryptProcess_3x3(textArea_input.getText());
							else if (chProcess == 2) {
								output = Processes.decrypt_3_3(textArea_input.getText());
								for(int i=0 ; i<2 ; i++){
									if(output.charAt(output.length()-1) == '~')
										output = output.substring(0, output.length()-1);
								}
							}
						}
						
						
						
						textArea_output.setText(output);
					}

				}
			});

		} catch (IndexOutOfBoundsException ee) {
			ee.printStackTrace();
			textArea_output.setText("error occured !!! " + ee);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			textArea_output.setText("error occured !!! " + e1);
		}
		btnStartProcess.setBounds(121, 215, 237, 42);
		panel.add(btnStartProcess);

		JLabel lblOutputText = new JLabel("output text");
		lblOutputText.setForeground(new Color(139, 0, 0));
		lblOutputText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOutputText.setBounds(255, 51, 103, 14);
		panel.add(lblOutputText);

		JButton btnCopy = new JButton("Copy");
		btnCopy.setForeground(new Color(139, 0, 0));
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea_output.getText() != null && textArea_output.getText().trim().length() > 0) {
					String myString = textArea_output.getText();
					StringSelection stringSelection = new StringSelection(myString);
					Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
					clpbrd.setContents(stringSelection, null);
					JOptionPane.showMessageDialog(null, "the String  Copied to your clipboard ");
				}

			}
		});
		btnCopy.setBounds(401, 47, 89, 23);
		panel.add(btnCopy);

		// JScrollPane jscrollPane = new JScrollPane(textArea);
		// jscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JRadioButton _2x2_RadioButton = new JRadioButton("2*2");
		_2x2_RadioButton.setBackground(Color.WHITE);
		_2x2_RadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetupt();
				panel.setVisible(true);
				chKey = 1;
				
			}
		});
		_2x2_RadioButton.setBounds(124, 7, 109, 23);
		frmHillAlogorithm.getContentPane().add(_2x2_RadioButton);

		JRadioButton _3x3_RadioButton = new JRadioButton("3*3");
		_3x3_RadioButton.setBackground(Color.WHITE);
		_3x3_RadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetupt();
				panel.setVisible(true);
				chKey = 2;
			}
		});
		_3x3_RadioButton.setBounds(238, 7, 109, 23);
		frmHillAlogorithm.getContentPane().add(_3x3_RadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(_2x2_RadioButton);
		buttonGroup.add(_3x3_RadioButton);

		JLabel lblNewLabel = new JLabel("Select Key");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(25, 11, 114, 14);
		frmHillAlogorithm.getContentPane().add(lblNewLabel);
		
		JLabel lblMohammedsalahgmailcom = new JLabel("mohammedsalah12371@gmail.com");
		lblMohammedsalahgmailcom.setBackground(Color.WHITE);
		lblMohammedsalahgmailcom.setHorizontalAlignment(SwingConstants.CENTER);
		lblMohammedsalahgmailcom.setForeground(Color.RED);
		lblMohammedsalahgmailcom.setFont(new Font("Segoe UI Black", Font.ITALIC, 14));
		lblMohammedsalahgmailcom.setBounds(260, 316, 260, 15);
		frmHillAlogorithm.getContentPane().add(lblMohammedsalahgmailcom);
		
		JButton btnChangeKey = new JButton("Change Key");
		btnChangeKey.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		btnChangeKey.setBackground(new Color(255, 0, 0));
		btnChangeKey.setBounds(421, 3, 109, 30);
		frmHillAlogorithm.getContentPane().add(btnChangeKey);

	}
	public void resetupt(){
		buttonGroup_process.clearSelection();
		textArea_input.setText("");
		textArea_output.setText("");
	}
}
