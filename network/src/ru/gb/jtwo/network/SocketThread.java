package ru.gb.jtwo.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketThread extends Thread { // должен принимать и передать данные,
    // но не должен значть ничего ни о клиенте, ни о сервере
    // так как этот СТ будет использоваться и в ЧС и в клиенте, т.е. должен быть униниверсальным (сложным)

    private final SocketThreadListener listener;
    private final Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public SocketThread(String name, SocketThreadListener listener, Socket socket) { //конструктор
        super(name);
        this.listener = listener;
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            listener.onSocketStart(this, socket);
            in = new DataInputStream(socket.getInputStream()); // инпустримы и айутпутсримы могут пораждать ИОЭксепшн, поэтому
            out = new DataOutputStream(socket.getOutputStream()); // оборачиваем их в трай-кетч
            listener.onSocketReady(this, socket); // сообщаем лиснеру, что стартанули
            while (!isInterrupted()) {
                String msg = in.readUTF();
                listener.onReceiveString(this, socket, msg);
            }
        } catch (IOException exception) {
            listener.onSocketException(this, exception); // оповещаем о эксепшинах лиснера
        } finally {
            close();
        }
    }

    public boolean sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
            return true;
        } catch (IOException exception) {
            listener.onSocketException(this, exception);
            close(); // закрываем сокет, если пошло, что-то не так
            return false;
        }
    }

    public void close() { //длеаем сложное закрытие
        try {
            in.close();
        } catch (IOException exception) {
            listener.onSocketException(this, exception);
        }
        interrupt();
        try {
            socket.close(); // закрываем сокет со стороны сервера, чтобы он постоянно не падал
        } catch (IOException exception) {
            listener.onSocketException(this, exception);
        }
        listener.onSocketStop(this);
    }

}
