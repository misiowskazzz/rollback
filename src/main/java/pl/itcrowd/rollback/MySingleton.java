package pl.itcrowd.rollback;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.TransactionSynchronizationRegistry;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

@Startup
@Singleton
public class MySingleton {

    private static final Logger LOGGER = Logger.getLogger(MySingleton.class.getCanonicalName());

    @Resource
    private TransactionSynchronizationRegistry transaction;


    @PostConstruct
    public void onCreate() throws Exception {

       /* LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new MyException("xxx--" + "MyException with xml" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
            throw e;
        }*/

       LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new MyException2("xxx--" + "MyException2 with out xml" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
            throw e;
        }
 /*
        LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new FileNotFoundException("xxx--" + "MyException3 (file not found exception)" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
            throw e;
        }*/
        /*LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new IllegalAccessException("xxx--" + "MyException4 (illegal access exception)" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
            throw e;
        }*/
    }
}
