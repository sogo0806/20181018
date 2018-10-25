import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import java.awt.*;

public class FrameMain6 extends JFrame {
    private JLabel jlb = new JLabel("加密法");
    private JLabel jlb2 = new JLabel("Key");
    private JLabel jlb3 = new JLabel("原始檔");
    private JLabel jlb4 = new JLabel("加密檔");
    private JButton jbtn = new JButton("Run");
    private JButton jbtn2 = new JButton("Close");
    private JButton jbtn3 = new JButton("Choose");
    private JButton jbtn4 = new JButton("Choose");
    private String in[] = {"DES","CAESA","AES","XOR"};
    private JComboBox jcbox = new JComboBox<String>(in);
    private JTextField jtf = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtf3 = new JTextField();
    private JProgressBar jpb = new JProgressBar();
    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpnc = new JPanel(new GridLayout(2,2,3,3));
    private JPanel jpne = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jpnw = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jpns = new JPanel(new GridLayout(1,1,3,3));
    public FrameMain6 (){
        init();
    }
    public void init(){
        this.setBounds(100,100,500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpnn,BorderLayout.NORTH);
        cp.add(jpnc,BorderLayout.CENTER);
        cp.add(jpnw,BorderLayout.WEST);
        cp.add(jpne,BorderLayout.EAST);
        cp.add(jpns,BorderLayout.SOUTH);
        jpnn.add(jlb);
        jpnn.add(jcbox);
        jpnn.add(jlb2);
        jpnn.add(jtf);
        jpnn.add(jbtn);
        jpnn.add(jbtn2);
        jpnc.add(jtf2);
        jpnc.add(jtf3);
        jpnw.add(jlb3);
        jpnw.add(jlb4);
        jpne.add(jbtn3);
        jpne.add(jbtn4);
        jpns.add(jpb);

    }
}
