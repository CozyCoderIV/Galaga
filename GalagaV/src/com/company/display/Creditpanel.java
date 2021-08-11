package com.company.display;

import javax.swing.*;
import java.awt.*;

public class Creditpanel extends JPanel
{   // Attributes
    JLabel title, credit1, credit2, credit3, credit4, credit5;
    String thx, spc, as, fbp, socials;
    JButton back;
    ImageIcon gimg = new ImageIcon("src/com/company/images/Shinobi4_edited_4_15.jpg");
    JLabel ssimg;

    // Constructor
    public Creditpanel(int width, int height)
    {   this.setSize(width, height);
        this.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.white));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);

        addTitle();
        addCredits();
        addImage();

    }

    // Methods
    public void addTitle()
    {   title = new JLabel();
        title.setVisible(true);
        title.setForeground(Color.white);
        title.setText("*** CREDITS ***");
        title.setFont(new Font(null, Font.BOLD, 22));
        title.setBounds(315, 25, 160, 30);
        this.add(title);
    }
    public void addImage()
    {   ssimg = new JLabel(gimg);
        ssimg.setBounds(400, 310, 310, 310);
        ssimg.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.CYAN));
        ssimg.setVisible(true);
        this.add(ssimg);
    }
    public void addButton()
    {   back = new JButton();
        //back.addActionListener(this);
        back.setSize(60, 30);
        back.setLocation(140, 300);
        back.setBorder(BorderFactory.createLineBorder(Color.white));
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.setText("BACK");
        this.add(back);
    }
    public void addCredits()
    {   thx = "Thank You For Playing!!!!";
        spc = "_________________________";
        as = "(Artwork/Sprites) By: Otis Jackson IV";
        fbp = "(FrontEnd/BackEnd) Programming By: Otis Jackson IV";
        socials = "(Instagram) --> 4th_of_my_kin && spiritedshinobi";
        /*credits.setText(String.format("%s \n\n %s \n %s \n %s", thx, as, fbp, socials));
        credits.setBounds(200, 150, 300, 100);
        credits.setBorder(BorderFactory.createLineBorder(Color.blue));
        credits.setVisible(true);*/

        credit1 = new JLabel(thx);
        credit1.setVisible(true);
        credit1.setForeground(Color.white);
        credit1.setBounds(140, 100, 210, 50);
        credit1.setFont(new Font(null, Font.BOLD, 16));
        this.add(credit1);

        credit2 = new JLabel(spc);
        credit2.setVisible(true);
        credit2.setForeground(Color.white);
        credit2.setBounds(140, 115, 230, 50);
        credit2.setFont(new Font(null, Font.BOLD, 16));
        this.add(credit2);

        credit3 = new JLabel(as);
        credit3.setVisible(true);
        credit3.setForeground(Color.white);
        credit3.setBounds(140, 150, 310, 50);
        credit3.setFont(new Font(null, Font.BOLD, 16));
        this.add(credit3);

        credit4 = new JLabel(fbp);
        credit4.setVisible(true);
        credit4.setForeground(Color.white);
        credit4.setBounds(140, 180, 460, 50);
        credit4.setFont(new Font(null, Font.BOLD, 16));
        this.add(credit4);

        credit5 = new JLabel(socials);
        credit5.setVisible(true);
        credit5.setForeground(Color.white);
        credit5.setBounds(140, 210, 400, 50);
        credit5.setFont(new Font(null, Font.BOLD, 16));
        this.add(credit5);
    }


}
