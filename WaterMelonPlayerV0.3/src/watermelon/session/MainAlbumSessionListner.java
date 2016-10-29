package watermelon.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MainAlbumSessionListner
 *
 */
@WebListener
public class MainAlbumSessionListner implements HttpSessionListener {
	
    public void sessionCreated(HttpSessionEvent e)  { 
    	HttpSession session = e.getSession();
    	
    }

    public void sessionDestroyed(HttpSessionEvent e)  { 
       
    }
	
}
