
package fr.utbm.eformation.jms.interfaces;

/**
 *
 * @author java
 * @param <T>
 */
public interface SessionRegJmsSendable <T> {
    /**
  * Send a T objet via JMS 
  * @param obj   
  */
    public void regNotification(T obj);
    
}
