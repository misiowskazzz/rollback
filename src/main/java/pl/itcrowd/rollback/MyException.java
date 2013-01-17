package pl.itcrowd.rollback;

import javax.annotation.Resource;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

public class MyException extends Exception{
    private static final Logger LOGGER = Logger.getLogger(MyException.class.getCanonicalName());
    @Resource
    private TransactionSynchronizationRegistry txReg;

    MyException() {
    }

    public MyException(String s) {
        super(s);
        LOGGER.info("exception" + s);
    }
}
