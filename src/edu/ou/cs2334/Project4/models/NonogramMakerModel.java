/**
 * @author crlar
 */
package edu.ou.cs2334.project4.models;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
public class NonogramMakerModel {

	private static final char EMPTY_CELL_CHAR = '0';
	private static final char FILLED_CELL_CHAR = '1';
	private int numRows;
	private int numCols;
	private boolean[][] grid;
	/**
	 * 
	 * @param numRows
	 * Insert into constructor rows
	 * @param numCols
	 * Insert into constructor Columns
	 */
	public NonogramMakerModel(int numRows, int numCols) 
	{
		if(numRows <= 0 || numCols <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.numRows = numRows;
			this.numCols = numCols;
			grid = new boolean[numRows][numCols];
		}
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param file
	 * @throws IOException
	 */
	public NonogramMakerModel(File file) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String[] size = br.readLine().split(" ");
		numRows = Integer.parseInt(size[0]);
		numCols = Integer.parseInt(size[1]);
		grid = new boolean[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
		int count = 0;
		for(int i = 0; i < Integer.parseInt(size[0]); ++i)
		{
			String j = br.readLine();
			String[] jArr = j.split(" ");
			
		}
		for(int i = 0; i < numCols; ++i)
		{
			br.readLine();
		}
		for(int i = 0; i < numRows; ++i)
		{
			String str = br.readLine();
			char[] charArr = str.toCharArray();
			for(int j = 0; j < numCols; ++j)
			{
				if(charArr[j] == EMPTY_CELL_CHAR)
				{
					grid[i][j] = false;
				}
				else
				{
					grid[i][j] = true;
				}
			}
		}
		br.close();
	}
	/**
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public NonogramMakerModel(String filename)throws IOException
	{
		this(new File(filename));
	}
	/**
	 * 
	 * @return
	 * a 2d boolean array of grid
	 */
	public boolean[][] getGrid()
	{
		return grid;
	}
	/**
	 * 
	 * @param rowIdx
	 * @param colIdx
	 * @return
	 */
	public boolean getCell(int rowIdx, int colIdx)
	{
		return grid[rowIdx][colIdx];
	}
	public void setCell(int rowIdx, int colIdx, boolean state)
	{
		grid[rowIdx][colIdx] = state;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumRows()
	{
		return grid.length;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumCols()
	{
		return grid[0].length;
	}
	/**
	 * 
	 * @param cells
	 * takes in a boolean not the grid but like a row
	 * @return
	 * a counted method of nonograms
	 */
	public static List<Integer> project(boolean[] cells)
	{
		int count = 0;
		List<Integer> arl = new ArrayList<Integer>();
		for(int i = 0; i < cells.length; i++)
		{
			
			if(cells[i] == true)
			{
				count++;
			}
			if(cells[i] == false)
			{
				if(count > 0)
				{
					arl.add(count);
				}
				count = 0;
			}
		}
		if(count > 0)
			arl.add(count);
		if(arl.size() == 0)
			arl.add(0);
			return arl;
		
	}
	/**
	 * uses the project(boolean[] cells method
	 * @param rowIdx
	 * @return
	 */
	public List<Integer> projectRow(int rowIdx)
	{
		boolean[] arr = new boolean[numCols];
		for(int i = 0; i < numCols; ++i)
		{
			arr[i] = grid[rowIdx][i];
		}
		return project(arr);
	}
	/**
	 * uses the project boolean[] cells method
	 * @param colIdx
	 * @return
	 */
	public List<Integer> projectCol(int colIdx)
	{
		boolean[] arr = new boolean[numRows];
		for(int i = 0; i < numRows; ++i)
		{
			arr[i] = grid[i][colIdx];
		}
		return project(arr);
	}
	@Override
	public String toString()
	{
		StringJoiner stj = new StringJoiner(System.lineSeparator());
		stj.add(numRows + " " + numCols);
		for(int i = 0; i < numRows; ++i)
		{
			stj.add(projectRow(i).toString().replaceAll(",", "")
					.replace("[", "").replace("]", ""));
		}
		for(int i = 0; i < numCols; ++i)
		{
			stj.add(projectCol(i).toString().replaceAll(",", "")
					.replace("[", "").replace("]", ""));
		}
		for(int i = 0; i < numRows; ++i)
		{
			stj.add(printRow(i));
		}
		//stj.add(Arrays.toString(grid));
				//.replace("false", String.valueOf(EMPTY_CELL_CHAR))
				//.replace("true", String.valueOf(FILLED_CELL_CHAR)));
		return stj.toString();
	}
	/**
	 * 
	 * @param r
	 * Setup on zero base
	 * @return
	 */
	private String printRow(int r)
	{
		StringJoiner stj = new StringJoiner("");
	    for(int i=0; i<grid[r].length; i++)
	    {
	        
	        stj.add(String.valueOf(grid[r][i]));
	    }
	    return stj.toString().replaceAll("false", String.valueOf(EMPTY_CELL_CHAR)).replaceAll("true", String.valueOf(FILLED_CELL_CHAR));
	}

}
