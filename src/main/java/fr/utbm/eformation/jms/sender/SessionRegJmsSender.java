
package fr.utbm.eformation.jms.sender;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.jms.interfaces.ClientSessionRegJmsSenderInterface;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author java
 */
public class SessionRegJmsSender implements ClientSessionRegJmsSenderInterface {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public SessionRegJmsSender() {
    }
    
    @Override
    public void regNotification(Client obj){
        try{
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("REGISTRATION");
            producer = session.createProducer(destination);
            //TextMessage mes = session.createTextMessage();
            //mes.setText("***** New registration made !!! *****");
            ObjectMessage objMessage = session.createObjectMessage();
            objMessage.setObject(obj);
            producer.send(objMessage);
            System.out.println("Sent: " + obj.toString());
            System.out.println(this.getClass().getName()+"has sent a message : " + obj);
            // Clean up
            session.close();
            connection.close();
        }catch (JMSException e){
             e.printStackTrace();
        }
    }
}
