package ru.gb.jtwo.network;

import java.net.ServerSocket;
import java.net.Socket;

public interface ServerSocketThreadListener { // прослойка, что бы ССТ мог сообзщать о возникновении событий слашателям, а те
    // кто этих слушателей будет реализовывать они будут как-то реагировать на эти события
    // лиснер со стороны НЕ клиента, т.ею изнутри
    void onServerStart(ServerSocketThread thread); //события старт
    void onServerStop(ServerSocketThread thread); //события стоп
    void onServerCreated(ServerSocketThread thread, ServerSocket server);
    void onServerTimeout(ServerSocketThread thread, ServerSocket server); // таймаут
    void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket); // аксепшин (у какого серверия, какой сокет)
    void onServerException(ServerSocketThread thread, Throwable throwable); //исключения


}
