package com.company;
import javax.swing.*;
import java.awt.*;


public class Player
{   // Attributes
    protected int x;
    protected int y;
    public int velX = 0;
    public int speed = 9;
    protected int score;
    protected int health;
    protected int damage;
    protected Helathbar bar;

    // Constructor
    public Player(int x, int y)
    {   this.x = x;
        this.y = y;
        this.health = 100;
        this.damage = 25;
        this.score = 0;
    }

    // Methods
    public int getX() // Gets X Position
    {   return x;
    }
    public int getY() // Gets Y Position
    {   return y;
    }
    public int getVelX() // Gets Velocity
    {   return velX;
    }
    public int getPlayerHealth() // Gets Player Health
    {   return health;
    }
    public Image getPlayerImage() // Gets Player Image
    {   Image pimg = new ImageIcon("src/com/company/images/GalagaD.png").getImage();
        return pimg;
    }
    public Rectangle getBounds() // Get Hit Box
    {   return new Rectangle(x + 40, y + 40, 50, 50); // creates rectangle around player
    }
    public void draw(Graphics2D g2d) // Draws Player and Score
    {   // Draw Player
        g2d.drawImage(getPlayerImage(), x, y, null);
        g2d.draw(getBounds());

        // Draw Score Title
        String scoreTitle = "Score";
        Font stfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(stfont);
        g2d.drawString(scoreTitle, Game.WIDTH - 200, 30);

        // Draw Score
        int stringx;
        String scoreText = Integer.toString(score);
        Font font = new Font("MV Boli", Font.BOLD, 25);

        int stringWidth = g2d.getFontMetrics(font).stringWidth(scoreText)+1;
        int padding = 15; // distance between center line and each score

        stringx = (Game.WIDTH * 3/4) + padding;

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(scoreText, stringx, 58);

        // Draw Health Title
        String healthTitle = "Health";
        Font hfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(hfont);
        g2d.drawString(healthTitle, Game.WIDTH - 200, 110);


        // Draw Health Bar
        g2d.setColor(Color.white);
        g2d.drawRect(660, 117, 180, 30);
        g2d.setColor(new Color(95, 30, 0));
        g2d.fillRect(660, 117, 180, 30);
        bar = new Helathbar(660, 117);

        bar.draw(g2d);

        bar.update(this, g2d);

        // Draw Health
        int stringh;
        String healthText = Integer.toString(health);
        Font nfont = new Font("MV Boli", Font.BOLD, 25);

        int padding2 = 15;

        stringh = (Game.WIDTH * 3/4) + padding2;

        g2d.setFont(nfont);
        g2d.setColor(Color.WHITE);
        g2d.drawString(healthText, stringh, 140);

    }
    public void update() throws NullPointerException // Updates Player
    {   x += velX;

        // Collision Mechanics
        if (x < -30) {   velX = 9;}
        if (x > 550) {  velX = -9;}

        /*bar.update(this, new Graphics2D() {
            @Override
            public void draw(Shape s) {

            }

            @Override
            public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
                return false;
            }

            @Override
            public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {

            }

            @Override
            public void drawRenderedImage(RenderedImage img, AffineTransform xform) {

            }

            @Override
            public void drawRenderableImage(RenderableImage img, AffineTransform xform) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(String str, float x, float y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, float x, float y) {

            }

            @Override
            public void drawGlyphVector(GlyphVector g, float x, float y) {

            }

            @Override
            public void fill(Shape s) {

            }

            @Override
            public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
                return false;
            }

            @Override
            public GraphicsConfiguration getDeviceConfiguration() {
                return null;
            }

            @Override
            public void setComposite(Composite comp) {

            }

            @Override
            public void setPaint(Paint paint) {

            }

            @Override
            public void setStroke(Stroke s) {

            }

            @Override
            public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {

            }

            @Override
            public Object getRenderingHint(RenderingHints.Key hintKey) {
                return null;
            }

            @Override
            public void setRenderingHints(Map<?, ?> hints) {

            }

            @Override
            public void addRenderingHints(Map<?, ?> hints) {

            }

            @Override
            public RenderingHints getRenderingHints() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public void translate(double tx, double ty) {

            }

            @Override
            public void rotate(double theta) {

            }

            @Override
            public void rotate(double theta, double x, double y) {

            }

            @Override
            public void scale(double sx, double sy) {

            }

            @Override
            public void shear(double shx, double shy) {

            }

            @Override
            public void transform(AffineTransform Tx) {

            }

            @Override
            public void setTransform(AffineTransform Tx) {

            }

            @Override
            public AffineTransform getTransform() {
                return null;
            }

            @Override
            public Paint getPaint() {
                return null;
            }

            @Override
            public Composite getComposite() {
                return null;
            }

            @Override
            public void setBackground(Color color) {

            }

            @Override
            public Color getBackground() {
                return null;
            }

            @Override
            public Stroke getStroke() {
                return null;
            }

            @Override
            public void clip(Shape s) {

            }

            @Override
            public FontRenderContext getFontRenderContext() {
                return null;
            }

            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        });*/
    }
    public void switchDirection(int direction)
    {   velX = speed * direction;
    }
    public void stop()
    {   velX = 0;
    }


}
