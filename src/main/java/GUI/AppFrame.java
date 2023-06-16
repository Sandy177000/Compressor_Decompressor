package GUI;

import comp_decomp.comp;
import comp_decomp.decomp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;
    AppFrame(String name){
        //set the window title
        this.setTitle(name);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        // panel for the heading inside the window
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(56, 119, 217)); // Set background color 135, 206, 235 sky-blue
        headingPanel.setPreferredSize(new Dimension(getWidth(),40));
        // label for the heading
        JLabel headingLabel = new JLabel("Compressor-Decompressor");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setForeground(Color.white); // Set text color
        headingPanel.add(headingLabel); // Add the heading label to the heading panel

        JPanel buttonPanel = new JPanel(); // Create a panel for the buttons
        buttonPanel.setBackground(new Color(150,150,255)); // Set background color
        buttonPanel.setPreferredSize(new Dimension(getWidth(),270)); // Set preferred size

        compressButton = new JButton("Select file to compress");
        decompressButton = new JButton("Select file to decompress");
        compressButton.setBackground(new Color(203, 214, 255)); // Set button background color
        decompressButton.setBackground(new Color(203, 214, 255)); // Set button background color
        compressButton.setForeground(new Color(50,50,100)); // Set button text color
        decompressButton.setForeground(new Color(50,50,100)); // Set button text color


        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        c.add(headingPanel, BorderLayout.NORTH); // Add the heading panel to the top
        c.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center

        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        this.setSize(500, 300);
        this.setResizable(false);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(Color.white); // Set background color for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);



    }


    //Overiding the actionPerformed method from the ActionListener interface
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    comp.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decomp.method(file);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }

}
