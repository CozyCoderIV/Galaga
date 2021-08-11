package com.company.display;

import com.company.Game;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Window extends JFrame implements ActionListener
{   // Attributes
    HomePanel homepanel;
    ImageIcon himg = new ImageIcon("src/com/company/images/GalagaIco.png");;
    JLabel hmg = new JLabel(himg);
    JLabel homeTitle;
    JButton start;
    JMenuBar homemenu = new JMenuBar();
    JMenu home, instructions, extras;
    JMenuItem instruct, credits, back;

    Game galaga;
    GamePanel galagaPanel;
    Creditpanel creditpanel;
    InstructPanel instructPanel;

    // Constructor
    public Window(String title, int width, int height)
    {   this.setSize(width, height);
        this.setTitle(title);
        createUI();
    }

    // Methods
    public void createUI()
    {   JPanel panel = new JPanel();
        LayerUI<JComponent> layerUI = new WindowWallpaper();
        JLayer<JComponent> jlayer = new JLayer<JComponent>(panel, layerUI);

        addHomeMenu();
        addHomePanel();
        addHomeImage();
        addStartButton();
        addHomeTitle();
        addGamePanel();
        addCreditPanel();
        addInstructPanel();
        addGame();
        this.add(jlayer);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void addHomePanel() // Adds Home Screen Panel
    {   homepanel = new HomePanel(760, 670);
        homepanel.setLocation(70, 40);
        this.add(homepanel);

    }
    public void addHomeImage() // Adds Home Screen Image
    {   hmg.setVisible(true);
        hmg.setBounds(110, 30, 530, 540);
        homepanel.add(hmg);
    }
    public void addStartButton() // Adds Home Screen Button
    {   start = new JButton();
        start.addActionListener(this);
        start.setText("Start".toUpperCase(Locale.ROOT));
        start.setSize(180, 40);
        start.setLocation(295, 600);
        start.setVisible(true);
        start.setBorder(BorderFactory.createLineBorder(Color.white));
        start.setForeground(Color.white);
        start.setBackground(new Color(40,10,29));
        homepanel.add(start);
    }
    public void addHomeTitle() // Adds Home Screen Title
    {   homeTitle = new JLabel("Galaga V  '1.6.0 BreakOut Edition'");
        homeTitle.setVisible(true);
        homeTitle.setBounds(215, 20, 390, 30);
        homeTitle.setFont(new Font(null, Font.BOLD, 22));
        homeTitle.setForeground(Color.white);
        homepanel.add(homeTitle);
    }
    public void addHomeMenu()  // Adds Home Screen Menu
    {   homemenu.setBackground(Color.black);
        this.setJMenuBar(homemenu);

        home = new JMenu("HOME");
        home.setForeground(Color.gray);
        back = new JMenuItem();
        back.setText("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.darkGray);
        back.addActionListener(this);
        back.setVisible(false);
        home.add(back);
        //home.add(newgame);
        //home.add(shipselect);

        instructions = new JMenu("HOW TO PLAY");
        instruct = new JMenuItem();
        instruct.setText("INSTRUCTIONS");
        instruct.setForeground(Color.darkGray);
        instruct.setBackground(Color.black);
        instruct.addActionListener(this);
        instructions.add(instruct);

        extras = new JMenu("EXTRAS");
        credits = new JMenuItem();
        credits.setText("CREDITS");
        credits.setForeground(Color.darkGray);
        credits.setBackground(Color.black);
        credits.addActionListener(this);
        extras.add(credits);
        //extras.add(credits);
        //extras.add(instruct);

        homemenu.add(home);
        homemenu.add(instructions);
        homemenu.add(extras);
    }
    public void addGame() // Adds Game To Home Screen
    {   galaga = new Game();
        galaga.setLocation(68, 40);
        galaga.setVisible(true);
        galagaPanel.add(galaga);
    }
    public void addGamePanel() // Adds Game Panel to Home Screen
    {   galagaPanel = new GamePanel(865, 680);
        galagaPanel.setVisible(false);
        galagaPanel.setLocation(10, 40);
        this.add(galagaPanel);
    }
    public void addCreditPanel() // Adds Credit Panel to Home Screen
    {   creditpanel = new Creditpanel(760, 670);
        creditpanel.setVisible(false);
        creditpanel.setLocation(70, 40);
        this.add(creditpanel);
    }
    public void addInstructPanel() // Adds Instruction Panel to Home Screen
    {   instructPanel = new InstructPanel(760, 670);
        instructPanel.setVisible(false);
        instructPanel.setLocation(70, 40);
        this.add(instructPanel);
    }
    public GamePanel getGalagaPanel()
    {   return galagaPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {   if (start == e.getSource())
        {   homepanel.setVisible(false);
            galagaPanel.setVisible(true);
            extras.setVisible(false);
            instructions.setVisible(false);
            galaga.start();
        }
        if (instruct == e.getSource())
        {   homepanel.setVisible(false);
            galagaPanel.setVisible(false);
            creditpanel.setVisible(false);
            instructPanel.setVisible(true);
            back.setVisible(true);

            instructions.setForeground(Color.gray);
            home.setForeground(Color.darkGray);
            extras.setForeground(Color.darkGray);
        }
        if (credits == e.getSource())
        {   homepanel.setVisible(false);
            galagaPanel.setVisible(false);
            instructPanel.setVisible(false);
            creditpanel.setVisible(true);
            back.setVisible(true);

            extras.setForeground(Color.gray);
            home.setForeground(Color.darkGray);
            instructions.setForeground(Color.darkGray);

        }
        if (back == e.getSource())
        {   galagaPanel.setVisible(false);
            instructPanel.setVisible(false);
            creditpanel.setVisible(true);
            back.setVisible(false);
            homepanel.setVisible(true);

            extras.setForeground(Color.darkGray);
            instructions.setForeground(Color.darkGray);
            home.setForeground(Color.gray);
        }

    }
}
