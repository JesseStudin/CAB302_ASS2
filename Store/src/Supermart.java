import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import SuperMarket.Store;

public class Supermart extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Produce.Stock stock = new Produce.Stock();
	private SuperMarket.Store store = Store.getInstance();
	
	//UI Items:
	private DefaultTableModel tableModel;
	private DefaultTableModel model;
	private Container uiContainer;
	private JTextField capitalValue;
	private JTable table;
	private JLabel capitalLabel;
	private JPanel inputPanel;

	//Menu Items / Bars:
	private JMenuItem loadMenuItemProperties;
	private JMenuItem loadMenuManifests;
	private JMenuItem loadMenuSalesLogs;
	private JMenuItem exitMenuItem;
	private JMenuBar menubar;
	private JMenu file;
	
	//File System / JFileChooser:
	private JFileChooser loadPropertiesFileChooser;
	private int loadPropertiesReturnValue;
	private File selectedFile;
	
	public Supermart() {}

	public static void main(String[] args)
	{
		Supermart supermart = new Supermart();
		supermart.RenderUI();
		supermart.createMenuBar();
	}
	
	/*
	 * To Add to a Table Model: model.addRow(item);
	 * To Remove from a Table Model: model.removeRow(table.getSelectedRow());
	 */
	public void RenderUI()
	{
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Name");
		tableModel.addColumn("Quantity");
		tableModel.addColumn("Manufacturing Cost");
		tableModel.addColumn("Sell Price");
		tableModel.addColumn("Re-Order Point");
		tableModel.addColumn("Re-Order Amount");
		tableModel.addColumn("Temperature");
	     
	    table = new JTable(tableModel);

	    inputPanel = new JPanel();
	    capitalLabel = new JLabel("Store Capital");
	    capitalValue = new JTextField(store.getCapital());
	    
	    capitalValue.setBounds(100,100, 200,30);
	    
		inputPanel.add(capitalLabel);
		inputPanel.add(capitalValue);
	    
		uiContainer = getContentPane();
		uiContainer.add(new JScrollPane(table), BorderLayout.CENTER);
		uiContainer.add(inputPanel, BorderLayout.NORTH);

	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);
	    setVisible(true);
	    setTitle("SuperMarket");
	}
	
	private void createMenuBar()
	{
		//Create a New MenuBar
		menubar = new JMenuBar();
		
		//Initialize the "File" Menu Item.
		file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F); //Give it a shortcut key

        // Menu Items:
        loadMenuItemProperties = new JMenuItem("Load Item Properties"); 
        loadMenuManifests = new JMenuItem("Export Manifest"); 
        loadMenuSalesLogs = new JMenuItem("Load Sales Log"); 
        exitMenuItem = new JMenuItem("Exit");
        
        //Load Properties Menu:
        loadMenuItemProperties.setToolTipText("Load in an Item Properties File");
        loadMenuItemProperties.addActionListener((ActionEvent event) -> {
        	
        	loadPropertiesFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    		loadPropertiesReturnValue = loadPropertiesFileChooser.showOpenDialog(null);

    		if(loadPropertiesReturnValue == JFileChooser.APPROVE_OPTION)
    		{
    			LoadItemProperties();
    		}
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
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        
        exitMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(loadMenuItemProperties);
        file.add(loadMenuManifests);
        file.add(loadMenuSalesLogs);
        file.add(exitMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }
	
	private void LoadItemProperties()
	{
		selectedFile = loadPropertiesFileChooser.getSelectedFile();
		
		stock.initialise(selectedFile);
		
		if(stock.getObjectAmount() > 0)
		{
		      for(int i = 0; i < stock.getObjectAmount(); i++)
		      {
		    	  System.out.println(stock.getObjectAmount());
		    	  String[] item = { "", "", "", "", "", "", "" };
		    	  item = stock.showInventory(i);
		    	  tableModel.addRow(item);
		      }
  	  }
		capitalValue.setText(store.getCapital());
	}
	
	private void LoadManifests()
	{
		stock.stockOrder();
	}
	
	private void LoadSalesLogs()
	{
		stock.salesLog(null);
	}


}
