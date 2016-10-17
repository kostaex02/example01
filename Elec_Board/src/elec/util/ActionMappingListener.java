package elec.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import elec.controller.Action;


@WebListener
public class ActionMappingListener implements ServletContextListener {

    public ActionMappingListener() {}

    public void contextDestroyed(ServletContextEvent arg0)  { }
    
    public void contextInitialized(ServletContextEvent e)  { 
    	ServletContext application =  e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	
    	Map<String,Action> map = new HashMap<>();
    	
    	for(String key : rb.keySet()){
    		String className = rb.getString(key);
    		try{
    			Action action = (Action)Class.forName(className).newInstance();
    			
    			map.put(key, action);
    		}catch(Exception e1){
    			e1.printStackTrace();
    		}
    	}
    	application.setAttribute("map", map);
    }
	
}
