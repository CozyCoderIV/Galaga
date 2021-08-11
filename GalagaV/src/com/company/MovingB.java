package com.company;

import javax.swing.*;
import java.awt.*;

public class MovingB
{   // Attributes
    protected int x;
    protected int y;
    public int VelY = 10;

    // Constructor
    public MovingB(int x, int y)
    {   this.x = x;
        this.y = y;
    }

    // Methods
    public int getX()
    {   return x;
    }
    public int getY()
    {   return y;
    }
    public int getVelY()
    {   return VelY;
    }
    public void draw(Graphics2D g2d)
    {   // Draw Moving Background
        g2d.drawImage(getImage(), x, y, null);
    }
    public void update()
    {   y += VelY;

        if(y > 50)
        {   y = -30;
        }
    }
    public Image getImage()
    {   Image pimg = new ImageIcon("src/com/company/images/space_edited (1).png").getImage();
        return pimg;
    }

}
