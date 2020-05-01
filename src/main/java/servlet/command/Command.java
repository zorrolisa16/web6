package servlet.command;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Polina
 */
public abstract class Command {
    
    public String getPattern(){
        return "";
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        
    }
   
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
           throws ServletException, IOException{
       doGet(request, response, servletContext);
   }
}
