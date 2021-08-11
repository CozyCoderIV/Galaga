package com.company.display;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{   // Constructor
    public GamePanel(int width, int height)
    {   this.setSize(width, height);
        this.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.WHITE));
        this.setBackground(Color.darkGray);
    }



}
