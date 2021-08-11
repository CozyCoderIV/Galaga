package com.company;

import java.awt.*;

public interface Laser
{   void shootELaser(Enemy enemy);
    Image getELaserImage();
    void drawELaser(Graphics2D g2d);
    void getEnemyVelocity2();
    Rectangle getELaserBounds();
    void Collision(Player player);
}
