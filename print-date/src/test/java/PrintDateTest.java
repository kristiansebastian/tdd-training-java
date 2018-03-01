import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class PrintDateTest {

	@Test
	public void testPrintCurrentDate() {
		Printer printer = Mockito.mock(Printer.class);
		DateProvider dateProvider = Mockito.mock(DateProvider.class);
		PrintDate printDate = new PrintDate(printer, dateProvider);
		Date date = new Date();
		Mockito.when(dateProvider.getCurrentDate()).thenReturn(date);

		printDate.printCurrentDate();

		Mockito.verify(printer).printDate(date);
	}
}
