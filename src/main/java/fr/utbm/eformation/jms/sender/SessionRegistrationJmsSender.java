/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.eformation.jms.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author java
 */
public class SessionRegistrationJmsSender {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public SessionRegistrationJmsSender() {
    }
    
    public void regNotification(){
        try{
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("REGISTRATION");
            producer = session.createProducer(destination);
            TextMessage mes = session.createTextMessage();
            mes.setText("***** New registration made !!! *****");
            producer.send(mes);
            System.out.println("Sent: " + mes.getText());
            // Clean up
            session.close();
            connection.close();
        }catch (JMSException e){
             e.printStackTrace();
        }
    }
}
