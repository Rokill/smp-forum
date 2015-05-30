/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.auquid.forum.util;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeansLocator {

    private static final String BEAN_LOCAL_CREATE_METHOD_NAME = "create";

    private static Logger log = Logger.getLogger(BeansLocator.class.getName());
    private static BeansLocator locator = null;
    private JndiNameBuilder nameBuilder = new JndiNameBuilder();

    private BeansLocator (){};

    public static BeansLocator getInstance() {
        if (locator == null) {
            locator = new BeansLocator();
        }
        return locator;
    }

    public Object lookup(String name) {
        Context context;
        try {
            context = new InitialContext();
            return context.lookup(name);
        } catch (NamingException ex) {
            log.log(Level.SEVERE, "Can't find object with name: " + name, ex);
            throw new RuntimeException("Can't find object with name: " + name);// maybe have to create custom exception?
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanLocal) {
    	return (T) lookup(nameBuilder.buildEjbName(beanLocal));
    }

}
