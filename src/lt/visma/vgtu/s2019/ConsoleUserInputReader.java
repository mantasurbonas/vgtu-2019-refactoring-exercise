package lt.visma.vgtu.s2019;

import java.io.IOException;

public class ConsoleUserInputReader {

	public static int readUserInput() throws IOException {
		int character;
		do {
			character = System.in.read();
		}while(character == '\n' || character == '\r');
		return character;
	}


}
