package ie.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI 
{
    Connection connection = null;

    @Override
    protected void init(VaadinRequest vaadinRequest) 
    {
        final VerticalLayout layout = new VerticalLayout();

        // Connect to database (need Azure conn strings)
        String connectionString = "jdbc:sqlserver://{your Database Server}.database.windows.net:1433;" + 
                                  "database={your Database};" + 
                                  "user={server admin login}@{your Database Server};" + 
                                  "password={your password};" + 
                                  "encrypt=true;" + 
                                  "trustServerCertificate=false;" + 
                                  "hostNameInCertificate=*.database.windows.net;" +
                                  "loginTimeout=30;";
        try 
        {
            // Connect with JDBC driver to a database
            connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customerTable WHERE paid = 'false' ORDER BY AMOUNT DESC;");
            while(rs.next())
            {
                layout.addComponent(new Label(rs.getString("first_name") + " " + rs.getString("last_name") + " has not paid " + rs.getDouble("amount")));  
            }
        } 
        catch (Exception e) 
        {
            // This will show an error message if something went wrong
            layout.addComponent(new Label(e.getMessage()));
        }
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
