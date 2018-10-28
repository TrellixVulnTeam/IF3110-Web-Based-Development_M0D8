import java.util.Random;

public class Token {
	private StringBuilder token;
	private static final int length = 20;
	
	public Token() {
		token = new StringBuilder(length);
		for (int i = 0; i < length; ++i) {
			token.append((char) 0);
		}
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
