package com.company;

import java.awt.*;

public class Helathbar
{   // Attributes
    int x;
    int y;

    // Constructor
    public Helathbar(int x, int y)
    {   this.x = x;
        this.y = y;


    }

    // Methods
    public void draw(Graphics2D g2d)
    {   g2d.setColor(Color.red);
        g2d.drawRect(x+1, y+1, 178, 25);
        g2d.fillRect(x+1, y+1, 178, 25);
    }
    public void update(Player p1, Graphics2D g2d)
    {   if (p1.health <= 80)
        {   g2d.fillRect(x, y, 80, 20);
        }
        if (p1.health <= 60)
        {   g2d.fillRect(x, y, 60, 20);
        }
        if (p1.health <= 40)
        {   g2d.fillRect(x, y, 40, 20);
        }
        if (p1.health <= 20)
        {   g2d.fillRect(x, y, 20, 20);
        }
        if (p1.health <= 10)
        {   g2d.fillRect(x, y, 10, 20);
        }
    }
}
