package server;

import client.Client;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ViewServer viewServer;
    private StoreService store;
    private List<Client> clientList;
    private boolean work;

    public Server(StoreService store, ViewServer viewServer) {
        this.store = store;
        this.clientList = new ArrayList<>();
        this.viewServer = viewServer;
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public String getHistory() {
        return store.read() + "\n";
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (client != null) {
            client.disconnectFromServer();
        }
    }

    public void sendMessage(String s) {
        if (!work) {
            return;
        }
        sendMessageWide(s);
        store.save(s);
        viewServer.appendLog(s);

    }

    public void sendMessageWide(String s) {
        for (Client client : clientList) {
            client.answerFromServer(s);
        }
    }

    public void serverStart() {
        if (work){
            viewServer.appendLog("Сервер уже был запущен");
        } else {
            work = true;
            viewServer.appendLog("Сервер запущен!");
        }
    }
    public void serverStop(){
        if (!work){
            viewServer.appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientList.isEmpty()){
                disconnectUser((clientList.get(clientList.size()-1)));
            }
            viewServer.appendLog("Сервер остановлен!");
        }
    }

}