/*
 * SuperMarketUI.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the entire frontend of the program including, rendering the window along with a menu, table, and capital.
 */
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

import Produce.Item;
//Import Other Relevant Packages.
import Produce.Stock;
import SuperMarket.Store;

public class SuperMarketUI extends JFrame
{
	//Miscellaneous:
	private static final long serialVersionUID = 1L;
	private Stock stock;
	private Store store;
	public int count = 0;
	
	//UI Items:
	private DefaultTableModel tableModel;
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
	private File selectedPropertiesFile;
	private File selectedManifestFile;
	
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
	
	//This Function handles the rendering of the UI minus the MenuBar.
	public void RenderUI()
	{
		//Create a new table and add some column headers.
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Name");
		tableModel.addColumn("Quantity");
		tableModel.addColumn("Manufacturing Cost");
		tableModel.addColumn("Sell Price");
		tableModel.addColumn("Re-Order Point");
		tableModel.addColumn("Re-Order Amount");
		tableModel.addColumn("Temperature");
	     
		//Define the table as a JTable.
	    table = new JTable(tableModel);

	    //Create a JPanel.
	    inputPanel = new JPanel();
	    
	    //Set the Capital Label and Value.
	    capitalLabel = new JLabel("Store Capital");
	    capitalValue = new JTextField(store.getCapital());
	    capitalValue.setBounds(150,150, 200,30);
	    
	    //Add the Capital items to the Panel.
		inputPanel.add(capitalLabel);
		inputPanel.add(capitalValue);
	    
		//Create a UIContainer.
		uiContainer = getContentPane();
		uiContainer.add(new JScrollPane(table), BorderLayout.CENTER);
		uiContainer.add(inputPanel, BorderLayout.NORTH);

		//Set a couple of options for the Window.
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);									//Set the Size.
	    setVisible(true);									//Set the Visibility.
	    setTitle("SuperMarket");							//Set the Title.
	}
	
	//This Function Handles the menubar, including the menu use functions.
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
		exitMenuItem = new JMenuItem("Exit");
      
		//Load Properties Menu:
		loadMenuItemProperties.setToolTipText("Load in an Item Properties File");
		
		//Add an ActionListener to this event.
		loadMenuItemProperties.addActionListener((ActionEvent event) -> {
      	
		//Create A Filechooser to select a file.
		loadPropertiesFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

  		loadPropertiesReturnValue = loadPropertiesFileChooser.showOpenDialog(null);

  		try
  		{
	  		if(loadPropertiesReturnValue == JFileChooser.APPROVE_OPTION)
	  		{
	  			LoadItemProperties();								//Call the LoadItemProperties Function.
	  		}
  		}
  		catch (Exception e) { e.printStackTrace(); }
      });
      
      //Load Manifests Menu:
      loadMenuManifests.setToolTipText("Import a Manifest File");
      
    //Add an ActionListener to this event.
      loadMenuManifests.addActionListener((ActionEvent event) -> {
      	
    	//Create A Filechooser to select a file.
      	loadManifestFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

  		loadManifestReturnValue = loadManifestFileChooser.showOpenDialog(null);

  		try
  		{
	  		if(loadManifestReturnValue == JFileChooser.APPROVE_OPTION)
	  		{
	  			LoadManifests();									//Call the LoadManifests Function.
	  		}
  		}
  		catch (Exception e) { e.printStackTrace(); }
      });
      
      //Save Manifests Menu:
      saveMenuManifests.setToolTipText("Export a Manifest File");
      
    //Add an ActionListener to this event.
      saveMenuManifests.addActionListener((ActionEvent event) -> {
      	SaveManifests();											//Call the SaveManifests Function.
      });
      
      //Load Sales Logs Menu:
      loadMenuSalesLogs.setToolTipText("Import a Sales Log File");
      
    //Add an ActionListener to this event.
      loadMenuSalesLogs.addActionListener((ActionEvent event) -> {
      	
    	//Create A Filechooser to select a file.
      	loadSalesLogsFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

  		loadSalesLogsReturnValue = loadSalesLogsFileChooser.showOpenDialog(null);

  		try
  		{
	  		if(loadSalesLogsReturnValue == JFileChooser.APPROVE_OPTION)
	  		{
	  			LoadSaleLogs();										//Call the LoadSaleLogs Function.
	  		}
  		}
  		catch (Exception e) { e.printStackTrace(); }
      });
      
      //Exit Menu:
      exitMenuItem.setMnemonic(KeyEvent.VK_E);
      exitMenuItem.setToolTipText("Exit application");
      
    //Add an ActionListener to this event.
      exitMenuItem.addActionListener((ActionEvent event) -> {
          System.exit(0);
      });

      //Add the Options to the Menu.
      file.add(loadMenuItemProperties);
      file.add(loadMenuSalesLogs);
      file.add(loadMenuManifests);
      file.add(saveMenuManifests);
      file.add(exitMenuItem);

      //Create the MenuBar.
      menubar.add(file);
      
      //Set the MenuBar.
      setJMenuBar(menubar);
  }
	
	//This Function is used to load the ItemProperties file that was selected from the filechooser above.
	private void LoadItemProperties()
	{
		try
		{
			selectedPropertiesFile = loadPropertiesFileChooser.getSelectedFile();	//Use the Selected File.
			
			stock.initialise(selectedPropertiesFile);								//initialize the selected file.
		
			//Check if the stock amount is valid.
			if(stock.getObjectAmount() > 0)
			{
				for(int i = 0; i < stock.getObjectAmount(); i++)					//Cycle through the available items.
				{
					String[] item = { "", "", "", "", "", "", "" };					//Create a new String Array for filling with information
					item = stock.showInventory(i);									//Fill the String Array
					tableModel.addRow(item);										//Add this information to the table.
				}
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		
		capitalValue.setText(store.getCapital());									//Set the Store Capital.
		
		ReloadUI();																	//Refresh the UI.
	}
	
	//Save Functions:
	
	//This Function Saves the Manifest by calling stock.stockOrder();
	private void SaveManifests()
	{
		stock.stockOrder();															//Call for a stock order.
		capitalValue.setText(store.getCapital());									//Set the Capital.
		
		ReloadUI();																	//Reload the UI.
	}
	
	//Load Functions:
	
	//This Function Loads the manifest and refreshes the Table.
	private void LoadManifests()
	{
		try
		{
			selectedManifestFile = loadManifestFileChooser.getSelectedFile();		//Use the Selected File.
			stock.manifestDelivered(selectedManifestFile);
			
			//Referenced From StackOverflow: https://stackoverflow.com/questions/11625755/how-to-remove-all-rows-in-jtable
			if (tableModel.getRowCount() > 0)
			{
                for (int i = tableModel.getRowCount() - 1; i > -1; i--)
                {
                    tableModel.removeRow(i);
                }
            }
			
			//Check if the stock amount is valid.
			if(stock.getObjectAmount() > 0)
			{
				for(int i = 0; i < stock.getObjectAmount(); i++)					//Cycle through the available items.
			    {
		    	  String[] item = { "", "", "", "", "", "", "" };					//Create a new String Array for filling with information
		    	  item = stock.showInventory(i);									//Fill the String Array
		    	  tableModel.addRow(item);											//Add this information to the table.									
			    }
			}
			capitalValue.setText(store.getCapital());								//Set the Store Capital
		}
		catch (Exception e) { e.printStackTrace(); }
		
		ReloadUI();																	//Reload the UI.
	}
	
	//This Function is used to load the sale logs.
	private void LoadSaleLogs()
	{
		try
		{
			selectedFile = loadSalesLogsFileChooser.getSelectedFile();				//Use the Selected File.
			stock.salesLog(selectedFile);											//Call the salesLog Function parsing in the Selected File.
			
			//Referenced From StackOverflow: https://stackoverflow.com/questions/11625755/how-to-remove-all-rows-in-jtable
			if (tableModel.getRowCount() > 0)
			{
                for (int i = tableModel.getRowCount() - 1; i > -1; i--)
                {
                    tableModel.removeRow(i);
                }
            }
			
			//Check if the stock amount is valid.
			if(stock.getObjectAmount() > 0)
			{
				for(int i = 0; i < stock.getObjectAmount(); i++)					//Cycle through the available items.
			    {
		    	  System.out.println(stock.getObjectAmount());
		    	  String[] item = { "", "", "", "", "", "", "" };					//Create a new String Array for filling with information
		    	  item = stock.showInventory(i);									//Fill the String Array
		    	  tableModel.addRow(item);											//Add this information to the table.	
			    }
			}
			capitalValue.setText(store.getCapital());;								//Set the Store Capital
		}
		catch (Exception e) { e.printStackTrace(); }
		
		ReloadUI();																	//Reload the UI.
	}
	
	//This Function is used to reload / repaint the UI.
	private void ReloadUI()
	{
		uiContainer.repaint();
		capitalValue.repaint();
		inputPanel.repaint();
		capitalLabel.repaint();
		table.repaint();
	}
}