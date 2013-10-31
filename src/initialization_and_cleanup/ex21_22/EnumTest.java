package initialization_and_cleanup.ex21_22;

public class EnumTest {
	public enum PaperCurrency { ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED }

	public void printEnum(PaperCurrency paperCurrency) {
		String output = null;
		// It's possible to do without a switch statement
		switch(paperCurrency) {
		case ONE:
			output = "$1";
			break;
		case FIVE:
			output = "$5";
			break;
		case TEN:
			output = "$10";
			break;
		case TWENTY:
			output = "$20";
			break;
		case FIFTY:
			output = "$50";
			break;
		case HUNDRED:
			output = "$100";
			break;
		}
		System.out.println(output);
	}

	public static void main() {
		for(PaperCurrency item : PaperCurrency.values()) {
			System.out.println(item + ", ordinal " + item.ordinal());
		}
	}
}