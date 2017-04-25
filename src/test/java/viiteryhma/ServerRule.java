/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viiteryhma;

import org.junit.rules.ExternalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
/**
 *
 * @author tiera
 */
public class ServerRule extends ExternalResource{
    private final int port;
    
    @Autowired
    EmbeddedWebApplicationContext server;
    
    public ServerRule(int port) {
        this.port = port;
    }
   /* 
    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/tiera/chromedriver");
        server. = 
        UserDao dao = new UserDaoForTests();
        dao.add(new User("jukka", "akkuj"));
        Main.setDao(dao);
        Main.main(null);
    }
*/
}
