import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

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
    FrameMain3 fd;
    private JFileChooser jch = new JFileChooser();
    private String loodFile;
    public FrameMain6 (FrameMain3 fa){
        init();
        fd = fa;
    }
    public void init(){
        this.setBounds(100,100,500,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fd.setVisible(true);
            }
        });
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


        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jch.showOpenDialog(FrameMain6.this) == JFileChooser.APPROVE_OPTION){
//                    loodFile = jch.getSelectedFile().getPath() + jch.getSelectedFile().getName();
                    jtf2.setText(jch.getSelectedFile().getPath());
                    jtf3.setText(jtf2.getText()+".sec");
                }
            }
        });

        jbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf2.getText().equals(" ")) {
                    JOptionPane.showMessageDialog(FrameMain6.this, "no file selected");
                } else {
                    try {
                        File selected = new File(jtf2.getText());
                        long length = selected.length();
                        jpb.setMaximum(100);
                        char key[] = jtf.getText().toCharArray();
                        FileReader fr = new FileReader(selected);
                        BufferedReader bf = new BufferedReader(fr);
                        File writeFile = new File(jtf3.getText());
                        FileWriter fw = new FileWriter(writeFile);
                        BufferedWriter bw = new BufferedWriter(fw);
                        int data;
                        int i = 0;
                        while ((data = bf.read()) != -1) {
                            data = data ^ key[i & key.length];
                            bw.write(data);
                            i++;
                            jpb.setValue(Math.round(((float) i / length) * 100));
                            bf.close();
                            fr.close();
                            JOptionPane.showMessageDialog(FrameMain6.this, "Finish!");
                        }
                    } catch (IOException ie) {
                        JOptionPane.showMessageDialog(FrameMain6.this, "no File");
                    }


                }


            }

        });




    }
}
