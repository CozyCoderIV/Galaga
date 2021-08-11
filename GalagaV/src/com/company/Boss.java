package com.company;

import javax.swing.*;
import java.awt.*;

public class Boss implements BLaser
{   // Attributes
    protected int x;
    protected int y;
    public int speed = 2;
    protected int health;
    protected int damage;

    // Laser Attributes
    int blvelX = 2;
    int blvelY = 4;
    int blx = getX();
    int bly = getY();

    // Constructor
    public Boss(int x, int y)
    {   this.x = x;
        this.y = y;
        this.health = 350;
        this.damage =  25;
    }

    // Methods
    public int getX()
    {   return x;
    }
    public int getY()
    {   return y;
    }
    public int getSpeed()
    {   return speed;
    }
    public void update()
    {   x += speed;
        if(x > 540)
        {   speed = -2;
        } else if(x < -60)
        {   speed = 2;
        }

        shootELaser(this);
    }
    public void draw(Graphics2D g2d)
    {   g2d.drawImage(getImage(), x, y, null);
        g2d.draw(getBounds());
        drawELaser(g2d);
        g2d.draw(getELaserBounds());
    }
    public void tookDamage(Player player)
    {   this.health -= 15;
    }
    public Image getImage()
    {   Image pimg = new ImageIcon("src/com/company/images/Alien Boss(192x192).png").getImage();
        return pimg;
    }
    public Rectangle getBounds()
    {   return new Rectangle(x + 68, y + 50, 50, 50); // creates rectangle around player
    }

    // Laser Methods
    @Override
    public void shootELaser(Boss boss)
    {   blx += blvelX;
        bly += blvelY;

        if(bly > this.y){blvelX = 0;}
        if(bly > 670)
        {   bly = getY();
            blx = getX();
            getEnemyVelocity2();
        }
        if(blx > 500){blvelX = -2;}
        if(blx < 0){blvelX = 2;}
    }

    @Override
    public Image getELaserImage()
    {   Image pimg = new ImageIcon("src/com/company/images/Alien Boss Shot(192x192).png").getImage();
        return pimg;
    }

    @Override
    public void drawELaser(Graphics2D g2d)
    {   g2d.drawImage(getELaserImage(), blx, bly, null);
        g2d.draw(getELaserBounds());
    }

    @Override
    public void getEnemyVelocity2()
    {    blvelX += this.getSpeed();
    }

    @Override
    public Rectangle getELaserBounds()
    {   return new Rectangle(blx + 73, bly + 115, 20, 20);
    }


}
