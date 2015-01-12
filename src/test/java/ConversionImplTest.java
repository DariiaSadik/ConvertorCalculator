import com.sourceit.functions.ConversionImpl;
import com.sourceit.models.Currency;
import org.junit.Assert;
import org.junit.*;

public class ConversionImplTest extends Assert {
    private ConversionImpl conversion;

    @Before
    public void setUp() throws Exception {
        System.out.println("Method started");
        conversion = new ConversionImpl();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Method finished");
    }
    @Test
    public void conversionUanToEuro() throws Exception {
        assertEquals("", "0,52euro",
                conversion.converting(new Currency("UAN", 10), "toEuro").toString());
    }
    @Test
    public void conversionDollarToEuro() throws Exception {
        assertEquals("", "8,20euro",
                conversion.converting(new Currency("$", 10), "toEuro").toString());
    }
    @Test
    public void conversionUanToDollar() throws Exception {
        assertEquals("", "12,35$",
                conversion.converting(new Currency("euro", 10), "toDollar").toString());
    }
    @Test
    public void conversionEuroToDollar() throws Exception {
        assertEquals("", "0,63$",
                conversion.converting(new Currency("UAN", 10), "toDollar").toString());
    }
    @Test
    public void equalsType() throws Exception {
        String type = conversion.converting(new Currency("UAN", 10), "toDollar").getType();
        String typeActual = "$";
        assertTrue(typeActual.equals(type));
    }
}
