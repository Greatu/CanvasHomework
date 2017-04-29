import javax.swing.*;
import javax.swing.filechooser.FileFilter;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GUI extends JFrame implements Runnable, ActionListener {
	private JFrame frame;
	/*private JMenuBar menuBar;
	private JMenu Menu, submenu;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem quitMenuItem;*/
	private JTextArea data;
	private JFileChooser chooser;


	public GUI(){
		
		super("Publish");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(800,500);
	    Container c = getContentPane();
	    c.setBackground(Color.GRAY);
	    

	    /*menuBar = new JMenuBar();
	    Menu = new JMenu("Menu");
	   
	    submenu = new JMenu("File");
	    submenu.setMnemonic(KeyEvent.VK_S);
	    openMenuItem = new JMenuItem("Open");
	    openMenuItem.addActionListener(this);
	    saveMenuItem = new JMenuItem("Save");
	    quitMenuItem = new JMenuItem("Quit");

	    
	    
	    
	    submenu.add(openMenuItem);
	    submenu.add(saveMenuItem);
	    submenu.add(quitMenuItem);
	    Menu.add(submenu);


	    // add menus to menubar
	    menuBar.add(Menu);
	   
	    c.add(BorderLayout.NORTH, menuBar);
	    */

	    
		
	
	    JPanel p= new JPanel();
		p.setLayout(null);
		
	    JTextArea display = new JTextArea (1, 20);
	    display.setFont(new Font("Times", Font.PLAIN, 28));
	    display.append("Display Area");
	    c.add(BorderLayout.WEST, display);	   
	    display.setEditable (false); // set textArea non-editable
	    //JScrollPane scroll = new JScrollPane (display);
	    //c.add(scroll);
	   // scroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	  
	   
		
		
       
		//add Choose files button
		JButton b = new JButton("Choose files");
		b.setBounds(50,50, 100, 20);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (chooser == null) {
                    chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    chooser.setAcceptAllFileFilterUsed(false);
                    chooser.addChoosableFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt/.java");
                        }

                        @Override
                        public String getDescription() {
                            return "Text/Java Files (*.txt/*.java)";
                        }
                    });
				}
				 switch (chooser.showOpenDialog(GUI.this)) {
                 case JFileChooser.APPROVE_OPTION:
                     try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                         display.setText(null);
                         String text = null;
                         while ((text = br.readLine()) != null) {
                        	 display.append(text);
                        	 display.append("\n");
                         }
                         display.setCaretPosition(0);
                     } catch (IOException exp) {
                         exp.printStackTrace();
                         JOptionPane.showMessageDialog(GUI.this, "Failed to read file", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                     break;
				 }
			}
		});
		p.add(b);
		
		//add area that shows the path
		Container c2 = getContentPane();
		JTextArea path = new JTextArea(1,1);
		//c2.add(path);
		//p.add(c2);
		path.setBounds(50,60,10,10);
		p.add(path);
		
		//add Compile button
		JButton cp = new JButton("Compile");
		cp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cp.setBounds(50,450, 100, 20);
		p.add(cp);
		
		//add Upload button
		JButton t = new JButton("Upload");
		t.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		t.setBounds(250,450, 100, 20);
		p.add(t);
		
		add(p);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new GUI();
	}

	  public void actionPerformed(ActionEvent ev)
	  {
	    SampleDialog dialog = new SampleDialog();
	    dialog.setModal(true);
	    dialog.setVisible(true);
	  }
	  private class SampleDialog extends JDialog implements ActionListener
	  {
	    //Private static final Frame frame;
		private JButton okButton = new JButton("OK");
	
	    private SampleDialog()
	    {
	      super(frame, "Sample Dialog", true);
	      JPanel panel = new JPanel(new FlowLayout());
	      panel.add(okButton);
	      getContentPane().add(panel);
	      setPreferredSize(new Dimension(300, 200));
	      pack();
	      setLocationRelativeTo(frame);
	    }
	
	    public void actionPerformed(ActionEvent ev)
	    {
	      setVisible(false);
	    }
	  }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
