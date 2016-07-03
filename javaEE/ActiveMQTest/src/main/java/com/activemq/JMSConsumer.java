package com.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //榛樿杩炴帴鐢ㄦ埛鍚?
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //榛樿杩炴帴瀵嗙爜
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    // 榛樿杩炴帴鍦板潃
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//杩炴帴宸ュ巶
        Connection connection = null;//杩炴帴

        Session session;//浼氲瘽 鎺ュ弹鎴栬€呭彂阃佹秷鎭殑绾跨▼
        Destination destination;//娑堟伅镄勭洰镄勫湴

        MessageConsumer messageConsumer;//娑堟伅镄勬秷璐硅€?/瀹炰緥鍖栬繛鎺ュ伐铡?
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

        try {
            //阃氲绷杩炴帴宸ュ巶銮峰彇杩炴帴
            connection = connectionFactory.createConnection();
            //鍚姩杩炴帴
            connection.start();
            //鍒涘缓session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //鍒涘缓涓€涓繛鎺elloWorld镄勬秷鎭槦鍒?
            destination = session.createQueue("HelloWorld");
            //鍒涘缓娑堟伅娑堣垂钥?
            messageConsumer = session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
                if(textMessage != null){
                    System.out.println("鏀跺埌镄勬秷鎭?" + textMessage.getText());
                }else {
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}