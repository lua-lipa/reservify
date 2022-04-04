import org.junit.Test;

import Interceptor.interceptor;
import Interceptor.loggingInterceptor;

import static org.junit.Assert.assertEquals;

public class InterceptorTest {

    @Test
    public void testNextInChain() {
        loggingInterceptor logging = new loggingInterceptor("log");
        loggingInterceptor nextInChain = new loggingInterceptor("log2");
        logging.setNextChain(nextInChain);
        interceptor actual_nextInChain = logging.getNextInChain();
        assertEquals(nextInChain, actual_nextInChain);
    }

}
