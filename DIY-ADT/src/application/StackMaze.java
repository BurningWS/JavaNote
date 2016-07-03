package application;

import stack.StackArray;

public class StackMaze {
	static char[][] maze = { { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
			{ '1', '0', '0', '1', '1', '1', '0', '0', '1', '1' },
			{ '1', '0', '0', '1', '1', '0', '0', '1', '0', '1' },
			{ '1', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
			{ '1', '0', '0', '0', '0', '1', '1', '0', '0', '1' },
			{ '1', '0', '0', '1', '1', '1', '0', '0', '0', '1' },
			{ '1', '0', '0', '0', '0', '1', '0', '1', '0', '1' },
			{ '1', '0', '1', '1', '0', '0', '0', '1', '0', '1' },
			{ '1', '1', '0', '0', '0', '0', '1', '0', '0', '1' },
			{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' } };

	private class Cell {
		int x;
		int y;
		boolean visited;
		char c;

		public Cell(int x, int y, boolean visited, char c) {
			super();
			this.x = x;
			this.y = y;
			this.visited = visited;
			this.c = c;
		}
	}

	private Cell[][] createMaze(char[][] maze) {
		Cell[][] cell = new Cell[maze.length][];
		for (int i = 0; i < cell.length; i++) {
			cell[i] = new Cell[maze[i].length];
			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = new Cell(i, j, false, maze[i][j]);
			}
		}
		return cell;
	}

	private void printMaze(Cell[][] cells) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				System.out.print(cells[i][j].c+" ");
			}
			System.out.println();
		}
	}

	public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		Cell[][] cells = createMaze(maze);
		printMaze(cells);
		StackArray s = new StackArray();
		
	}

	public static void main(String[] args) {
		new StackMaze().mazeExit(maze,8,8,1,7);
		
	}
}
