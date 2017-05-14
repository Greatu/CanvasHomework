import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.*;

public class UploadGUI extends JFrame {
	private TextArea display,showarea;
	private JButton open,clear,upload,check;
	private JTextField start,end,due,interval,checkfield;
	private JLabel startLab,endLab, firLab, secLab,dueLab,intervalLab,disLabel, showLabel;
	//private JPanel gradArea, comPanel, rstPanel, panel, disPanel, openPanel, pane3;
	//private FileDialog openDia, saveDia, nextDia;
	private File file;
	private File[] files;

	
	List<File> fileList = new ArrayList<>();//create new file list to store files
	
	UploadGUI() {
		display = new TextArea();
		display.setEditable(false);
		showarea = new TextArea("",8,60,TextArea.SCROLLBARS_VERTICAL_ONLY);//make it can only scroll vertically
		showarea.setEditable(false);
		disLabel = new JLabel("Files");
		showLabel = new JLabel("Content");
		//open button
		open = new JButton("Open");	
		//clear button
		clear = new JButton("Clear");
		//check area
		checkfield = new JTextField("",10);
		check = new JButton("Check");
		firLab = new JLabel("the");
		secLab = new JLabel("file");
		// start area
		startLab = new JLabel("Start Date");
		start = new JTextField("", 10);
		// end area
		endLab = new JLabel("End Date");
		end = new JTextField("", 10);
		// due area
	/*  dueLab = new JLabel("Due Date");
		due = new JTextField("", 10);*/
		// upload interval area
		intervalLab = new JLabel("Intervals");
		interval = new JTextField("", 4);				
		// Upload area
		upload = new JButton("Upload");
		//layout
		this.setTitle("Upload");
		this.setBounds(300, 100, 700, 600);
		this.setLayout(new GridBagLayout());

		// Add components into frame
		GridBagConstraints c = new GridBagConstraints();
		//display area
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; 
		c.gridy = 0;
		c.gridwidth = 8;
		c.gridheight = 2;
		this.add(disLabel, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0; 
		c.gridy = 2;
		c.gridwidth = 8;
		c.gridheight = 8;
		c.weightx = 0;
		c.weighty = 0;
		this.add(display, c);
		//show area
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; 
		c.gridy = 10;
		c.gridwidth = 8;
		c.gridheight = 2;
		this.add(showLabel, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0; 
		c.gridy = 12;
		c.gridwidth = 8;
		c.gridheight = 8;
		c.weightx = 0;
		c.weighty = 0;
		this.add(showarea, c);
		//open button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; 
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.add(open, c);
		//clear button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 10; 
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.add(clear, c);
		//check area
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; 
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		this.add(check, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 9; 
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		this.add(firLab, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 10; 
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.ipadx = 30;
		this.add(checkfield, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 11; 
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		this.add(secLab, c);
	
		//start date
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; 
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 2;
		this.add(startLab, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 9; 
		c.gridy = 6;
		c.gridwidth = 3;
		c.gridheight = 2;
		this.add(start, c);
		//end date
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; 
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.add(endLab, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 9; 
		c.gridy = 8;
		c.gridwidth = 3;
		c.gridheight = 2;
		this.add(end, c);
		//interval
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; 
		c.gridy = 10;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.add(intervalLab, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 9; 
		c.gridy = 10;
		c.gridwidth = 3;
		c.gridheight = 2;
		this.add(interval, c);
		//upload 
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.RELATIVE;
		c.gridx = 8; 
		c.gridy = 18;
		c.gridwidth = 4;
		c.gridheight = 2;
		this.add(upload, c);


/*		//make due date
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 9; 
		c.gridy = 8;
		c.gridwidth = 1;
		this.add(dueLab, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		c.gridx = 8; 
		c.gridy = 9;
		c.gridwidth = 2;
		this.add(due, c);
*/


		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myEvent();
	}
	
	// Event method for components
	private void myEvent() {
		// open files;
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Please choose your text files:");
				jfc.setMultiSelectionEnabled(true);//make it can select multiple files at a time
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");//txt files only
				jfc.addChoosableFileFilter(filter);
				
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					files = jfc.getSelectedFiles();
					for(int i=0;i<files.length;i++){
						if(files[i].isFile()){//tell whether it is a file or not
							fileList.add(files[i]);//add file into a new File list
							System.out.println(fileList.toString());// check every files
							display.append("("+fileList.size()+")"+" "+files[i].getName()+'\n');//display the order number and filename
						}
					}
					
				}					
			}
		});
		//clear files
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				display.setText(null);
				showarea.setText(null);
				fileList.clear();
			}
		});
		//check the file
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showarea.setText(null);
				int intfile = Integer.parseInt(checkfield.getText()) + 1;//Convert input string to integer,and make it plus one to be actual number of file
				try {
					BufferedReader bufr = new BufferedReader(new FileReader(fileList.get(intfile)));
					String line = null;
					while ((line = bufr.readLine()) != null) {
						showarea.append(line + "\r\n");
					}
					bufr.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		//upload event listener
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}

	
	
	public static void main(String[] args) throws IOException { 
 		UploadGUI java = new UploadGUI();

	}
}