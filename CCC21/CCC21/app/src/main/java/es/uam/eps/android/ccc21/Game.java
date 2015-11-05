package es.uam.eps.android.ccc21;

public class Game {
	static final int SIZE = 7;
	private int grid[][];
	private static final int CROSS[][] = { { 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 0, 0 } };
	private static final int BOARD[][] = { { 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 0, 0 } };
	private int pickedI, pickedJ;
	private int jumpedI, jumpedJ;

	private enum State {
		READY_TO_PICK, READY_TO_DROP, FINISHED
	};

	private State gameState;

	public Game() {
		grid = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				grid[i][j] = CROSS[i][j];

		gameState = State.READY_TO_PICK;
	}

	public int getGrid(int i, int j) {
		return grid[i][j];
	}

	public boolean isAvailable(int i1, int j1, int i2, int j2) {

		if (grid[i1][j1] == 0 || grid[i2][j2] == 1)
			return false;

		if (Math.abs(i2 - i1) == 2 && j1 == j2) {
			jumpedI = i2 > i1 ? i1 + 1 : i2 + 1;
			jumpedJ = j1;
			if (grid[jumpedI][jumpedJ] == 1)
				return true;
		}

		if (Math.abs(j2 - j1) == 2 && i1 == i2) {
			jumpedI = i1;
			jumpedJ = j2 > j1 ? j1 + 1 : j2 + 1;
			if (grid[jumpedI][jumpedJ] == 1)
				return true;
		}

		return false;
	}

	public void play(int i, int j) {
		if (gameState == State.READY_TO_PICK) {
			pickedI = i;
			pickedJ = j;
			gameState = State.READY_TO_DROP;
		} else if (gameState == State.READY_TO_DROP) {
			if (isAvailable(pickedI, pickedJ, i, j)) {
				gameState = State.READY_TO_PICK;

				grid[pickedI][pickedJ] = 0;
				grid[jumpedI][jumpedJ] = 0;
				grid[i][j] = 1;

				if (isGameFinished())
					gameState = State.FINISHED;
			} else {
				pickedI = i;
				pickedJ = j;
			}
		}
	}

	public boolean isGameFinished() {

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				for (int p = 0; p < SIZE; p++)
					for (int q = 0; q < SIZE; q++)
						if (grid[i][j] == 1 && grid[p][q] == 0
								&& BOARD[p][q] == 1)
							if (isAvailable(i, j, p, q))
								return false;

		return true;
	}
	
	public String gridToString (){
	    String str = "";
	    for (int i=0; i<SIZE; i++)
		for (int j=0; j<SIZE; j++)
		    str += grid[i][j];
	    return str;
	}

	public void stringToGrid (String str){
	    for (int i=0, cont=0; i<SIZE; i++)
	        for (int j=0; j<SIZE; j++)
		     grid[i][j] = str.charAt(cont++)-'0';		
	}
}
