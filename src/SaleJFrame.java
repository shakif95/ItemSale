

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JCheckBox;

public class SaleJFrame extends JFrame {

	private JFrame frmSaleSoftware;
	private JTextField textFieldEnterId;
	private JTextField textFieldQuantity;
	
	private JTable table_1;
	private JLabel lblTotal;
	private JTextField textFieldActualTotal;
	private JLabel lblWelcomeToOur;

	private JButton bdVatbtn;


	ProcessSaleController psc = new ProcessSaleController();
	SaleLineItem sli;
	//SaleLineItem sli = new SaleLineItem();
	int sl = 0;
	public static String choice="BD";
	private JTextField textFieldGrandTotal;
	private JTextField textField_discount;
	private JTextField textField_vat;
	//int total = 0;

	public void addProduct(SaleLineItem saleItem,int quantity) {

		if (!saleItem.getPs().getId().equals("-1")) {
					sl++;
					table_1.setValueAt(Integer.toString(sl), sl, 0);
					table_1.setValueAt(String.valueOf(saleItem.getPs().getName()), sl, 1);
					table_1.setValueAt(String.valueOf(saleItem.getPs().getPrice()), sl, 2);
					table_1.setValueAt(String.valueOf(saleItem.getQuantity()), sl, 3);
					table_1.setValueAt(String.valueOf(saleItem.getSubTotal()), sl, 4);
					//System.out.println(saleItem.getPs().getManufacturerAddress());
				} else {
					JOptionPane.showMessageDialog(this, "Wrong Item ID", "Wrong Input", JOptionPane.ERROR_MESSAGE);
				}
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleJFrame window = new SaleJFrame();
					window.frmSaleSoftware.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaleJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaleSoftware = new JFrame();
		frmSaleSoftware.setBackground(Color.WHITE);
		frmSaleSoftware.getContentPane().setBackground(Color.WHITE);
		frmSaleSoftware.setTitle("Sale Software");
		frmSaleSoftware.setForeground(SystemColor.activeCaptionBorder);
		frmSaleSoftware.setBounds(100, 100, 663, 614);
		frmSaleSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaleSoftware.getContentPane().setLayout(null);

		

		JLabel lblItemId = new JLabel("Item Id");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemId.setBounds(10, 58, 69, 23);
		frmSaleSoftware.getContentPane().add(lblItemId);

		textFieldEnterId = new JTextField();
		textFieldEnterId.setToolTipText("");
		textFieldEnterId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEnterId.setBounds(110, 61, 140, 20);
		frmSaleSoftware.getContentPane().add(textFieldEnterId);
		textFieldEnterId.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(10, 92, 69, 14);
		frmSaleSoftware.getContentPane().add(lblQuantity);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldQuantity.setBounds(110, 92, 140, 20);
		frmSaleSoftware.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);

		table_1 = new JTable();
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { "SL#", "Item Name", "Unit Price", "Quantity", "Sub Total" },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table_1.setBounds(10, 158, 627, 208);
		frmSaleSoftware.getContentPane().add(table_1);

		lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(456, 377, 54, 14);
		frmSaleSoftware.getContentPane().add(lblTotal);

		textFieldActualTotal = new JTextField();
		textFieldActualTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldActualTotal.setBounds(512, 377, 125, 20);
		frmSaleSoftware.getContentPane().add(textFieldActualTotal);
		textFieldActualTotal.setColumns(10);
		
		JLabel lblGrandTotal = new JLabel("Grand Total :");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrandTotal.setBounds(407, 503, 102, 14);
		frmSaleSoftware.getContentPane().add(lblGrandTotal);
		
		textFieldGrandTotal = new JTextField();
		textFieldGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGrandTotal.setBounds(512, 500, 125, 20);
		frmSaleSoftware.getContentPane().add(textFieldGrandTotal);
		textFieldGrandTotal.setColumns(10);

		lblWelcomeToOur = new JLabel("Welcome to Our XYZ Shop");
		lblWelcomeToOur.setBackground(new Color(255, 255, 255));
		lblWelcomeToOur.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		lblWelcomeToOur.setBounds(190, 11, 320, 39);
		frmSaleSoftware.getContentPane().add(lblWelcomeToOur);
		
		JLabel lblVat_1 = new JLabel("VAT:");
		lblVat_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVat_1.setBounds(468, 458, 42, 14);
		frmSaleSoftware.getContentPane().add(lblVat_1);
		
		textField_vat = new JTextField();
		textField_vat.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_vat.setBounds(512, 457, 125, 20);
		frmSaleSoftware.getContentPane().add(textField_vat);
		textField_vat.setColumns(10);
		
