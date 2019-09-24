package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * nuskaito vartotojo komandą - šioje versijoje iš klaviatūros, bet ateityje
 * galės iš džoistiko ar pelės ir t.t.
 * 
 * @author mantas.urbonas
 *
 */
public class ConsoleUserInputReader {

	/***
	 * gražina skaitinę įvestos komandos reikšmę, pvz., 'a', 's', 'd', 'w'
	 * 
	 * nufiltruoja 'šiukšles', tokias kaip 'enter' klavišo paspaudimas.
	 * 
	 */
	public static Command readUserInput() throws IOException {
		int character;
		do {
			character = System.in.read();
		} while (character == '\n' || character == '\r');
		Command command = Command.valueOf((char) character);
		return command;
	}

}
