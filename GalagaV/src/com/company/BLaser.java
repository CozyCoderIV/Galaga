package com.company;

import java.awt.*;

public interface BLaser
{   void shootELaser(Boss boss);
    Image getELaserImage();
    void drawELaser(Graphics2D g2d);
    void getEnemyVelocity2();
    Rectangle getELaserBounds();
}
