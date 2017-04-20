/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viiteryhma;

import org.junit.rules.ExternalResource;
/**
 *
 * @author tiera
 */
public class ServerRule extends ExternalResource{
    private final int port;

    public ServerRule(int port) {
        this.port = port;
    }
    
    
}
