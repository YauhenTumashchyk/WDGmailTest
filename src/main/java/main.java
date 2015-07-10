import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by Yauhen_Tumashchyk on 7/8/2015.
 */
public class Main {

    static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        //Configure logger
        BasicConfigurator.configure();
        logger.debug("Hello World!");
    }

}
