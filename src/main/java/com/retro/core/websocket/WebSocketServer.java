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

/**
 * https://my.oschina.net/hibony/blog/1623339
 * https://blog.csdn.net/zhangdehua678/article/details/78913839
 */
@ServerEndpoint(value = "/websocket", configurator = EndpointConfig.class)
@Component
public class WebSocketServer {

    // https://blog.csdn.net/tornadojava/article/details/78781474
    @Autowired
    private CardService cardService;

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private static CopyOnWriteArrayList<Session> sessionSet = new CopyOnWriteArrayList<>();
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) throws EncodeException {
        System.out.println("连接成功");
        sessionSet.add(session);
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        sendMessage(cardService.findAll());
        System.out.println("发送连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("有一连接关闭");
        webSocketSet.remove(this);  //从set中删除
        sessionSet.remove(this.session);
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        //sendInfo("ghghhhjkh");
    }

    /**
     * 群发自定义消息
     * */
    public static void sendInfo(List<Card> cards) throws IOException, EncodeException {
        for (WebSocketServer item : webSocketSet) {
            item.sendMessage(cards);
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        sessionSet.remove(session);
        System.out.println("error..............ON error");
//        this.onClose();
        error.printStackTrace();
    }

    public void sendMessage(List<Card> message){
        if(webSocketSet.size() > 0){
            for(WebSocketServer server: webSocketSet){
                if(server != null){
                    for(Session session: sessionSet){
                        if(session.isOpen()){
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

        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
