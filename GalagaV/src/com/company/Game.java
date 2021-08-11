package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener
{   // Attributes
    public static final int WIDTH = 860;
    public static final int HEIGHT = 670;

    public boolean running = true;
    private Thread gameThread;

    protected Player player1;
    private PlayerLaser plaser;
    private MovingB mb;
    private EnemyHandler eh;
    private PlayerHandler ph;
    private Helathbar bar;

    // Constructor
    public Game()
    {   canvasSetUp();
        init();
    }

    // Methods
    public void draw() // Draws Game
    {   // Initialize Drawing Tools
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null)
        {   this.createBufferStrategy(5);
            return;
        }

        Graphics g = buffer.getDrawGraphics();
        Graphics2D g3d = (Graphics2D) buffer.getDrawGraphics();

        // Draw Background
        drawBackground(g);

        // Draw Moving Background
        mb.draw(g3d);

        // Draw Enemy Handler
        eh.drawEnemy(g3d);
        eh.drawBoss(g3d);

        // Draw Player Laser
        plaser.draw(g3d);

        // Draw Player && Score
        player1.draw(g3d);
        //ph.draw(g3d);

        // Draw Health Bar

        // Dispose -> Actually Draws (Puts Things On Screen)
        g.dispose();
        g3d.dispose();
        buffer.show();

    }
    public void update() // Updates Game
    {   // Update Player
        player1.update();
        plaser.update(player1);
        mb.update();

        eh.updateEnemy();
        eh.updateBoss();

        //ph.update();
    }

    @Override
    public void run() // Game Loop -> (Runs Game)
    {   // Game Loop
        final int MAX_fps = 60;
        final int MAX_ups = 60;

        final double F_Optimal = 1000000000/ MAX_fps;
        final double U_Optimal = 1000000000/ MAX_ups;

        double fDeltaTime = 0;
        double uDeltaTime = 0;

        long startTime = System.nanoTime();


        while(running)
        {   // Calaculate difference in time
            long currentTime = System.nanoTime();
            uDeltaTime += (currentTime - startTime);
            fDeltaTime += (currentTime - startTime);
            startTime = currentTime;

            if (uDeltaTime >= U_Optimal)
            {   update();
                uDeltaTime -= U_Optimal;
            }
            if (fDeltaTime >= F_Optimal)
            {   draw();
                fDeltaTime -= F_Optimal;
            }
            if  (player1.health < 0)
            {   System.out.println("Game Over: " + player1.score);
                running = false;
                return;
            }
        }
    }
    public void start() // Start Game Thread
    {   gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }
    public void stop() // Stops Game Thread
    {    try {
            gameThread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void init() // Instantiates Game Objects
    {   // Initialize Player
        player1 = new Player(250, 560);
        //ph = new PlayerHandler();

        // Initialize Laser
        plaser = new PlayerLaser(player1.x, player1.y+9);

        // Initialize Enemy Handler
        eh = new EnemyHandler();

        // Initialize MovingB
        mb = new MovingB(0, 0);

        // Initialize Health Bar
        bar = new Helathbar(660, 117);
    }
    public void canvasSetUp() // Sets Up Base Canvas
    {   this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    public void drawBackground(Graphics g) // Draws Canvas Background
    {   // space space
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Image bimg = new ImageIcon("src/com/company/images/space_edited (1).png").getImage();
        g.drawImage(bimg,0, 0, this);
    }
    public Player getPlayer1()
    {   return player1;
    }
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e) // Player Input
    {   switch (e.getKeyCode())
        {   case 37: // Left
                //ph.player.velX = -9;
                player1.velX = -9;
                plaser.laserMovement(player1);
                break;
            case 39: // Right
                //ph.player.velX = 9;
                player1.velX = 9;
                plaser.laserMovement(player1);
                break;
            case 38: // Up
                //ph.player.velX = 0;
                player1.velX = 0;
                plaser.laserMovement(player1);
                break;
            case 32: // Space -> (Shoot)
                plaser.velY = -70;
                plaser.velX = 0;
        }
        //System.out.println("you pressed key code: " + e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e){
    }
}
