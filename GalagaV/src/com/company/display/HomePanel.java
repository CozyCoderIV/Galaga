package com.company.display;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel
{   // Constructor
    public HomePanel(int width, int height)
    {   this.setSize(width, height);
        this.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.white));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
    }
}
