package fr.utbm.eformation.jms.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Class receiving a JMS message using a point to point communication 
 * @author java
 */
public class SessionRegJmsReceiver {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer messConsumer = null;

    public SessionRegJmsReceiver() {
    }
    /**
     * receive a JMS message and print it into console
     */
    public void listenMessage() {
        try {
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL
            );
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("REGISTRATION");
            messConsumer = session.createConsumer(destination);
            while (true) {
                Message message = messConsumer.receive();
                if (message instanceof ObjectMessage) {
                    Object obj = ((ObjectMessage) message).getObject();
                    //Client client = (Client) obj;
                    System.out.println("<--- Notification received : ");
                    System.out.println("<--- Notification ID : " + ((ObjectMessage) message).getJMSMessageID());
                    System.out.println("<--- Notification Message : " + obj.toString());

                }
                if (message instanceof TextMessage) {
                    TextMessage text = (TextMessage) message;
                    System.out.println("<--- Notification received : ");
                    System.out.println("<--- Notification ID : " + text.getJMSMessageID());
                    System.out.println("<--- Notification Message : " + text.getText());

                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
