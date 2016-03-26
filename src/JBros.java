/**
 * Created by ������ on 26.03.2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class JBros
{
    // ������� ����
    public static void main (String[] args)
    {
        Window frame = new Window();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class Window extends JFrame
{
    public Window()
    {
        // ����������� �������� ������
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //=======================================================

        //���������� ������ �� ������ ������

        setSize (screenWidth / 2, screenHeight / 2);
        setLocation (screenWidth / 4, screenHeight / 4);

        //========================================================

        //��������� ����������� � ��������� ����

        setTitle("JBros");
        Image img = kit.getImage("icon.gif");
        setIconImage(img);

        //=======================================================

        // ����
        JMenu fileMenu = new JMenu("File");
        //������� � ���������� �������
        fileMenu.add(new AbstractAction("Close")
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });

        //����
        JMenu helpMenu = new JMenu("Help");
        //������� � ���������� �������
        helpMenu.add(new AbstractAction("About")
        {
            public void actionPerformed(ActionEvent event)
            {
                HelpWin helpWin = new HelpWin();
                helpWin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //���������� ��������� ����.
                helpWin.setVisible(true);
            }
        });
        // ���������� ��. ����.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // �� ���� ����� ������
        JLabel labelA = new JLabel("URL:");
        final JTextField urlName = new JTextField(20);
        urlName.setText("http://");


        //������ � ������������ �������
        JButton buttonGO = new JButton("GO");

        JPanel adress = new JPanel();
        adress.add(labelA);
        adress.add(urlName);
        adress.add(buttonGO);

        //������ ����� ������
        JPanel contentPane = new JPanel (new BorderLayout());
        setContentPane(contentPane);
        contentPane.add(adress, BorderLayout.NORTH);


        //������� ��� ������ ��������.
        final JTextArea okno = new JTextArea();
        okno.setBackground(Color.white);

        okno.setEditable(false);
        //contentPane.add(okno);
        add(new JScrollPane(okno),BorderLayout.CENTER);


        //���������� ��� ������
        buttonGO.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    // ������

                    String initialURL = urlName.getText().trim();
                    URL url = new URL(initialURL);
                    URLConnection conn = url.openConnection();
                    // ������ ���� � �������
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    //����� �����������
                    String inputLine = null;
                    while ((inputLine = in.readLine()) != null)
                    {
                        okno.append(inputLine);
                        okno.append("\n");
                    }
                }

                catch (Exception e) { /*okno.append("URL not Found");*/}

            }
        });





    }

}
// ����� ��� ���� Help
class HelpWin extends JFrame
{
    public HelpWin()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation (screenWidth / 4, screenHeight / 4);

        JPanel panel = new JPanel();
        setTitle("About Program");
        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setSize(WIDTH, HEIGHT);
        panel.setVisible(true);

        JLabel label=new JLabel("  JBros; version 0.1t;  Pogoreliy Ihor;  contact: piv86@list.ru");
        label.setFont(new Font("Arial",Font.BOLD, 14));
        add(label, BorderLayout.CENTER);

    }
    public static final int WIDTH = 425;
    public static final int HEIGHT = 100;
}