import com.sourceit.calculation.PolishStrategy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolishStrategyTest extends Assert {
    private PolishStrategy polishStrategy;
    @Before
    public void setUp() throws Exception {
        System.out.println("Method started");
        polishStrategy = new PolishStrategy();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Method finished");
    }
    @Test
    public void polishStrategyTestOne() throws Exception {
        assertEquals("toDollar(5euro+5euro)+(toDollar(5euro-4euro)*2) = $14,64", "$14,64",
                polishStrategy.eval("toDollar(5euro+5euro)+(toDollar(5euro-4euro)*2)").toString());
    }
    @Test
    public void polishStrategyTestTwo() throws Exception {
        assertEquals("toDollar(5euro+5euro) = $12,20", "$12,20",
                polishStrategy.eval("toDollar(5euro+5euro)").toString());
    }
    @Test
    public void polishStrategyTestThree() throws Exception {
        assertEquals("toEuro(10UAN)+toEuro($5) = 4,62euro", "4,62euro",
                polishStrategy.eval("toEuro(10UAN)+toEuro($5)").toString());
    }
    @Test
    public void polishStrategyTestFour() throws Exception {
        assertEquals("toDollar(toEuro($10.00)+5euro) = $16,10", "$16,10",
                polishStrategy.eval("toDollar(toEuro($10.00)+5euro)").toString());
    }
    @Test
    public void polishStrategyTestFive() throws Exception {
        assertEquals("toEuro(10UAN)+toEuro(25$)-toEuro(toDollar(10UAN))-5euro = 15,50euro", "15,50euro",
                polishStrategy.eval("toEuro(10UAN)+toEuro(25$)-toEuro(toDollar(10UAN))-5euro").toString());
    }
}
