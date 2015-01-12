import com.sourceit.functions.PropertiesCurrency;
import org.junit.Assert;
import org.junit.*;

public class PropertiesCurrencyTest extends Assert {
    private PropertiesCurrency propertiesCurrency;

    @Before
    public void setUp() throws Exception {
        System.out.println("Method started");
        propertiesCurrency = new PropertiesCurrency();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Method finished");
    }
    @Test
    public void parseStringTest() throws Exception {
        assertEquals("{[toEuro, Xeuro]={$=1.22, UAN=19.27}, [toDollar, $X]={euro=0.81, UAN=15.77}}",
                propertiesCurrency.parseString().toString());
    }
}
