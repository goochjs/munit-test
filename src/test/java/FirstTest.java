import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.munit.runner.functional.FunctionalMunitSuite;


/**
 * Munit test created with JAVA
 */
public class FirstTest extends FunctionalMunitSuite {

    /**
     * This can be omitted. In that case, the config resources will be taken from mule-deploy.properties file.
     * @return The location of your Mule config file. 
     */
    @Override
    protected String getConfigResources() {
        return "munit-test.xml";
    }


    @Test
    public void validateEchoFlow() throws Exception {
    	String testPayload = "Hello world!";
        MuleEvent resultEvent = runFlow("echoFlow", testEvent(testPayload));

        assertEquals(testPayload, resultEvent.getMessage().getPayloadAsString());
    }
}