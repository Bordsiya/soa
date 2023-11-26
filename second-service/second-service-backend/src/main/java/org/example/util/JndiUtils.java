package org.example.util;

import javax.naming.InitialContext;
import java.util.Properties;

public class JndiUtils {
    @SuppressWarnings("unchecked")
    public static <T> T getFromContext(Class<T> clazz, String path) {
        try {
            Properties jndiProps = new Properties();
            jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProps.put("jboss.naming.client.ejb.context", true);
            jndiProps.put("java.naming.provider.url", "http-remoting://localhost:9100");
            return (T) new InitialContext(jndiProps).lookup(path);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve item from context. Path = "+path);
        }
    }
}