		JLabel lblVat = new JLabel("Current Vat: BDVAT");
		lblVat.setBounds(10, 411, 171, 14);
		frmSaleSoftware.getContentPane().add(lblVat);
		
		
		JButton intVATbtn = new JButton("Click to change vat system to Int'l");
		intVATbtn.addActionListener(new ActionListener() {
			//boolean flag = true;
			public void actionPerformed(ActionEvent e) {
				choice = "Int'l";
				lblVat.setText("Current Vat: International");
			}
		});
		intVATbtn.setBounds(383, 60, 254, 23);
		frmSaleSoftware.getContentPane().add(intVATbtn);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id = textFieldEnterId.getText();
				int quantity = Integer.parseInt(textFieldQuantity.getText());
				
				SaleLineItem saleItem = psc.addProduct(id,quantity);
				sli = saleItem;
				addProduct(saleItem,quantity);
				
				
				//String tot = Double.toString(psc.getTotal());
				textFieldActualTotal.setText(String.valueOf(psc.getSale().getActualTotal()));
				
				//String grandtot;
				try {
					
					textFieldGrandTotal.setText(String.valueOf(psc.getGrandTotal()));
					textField_vat.setText(String.valueOf(psc.getGrandTotal()-psc.getTotal()));
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				textFieldEnterId.setText("");
				textFieldQuantity.setText("");
				
				

			}

		});
		btnAddItem.setBounds(161, 123, 89, 23);
		frmSaleSoftware.getContentPane().add(btnAddItem);
		
		
		//resetting sale list
		JButton btnNewSale = new JButton("New Sale");
		btnNewSale.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 1; i <= sl; i++) {

					table_1.setValueAt("", i, 0);
					table_1.setValueAt("", i, 1);
					table_1.setValueAt("", i, 2);
					table_1.setValueAt("", i, 3);
					table_1.setValueAt("", i, 4);
				}
				psc.makeNewSale();
				sl = 0;
				textFieldActualTotal.setText("0.0");
				textField_discount.setText("0.0");
				textField_vat.setText("0.0");
				textFieldGrandTotal.setText("0.0");
				textFieldEnterId.setText("");
				textFieldQuantity.setText("");

			}
		});
		btnNewSale.setBounds(10, 377, 89, 23);
		frmSaleSoftware.getContentPane().add(btnNewSale);
		
		//discounts options for user
		String list[] = {"Best for Store","Best for Customer"};
		JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(10, 436, 254, 20);
		frmSaleSoftware.getContentPane().add(comboBox);
		
		JLabel lblDiscount = new JLabel("Discount :");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiscount.setBounds(430, 415, 80, 14);
		frmSaleSoftware.getContentPane().add(lblDiscount);
		
		textField_discount = new JTextField();
		textField_discount.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_discount.setColumns(10);
		textField_discount.setBounds(512, 412, 125, 20);
		frmSaleSoftware.getContentPane().add(textField_discount);
		
		
		JCheckBox chckbxSeniorCitizen = new JCheckBox("Senior Citizen");
		chckbxSeniorCitizen.setBounds(10, 474, 97, 23);
		frmSaleSoftware.getContentPane().add(chckbxSeniorCitizen);
		
		JCheckBox chckbxEidOffer = new JCheckBox("Eid Offer");
		chckbxEidOffer.setBounds(123, 474, 97, 23);
		frmSaleSoftware.getContentPane().add(chckbxEidOffer);
		
		JLabel label_1 = new JLabel("---------------------------------------------------------------");
		label_1.setBounds(383, 478, 254, 14);
		frmSaleSoftware.getContentPane().add(label_1);
		
		JButton btnCalDis = new JButton("Calculate Discount");
		btnCalDis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CompositePricingStrategy cps = new CompositePricingStrategy();
				if(comboBox.getSelectedIndex()==0){
					cps.setChoice(CompositePricingStrategy.choice.BestForCustomer);
				}
				if(comboBox.getSelectedIndex()==1){
					cps.setChoice(CompositePricingStrategy.choice.BestForStore);
				}
				if(chckbxSeniorCitizen.isSelected()){
					cps.add(new PercentageDiscountPricingStrategy());
				}
				
				if(chckbxEidOffer.isSelected()){
					if(psc.getSale().getActualTotal()<1000) //if actual sale is less than 1000 then Eid offer is invalid
						return;
					cps.add(new AbsoluteDiscountOverThresholdPricingStrategy());
				}
				
				
			psc.getSale().disStrategy = cps;
			textField_discount.setText(String.valueOf(psc.getSale().getActualTotal()-psc.getTotal()));
			try {
				textFieldGrandTotal.setText(String.valueOf(psc.getGrandTotal()));
				textField_vat.setText(String.valueOf(psc.getGrandTotal()-psc.getTotal()));
				psc.getSale().publish();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnCalDis.setBounds(10, 504, 140, 23);
		frmSaleSoftware.getContentPane().add(btnCalDis);
		
		psc.getSale().addProperty(new beep()); //adding beep sound when calculate discount pressed.
		
		JButton btnNewButton = new JButton("Manufacturers info\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ManufacturerListJFrame manFrame = new ManufacturerListJFrame(sli);
				ManufacturerListJFrame.ManuList(psc);
			}
		});
		
		
		btnNewButton.setBounds(383, 90, 254, 23);
		frmSaleSoftware.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		

	}
}
