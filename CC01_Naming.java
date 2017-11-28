import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

class CC01_Naming {

	private List<int[]> theList = new ArrayList<>();
	private List<int[]> gameBoard = new ArrayList<>();
	private List<Cell> gameBoard2 = new ArrayList<>();
 	
	public static void main(String[] args){
		
		// 1 - Use Intention Revealing Names
		
			// K.O
			int d; // elapsed time in days 
					//(here the name d reveals nothing)
					
			// O.K
			int elapsedTimeInDays;
			int daysSinceCreation;
			int fileAgeInDays;
			
		// 2 - Avoid Desinformation
		
			// K.O
			int O = 0; // initial value
			int l = 1; // length
			if(O == l) // disinformative seems like (0 == 1)
				return;
				
			// Variables Names may be informative
			
		// 3- Make meaningful distinction between varaible name
			
			// K.O
			int zork;
			int theZork; // if two variables are diffrents then they may reflect this difference.
			int zorkVariable; // Variable name may never contains the work "variable"
			
			//NB : (To avoid) thee is no distinction between (theMessage, message), (money, moneyAmount) & (Customer, CustomerInfo)	
			
		// 5 - Give Searchable Names to variables		
			//-> If a variable or constant might be seen or used in multiple places in a body of code,
			// 	it is imperative to give it a search-friendly name
			
		// 6- Interface & Implementation
			// Don't need to put prefix 'I' to Interface Name (so ShapeFactory instead of IShapeFactory) 
			 	//beside it too much information& we're telling to the client of the interface
				// It's much likely to have 'ShapeFactoryImpl' than having prefix in the Interface Name
	
 	}
	
	// 4 - Use Pronounceable Names (Variable Names may be Prononciable)
		// K.O
		class DtaRcrd102 {
			private Date genymdhms; // for : generation year month day hour munite second.
			private Date modymdhms; // for : modification ...
		} 
		
		// O.K
		class Customer {
			private Date generationTimeStamp;
			private Date modificationTimeStamp;
		}
		
		// NB : This made easy communication between developper about thing (image discussion about the first case's attributes)
	
	// B-Ex-1 : Example method with "BAD NAMING"
	// Here are some question to lay on this function :
		// 1- What kinds of things are in 'theList' ?
		// 2- What is the significance of the zeroth elt of an elt in 'theList' ?
		// 3- What is the significance of the value 4 ?
		// 4- How would I use the list being returned ? 
	public List<int[]> getThem(){
		List<int[]> list1 = new ArrayList<>();
		for(int[] x : theList){
			if(x[0] == 4){
				list1.add(x);
			}
		}
		return list1;
	}
	
	// B-Ex-1 : WELL NAMED 1 (Reponse to the question)
	private int STATUS_VALUE = 0;
	private int FLAGGED = 4;
	public List<int[]> getFlaggedCells() {
		List<int[]> flaggedCells = new ArrayList<int[]>(); 
		for (int[] cell : gameBoard)
			if (cell[STATUS_VALUE] == FLAGGED) 
				flaggedCells.add(cell);
		return flaggedCells; 
	}
	
	// B-Ex-1 : WELL NAMED 2 (Improve Above Function)
	public List<Cell> getFlaggedCells_2() {
		List<Cell> flaggedCells = new ArrayList<Cell>(); 
		for (Cell cell : gameBoard2)
			if (cell.isFlagged()) 
				flaggedCells.add(cell);
		return flaggedCells; 
	}
	
	class Cell {
		
		public boolean isFlagged(){
			// May contains logics
			return true;
		}
	}
	
	// 7- Variable with unclear context (BAD EXEMPLE)
	private void printGuessStatistics(char candidate, int count){
		String number;
		String verb;
		String plurialModifier;
		
		if(count == 0){
			number = "no";
			verb = "are";
			plurialModifier = "s";
		}else if(count == 1){
			number = "1";
			verb = "is";
			plurialModifier = "";
		}else {
			number = Integer.toString(count);
			verb = "are";
			plurialModifier = "s";
		}
		
		String gessMessage = String.format(
			"There %s %s %s%s", verb, number, candidate, plurialModifier);
		return gessMessage;
	}
	
	// 7- Contextualized variable (One Solution for preceding example)
		// Main problem is that the function is long, so by creating GessStatisticMessage 
		//=> give clear context to the variables + Clarity of algorithm by breaking down into smalller functions  
	class GessStatisticMessage {
		// Above method variables have now clear context 
		private String number;
		private String verb;
		private String plurialModifier;
		
		public void make(char candidate, int count){}
	}
	
}