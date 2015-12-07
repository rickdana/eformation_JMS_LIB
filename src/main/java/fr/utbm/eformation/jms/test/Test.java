
package fr.utbm.eformation.jms.test;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.jms.receiver.SessionRegJmsReceiver;
import fr.utbm.eformation.jms.sender.JmsSender;
import fr.utbm.eformation.jms.sender.SessionRegJmsSender;

/**
 *
 * @author java
 */
public class Test {
    public static void main(String[] args){
        //SessionRegJmsSender s = new SessionRegJmsSender();
        JmsSender s = new JmsSender();
        Client c = new Client();
        c.setFirstName("achille");
        c.setFirstName("Dana");
        c.setAddress("28 rue adolphe thiers");
        
        Location l = new Location();
        l.setCity("Yaoundé");
        l.setLocationId(45);
        
        
        s.regNotification(l);
        int i = 2;
        while(i>0){
           s.regNotification(c); 
           i--;
        }
      
    }
}
