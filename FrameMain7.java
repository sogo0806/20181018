import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain7 extends JFrame {
    private JLabel jlb[] = new JLabel[8];
    private JButton jbt = new JButton("start");
    private JButton jbt2 = new JButton("reset");
    private JButton jbt3 = new JButton("close");
    private ImageIcon image[] = new ImageIcon[10];
    private String icon[] = {"0.png","1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png"};
    private JPanel jpenc = new JPanel(new GridLayout(1,8,3,3));
    private JPanel jpens = new JPanel(new GridLayout(1,3,3,3));
    private Container cp;
    private Timer t1;
    private int h , m , s;
    public FrameMain7(){
        init();
    }
    public void init(){
        this.setBounds(100,100,500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        for (int i = 0 ; i<10 ; i++){
            image [i] = new ImageIcon(icon[i]);
            Image img = image[i].getImage();
            Image imgst = img.getScaledInstance(30,50, Image.SCALE_SMOOTH);
            image [i] = new ImageIcon(imgst);
        }
        jlb[6] = new JLabel(":");
        jlb[6].setFont(new Font(null,Font.BOLD,28));
        jlb[7] = new JLabel(":");
        jlb[7].setFont(new Font(null,Font.BOLD,28));
        for (int i = 0 ; i < 6 ; i++){
            jlb[i] = new JLabel(image[0]);
            if (i==2){
                jpenc.add(jlb[6]);
                jpenc.add(jlb[i]);
            }else if (i==4){
                jpenc.add(jlb[7]);
                jpenc.add(jlb[i]);
            }else {
                jpenc.add(jlb[i]);
            }
        }


        t1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s++;
                if (s==60){
                    s=0;
                    m++;
                    if (m==60){
                        m=0;
                        h++;
                    }
                }
                if ((s%2)==0){
                    jlb[6].setForeground(Color.BLACK);
                    jlb[7].setForeground(Color.BLACK);
                }else {
                    jlb[6].setForeground(Color.blue);
                    jlb[7].setForeground(Color.blue);
                }
                jlb[5].setIcon(image[s%10]);
                jlb[4].setIcon(image[s/10]);
                jlb[3].setIcon(image[m%10]);
                jlb[2].setIcon(image[m/10]);
                jlb[1].setIcon(image[h%10]);
                jlb[0].setIcon(image[h/10]);
            }
        });

        cp.add(jpens,BorderLayout.SOUTH);
        cp.add(jpenc,BorderLayout.CENTER);
        jpens.add(jbt);
        jpens.add(jbt2);
        jpens.add(jbt3);


        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton)e.getSource();
                if (tmp.getText().equals("start")){
                    t1.start();
                    jbt.setText("pause");
                }else {
                    t1.stop();
                    jbt.setText("start");
                }
            }
        });
    }
}
