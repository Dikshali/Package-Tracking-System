package packageDeliverySystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Mainscreen extends JApplet {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	static BlockingQueue<Shortest> bbcp = new ArrayBlockingQueue<>(10);
	static ExecutorService pool = Executors.newFixedThreadPool(2);
	
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
		layeredPane1.setVisible(false);
		layeredPane1.setBounds(61, 72, 450, 201);
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
		layeredPane2.setBounds(10, 325, 580, 319);
		getContentPane().add(layeredPane2);
		//layeredPane2.setEnabled(false);
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
		
		JLabel lblNewLabel_10 = new JLabel("Sender Name");
		lblNewLabel_10.setBounds(10, 53, 90, 14);
		layeredPane2.add(lblNewLabel_10);
		
		JLabel lblReceiverName = new JLabel("Receiver Name");
		lblReceiverName.setBounds(10, 72, 90, 14);
		layeredPane2.add(lblReceiverName);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(10, 97, 90, 14);
		layeredPane2.add(lblSource);
		
		JLabel p2Sender = new JLabel("");
		p2Sender.setBounds(120, 53, 100, 14);
		layeredPane2.add(p2Sender);
		
		JLabel p2Receiver = new JLabel("");
		p2Receiver.setBounds(120, 72, 100, 14);
		layeredPane2.add(p2Receiver);
		
		JLabel p2Source = new JLabel("");
		p2Source.setBounds(120, 97, 136, 14);
		layeredPane2.add(p2Source);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 115, 90, 14);
		layeredPane2.add(lblDestination);
		
		JLabel p2Destination = new JLabel("");
		p2Destination.setBounds(120, 115, 136, 14);
		layeredPane2.add(p2Destination);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(307, 53, 90, 14);
		layeredPane2.add(lblWeight);
		
		JLabel p2Weight = new JLabel("");
		p2Weight.setBounds(421, 53, 90, 14);
		layeredPane2.add(p2Weight);
		
		JLabel lblPackageType = new JLabel("Package type");
		lblPackageType.setBounds(307, 72, 90, 14);
		layeredPane2.add(lblPackageType);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(307, 97, 90, 14);
		layeredPane2.add(lblQuantity);
		
		JLabel p2Package = new JLabel("");
		p2Package.setBounds(421, 72, 90, 14);
		layeredPane2.add(p2Package);
		
		JLabel p2Quantity = new JLabel("");
		p2Quantity.setBounds(421, 97, 90, 14);
		layeredPane2.add(p2Quantity);
		
		JLabel lblStatus0 = new JLabel("");
		lblStatus0.setBounds(10, 145, 560, 14);
		layeredPane2.add(lblStatus0);
		
		//table_1 = new JTable();
		//table_1.setBounds(10, 230, 547, -89);
		//table_1.setVisible(false);
		
		//layeredPane2.add(table_1);
		
		
		btnCancelTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew.setEnabled(true);
				layeredPane2.setVisible(false);
				textField.setText("");
				p2Sender.setText("");
				p2Receiver.setText("");
				p2Source.setText("");
				p2Destination.setText("");
				p2Weight.setText("");
				p2Package.setText("");
				p2Quantity.setText("");
			}
		});
		
		btnTrackPack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrackPackage trackPackage = new TrackPackage(Integer.parseInt(textField.getText()));
				PackageModel pm = trackPackage.getShippingDetails();
				p2Sender.setText(pm.getSenderName());
				p2Receiver.setText(pm.getReceiverName());
				p2Source.setText(pm.getSource());
				p2Destination.setText(pm.getDestination());
				p2Weight.setText(pm.getWeight());
				p2Package.setText(pm.getPackageType());
				p2Quantity.setText(pm.getQuantity());
				
				JLabel lblStatus0 = new JLabel("");
				lblStatus0.setBounds(10, 145, 560, 14);
				layeredPane2.add(lblStatus0);
				
				if(!pm.getShippingList().isEmpty()) {
					JFrame f=new JFrame();  
					String data[][] = new String[pm.getShippingList().size()][3];
					for(int i=0; i<pm.getShippingList().size(); i++) {
						PackageShipModel sh = pm.getShippingList().get(i);
						data[i][0]=sh.getCenterName();
						data[i][1] = sh.getArrivalTime().toString();
						data[i][2] = sh.getDepartureTime().toString();
					}
				    String column[]={"Center Name","Arrival Time","Departure Time"};         
				    JTable jt=new JTable(data,column);    
				    jt.setBounds(30,40,200,300);          
				    JScrollPane sp=new JScrollPane(jt);    
				    f.add(sp);          
				    f.setSize(600,300);    
				    f.setVisible(true);
				}else {
					lblStatus0.setText("Package in process");
				}
				
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
				layeredPane2.setVisible(false);
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
				int result=0;
				try {
					String weight=textField_3.getText();
					boolean signatureRequired=rdbtnSignatureRequired.isSelected();
					String packageType=comboBox_3.getSelectedItem().toString();
					String quantity=textField_4.getText();
					String senderName=textField_1.getText();
					String receiverName=textField_2.getText();
					String source=comboBox_1.getSelectedItem().toString();
					String destination=comboBox_2.getSelectedItem().toString();
					String specialServices=textArea.getText();
					Timestamp d = new Timestamp(new Date().getTime());
					PackageModel packageModel = new PackageModel(senderName, receiverName, source, destination, packageType, weight, quantity, signatureRequired, specialServices,d,d);
					Createpackage c = new Createpackage(packageModel);
					result = c.insertPackage();
					packageModel.setTrackingId(result);
					lblNewLabel_9.setText("Tracking Number: "+result);
					btnCreate.setEnabled(false);
					Runnable shortestRunnableObject = new Shortest(packageModel);
					pool.execute(shortestRunnableObject);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane1.setVisible(false);
				layeredPane2.setVisible(true);
				btnNew.setEnabled(false);
			}
		});
	}
}
