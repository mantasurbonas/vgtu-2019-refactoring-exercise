package lt.visma.vgtu.s2019;

public class GameRenderer {

	private Map map;
	private Pacman pacman;
	private Ghost ghost;

	public GameRenderer(Map map, Pacman pacman, Ghost ghost) {
		this.map = map;
		this.pacman = pacman;
		this.ghost = ghost;
	}
	
	public void drawFrame() {
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth();x++) {
				System.out.print(getElementToDraw(y, x));
			}
			System.out.println();
		}
		System.out.println();
	}


	private String getElementToDraw(int y, int x) {
		if (pacman.position.x == x && pacman.position.y == y) 
			return "C";
		
		if (ghost.position.x == x && ghost.position.y == y)
			return "W";
			
		int element = map.getMapElement(y, x);
		
		if (element == 0)
			return " ";

		return "#";
	}

}
