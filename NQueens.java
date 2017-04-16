
public class NQueens {



	public static void printBoard(int[] board){
    int rowandcol=board.length;
    if(rowandcol>0){//check the board is not empty
    	for(int i=0,tamp;i<rowandcol;i++){
    		tamp=board[i];//check where is the queen  
    		for (int j = 0; j < board.length; j++) {
    			if(tamp==j){
			
					System.out.print("Q"+" ");//print the queen 
				}
				else{
					System.out.print("*"+" ");//print the *
				}
    		}
    		System.out.println();
    	}	
    }else System.out.println("There is no solution");
    


	}
	public static boolean checkrowcol(int[] board, int n,int stopvar){//check if the only queen in the diagonals line
    int tamp=n;//the row
    int tamp2=board[n];//the col
    boolean ans=true;
    for (int i = 0; i < stopvar&&ans; i++) {
		if(Math.abs(tamp-i)==Math.abs(tamp2-board[i])&&i!=n){//check 
			ans=false;
		}
	}
	return ans;
	}
	
	public static boolean same(int[] board,int n){//check if the only queen in the column
		boolean ans=true;
		for (int i = 0; (i <n)&&ans; i++) {
			for (int j = i+1; (j <n)&&ans; j++) {
				if(board[i]==board[j]){//check if the queen in the same column with different queen 
					ans=false;
					
				}
			}
			
		}
		return ans;
	}

	public static boolean isLegalSolution(int[] board, int n){
       boolean ans =true;
		if(board.length==0&&(n==3||n==2)){//check if n=2 or n=3 and the array is empty 
    	   ans= true;
       }else if(same(board,board.length)) {//call function 
    	   for (int i = 0;ans&& i < board.length; i++) {
               ans=checkrowcol(board,i,board.length);	//check every queen
			}			
		}else ans=false;
		return ans;
 
       }

	public static boolean addQueen(int[] board, int row, int col){
	  boolean ans=false;
	  int tamp=board[row];//save the old place of the queen 
      board[row]=col;//put the queen in row,column
      if(same(board, row+1)&&checkrowcol(board, row, row+1)){
    	  ans =true;
      }
      if(!ans){
    	  board[row]=tamp;//return the board[row] to the beginning   
      }
      
		return ans;
	}


	public static int[] nQueens(int n) {
        int [] ans =new int[n];
        if(!nQueens(ans, 0, 0)){//call recursive function 
        	ans=new int[0];
        }
		return ans;//return array ,if false return empty array   
	}

	public static boolean nQueens(int[] board, int row, int col){
        boolean ans =false;
    	if(row==board.length){//the stop condition 
    		ans= true;
    	}else{
             if(col<board.length){
              if((addQueen(board, row, col)&&nQueens(board, row+1, 0))){//check if can we add queen in this row and cal if true,go to the next row
        	      ans=true;
              }else{
        	ans =nQueens(board, row, col+1);}//if false,move the queen to the next col
             }
           }
        return ans;

	}
}
