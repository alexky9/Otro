package barmex;

import javax.servlet.*;

    public final class ContextListener implements ServletContextListener {
    public void contextInitialized (ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext ();
        try {
            EquiposDB nuevo = new EquiposDB();
            servletContext.setAttribute ("BaseDatos", nuevo);
        }
        catch (Exception e) {
            servletContext.log ("No se pudo crear el atributo BaseDatos: " + e.getMessage ());
        }
    }

    public void contextDestroyed (ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext ();
        EquiposDB nuevo = (EquiposDB) servletContext.getAttribute ("BaseDatos");
        nuevo.close ();
        servletContext.removeAttribute ("BaseDatos");
    }
}

