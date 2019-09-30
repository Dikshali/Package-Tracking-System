package packageDeliverySystem;

import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.RescaleOp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;

public class Mainscreen extends JApplet {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	/**
	 * Create the applet.
	 */
	/*public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }*/
	
	public Mainscreen() {
		setBounds(new Rectangle(0, 0, 1000, 1000));
		getContentPane().setBounds(new Rectangle(0, 0, 1000, 1000));
		getContentPane().setSize(new Dimension(1000, 1000));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to FedEx");
		lblNewLabel.setBounds(61, 0, 450, 32);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JButton btnNew = new JButton("Create new package");
		btnNew.setBounds(61, 35, 170, 23);
		getContentPane().add(btnNew);
		
		JButton btnTrack = new JButton("Track Package");
		btnTrack.setBounds(341, 35, 170, 23);
		getContentPane().add(btnTrack);
		
		JLayeredPane layeredPane1 = new JLayeredPane();
		layeredPane1.setBounds(61, 72, 450, 201);
		//layeredPane1.setBounds(10, 88, 430, 201);
		layeredPane1.setEnabled(false);
		layeredPane1.setVisible(false);
		getContentPane().add(layeredPane1);
		
		JLabel lblNewLabel_1 = new JLabel("Sender Name");
		lblNewLabel_1.setBounds(10, 24, 90, 14);
		layeredPane1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 21, 101, 20);
		layeredPane1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Receiver Name");
		lblNewLabel_2.setBounds(10, 49, 90, 14);
		layeredPane1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Source");
		lblNewLabel_3.setBounds(10, 74, 90, 14);
		layeredPane1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Destination");
		lblNewLabel_4.setBounds(10, 99, 90, 14);
		layeredPane1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 46, 101, 20);
		layeredPane1.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Northborough, MA", "Edison, NJ", "Pittsburgh, PA", "Allentown, PABD Strap Endlinksth", "Martinsburg, WV", "Charlotte, NC", "Atlanta, GA", "Orlando, FL", "Memphis, TN", "Grove City, OH", "Indianapolis, IN", "Detroit, MI", "New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX", "Denver, CO", "Salt Lake City, UT", "Phoenix, AZ", "Los Angeles, CA", "Chino, CA", "Sacramento, CA", "Seattle, WA"}));
		comboBox_1.setBounds(110, 71, 100, 20);
		layeredPane1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Northborough, MA", "Edison, NJ", "Pittsburgh, PA", "Allentown, PABD Strap Endlinksth", "Martinsburg, WV", "Charlotte, NC", "Atlanta, GA", "Orlando, FL", "Memphis, TN", "Grove City, OH", "Indianapolis, IN", "Detroit, MI", "New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX", "Denver, CO", "Salt Lake City, UT", "Phoenix, AZ", "Los Angeles, CA", "Chino, CA", "Sacramento, CA", "Seattle, WA"}));
		comboBox_2.setBounds(109, 96, 101, 20);
		layeredPane1.add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Package type");
		lblNewLabel_5.setBounds(10, 124, 90, 14);
		layeredPane1.add(lblNewLabel_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Package", "Letter"}));
		comboBox_3.setBounds(109, 121, 101, 20);
		layeredPane1.add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("Weight (kgs)");
		lblNewLabel_6.setBounds(235, 24, 75, 14);
		layeredPane1.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(320, 21, 100, 20);
		layeredPane1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Quantity");
		lblNewLabel_7.setBounds(235, 49, 75, 14);
		layeredPane1.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(320, 46, 100, 20);
		layeredPane1.add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnSignatureRequired = new JRadioButton("Direct Signature required");
		rdbtnSignatureRequired.setBounds(235, 70, 174, 23);
		layeredPane1.add(rdbtnSignatureRequired);
		
		JLabel lblNewLabel_8 = new JLabel("Comments");
		lblNewLabel_8.setBounds(235, 99, 75, 14);
		layeredPane1.add(lblNewLabel_8);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(320, 94, 100, 44);
		layeredPane1.add(textArea);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(175, 167, 89, 23);
		layeredPane1.add(btnCreate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(20, 167, 89, 23);
		layeredPane1.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(320, 167, 89, 23);
		layeredPane1.add(btnCancel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(20, 147, 400, 14);
		layeredPane1.add(lblNewLabel_9);
		
		JLayeredPane layeredPane2 = new JLayeredPane();
		layeredPane2.setBounds(27, 284, 521, 249);
		getContentPane().add(layeredPane2);
		layeredPane2.setEnabled(false);
		layeredPane2.setVisible(false);
		
		JLabel lblEnterTrackingNo = new JLabel("Enter Tracking No : ");
		lblEnterTrackingNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterTrackingNo.setBounds(10, 11, 113, 20);
		layeredPane2.add(lblEnterTrackingNo);
		
		textField = new JTextField();
		textField.setBounds(133, 8, 123, 23);
		layeredPane2.add(textField);
		textField.setColumns(10);
		
		JButton btnTrackPack = new JButton("Track");
		btnTrackPack.setBounds(283, 7, 100, 23);
		layeredPane2.add(btnTrackPack);
		
		JButton btnCancelTrack = new JButton("Cancel");
		btnCancelTrack.setBounds(411, 7, 100, 23);
		layeredPane2.add(btnCancelTrack);
		
		btnCancelTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew.setEnabled(true);
				layeredPane2.setEnabled(false);
				layeredPane2.setVisible(false);
				textField.setText("");
			}
		});
		
		btnTrackPack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew.setEnabled(false);
			}
		});
		
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_3.setSelectedIndex(-1);
				textArea.setText("");
				rdbtnSignatureRequired.setSelected(false);
				layeredPane1.setVisible(false);
				layeredPane1.setVisible(true);
				btnTrack.setEnabled(false);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_3.setSelectedIndex(-1);
				textArea.setText("");
				rdbtnSignatureRequired.setSelected(false);
				layeredPane1.setVisible(false);
				btnTrack.setEnabled(true);
				btnCreate.setEnabled(true);
				lblNewLabel_9.setText("");
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_3.setSelectedIndex(-1);
				textArea.setText("");
				rdbtnSignatureRequired.setSelected(false);
				lblNewLabel_9.setText("");
				btnCreate.setEnabled(true);
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(comboBox_1.getSelectedIndex() == comboBox_2.getSelectedIndex()) {
					infoBox("Source and Destination cannot be same", "Error");
				}*/
				int result=0;
				String weight=textField_3.getText();
				boolean signatureRequired=rdbtnSignatureRequired.isSelected();
				String packageType=comboBox_3.getSelectedItem().toString();
				String quantity=textField_4.getText();
				String senderName=textField_1.getText();
				String receiverName=textField_2.getText();
				String source=comboBox_1.getSelectedItem().toString();
				String destination=comboBox_2.getSelectedItem().toString();
				String specialServices=textArea.getText();
				Createpackage c = new Createpackage();
				try {
					result= c.insertPackage(senderName, receiverName, source, destination, packageType, weight, quantity, signatureRequired, specialServices);
					c.createPath(source, destination, result);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				lblNewLabel_9.setText("Tracking Number: "+result);
				btnCreate.setEnabled(false);
				//System.out.println(result);
			}
		});
		
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane2.setEnabled(true);
				layeredPane2.setVisible(true);
				
			}
		});
	}
}
