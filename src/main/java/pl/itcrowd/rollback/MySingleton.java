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

    @EJB
    private MyException myException;

    @EJB
    private MyException2 myException2;

    @PostConstruct
    public void onCreate() {

        LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new MyException("xxx--" + "MyException" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
        }

        LOGGER.info("TX Status:" + transaction.getTransactionStatus());
        LOGGER.info("TX Status:" + transaction.getTransactionKey());
        try {
            throw new MyException2("xxx--" + "MyException2" + "--xxx");
        } catch (Exception e) {
            LOGGER.info("Transaction status: " + transaction.getTransactionStatus());
        }

        try {
            throw new FileNotFoundException("xxx--" + "MyException2" + "--xxx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throw new IllegalAccessException("xxx--" + "MyException2" + "--xxx");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
