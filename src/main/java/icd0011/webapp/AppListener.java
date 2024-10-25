package icd0011.webapp;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@WebListener
public class AppListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.example");
        context.refresh();

        sce.getServletContext().setAttribute("springContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AnnotationConfigWebApplicationContext context = (AnnotationConfigWebApplicationContext)
                sce.getServletContext().getAttribute("springContext");
        if (context != null) {
            context.close();
        }
    }
}