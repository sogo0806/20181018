import javafx.stage.FileChooser;

import javax.naming.NamingEnumeration;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class FrameMain5 extends JFrame {
    private JTextArea jtext = new JTextArea(null,"",15,10);
    private JTextArea jtext2 = new JTextArea(null,"",15,10);
    private JScrollPane jsp = new JScrollPane(jtext);
    private JScrollPane jsp2 = new JScrollPane(jtext2);
    private String in[] = {"DES","CAESA","AES","XOR"};
    private JComboBox jcom = new JComboBox<String>(in);
    private JRadioButton jrb = new JRadioButton("Encrpy");
    private JRadioButton jrb2 = new JRadioButton("Decrpy");
    private Container cp;
    private JPanel jpe = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpw = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpc = new JPanel(new GridLayout(9,1,3,3));
    private JButton jbt = new JButton("Clear");
    private JButton jbt2 = new JButton("Run");
    private JButton jbt3 = new JButton("Exit");
    private JLabel jlb = new JLabel("Method");
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField();
    ButtonGroup but = new ButtonGroup();
    private JMenuBar jmb = new JMenuBar();
    private JMenu jfile = new JMenu("File");
    private JMenu jabout = new JMenu("About");
    private JMenuItem iopen = new JMenuItem("Open");
    private JMenuItem isave = new JMenuItem("Save");
    private JMenuItem iclose = new JMenuItem("Close");
    FrameMain3 ad;
    JFileChooser jch = new JFileChooser();
    public FrameMain5(FrameMain3 af){
        ad = af;
        init();
    }
    public void init(){
        this.setBounds(100,100,500,700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ad.setVisible(true);
            }
        });
        this.setLayout(null);
        this.setJMenuBar(jmb);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpe,BorderLayout.EAST);
        cp.add(jpc,BorderLayout.CENTER);
        cp.add(jpw,BorderLayout.WEST);
        jpe.add(jsp);
        jpw.add(jsp2);
        jpc.add(jlb);
        jpc.add(jcom);
        jpc.add(jlb2);
        jpc.add(jtf);
        jpc.add(jrb);
        jpc.add(jrb2);
        but.add(jrb);
        but.add(jrb2);
        jpc.add(jbt);
        jpc.add(jbt2);
        jpc.add(jbt3);
        jmb.add(jfile);
        jmb.add(jabout);
        jfile.add(iopen);
        jfile.add(isave);
        jfile.add(iclose);



        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb.isSelected()) {
                    int dataLengh = jtext2.getText().length();
                    if (dataLengh > 0) {
                        switch (jcom.getSelectedIndex()) {
                            case 0:
                                break;

                            case 1:
                                int key = Integer.parseInt(jtf.getText());
                                char data[] = jtext2.getText().toCharArray();
                                for (int i = 0; i < dataLengh; i++) {
                                    data[i] = (char) (data[i] + key);
                                }
                                jtext.setText(new String(data));
                                break;


                            case 2:
                                break;


                            case 3:
                                char data1[] = jtext2.getText().toCharArray();
                                char key1[] = jtf.getText().toCharArray();
                                for (int i = 0; i < data1.length; i++) {
                                    data1[i] = (char) ((int) data1[i] ^ (int) key1[i % key1.length]);
                                }
                                jtext.setText(new String(data1));
                                break;
                        }

                    }
                }
                    else if(jrb2.isSelected()) {
                        switch (jcom.getSelectedIndex()){
                            case 0:
                                break;

                            case 1:
                                int key = Integer.parseInt(jtf.getText());
                                int datalength = jtext.getText().length();
                                char data[] = jtext.getText().toCharArray();
                                for (int i = 0 ; i < datalength ; i++){
                                    data [i] = (char)(data[i]-key);
                                }
                                jtext2.setText(new String(data));
                                break;
                        }
                    }
                }

        });


        jbt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
             jtext.setText("");
             jtext2.setText("");
            }
        });



        jbt3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        iopen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jch.showOpenDialog(FrameMain5.this)==JFileChooser.APPROVE_OPTION){
                       jtext.setText("");
                       String str = "";
                        File selectFile = jch.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bf = new BufferedReader(fr);
                        while ((str = bf.readLine()) != null){
                            jtext.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ie){
                    JOptionPane.showMessageDialog(FrameMain5.this,"No file is not here");
                }
                }

        });
        isave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (jtext2.getText().length() > 0){
                        jch.setFileFilter(new FileNameExtensionFilter(".txt.doc",".txt",".doc"));
                        if (jch.showSaveDialog(FrameMain5.this) == JFileChooser.APPROVE_OPTION){
//                            File selectFile = jch.getSelectedFile();
                        File selectFile = new File(jch.getSelectedFile().getPath() + jch.getSelectedFile().getName() + ".txt");
                            FileWriter fw = new FileWriter(selectFile);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(jtext2.getText());
                            bw.close();
                        }
                        else {
                            JOptionPane.showMessageDialog(FrameMain5.this,"No Data can write");
                        }
                    }
                }catch (IOException ie){
                    JOptionPane.showMessageDialog(FrameMain5.this,"Open File Error"+ie.toString());
                }catch (Exception exp1){
                    JOptionPane.showMessageDialog(FrameMain5.this,"Error:404"+exp1.toString());
                }
            }
        });
    }

}