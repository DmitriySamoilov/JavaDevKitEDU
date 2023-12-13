import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServerWindow extends JFrame {
    private static final int POS_X = 1000;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JPanel panelBottom = new JPanel(new GridLayout(1,2));
    private final JButton bStart = new JButton("Start");
    private final JButton bStop = new JButton("Stop");
    private final JPanel panelTop = new JPanel(new BorderLayout());
    private final JTextArea log = new JTextArea();
    private boolean isServerWorking;

    public static void main(String[] args) {
        new ServerWindow();
    }
    public ServerWindow(){
        isServerWorking = false;
        bStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                log.append("Server stopped.\n");
                saveLog(log.getText());
                log.setText("");
                reLoadChat();
            }
        });
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                readLog();
                log.append("Server started.\n");
                reLoadChat();
            }
        });


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WIDTH,HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        //setLayout(new GridLayout(1,2));

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        panelBottom.add(bStart,BorderLayout.WEST);
        panelBottom.add(bStop, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }
    public void reLoadChat(){

    }

    public boolean isServerWorking() {
        return isServerWorking;
    }
    public void addServerLog(String text){
        log.append(text);
    }
    public String getServerLog(){
        return log.getText();
    }
    private void saveLog(String text)  {
        try (FileWriter writer = new FileWriter("BackUp.log",false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readLog() {
        try {
            Scanner scanner = new Scanner(new File("BackUp.log"));
            while (scanner.hasNextLine()) {
                log.append(scanner.nextLine() + "\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
