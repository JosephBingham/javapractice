package hw3;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import api.Cell;
import api.Flow;

/**
 * Utility class with methods for creating Flows from string descriptors
 * and reading string descriptors from a file.  A string descriptor is
 * an array of strings, all with the same length, in which an alphabetic
 * character at a given row and column represents a cell at that
 * row and column.  The color of the cell is determined from the character
 * by the Cell constructor.  A descriptor is invalid if not all strings
 * are the same length or if there is an alphabetic character that 
 * does not appear exactly twice.
 */
public class Util
{
  /**
   * Creates an array of Flow objects based on the string descriptor.
   * If the descriptor is invalid, this method returns null.
   * @param descriptor
   *   array of strings
   * @return
   *   array of Flow objects determined by the descriptor 
   */
  public static Flow[] createFlowsFromStringArray(String[] descriptor)
  {
	//double loop through and make a cell from it. 
	 
	  ArrayList<Cell> created = new ArrayList<Cell>(0);
	for (int i = 0; i < descriptor.length; i ++){
		descriptor[i] = descriptor[i].trim();
		for (int j = 0; j < descriptor[i].length(); j ++){
			if(descriptor[i].charAt(j) != '-'){
				Cell cell = new Cell(i, j, descriptor[i].charAt(j));
				created.add(cell);
			}
		}
	}
	Flow[] flower = new Flow[created.size()/2];
	int k = 0;
	for(int i = 0; i < created.size(); i++ ){
		for(int j = 0; j < created.size(); i++){
			if(created.get(i).colorMatches(created.get(j).getColor()) && hasIn(flower, created.get(i).getColor()) ){
				Flow f = new Flow(created.get(i), created.get(j));
				flower[k] = f;
				k++;
			}
		}
	}
	  
    return flower;
  }
  
  private static boolean hasIn(Flow[] flower, Color color){
	 if(flower.length == 0){
		 return false;
	 }else{
	  for(Flow j : flower){
		  if(j.getColor().equals(color)){
			  return true;
		  }
		  
	  }
	  return false;
  }
  }
  
 
  /**
   * Reads the given file and constructs a list of FlowGame objects, one for
   * each descriptor in the file.  Descriptors in the file are separated by 
   * some amount of whitespace, but the file need not end with whitespace and
   * may have extra whitespace at the beginning.  Invalid descriptors in the file
   * are ignored, so the method may return an empty list.
   * @param filename
   *   name of the file to read
   * @return
   *   list of FlowGame objects created from the valid descriptors in the file
   * @throws FileNotFoundException
   */
  public static ArrayList<FlowGame> readFile(String filename) throws FileNotFoundException
  {
    // TODO
	  //read line to read online at a time create array from string. 
	  ArrayList<FlowGame> flowgamey = new ArrayList<FlowGame>();
	  String[] stringy = filename.split("\\s*\n\\s*\n\\s*");
	  for(String s  : stringy){
		  String[] stringed = s.split("\n");
		  Flow[] flowy = createFlowsFromStringArray(stringed);
		  FlowGame g = new FlowGame(flowy ,stringed.length, stringed[0].trim().length());
		  flowgamey.add(g);
	  }
	  return flowgamey;
  }

}
