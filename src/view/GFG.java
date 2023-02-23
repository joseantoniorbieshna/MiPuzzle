package view;

class GFG
{
     
// A utility function to count
// inversions in given array 'arr[]'
static int getInvCount(int[] arr)
{
    int inv_count = 0;
    for (int i = 0; i < 9; i++)
        for (int j = i + 1; j < 9; j++)
         
            // Value 0 is used for empty space
            if (arr[i] > 0 &&
                            arr[j] > 0 && arr[i] > arr[j])
                inv_count++;
    return inv_count;
}
 
// This function returns true
// if given 8 puzzle is solvable.
static boolean isSolvable(int[][] puzzle)
{
    int linearPuzzle[];
    linearPuzzle = new int[9];
    int k = 0;
     
  // Converting 2-D puzzle to linear form
    for(int i=0; i<3; i++)
        for(int j=0; j<3; j++)
            linearPuzzle[k++] = puzzle[i][j];
     
    // Count inversions in given 8 puzzle
    int invCount = getInvCount(linearPuzzle);
 
    // return true if inversion count is even.
    return (invCount % 2 == 0);
}
 
/* Driver code */
public static void main (String[] args)
{
    int[][] puzzle = {{1, 2, 3},{4, 5, 6},{8, 7, 9}};
    // in linear
    if(isSolvable(puzzle))
        System.out.println("Solvable");
    else
    System.out.println("Not Solvable");
}
}