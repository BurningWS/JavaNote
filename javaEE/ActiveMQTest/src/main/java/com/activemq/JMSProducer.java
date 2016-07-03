package com.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {

    //榛樿杩炴帴鐢ㄦ埛鍚?
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //榛樿杩炴帴瀵嗙爜
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //榛樿杩炴帴鍦板潃
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //鍙戦€佺殑娑堟伅鏁伴噺
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        //杩炴帴宸ュ巶
        ConnectionFactory connectionFactory;
        //杩炴帴
        Connection connection = null;
        //浼氲瘽 鎺ュ弹鎴栬€呭彂阃佹秷鎭殑绾跨▼
        Session session;
        //娑堟伅镄勭洰镄勫湴
        Destination destination;
        //娑堟伅鐢熶骇钥?
        MessageProducer messageProducer;
        //瀹炰緥鍖栬繛鎺ュ伐铡?
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            //阃氲绷杩炴帴宸ュ巶銮峰彇杩炴帴
            connection = connectionFactory.createConnection();
            //鍚姩杩炴帴
            connection.start();
            //鍒涘缓session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //鍒涘缓涓€涓悕绉颁负HelloWorld镄勬秷鎭槦鍒?
            destination = session.createQueue("HelloWorld");
            //鍒涘缓娑堟伅鐢熶骇钥?
            messageProducer = session.createProducer(destination);
            //鍙戦€佹秷鎭?
            sendMessage(session, messageProducer);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 鍙戦€佹秷鎭?
     *
     * @param session
     * @param messageProducer 娑堟伅鐢熶骇钥?
     * @throws Exception
     */
    public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            //鍒涘缓涓€鏉℃枃链秷鎭?
            TextMessage message = session.createTextMessage("ActiveMQ 鍙戦€佹秷鎭? + i);
            System.out.println("鍙戦€佹秷鎭细Activemq 鍙戦€佹秷鎭? + i);
            //阃氲绷娑堟伅鐢熶骇钥呭彂鍑烘秷鎭?
            messageProducer.send(message);
        }

    }
}