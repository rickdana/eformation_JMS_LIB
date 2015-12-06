/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.eformation.jms.test;

import fr.utbm.eformation.jms.receiver.SessionRegistrationJmsReceiver;
import fr.utbm.eformation.jms.sender.SessionRegistrationJmsSender;

/**
 *
 * @author java
 */
public class Test {
    public static void main(String[] args){
        SessionRegistrationJmsSender s = new SessionRegistrationJmsSender();
        s.regNotification();
    }
}
