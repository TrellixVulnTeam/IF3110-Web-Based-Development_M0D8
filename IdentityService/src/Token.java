import java.util.Random;

public class Token {
	private StringBuilder token;
	private static final int length = 20;
	
	public Token() {
		token = new StringBuilder(length);
	}
	
	public void generate() {
		Random rand = new Random();
		for (int i = 0; i < length; ++i) {
			int ascii = rand.nextInt(26) + (int) 'a';
			boolean capital = rand.nextBoolean();
			if (capital) {
				ascii -= 32;
			}
			token.setCharAt(i, (char) ascii);
		}
	}
	
	public String get() {
		return token.toString();
	}
}
