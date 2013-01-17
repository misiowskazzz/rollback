package pl.itcrowd.rollback;

import javax.annotation.Resource;
import javax.ejb.ApplicationException;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

@ApplicationException(rollback = false)
public class MyException2 extends Exception {

    private static final Logger LOGGER = Logger.getLogger(MyException.class.getCanonicalName());
    @Resource
    private TransactionSynchronizationRegistry txReg;

    MyException2() {
    }

    public MyException2(String s) {
        super(s);
        LOGGER.info("exception" + s);
    }
}
