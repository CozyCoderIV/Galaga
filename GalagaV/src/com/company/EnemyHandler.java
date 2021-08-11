package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class EnemyHandler
{   // Attributes
    Enemy etemp;
    Boss btemp;
    Player player;

    public static LinkedList <Enemy> enemylist = new LinkedList();
    public static ArrayList <Boss> bossList = new ArrayList();
    //public static ArrayList<Player> playerList = new ArrayList<>();
    PlayerHandler ph = new PlayerHandler();

    // Constructor
    public EnemyHandler()
    {   addEnemy(new Enemy(10, 100));
        addEnemy(new Enemy(200, 200));
        addEnemy(new Enemy(400, 300));
        addEnemy(new Enemy(600, 150));
        addBoss(new Boss(250, 100));
    }

    // Control Methods

    // Enemy Methods
    public void drawEnemy(Graphics2D g2d)
    {   for(int i = 0; i < enemylist.size(); i++)
        {   etemp = enemylist.get(i);
            etemp.draw(g2d);
        }
    }
    public void updateEnemy()
    {   for(int i = 0; i < enemylist.size(); i++)
        {   etemp = enemylist.get(i);
            etemp.update();

            if (etemp.health < 0)
            {   removeEnemy(etemp);
            }
        }
        reset();
    }
    public void addEnemy(Enemy enemy)
    {   enemylist.add(enemy);
    }
    public void removeEnemy(Enemy enemy)
    {   enemylist.remove(enemy);
    }

    public static LinkedList<Enemy> getEnemyBounds()
    {   return enemylist;
    }

    public static ArrayList<Boss> getBossBounds()
    {   return bossList;
    }

    // Boss Methods
    public void drawBoss(Graphics2D g2d)
    {   for(int i = 0; i < bossList.size(); i++)
        {   btemp = bossList.get(i);
            btemp.draw(g2d);
        }
    }
    public void updateBoss()
    {   for(int i = 0; i < bossList.size(); i++)
        {   btemp = bossList.get(i);
            btemp.update();

            if (btemp.health < 0)
            {   removeBoss();
            }
        }
    }
    public void addBoss(Boss boss)
    {   bossList.add(boss);
    }
    public void removeBoss()
    {   bossList.remove(0);
    }

    public void reset()
    {   if (enemylist.size() == 0)
        {   for(int i = 0; i < 3; i++)
            {   addEnemy(new Enemy(10, 100));
                addEnemy(new Enemy(200, 200));
                addEnemy(new Enemy(400, 300));
                addEnemy(new Enemy(600, 150));
            }
        }
    }


}
