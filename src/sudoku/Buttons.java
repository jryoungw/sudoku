package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

import sudoku.Board;

public class Buttons{

	final static JFrame f = new JFrame("Sudoku by Ryoungwoo Jang");
	final static JButton[] buttonList = new JButton[9];
	final static JButton allClear = new JButton("Reset");
	final static JButton status = new JButton("On progress ...");
	final static JButton progress = new JButton("Click to check progress");
	private static int iset = 0;
	private static int jset = 0;
	private static int sum = 0;
	private static int flag = 0;
	private static Integer[][] defaultIndicesCanvas = {{0,2},
											{0,5},
											{0,6},
											{1,0},
											{1,1},
											{1,2},
											{1,4},
											{1,6},
											{1,7},
											{2,0},
											{2,2},
											{2,5},
											{2,7},
											{2,8},
											{3,0},
											{3,1},
											{3,4},
											{3,5},
											{3,6},
											{4,1},
											{4,6},
											{4,8},
											{5,0},
											{5,2},
											{5,5},
											{5,8},
											{6,0},
											{6,2},
											{6,4},
											{6,6},
											{6,7},
											{7,0},
											{7,2},
											{7,7},
											{8,5},
											{8,6},
											{8,7},
											{8,8}};
	private static List<List<Integer>> defaultIndices = Arrays.asList(defaultIndicesCanvas).stream().map(i -> Arrays.asList(i)).collect(Collectors.toList());
	private static ArrayList<ArrayList<Integer>> sudokuMap = new ArrayList<ArrayList<Integer>>();
	
	
	
	private static boolean checkIfContains(JButton[][] matrix, int i, int j) {
		boolean contains = false;
		for(int k=0;k<defaultIndices.size();k++) {
			if(i==defaultIndices.get(k).get(0)) {
				if(j==defaultIndices.get(k).get(1)) {
					contains = true;
				}
			}
		}
		return contains;

	}
	
	public static void setButtons(){
		System.out.println("Play start!");
		// Button setting
		Board b = new Board();
		JButton[][] matrix = b.getBoard();
		for(int idx=0;idx<9;idx++) {
			buttonList[idx] = new JButton(Integer.toString(idx+1));
			buttonList[idx].setBounds(1050+(idx%3)*100, 250+(idx/3)*100, 100, 100);
			buttonList[idx].setOpaque(true);
			buttonList[idx].setBackground(new Color(255,128,0));
			buttonList[idx].setFont(buttonList[idx].getFont().deriveFont(28f));
			f.add(buttonList[idx]);
		}
		
		
		
		
		allClear.setBounds(1050,150,300,100);
		allClear.setOpaque(true);
		allClear.setBackground(Color.BLUE);
		allClear.setFont(allClear.getFont().deriveFont(28f));
		f.add(allClear);
		
		progress.setBounds(1050,550,300,100);
		progress.setFont(allClear.getFont().deriveFont(20f));
		f.add(progress);
		
		status.setBounds(1050,650,300,100);
//		status.setOpaque(true);
//		status.setBackground(Color.BLUE);
		status.setEnabled(false);
		status.setFont(allClear.getFont().deriveFont(28f));
		f.add(status);
		
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++) {
				matrix[j][i].setBounds(i*90, j*90, 90, 90);
				matrix[i][j].setFont(matrix[j][i].getFont().deriveFont(28f));
				boolean contains = checkIfContains(matrix, i, j);
				if(contains) {
					matrix[i][j].setOpaque(true);
					matrix[i][j].setBackground(Color.BLACK);
				}
				f.add(matrix[i][j]);
			}
		Buttons but = new Buttons();
		/*
		 * Button click actions
		 */
		
		// Playboard button
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				final int itmp = i;
				final int jtmp = j;
				JButton pressed = matrix[i][j];
				pressed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == pressed) {
							but.iset = itmp;
							but.jset = jtmp;
						}
					}
				});
			}
		}
		
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++) {
//				final int itmp = i;
//				final int jtmp = j;
//				JButton pressed = matrix[i][j];
//				pressed.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						if(e.getSource()==pressed) {
//							but.iset = itmp;
//							but.jset = jtmp;
//							for(int i=0;i<9;i++) {
//								for(int j=0;j<9;j++) {
//									if(matrix[i][j].getText()==pressed.getText()) {
//										matrix[i][j].setOpaque(true);
//										matrix[i][j].setBackground(Color.GRAY);
//									}
//								}
//							}
//						}
//					}
//				});
//			}
//		}
		
		// 1~9 button
		
		for(int num=0;num<9;num++) {
			JButton jb = buttonList[num];
			jb.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					matrix[iset][jset].setText(jb.getText());
				}
			});
		}
		
		// Reset button
		

		JButton c = allClear;
		c.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
//						ArrayList<Integer> tmpList = new ArrayList<Integer>();
//						tmpList.add(i);
//						tmpList.add(j);
						final Integer[] tmpList = {i,j};
						if(!defaultIndices.contains(Arrays.asList(tmpList))) {
//						if(!defaultIndices.get(tmpList)) {
							matrix[i][j].setText("");
							matrix[i][j].setBackground(null);
						} else {
							System.out.println(1);
						}
					}
				}
			}
		});
		
		// Progress check button implementation
		
		JButton p = progress;
		p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final boolean[][] success = new boolean[9][9];
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
						success[i][j] = false;
					}
				}
				// Row sum check
				int rowFlag = 0;
				for(int i=0;i<9;i++) {
					int rowCount = 0;
					int stmp = 0;
					for(int j=0;j<9;j++) {
						String ijText = matrix[j][i].getText(); // i j
						if(ijText!="") {
							int vtmp = Integer.parseInt(ijText);
							stmp = stmp + vtmp;
							rowCount = rowCount + 1;
						}
					}
					if((stmp==45) && (rowCount==9)) {
						for(int jdx=0;jdx<9;jdx++) {
							success[jdx][i] = true;
						}
					}
				}
				
				// Column sum check
				int columnFlag = 0;
				for(int i=0;i<9;i++) {
					int colCount = 0;
					int stmp = 0;
					for(int j=0;j<9;j++) {
						String ijText = matrix[i][j].getText(); // j i
						if(ijText!="") {
							int vtmp = Integer.parseInt(ijText);
							stmp = stmp + vtmp;
							colCount = colCount + 1;
						}
					}
					if((stmp==45) && (colCount==9)) {
						for(int jdx=0;jdx<9;jdx++) {
							success[i][jdx] = true;
						}
					}
				}
				for(int idx=0;idx<9;idx++) {
					for(int jdx=0;jdx<9;jdx++) {
						if(success[idx][jdx] == true) {
							matrix[idx][jdx].setOpaque(true);
							matrix[idx][jdx].setBackground(Color.GREEN);
						}
						else {
							matrix[idx][jdx].setOpaque(true);
							matrix[idx][jdx].setBackground(null);
						}
					}
				}
				
				if((rowFlag==9) && (columnFlag==9)) {
					status.setText("Finished");
				}
			}
		});
		
		


		
		f.setSize(1500,1500);
		f.setLayout(null);
		f.setVisible(true);
		
	}
}
