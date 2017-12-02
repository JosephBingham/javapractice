package hw3;

import api.Cell;
import api.Flow;

/**
 * Game state for a Flow Free game.
 */
public class FlowGame {
	/**
	 * Constructs a FlowGame to use the given array of Flows and the given width
	 * and height. Client is responsible for ensuring that all cells in the
	 * given flows have row and column values within the given width and height.
	 * 
	 * @param givenFlows
	 *            an array of Flow objects
	 * @param givenWidth
	 *            width to use for the game
	 * @param givenHeight
	 *            height to use for the game
	 */
	/*
	 * these vars are all the vars needed to do this project.  
	 */
	private int maxRow = 0;
	private int maxCol = 0;
	private Flow[] flowed;
	private Cell current;
	private Flow flowing;

	public FlowGame(Flow[] givenFlows, int givenWidth, int givenHeight) {

		this.maxRow = givenWidth;
		this.maxCol = givenHeight;
		this.flowed = givenFlows;
		this.current = null;
	}

	/**
	 * Constructs a FlowGame from the given descriptor.
	 * 
	 * @param descriptor
	 *            array of strings representing initial endpoint positions
	 */
	public FlowGame(String[] descriptor) {
		
		this.flowed = Util.createFlowsFromStringArray(descriptor);
		this.maxRow = descriptor.length;
		this.maxCol = descriptor[1].length();
		this.current = null;
	}

	/**
	 * Returns the width for this game.
	 * 
	 * @return width for this game
	 */
	public int getWidth() {

		return maxRow;
	}

	/**
	 * Returns the height for this game.
	 * 
	 * @return height for this game
	 */
	public int getHeight() {

		return maxCol;
	}

	/**
	 * Returns the current cell for this game, possible null.
	 * 
	 * @return current cell for this game
	 */
	public Cell getCurrent() {
		
		return current;
	}

	/**
	 * Returns all flows for this game. Client should not modify the returned
	 * array or lists.
	 * 
	 * @return array of flows for this game
	 */
	public Flow[] getAllFlows() {
		
		return flowed;
	}

	/**
	 * Returns the number of occupied cells in all flows (including endpoints).
	 * 
	 * @return occupied cells in this game
	 */
	public int getCount() {
		// TODO
		int count = 0;
		for(Flow f: flowed){
			count += f.getCells().size();
		}
		return count;
	}

	/**
	 * Returns true if all flows are complete and all cells are occupied.
	 * 
	 * @return true if all flows are complete and all cells are occupied
	 */
	public boolean isComplete() {
		if(getCount() == maxRow*maxCol && isFlowen())
		return true;
		else return false;
	}
/*
 * This is a helper method to checks to see if any of the flows are incomplete
 */
	private boolean isFlowen(){
		for(Flow f : flowed){
			if(!f.isComplete())
				return false;
		}
		return true;
	}
	/**
	 * Attempts to set the "current" cell to be an existing cell at the given
	 * row and column. When using a GUI, this method is typically invoked when
	 * the mouse is pressed.
	 * <ul>
	 * <li>Any endpoint can be selected as the current cell. Selecting an
	 * endpoint clears the flow associated with that endpoint.
	 * <li>A non-endpoint cell can be selected as the current cell only if it is
	 * the last cell in a flow.
	 * </ul>
	 * If neither of the above conditions is met, this method does nothing.
	 * 
	 * @param row
	 *            given row
	 * @param col
	 *            given column
	 */
	public void startFlow(int row, int col) {
		for (Flow f : flowed)
			for (int i = 0; i <= 1; i++) {
				Cell c = f.getEndpoint(i);
				if (c.positionMatches(row, col)) {
					flowing = f;
					flowing.clear();
					current = c;
					flowing.add(current);
				}
			}
	}

	/**
	 * Clears the "current" cell. That is, directly after invoking this method,
	 * <code>getCurrent</code> returns null. When using a GUI, this method is
	 * typically invoked when the mouse is released.
	 */
	public void endFlow() {
		
		current = null;
		flowing = null;
	}

	/**
	 * Attempts to add a new cell to the flow containing the current cell. When
	 * using a GUI, this method is typically invoked when the mouse is dragged.
	 * In order to add a cell, the following conditions must be satisfied:
	 * <ol>
	 * <li>The current cell is non-null
	 * <li>The given position is horizontally or vertically adjacent to the
	 * current cell
	 * <li>The given position either is not occupied OR it is occupied by an
	 * endpoint for the flow that is not already in the flow </ul> If the three
	 * conditions are met, a new cell with the given row/column and correct
	 * color is added to the current flow, and the current cell is updated to be
	 * the new cell.
	 * 
	 * @param row
	 *            given row for the new cell
	 * @param col
	 *            given column for the new cell
	 */
	public void addCell(int row, int col)
  {
		if(current != null && isAdjacent(row, col) && !isOccupied(row, col))
		{
			if (flowing.isComplete()){
				current = null;
			}
			else{
				current = new Cell(row, col, flowing.getColor());
			}
			if(current != null){
				flowing.add(current);
			}
		}
		
  }
/*
 * this is a helper method that checks to see if the cell in question is adjacent
 * to a given cell
 */
	private boolean isAdjacent(int row, int col){
		boolean isHorizontallyAdjacent = (Math.abs(col - current.getCol()) == 1) && row == current.getRow();
		boolean isVerticallyAdjacent = (Math.abs(row - current.getRow()) == 1) && col == current.getCol();
		if(isHorizontallyAdjacent || isVerticallyAdjacent){
			return true;
		}else{
			return false;
		}
		
  }

	/**
	 * Returns true if the given position is occupied by a cell in a flow in
	 * this game (possibly an endpoint).
	 * 
	 * @param row
	 *            given row
	 * @param col
	 *            given column
	 * @return true if any cell in this game has the given row and column, false
	 *         otherwise
	 */
	public boolean isOccupied(int row, int col) {
		
		for(Flow f: flowed){
			for(Cell c: f.getCells()){
				if(c.positionMatches(row, col) || isEndPoint(row,col)){
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * This is a helper method that takes in the same row and col from the method
	 * and checks to see if the cell is and endpoint and if it is not the same color
	 * as the first endpoint.
	 */
	private boolean	isEndPoint(int row, int col){
		for(Flow f: flowed){
			for(int i=0; i <= 1; i++){
				if(f.getEndpoint(i).positionMatches(row, col) && !current.colorMatches(f.getEndpoint(i).getColor()))
					return true;
			}
		}
		return false;
	}

	
	
}
