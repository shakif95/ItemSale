import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class ManufacturerListJFrame {

	private JFrame frame;
	private JTable table_1;
	ProcessSaleController psc;
	/**
	 * Launch the application.
	 */
	
	public ManufacturerListJFrame(ProcessSaleController psc){
		this.psc = psc;
		initialize(psc);
	}
	public static void ManuList(ProcessSaleController psc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManufacturerListJFrame window = new ManufacturerListJFrame(psc);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public ManufacturerListJFrame() {
		initialize();
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProcessSaleController psc) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 636, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		table_1 = new JTable();
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"id","Product Name" ,"Manufracturer name", "Address"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(0, 92, 620, 208);
		frame.getContentPane().add(table_1);
		
		JLabel lblNewLabel = new JLabel("Manufacturer Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(155, 32, 311, 22);
		frame.getContentPane().add(lblNewLabel);
		int sl = 0;
		//ProcessSaleController psc = new ProcessSaleController();
		
		for(int i=0;i<psc.getSale().getList().size();i++){
			//System.out.println(psc.getSale().getList().get(i).getPs().getName());;
				sl++;
				table_1.setValueAt(Integer.toString(sl), sl, 0);
				table_1.setValueAt(String.valueOf(psc.getSale().getList().get(i).getPs().getName()), sl, 1);
				table_1.setValueAt(String.valueOf(psc.getSale().getList().get(i).getPs().getManufacturer().getName()), sl, 2);
				table_1.setValueAt(String.valueOf(psc.getSale().getList().get(i).getPs().getManufacturer().getAddress()), sl, 3);
			
		}
		

	}
}
