import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientGUI extends JFrame {
    private static final int POS_X = 1000;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(3,2));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8080");
    private final JTextField tfLogin = new JTextField("Enter Name");
    private JPasswordField tfPassword = new JPasswordField("password");
    private final JButton bLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton bSendUpdate = new JButton("Send/Update");

    private boolean isLogged = false;

    ClientGUI(ServerWindow serverWindow, int position){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(POS_X - position,POS_Y,WIDTH,HEIGHT);
        //setSize(WIDTH,HEIGHT);
        setTitle("Chat Client");
        setAlwaysOnTop(true);

        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isLogged && serverWindow.isServerWorking()){
                    panelTop.setVisible(false);
                    log.append("Вы успешно подключились\n");
                    serverWindow.addServerLog(tfLogin.getText() + " подключился к беседе\n");
                    isLogged = true;
                }else {log.append("Сервер недоступен\n");}
            }
        });

        bSendUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isLogged){
                    if (serverWindow.isServerWorking()) {
                        if (tfMessage.getText().equals("")){log.setText(serverWindow.getServerLog());return;}//update

                        log.append(tfLogin.getText() +": " + tfMessage.getText() + "\n");
                        serverWindow.addServerLog(tfLogin.getText() +": " + tfMessage.getText() + "\n");//new message
                        tfMessage.setText("");
                        log.setText(serverWindow.getServerLog());}
                    else {
                        log.append("Сервер недоступен\n");
                        isLogged = false;
                        panelTop.setVisible(true); }
                }
            }
        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin,BorderLayout.SOUTH);
        panelTop.add(tfPassword);
        panelTop.add(bLogin);
        add(panelTop,BorderLayout.NORTH);

        panelBottom.add(tfMessage,BorderLayout.CENTER);
        panelBottom.add(bSendUpdate,BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }

    /*public static void main(String[] args) {
        new ClientGUI();
    }*/
}
