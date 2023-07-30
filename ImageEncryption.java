package project;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ImageEncryption{
    ImageEncryption(){
        frame();
    }
    public static void operate(int key){
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(null);
        File f=fc.getSelectedFile();
        //file fileinputstream reader
        try{
            FileInputStream fis=new FileInputStream(f);
            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(f, false);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done!");



        }catch(Exception e){
            System.out.println(e);
        }

    }

    static void frame(){
        JFrame jf=new JFrame();
        jf.setTitle("Image Encryptor");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb=new JButton(null, null);
        jb.setText("Open Image");
       

        JTextField jt=new JTextField(10);
        jt.setText(null);
        jf.setLayout(new FlowLayout());
        jf.add(jb);
        jf.add(jt);
         jb.addActionListener(e->{
            System.out.println("Buttoon Click");
           String text= jt.getText();
           int temp=Integer.parseInt(text);
           operate(temp);
        });
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        System.out.print("hi");
       ImageEncryption i=new ImageEncryption();
    }
}