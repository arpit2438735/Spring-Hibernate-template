#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.stmicro.eot.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * The Class SystemEnvPropertyConfigurer. Uses an environment property to determine properties class
 * to use
 */
public class SystemEnvPropertyConfigurer extends PropertyPlaceholderConfigurer
{

    /** The Constant LOGGER. */
    private static final Log LOGGER = LogFactory.getLog(SystemEnvPropertyConfigurer.class);

    /** The Constant ENV_VARIABLE_NAME. */
    private static final String ENV_VARIABLE_NAME = "project_env";

    /** The Constant DEFAULT_ENVIRONMENT. */
    private static final String DEFAULT_ENVIRONMENT = "dev";

    private static final String SYSTEM_ENV;

    static
    {
        String env = System.getenv(ENV_VARIABLE_NAME);

        if (env == null || "".equals(env))
        {
            env = System.getProperty(ENV_VARIABLE_NAME);
        }
        
        if(env == null || "".equals(env)) {
            env = DEFAULT_ENVIRONMENT;
        }
        
        SYSTEM_ENV = env;

        LOGGER.info("Using Environment configuration (" + ENV_VARIABLE_NAME + ") for " + SYSTEM_ENV);
    }
    
    public static String getEnv()
    {
        return SYSTEM_ENV;
    }

    /**
     * Sets the property name.
     * 
     * @param name
     *            the new property name
     */
    public void setPropertyName(final String name)
    {
        String resourceLocation = name;
        resourceLocation += "-" + SYSTEM_ENV;
        resourceLocation += ".properties";
        super.setLocation(new ClassPathResource(resourceLocation));
    }
    
    public String resolveProperty(String name) throws IOException
    {
        Properties props = new Properties();
        super.loadProperties(props);
        return props.getProperty(name);
    }

}