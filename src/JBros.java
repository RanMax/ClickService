/**
 * Created by Максим on 26.03.2016.
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
    // Главное окно
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
        // Определение размеров экрана
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //=======================================================

        //Размещение фрейма по центру экрана

        setSize (screenWidth / 2, screenHeight / 2);
        setLocation (screenWidth / 4, screenHeight / 4);

        //========================================================

        //Установка пиктограммы и заголовка окна

        setTitle("JBros");
        Image img = kit.getImage("icon.gif");
        setIconImage(img);

        //=======================================================

        // Меню
        JMenu fileMenu = new JMenu("File");
        //Подменю с обработкой событий
        fileMenu.add(new AbstractAction("Close")
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });

        //Меню
        JMenu helpMenu = new JMenu("Help");
        //Подменю с обработкой событий
        helpMenu.add(new AbstractAction("About")
        {
            public void actionPerformed(ActionEvent event)
            {
                HelpWin helpWin = new HelpWin();
                helpWin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Закрыватем вторичные окна.
                helpWin.setVisible(true);
            }
        });
        // Добавления гл. меню.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Ст рока ввода адреса
        JLabel labelA = new JLabel("URL:");
        final JTextField urlName = new JTextField(20);
        urlName.setText("http://");


        //Кнопка с обработчиком событий
        JButton buttonGO = new JButton("GO");

        JPanel adress = new JPanel();
        adress.add(labelA);
        adress.add(urlName);
        adress.add(buttonGO);

        //Строка ввода адреса
        JPanel contentPane = new JPanel (new BorderLayout());
        setContentPane(contentPane);
        contentPane.add(adress, BorderLayout.NORTH);


        //Область для вывода страницы.
        final JTextArea okno = new JTextArea();
        okno.setBackground(Color.white);

        okno.setEditable(false);
        //contentPane.add(okno);
        add(new JScrollPane(okno),BorderLayout.CENTER);


        //Обработчик для кнопки
        buttonGO.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    // Конект

                    String initialURL = urlName.getText().trim();
                    URL url = new URL(initialURL);
                    URLConnection conn = url.openConnection();
                    // Чтение инфы с сервера
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    //Вывод содержимого
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
// Класс для окна Help
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