import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameMain2 extends JFrame{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenw = screenSize.width;
    private int screenh = screenSize.height;
    private int frw = 300 , frh = 120 ;
    private Container cp;
    private JPanel jpnc = new JPanel(new GridLayout(2,2,3,3));
    private JPanel jpns = new JPanel(new GridLayout(1,3,3,3));
    private JButton jbt = new JButton("keybord");
    private JButton jbt2 = new JButton("login");
    private JButton jbt3 = new JButton("exit");
    private JLabel jlb = new JLabel("ID:");
    private JLabel jlb2 = new JLabel("PW:");
    private JTextField jf = new JTextField();
    private JPasswordField jp = new JPasswordField();
    public FrameMain2(){
        init();
    }

    public void init(){
        this.setBounds(screenw/2-frw/2,screenh/2-frh/2,frw,frh);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());


        jlb.setBounds(20,10,20,10);
        jlb2.setBounds(20,30,20,10);
        jf.setBounds(50,10,20,10);
        jp.setBounds(50,30,20,10);
        jbt.setBounds(10,100,20,10);
        jbt2.setBounds(50,100,20,10);
        jbt3.setBounds(100,100,20,10);
        cp.add(jpnc,BorderLayout.CENTER);
        cp.add(jpns,BorderLayout.SOUTH);
        jpnc.add(jlb);
        jpnc.add(jf);
        jpnc.add(jlb2);
        jpnc.add(jp);
        jpns.add(jbt);
        jpns.add(jbt2);
        jpns.add(jbt3);



        jbt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain fr = new FrameMain(FrameMain2.this);
                fr.setVisible(true);
            }
        });


        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jf.getText().equals("anita") && new String(jp.getPassword()).equals("123456")){
                    FrameMain3 fr = new FrameMain3();
                    fr.setVisible(true);
                    FrameMain2.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(FrameMain2.this,"errror");
                }
            }
        });



        jbt3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void setpass (String arg){
        jp.setText(arg);
    }

}