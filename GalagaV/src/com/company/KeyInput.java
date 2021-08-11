package com.company;

import com.company.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter implements KeyListener // Un-used Class
{   // Attributes
    private Player p1;
    private boolean left = false;
    private boolean right = false;

    // Constructor
    public KeyInput(Player p1)
    {   this.p1 = p1;
    }

    // Methods
    public void keyPressed(KeyEvent e)
    {   int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
        {   p1.switchDirection(-1);
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT)
        {   p1.switchDirection(1);
            right = true;
        }
        if (key == KeyEvent.VK_UP)
        {   p1.stop();
        }
    }
    public void keyReleased(KeyEvent e)
    {    int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
        {   p1.switchDirection(-1);
            p1.velX = -9;
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT)
        {   p1.switchDirection(1);
            p1.velX = 9;
            right = false;
        }

    }
}
