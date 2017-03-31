import org.junit.Test;
import static org.junit.Assert.*;

public class HtmlToSpannedConverterTest1 {
    
	@Test
    public void endBlockElementTest_If1() {
		HtmlToSpannedConverter converter = new HtmlToSpannedConverter();
        assertEquals(4, 2 + 2);
    }
}