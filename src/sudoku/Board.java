package sudoku;

import javax.swing.*;

public class Board {
	public JButton[][] getBoard() {
		JButton[][] matrix = new JButton[9][9];
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				matrix[i][j] = new JButton("");
			}
		}
		matrix[0][2] = new JButton("8");
		matrix[0][2].setEnabled(false);
		matrix[0][5] = new JButton("5");
		matrix[0][5].setEnabled(false);
		matrix[0][6] = new JButton("9");
		matrix[0][6].setEnabled(false);
		
		matrix[1][0] = new JButton("4");
		matrix[1][0].setEnabled(false);
		matrix[1][1] = new JButton("2");
		matrix[1][1].setEnabled(false);
		matrix[1][2] = new JButton("9");
		matrix[1][2].setEnabled(false);
		matrix[1][4] = new JButton("6");
		matrix[1][4].setEnabled(false);
		matrix[1][6] = new JButton("1");
		matrix[1][6].setEnabled(false);
		matrix[1][7] = new JButton("8");
		matrix[1][7].setEnabled(false);
		
		matrix[2][0] = new JButton("5");
		matrix[2][0].setEnabled(false);
		matrix[2][2] = new JButton("1");
		matrix[2][2].setEnabled(false);
		matrix[2][5] = new JButton("8");
		matrix[2][5].setEnabled(false);
		matrix[2][7] = new JButton("7");
		matrix[2][7].setEnabled(false);
		matrix[2][8] = new JButton("4");
		matrix[2][8].setEnabled(false);
		
		matrix[3][0] = new JButton("6");
		matrix[3][0].setEnabled(false);
		matrix[3][1] = new JButton("1");
		matrix[3][1].setEnabled(false);
		matrix[3][4] = new JButton("4");
		matrix[3][4].setEnabled(false);
		matrix[3][5] = new JButton("9");
		matrix[3][5].setEnabled(false);
		matrix[3][6] = new JButton("8");
		matrix[3][6].setEnabled(false);
	
		matrix[4][1] = new JButton("5");
		matrix[4][1].setEnabled(false);
		matrix[4][6] = new JButton("6");
		matrix[4][6].setEnabled(false);
		matrix[4][8] = new JButton("9");
		matrix[4][8].setEnabled(false);
		
		matrix[5][0] = new JButton("9");
		matrix[5][0].setEnabled(false);
		matrix[5][2] = new JButton("4");
		matrix[5][2].setEnabled(false);
		matrix[5][5] = new JButton("2");
		matrix[5][5].setEnabled(false);
		matrix[5][8] = new JButton("1");
		matrix[5][8].setEnabled(false);
		
		matrix[6][0] = new JButton("1");
		matrix[6][0].setEnabled(false);
		matrix[6][2] = new JButton("6");
		matrix[6][2].setEnabled(false);
		matrix[6][4] = new JButton("8");
		matrix[6][4].setEnabled(false);
		matrix[6][6] = new JButton("7");
		matrix[6][6].setEnabled(false);
		matrix[6][7] = new JButton("5");
		matrix[6][7].setEnabled(false);
	
		matrix[7][0] = new JButton("7");
		matrix[7][0].setEnabled(false);
		matrix[7][2] = new JButton("4");
		matrix[7][2].setEnabled(false);
		matrix[7][7] = new JButton("1");
		matrix[7][7].setEnabled(false);
		
		matrix[8][5] = new JButton("7");
		matrix[8][5].setEnabled(false);
		matrix[8][6] = new JButton("4");
		matrix[8][6].setEnabled(false);
		matrix[8][7] = new JButton("9");
		matrix[8][7].setEnabled(false);
		matrix[8][8] = new JButton("6");
		matrix[8][8].setEnabled(false);
		
		return matrix;
	}
}
