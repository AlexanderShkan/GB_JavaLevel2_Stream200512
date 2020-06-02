package ru.gb.jtwo.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerSocketThread extends Thread { // фабрика сокетов, потоки сокетов, которых будет много

    int port; // создаем порт
    int timeout; // таймаут
    ServerSocketThreadListener listener; //слушатель

    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {
        listener.onServerStart(this); // сообщаем лиснеру о событии
        try (ServerSocket server = new ServerSocket(port)) {
            server.setSoTimeout(timeout);
            listener.onServerCreated(this, server); // создали сервер - инищиализировались и начинаем ждать
            while (!isInterrupted()) { // делаем бесконеный цикл, чтобы бесконечно создавать сокеты (пока Не интерптед)
                Socket socket;
                //старт-бесконечный цикл-эксепт
                try {
                    socket = server.accept(); // висим в методе акцепт, бесконечно, пока не подлючится клиент
                    //чтобы вызвать метода, нужно передать ссылку на объект
                    // чтобы отдать сокет ЧатСерверу, нам нужно чтобы серверСоектТред мог вызвать метод Чат Сервера
                } catch (SocketTimeoutException e) { // ловим порт исключением
                    listener.onServerTimeout(this, server); //
                    continue; // ловим сокеты и не делаем ничего, если никто не подсоединился, то у нас таймайт у мы опять уходим проверять
                }
                listener.onSocketAccepted(this, server, socket);
            }
        } catch (IOException e) { // ловим порт исключением
            listener.onServerException(this, e); // событие передаем (тред и экспеншен)
        } finally { // финалим
            listener.onServerStop(this); // событие предаем тред
        }
    }
}
