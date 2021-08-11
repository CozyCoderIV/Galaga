package com.company.display;

import javax.swing.*;
import java.awt.*;

public class InstructPanel extends JPanel
{   // Attributes
    String i1, i2, i3, i4, i5;
    JLabel title, ins1, ins2, ins3, ins4, ins5;
    ImageIcon i = new ImageIcon("src/com/company/images/Galaga1(512x512).png");
    JLabel img;

    // Constructor
    public InstructPanel(int width, int height)
    {   this.setSize(width, height);
        this.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.white));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);

        addTitle();
        addInstructions();
        addImage();
    }

    // Methods
    public void addTitle()
    {   title = new JLabel();
        title.setVisible(true);
        title.setForeground(Color.white);
        title.setText("*** Instructions ***");
        title.setFont(new Font(null, Font.BOLD, 22));
        title.setBounds(285, 25, 200, 30);
        this.add(title);
    }
    public void addInstructions()
    {   i1 = "First Left Click The SpaceShip (Once)";
        i2 = "Move Left <- (Left Arrow)";
        i3 = "(Right Arrow) -> Move Right";
        i4 = "(Up Arrow) -> Stop Movement";
        i5 = "(SpaceBar) -> Shoot Laser";

        ins1 = new JLabel(i1);
        ins1.setVisible(true);
        ins1.setForeground(Color.orange);
        ins1.setBounds(235, 100, 290, 50);
        ins1.setFont(new Font(null, Font.BOLD, 16));
        this.add(ins1);

        ins2 = new JLabel(i2);
        ins2.setVisible(true);
        ins2.setForeground(Color.white);
        ins2.setBounds(90, 280, 250, 50);
        ins2.setFont(new Font(null, Font.BOLD, 16));
        this.add(ins2);

        ins3 = new JLabel(i3);
        ins3.setVisible(true);
        ins3.setForeground(Color.white);
        ins3.setBounds(480, 280, 250, 50);
        ins3.setFont(new Font(null, Font.BOLD, 16));
        this.add(ins3);

        ins4 = new JLabel(i4);
        ins4.setVisible(true);
        ins4.setForeground(Color.white);
        ins4.setBounds(260, 170, 250, 50);
        ins4.setFont(new Font(null, Font.BOLD, 16));
        this.add(ins4);

        ins5 = new JLabel(i5);
        ins5.setVisible(true);
        ins5.setForeground(Color.white);
        ins5.setBounds(275, 420, 250, 50);
        ins5.setFont(new Font(null, Font.BOLD, 16));
        this.add(ins5);

    }
    public void addImage()
    {   img = new JLabel(i);
        img.setBounds(110, 40, 530, 540);
        this.add(img);
    }
}
