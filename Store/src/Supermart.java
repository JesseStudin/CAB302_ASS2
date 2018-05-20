import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Supermart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	
	public Supermart() {
		
	}

	public static void main(String[] args) {
		Supermart supermart = new Supermart();
		
		supermart.RenderUI();
		supermart.createMenuBar();
	}
	
	public void RenderUI()
	{
	    model = new DefaultTableModel();
	    model.addColumn("Name");
	    model.addColumn("Quantity");
	    model.addColumn("Manufacturing Cost");
	    model.addColumn("Sell Price");
	    model.addColumn("Re-Order Point");
	    model.addColumn("Re-Order Amount");
	    model.addColumn("Temperature");
	    
	    String[] frozenvegetablemix = { "frozen vegetable mix", "88", "5", "8", "255", "325", "-12" };
	    model.addRow(frozenvegetablemix);

	    table = new JTable(model);

	    JButton addButton = new JButton("Add Item");
	    
	    addButton.addActionListener(new ActionListener() {

	      public void actionPerformed(ActionEvent event) {
	        String[] item = { "", "", "", "", "", "", "" };
	        model.addRow(item);
	      }
	    });

	    JButton removeButton = new JButton("Remove Selected Item");

	    removeButton.addActionListener(new ActionListener() {

	      public void actionPerformed(ActionEvent event) {
	        model.removeRow(table.getSelectedRow());
	      }
	    });
	    JPanel inputPanel = new JPanel();
	    
	    inputPanel.add(addButton);
	    inputPanel.add(removeButton);
	    
	    JTextField t1;
		t1=new JTextField("$1,000,000,00");
		t1.setBounds(50,100, 200,30);
		inputPanel.add(t1);

	    Container container = getContentPane();
	    container.add(new JScrollPane(table), BorderLayout.CENTER);
	    container.add(inputPanel, BorderLayout.NORTH);

	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);
	    setVisible(true);
	}
	
	private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon("src/main/resources/exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        // Menu Items:
        JMenuItem loadMenuItemProperties = new JMenuItem("Load Item Properties"); 
        JMenuItem loadMenuManifests = new JMenuItem("Load Manifest"); 
        JMenuItem loadMenuSalesLogs = new JMenuItem("Load Sales Log"); 
        JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
        
        // Menu Item Settings:
        
        //Load Properties Menu:
        loadMenuItemProperties.setToolTipText("Load in an Item Properties File");
        loadMenuItemProperties.addActionListener((ActionEvent event) -> {
        	LoadItemProperties();
        });
        
        //Load Manifests Menu:
        loadMenuManifests.setToolTipText("Load in a Manifest File");
        loadMenuManifests.addActionListener((ActionEvent event) -> {
        	LoadManifests();
        });
        
        //Load Sales Logs Menu:
        loadMenuSalesLogs.setToolTipText("Load in a Sales Log File");
        loadMenuSalesLogs.addActionListener((ActionEvent event) -> {
        	LoadSalesLogs();
        });
        
        //Exit Menu:
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(loadMenuItemProperties);
        file.add(loadMenuManifests);
        file.add(loadMenuSalesLogs);
        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }
	
	private void LoadItemProperties()
	{
		
	}
	
	private void LoadManifests()
	{
		
	}
	
	private void LoadSalesLogs()
	{
		
	}


}
