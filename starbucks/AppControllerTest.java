import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class AppControllerTest
{
    private AppController app;

    /**
     * Default constructor for test class AppControllerTest
     */
    public AppControllerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        app = new AppController();
        app.startUp() ;    
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void Test1234() throws Exception
    {
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        assertEquals( "pin valid!", app.onScreen() ) ;
    }
}


