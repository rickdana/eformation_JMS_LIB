/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.eformation.jms.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author java
 */
public class SessionRegistrationJmsReceiver {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null; 
    private MessageConsumer consumer = null;

    public SessionRegistrationJmsReceiver() {
    }
    
    public void listenMessage(){
        try{
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL
            );
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("REGISTRATION");
            consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            
            if (message instanceof TextMessage){
                TextMessage text = (TextMessage)message;
                System.out.println("<--- Notification received : ");
                System.out.println("<--- Notification ID : "+text.getJMSMessageID());
                System.out.println("<--- Notification Message : "+text.getText());

            }
            
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
