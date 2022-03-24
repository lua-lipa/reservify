import org.junit.Test;

import Interceptor.interceptor;
import Interceptor.loggingInterceptor;

import static org.junit.Assert.assertEquals;

public class InterceptorTest {
    @Test
    public void testTriggerEvent() {
        String triggerEvent = "trigger event";
        interceptor logging = new loggingInterceptor(triggerEvent);
        String actualTriggerEvent = logging.getTriggerEvent();
        assertEquals(triggerEvent, actualTriggerEvent);
    }

    @Test
    public void testChainInCommandNextExists() {
        String triggerEvent = "trigger event";
        interceptor logging1 = new loggingInterceptor(triggerEvent);
        interceptor logging2 = new loggingInterceptor(triggerEvent);
        logging1.setNextChain(logging2);
        assertEquals(logging2, logging1.getNextInChain());
    }

    @Test
    public void testChainInCommandEmpty() {
        String triggerEvent = "trigger event";
        interceptor logging1 = new loggingInterceptor(triggerEvent);
        assertEquals(null, logging1.getNextInChain());
    }
}