import java.util.*;
import java.io.*;

public class GameOfLifeMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Play game from file? (y/n)");
		String premade = sc.next();
		GameOfLife board = null;
		if (premade.contentEquals("y")) {
			String filename = null;
			File file = null;
			boolean fileFound = false;
			while (!fileFound) {
				System.out.print("Enter name of premade file: ");
				filename = sc.next();
				file = new File(filename);
				fileFound = file.exists();
				if (!fileFound) {
					System.out.println("File not found, try again ");
				}
			}
			Cell[][] loadFile = loadFile(file);
			board = new GameOfLife(loadFile);

		} else {
			System.out.print("Enter size of grid: ");
			int size = sc.nextInt();
			board = new GameOfLife(size);
		}
		int i = 0;
		board.initialize();
		while (board.isActive()) {
			StdDraw.show(0);
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(-1, -1, "" + i);
			board.draw();
			StdDraw.show(1);
			board.nextState();
			i++;
		}
		board.draw();
		StdDraw.show(50);

		System.out.println("Thanks for playing. Press 0 to exit");
		if (sc.nextInt() == 0) {
			System.exit(0);
		}
	}

	public static Cell[][] loadFile(File file) throws FileNotFoundException {

		List<String> allCells = new ArrayList<>();

		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allCells.add(line);
		}

		int size = allCells.size();
		Cell[][] matrix = new Cell[size][size];

		for (int y = 0; y < size; y++) {
			String line = allCells.get(y);
			int x = 0;
			int i = 0;
			while (i < line.length()) {
				char c = line.charAt(i);
				if (c != ' ') {
					matrix[size - y - 1][x] = new Cell(c != '0', 0);
					x++;
				}
				i++;
			}
		}
		return matrix;
	}

}
