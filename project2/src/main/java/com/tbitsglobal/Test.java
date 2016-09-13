package com.tbitsglobal;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.naming.ConfigurationException;

import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	private static PropertiesConfiguration datanucleusPropConf = null;
	 private static Logger logger = LoggerFactory.getLogger(Test.class);
	private static PersistenceManagerFactory pmf=null;

    public static Employee storeClient(PersistenceManager pm, Employee client) {
    	return pm.makePersistent(client);
    }


    public static Employee storeClient(Employee client) throws org.apache.commons.configuration.ConfigurationException {
    	Employee newClient = null;
        PersistenceManager pm = getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            newClient = storeClient(pm,client);
            newClient = pm.detachCopy(newClient);
            tx.commit();
        } catch (Throwable t) {
            logger.error(t.toString());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        return newClient;
    }
    
    public static PersistenceManagerFactory getPmf() throws org.apache.commons.configuration.ConfigurationException {
		if (pmf == null) {
			if (logger.isTraceEnabled())
				logger.trace("Creating persistence factory");
			Properties properties = new Properties();
			try {
					properties = getDatanucleusPropertiesFile("datanucleus.properties");
			} catch (ConfigurationException ioe) {
				logger.error(
						"Could not find datanucleus.properties file that defines " + "Datanucles persistence setup.");
			}
			pmf = JDOHelper.getPersistenceManagerFactory(properties);
		}
		return pmf;
	}
    
	public static Properties getDatanucleusPropertiesFile(String fileName)
			throws ConfigurationException, org.apache.commons.configuration.ConfigurationException {
		if (datanucleusPropConf == null) {
				datanucleusPropConf = new PropertiesConfiguration("E:/Training/project2/src/main/resources/"
						+ fileName);
				datanucleusPropConf.setReloadingStrategy(new FileChangedReloadingStrategy());
		}
		return ConfigurationConverter.getProperties(datanucleusPropConf);
	}
	
	public static PersistenceManager getPersistenceManager() throws org.apache.commons.configuration.ConfigurationException {
		return getPmf().getPersistenceManager();
	}

     public static void main(String[] args) throws org.apache.commons.configuration.ConfigurationException {
		Employee cl= new Employee(1,"saurabh");
		storeClient(cl);
	}
}
