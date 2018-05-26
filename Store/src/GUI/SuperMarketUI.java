package GUI;

//Import Java AWT and IO Packages.
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

//Import JavaX Swing Files.
import javax.swing.*;
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

//Import Other Relevant Packages.
import Produce.Stock;
import SuperMarket.Store;

public class SuperMarketUI extends JFrame
{
	//Miscellaneous:
	private static final long serialVersionUID = 1L;
	private Stock stock;
	private Store store;
	
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
	private JMenuItem saveMenuManifests;
	private JMenuItem loadMenuSalesLogs;
	private JMenuItem saveMenuSalesLogs;
	private JMenuItem exitMenuItem;
	private JMenuBar menubar;
	private JMenu file;
	
	//File System / JFileChooser:
	private JFileChooser loadPropertiesFileChooser;
	private JFileChooser loadManifestFileChooser;
	private JFileChooser loadSalesLogsFileChooser;
	private int loadPropertiesReturnValue;
	private int loadManifestReturnValue;
	private int loadSalesLogsReturnValue;
	private File selectedFile;
	
	private SuperMarketUI()
	{
		stock = new Produce.Stock();
		store = Store.getInstance();
	}
	
	public static void main(String[] args)
	{
		SuperMarketUI supermart = new SuperMarketUI();
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
      loadMenuManifests = new JMenuItem("Open Manifest");
      loadMenuSalesLogs = new JMenuItem("Open Sales Log");
      saveMenuManifests = new JMenuItem("Export Manifest"); 
      saveMenuSalesLogs = new JMenuItem("Export Sales Log"); 
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
      loadMenuManifests.setToolTipText("Import a Manifest File");
      loadMenuManifests.addActionListener((ActionEvent event) -> {
      	
      	loadManifestFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

  		loadManifestReturnValue = loadManifestFileChooser.showOpenDialog(null);

  		if(loadManifestReturnValue == JFileChooser.APPROVE_OPTION)
  		{
  			LoadManifests();
  		}
      });
      
      //Save Manifests Menu:
      saveMenuManifests.setToolTipText("Export a Manifest File");
      saveMenuManifests.addActionListener((ActionEvent event) -> {
      	SaveManifests();
      });
      
      //Load Sales Logs Menu:
      loadMenuSalesLogs.setToolTipText("Import a Sales Log File");
      loadMenuSalesLogs.addActionListener((ActionEvent event) -> {
      	
      	loadSalesLogsFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

  		loadSalesLogsReturnValue = loadSalesLogsFileChooser.showOpenDialog(null);

  		if(loadSalesLogsReturnValue == JFileChooser.APPROVE_OPTION)
  		{
  			LoadSaleLogs();
  		}
      });
      
      //Save Sales Logs Menu:
      saveMenuSalesLogs.setToolTipText("Export a Sales Log File");
      saveMenuSalesLogs.addActionListener((ActionEvent event) -> {
      	SaveSaleLogs();
      });
      
      //Exit Menu:
      exitMenuItem.setMnemonic(KeyEvent.VK_E);
      exitMenuItem.setToolTipText("Exit application");
      
      exitMenuItem.addActionListener((ActionEvent event) -> {
          System.exit(0);
      });

      file.add(loadMenuItemProperties);
      file.add(loadMenuManifests);
      file.add(saveMenuManifests);
      file.add(loadMenuSalesLogs);
      file.add(saveMenuSalesLogs);
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
		System.out.println("Setting Capital");
		capitalValue.setText(store.getCapital());
	}
	
	//Save Functions:
	
	private void SaveManifests()
	{
		stock.stockOrder();
	}
	
	private void SaveSaleLogs()
	{
		File createFile = new File("src\\CSV's\\sales_log_0.csv");
		stock.salesLog(selectedFile);
	}
	
	//Load Functions:
	
	private void LoadManifests()
	{
		selectedFile = loadManifestFileChooser.getSelectedFile();
		
		//TODO: add Relevant Function.
	}
	
	private void LoadSaleLogs()
	{
		selectedFile = loadSalesLogsFileChooser.getSelectedFile();
		
		//TODO: add Relevant Function.
	}
}