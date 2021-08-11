package com.company;

import javax.swing.*;
import java.awt.*;

public class Enemy implements Laser
{   // Attributes
    protected int x;
    protected int y;
    public int speed = 3;
    protected int health;
    protected int damage;


    // Laser Attributes
    int velX = 2;
    int velY = 4;
    int eLaserX = x + 60;
    int eLaserY = y + 79;

    // Constructor
    public Enemy(int x, int y)
    {   this.x = x;
        this.y = y;
        this.health = 75;
        this.damage = 15;
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
    public int geteLaserX()
    {   return eLaserX;
    }
    public int geteLaserY()
    {   return eLaserY;
    }
    public void update()
    {   x += speed;
        if(x > 540)
        {   speed = -3;
        } else if(x < -60)
        {   speed = 3;
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
    {   Image pimg = new ImageIcon("src/com/company/images/aliev.png").getImage();
        return pimg;
    }
    public Rectangle getBounds()
    {   return new Rectangle(x + 68, y + 50, 50, 50); // creates rectangle around player
    }

    // Laser Methods
    @Override
    public void shootELaser(Enemy enemy)
    {   eLaserX += velX;
        eLaserY += velY;

        if(eLaserY > this.y){  velX = 0;}
        if (eLaserY > 670)
        {   eLaserY = getY() + 79;
            eLaserX = getX();
            getEnemyVelocity2();
        }
        if (eLaserX > 500) {    velX = -3;}
        if (eLaserX < -30) {    velX = 3;}

    }

    @Override
    public Image getELaserImage()
    {   Image pimg = new ImageIcon("src/com/company/images/purplebeam.png").getImage();
        return pimg;
    }

    @Override
    public void drawELaser(Graphics2D g2d)
    {   g2d.drawImage(getELaserImage(), eLaserX, eLaserY, null);
        g2d.draw(getELaserBounds());
    }

    @Override
    public void getEnemyVelocity2()
    {   velX += this.getSpeed();
    }

    @Override
    public Rectangle getELaserBounds()
    {   return new Rectangle(eLaserX+23, eLaserY+18, 15, 15);
    }

    @Override
    public void Collision(Player player)
    {   if (getELaserBounds().intersects(player.getBounds()))
        {   player.health -= damage;
        }
    }

}
