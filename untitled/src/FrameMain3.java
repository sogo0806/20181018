import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameMain3 extends JFrame {
    private JMenuBar jbr = new JMenuBar();
    private JMenu jfile = new JMenu("File");
    private JMenu jgame = new JMenu("Game");
    private JMenu jabout = new JMenu("About");
    private JMenu jatool = new JMenu("Tool");
    private JMenuItem iopen = new JMenuItem("Open");
    private JMenuItem iclose = new JMenuItem("Close");
    private JMenuItem iexit = new JMenuItem("Exit");
    private JMenuItem iox = new JMenuItem("OX");
    private JMenuItem iencrypt = new JMenuItem("Encrypt");
    public FrameMain3(){
        init();
    }

    public void init(){
        this.setBounds(200,200,500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setJMenuBar(jbr);
        jbr.add(jfile);
        jbr.add(jgame);
        jbr.add(jabout);
        jbr.add(jatool);
        jfile.add(iopen);
        jfile.add(iclose);
        jfile.add(iexit);
        jgame.add(iox);
        jatool.add(iencrypt);

        iox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain4 fr = new FrameMain4(FrameMain3.this);
                fr.setVisible(true);
                FrameMain3.this.setVisible(false);
            }
        });


        iexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        iencrypt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain5 fr = new FrameMain5(FrameMain3.this);
                fr.setVisible(true);
                FrameMain3.this.setVisible(false);
            }
        });
    }
}
