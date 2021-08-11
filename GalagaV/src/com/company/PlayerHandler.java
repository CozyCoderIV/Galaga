package com.company;

import java.awt.*;
import java.util.ArrayList;

public class PlayerHandler // Un-used Class
{   // Attributes
    Player player;
    public static ArrayList<Player> playerList = new ArrayList<>();

    // Constructor
    public PlayerHandler()
    {   addPlayer(new Player(250, 560));
    }
    // Methods
    public void addPlayer(Player player)
    {   playerList.add(player);
    }
    public void removePlayer(Player player)
    {   playerList.remove(player);
    }
    public void update()
    {   for(int i = 0; i< playerList.size(); i++)
        {   player = playerList.get(i);
            player.update();
        }
    }
    public void draw(Graphics2D g2d)
    {   for(int i = 0; i < playerList.size(); i++)
        {   player = playerList.get(i);
            player.draw(g2d);
        }
    }
}
