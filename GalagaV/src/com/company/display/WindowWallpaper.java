package com.company.display;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

public class WindowWallpaper extends LayerUI<JComponent>
{   @Override
    public void paint(Graphics g, JComponent c)
    {   super.paint(g, c);

        Graphics2D g2 = (Graphics2D) g.create();

        int w = c.getWidth();
        int h = c.getHeight();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .99f));
        g2.setPaint(new GradientPaint(0, 0, new Color(13, 13, 30), 0, h, Color.black));
        g2.fillRect(0, 0, w, h);
        g2.dispose();
    }
}
