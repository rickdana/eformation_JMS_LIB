/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.eformation.jms.test;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.jms.receiver.SessionRegJmsReceiver;
import fr.utbm.eformation.jms.sender.SessionRegJmsSender;

/**
 *
 * @author java
 */
public class Test {
    public static void main(String[] args){
        SessionRegJmsSender s = new SessionRegJmsSender();
        Client c = new Client();
        c.setFirstName("achille");
        c.setFirstName("Dana");
        c.setAddress("28 rue adolphe thiers");
        int i = 2;
        while(i>0){
           s.regNotification(c); 
           i--;
        }
      
    }
}
