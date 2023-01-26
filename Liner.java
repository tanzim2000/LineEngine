/**
 * <p style="text-align:center;font-size:xx-large;">Line Engine</p>
 * <hr>
 * <p style="text-align:center;">A class tool to generate ASCI line in output</p>
 * <br>
 * <p style="font-size:medium;"><b><u>New in 3.2</u></b></p>
 * <ul>
 * 	<li>Better Javadoc for ease of access.</li>
 * 	<li>New set of class constructors</li>
 * 	<li>Bug Fixes</li>
 * </ul>
 * <div style="border: 2px dashed; background-color: black; color: blue;">
 * <p style="text-align:center;">Newer update will support pattern arguments</p>
 * </div>
 * <br>
 * @author Tanzim Ahmed Sagar
 * @version 3.2
 * @since 10.11.2022
 */
public class Liner {
	/** default {@code char} element to create a line */
	private char lineElement;
	/** default line length */
	private int lineLength;
	
	/**
	 * default constructor
	 * @since 2.0
	 */
	public Liner() {
		this('*', 80);
	}
	/**
	 * constructor that sets the passed argument as the default {@code char} element
	 * and {@code 80} as default length
	 * @since 2.0
	 * @param lineElement default line element
	 */
	public Liner(char lineElement) {
		this(lineElement, 80);
	}
	/**
	 * constructor that sets the passed argument as the default {@code int} length
	 * and {@code '*'} as default element
	 * @since 3.2
	 * @param lineLength default length of the line
	 */
	public Liner(int lineLength) {
		this('*', lineLength);
	}
	/**
	 * constructor that sets the passed arguments as the default.
	 * @since 3.2
	 * @param lineElement default line element
	 * @param lineLength default length of the line
	 */
	public Liner(char lineElement, int lineLength) {
		this.lineElement = lineElement;
		this.lineLength = lineLength;
	}
	/**
	 * default method to print a line
	 * uses default {@code char} to construct a line
	 * with the default length.
	 * @since 2.0
	 * @return {@code string} representing a line
	 */
	public String print() {
		String line = this.print(this.lineElement);
		return line;
	}
	/**
	 * method to print a line that takes a {@code char} to construct a line
	 * with the default length.
	 * @since 1.0
	 * @param lineElement char that'll construct the line
	 * @return string represents a line
	 */
	public String print(char lineElement) {
		String line = this.print(lineElement, this.lineLength);
		return line;
	}
	/**
	 * method to print a line that takes a {@code int} to construct a line of that length
	 * with the default {@code char} element.
	 * @since 3.0
	 * @param lineLength length of the line
	 * @return string represents a line
	 */
	public String print(int lineLength) {
		String line = this.print(this.lineElement, lineLength);
		return line;
	}
	/**
	 * method to print a line that takes a {@code char} to construct a line
	 * with the given length in {@code int}
	 * @since 3.0
	 * @param lineElement char that'll construct the line
	 * @param lineLength length of the line
	 * @return string represents a line
	 */
	public String print(char lineElement, int lineLength) {
		String line = "";
		for(int i = 0; i < lineLength; i++) {
			line = line + lineElement;
		}
		return line;
	}
	/* === PATTERN IMPL === */
	/**
	 * Method to generate a line using a given pattern, mode, and line length.
	 * @since 3.5
	 * @param pattern The pattern for the line, as a string.
	 * @param mode The mode to use for generating the line, as a char.
	 * @param lineLength The desired length of the generated line.
	 * @return The generated line as a string.
	 */
	public String pattern(String pattern, char mode, int lineLength) {
		String line = "";
		switch (mode) {
			case 'F':
				int patternIndex = 0;
				while (line.length() < lineLength) {
					line += pattern.charAt(patternIndex);
					patternIndex++;
					if (patternIndex == pattern.length()) {
						patternIndex = 0;
					}
				}
				break;
			case 'S':
				int stretch = pattern.length() - (lineLength % pattern.length());
				for (int i = 0; i < pattern.length(); i++) {
					for (int j = 0; j < stretch; j++) {
						line += pattern.charAt(i);
					}
				}
				break;
			case 'C':
				int border = (lineLength / 2) - (pattern.length() / 2);
				for (int i = 0; i < border; i++) {
					line += pattern.charAt(0);
				}
				line += pattern;
				for (int i = 0; i < border; i++) {
					line += pattern.charAt(pattern.length() - 1);
				}
				break;
		}
		return line;
	}
}
