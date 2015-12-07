package fr.utbm.eformation.jms.test;


import fr.utbm.eformation.jms.receiver.SessionRegJmsReceiver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java
 */
public class JMS {
    
    public static void main(String[] args){
        SessionRegJmsReceiver r = new SessionRegJmsReceiver();
        while(true){
          r.listenMessage();  
        }
        
    }
    
}
