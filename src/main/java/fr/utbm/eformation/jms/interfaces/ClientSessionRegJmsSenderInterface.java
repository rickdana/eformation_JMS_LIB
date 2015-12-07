
package fr.utbm.eformation.jms.interfaces;

import fr.utbm.eformation.core.entity.Client;

/**
 *
 * @author java
 */
public interface ClientSessionRegJmsSenderInterface extends SessionRegJmsSendable <Client> {
       @Override
       public void regNotification(Client obj);
}
