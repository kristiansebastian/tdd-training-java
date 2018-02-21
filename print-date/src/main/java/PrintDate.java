public class PrintDate {

    private Printer printer;
    private DateProvider dateProvider;

	public PrintDate(Printer printer, DateProvider dateProvider) {
		this.printer = printer;
		this.dateProvider = dateProvider;
	}

	public void printCurrentDate() {
		this.printer.printCurrentDate(this.dateProvider.getCurrentDate());
}
}
