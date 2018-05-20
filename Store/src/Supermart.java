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
import javax.swing.table.DefaultTableModel;

public class Supermart extends JFrame{

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

		    JButton removeButton = new JButton("Remove Selected Philosopher");

		    removeButton.addActionListener(new ActionListener() {

		      public void actionPerformed(ActionEvent event) {
		        model.removeRow(table.getSelectedRow());
		      }
		    });
		    JPanel inputPanel = new JPanel();
		    inputPanel.add(addButton);
		    inputPanel.add(removeButton);

		    Container container = getContentPane();
		    container.add(new JScrollPane(table), BorderLayout.CENTER);
		    container.add(inputPanel, BorderLayout.NORTH);

		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    setSize(400, 300);
		    setVisible(true);

	}
	
	private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon("src/main/resources/exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }


}
