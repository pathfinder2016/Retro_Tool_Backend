package com.retro.core.websocket;

import com.alibaba.fastjson.JSON;
import com.retro.core.retro.model.Card;
import com.retro.core.retro.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket", configurator = EndpointConfig.class)
@Component
public class WebSocketServer {

    @Autowired private CardService cardService;
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private static CopyOnWriteArrayList<Session> sessionSet = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws EncodeException {
        System.out.println(session + "New connect successful");
        sessionSet.add(session);
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("Current online count: " + getOnlineCount());
        sendMessage(cardService.findAll());
    }

    @OnClose
    public void onClose() {
        System.out.println("有一连接关闭");
        sessionSet.remove(this.session);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    public static void sendInfo(List<Card> cards) throws IOException, EncodeException {
        for (WebSocketServer item : webSocketSet) {
            item.sendMessage(cards);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        sessionSet.remove(session);
        System.out.println("error..............ON error");
        error.printStackTrace();
    }

    private void sendMessage(List<Card> message) {
        for (WebSocketServer server : webSocketSet) {
            if (server != null) {
                for (Session session : sessionSet) {
                    if (session.isOpen()) {
                        System.out.println("session is open......");
                        try {
                            session.getBasicRemote().sendText(JSON.toJSON(message).toString());
                        } catch (IOException e) {
                            System.out.println("Error");
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static synchronized AtomicInteger getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount.getAndAdd(1);
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount.getAndAdd(-1);
    }

}
