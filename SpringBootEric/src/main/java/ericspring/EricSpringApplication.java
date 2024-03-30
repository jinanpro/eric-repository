package ericspring;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

public class EricSpringApplication {

    public static void run(Class clazz){
        System.out.println("Eric Application Test Succeed");
        //创建Spring容器
//        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();
        //启动tomcat
//        startTomcat(applicationContext);

        //启动 Tomcat / Jetty 服务
        WebServer webServer = getWebServer(applicationContext);
        webServer.getStart(applicationContext);
    }


    public static WebServer getWebServer(WebApplicationContext applicationContext){
        Map<String,WebServer> webservers = applicationContext.getBeansOfType(WebServer.class);

        if(webservers.isEmpty()){
            throw new NullPointerException();
        }

        if(webservers.size() > 1){
            throw new IllegalStateException();
        }

        return webservers.values().stream().findFirst().get();
    }

    private static void startTomcat(WebApplicationContext applicationContext){
        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8081);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet(applicationContext));
        context.addServletMappingDecoded("/*","dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
