package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ClientGui {

	private JFrame frame;
	private JTextField address;
	private JTextField site;
	private JTextField interval;
	private JTextField time;
	private JButton btnSave;
	private JTextField saveDest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGui window = new ClientGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextArea StatusArea;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnClr;

	/**
	 * Create the application.
	 */
	public ClientGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		Dimension d = new Dimension();
		d.setSize(400, 160);
		frame.setMinimumSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 0;
		frame.getContentPane().add(panel2, gbc_panel2);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[]{80, 0, 80, 0};
		gbl_panel2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel2.setLayout(gbl_panel2);
		
		address = new JTextField();
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setColumns(2);
		address.setEditable(false);
		address.setText("Address:");
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.anchor = GridBagConstraints.SOUTH;
		gbc_address.gridx = 0;
		gbc_address.gridy = 0;
		panel2.add(address, gbc_address);
		
		site = new JTextField();
		site.setText("http://www.google.se");
		GridBagConstraints gbc_site = new GridBagConstraints();
		gbc_site.insets = new Insets(0, 0, 5, 5);
		gbc_site.fill = GridBagConstraints.HORIZONTAL;
		gbc_site.gridx = 1;
		gbc_site.gridy = 0;
		panel2.add(site, gbc_site);
		site.setColumns(10);
		
		btnStart = new JButton("START");
		/**
		 * START PROGRAM
		 */
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.gridx = 2;
		gbc_btnStart.gridy = 0;
		panel2.add(btnStart, gbc_btnStart);
		
		interval = new JTextField();
		interval.setEditable(false);
		interval.setHorizontalAlignment(SwingConstants.CENTER);
		interval.setText("Interval:");
		GridBagConstraints gbc_interval = new GridBagConstraints();
		gbc_interval.insets = new Insets(0, 0, 5, 5);
		gbc_interval.fill = GridBagConstraints.HORIZONTAL;
		gbc_interval.gridx = 0;
		gbc_interval.gridy = 1;
		panel2.add(interval, gbc_interval);
		interval.setColumns(10);
		
		time = new JTextField();
		time.setText("30");
		GridBagConstraints gbc_time = new GridBagConstraints();
		gbc_time.insets = new Insets(0, 0, 5, 5);
		gbc_time.fill = GridBagConstraints.HORIZONTAL;
		gbc_time.gridx = 1;
		gbc_time.gridy = 1;
		panel2.add(time, gbc_time);
		time.setColumns(10);
		
		btnSave = new JButton("Save location");
		/**
		 * Save Listener!
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSaveLoc();
			}
		});
		
		btnStop = new JButton("STOP");
		
		/**
		 * 
		 * STOP PROGRAM
		 */
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStop.insets = new Insets(0, 0, 5, 0);
		gbc_btnStop.gridx = 2;
		gbc_btnStop.gridy = 1;
		panel2.add(btnStop, gbc_btnStop);
		
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 2;
		panel2.add(btnSave, gbc_btnSave);
		
		saveDest = new JTextField();
		saveDest.setEditable(false);
		saveDest.setText("File save location is not set");
		GridBagConstraints gbc_saveDest = new GridBagConstraints();
		gbc_saveDest.insets = new Insets(0, 0, 0, 5);
		gbc_saveDest.anchor = GridBagConstraints.NORTH;
		gbc_saveDest.fill = GridBagConstraints.HORIZONTAL;
		gbc_saveDest.gridx = 1;
		gbc_saveDest.gridy = 2;
		panel2.add(saveDest, gbc_saveDest);
		saveDest.setColumns(10);
		
		btnClr = new JButton("CLR");
		
		/**
		 * 
		 * CLEAR CHAT
		 */
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnClr = new GridBagConstraints();
		gbc_btnClr.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClr.gridx = 2;
		gbc_btnClr.gridy = 2;
		panel2.add(btnClr, gbc_btnClr);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		StatusArea = new JTextArea();
		StatusArea.setText("Status Area");
		StatusArea.setEditable(false);
		StatusArea.setBackground(Color.GRAY);
		scrollPane.setViewportView(StatusArea);
	}
	
	private void setSaveLoc(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  String path = file.toPath().toString() + "\\";
		  System.out.println(path);
		  writeStatus("Save location set to: " + path);
		  
		}
	}
	
	public void writeStatus(String msg){
		StatusArea.append("\n" + msg);
	}

}
