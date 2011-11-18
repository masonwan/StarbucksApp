public class KeyPad {

	public char press(int x, int y) {
		if (x == 3 && y == 4)
			return 'X';
		else if (x == 2 && y == 4)
			return '0';
		else if (x == 1 && y == 4)
			return ' ';
		else
			return (Integer.toString(x + 3 * (y - 1))).charAt(0);
	}
}