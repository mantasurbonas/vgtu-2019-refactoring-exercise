package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * nuskaito vartotojo komandą - šioje versijoje iš klaviatūros, bet ateityje galės iš džoistiko ar pelės ir t.t.
 *
 * @author mantas.urbonas
 *
 */
public class ConsoleUserInputReader {
	/***
	 * gražina skaitinę įvestos komandos reikšmę, pvz., 'a', 's', 'd', 'w'
	 *
	 *  nufiltruoja 'šiukšles', tokias kaip 'enter' klavišo paspaudimas.
	 *
	 */
	final private static char NEW_LINE = '\n';
	final private static char CARRIAGE_RETURN = '\r';

	public static int readUserInput() throws IOException {
		int character;
		do {
			character = System.in.read();
		} while (character == NEW_LINE || character == CARRIAGE_RETURN);
		return character;
	}
}
