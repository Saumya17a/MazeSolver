/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

public class MazeSolver {
    public static String findPath(Maze maze) {
        
        String result = "";
        boolean[][] travelto= new boolean[maze.getNumRows()][maze.getNumCols()];
        
        StackRefBased<MazeLocation> raasta = new StackRefBased<>();
        
         MazeLocation curr = maze.getEntry();
         
        
            //the following loop checks if the the coordinates are equal toexit and if they are the code will go outside the loop 
            while(!curr.equals(maze.getExit()))
            {
                // we push the current into the stack
                raasta.push(curr);
                // marks the coordinates as visited
                travelto[curr.getRow()][curr.getCol()]= true;
                /*the ifs and elses check if there is any wall in four directions and if there isn't then it checks if that coordinate is visited or not. The coordinates where there is not a wall 
                 becomes the current and current coordinates, in the boolean array, gets marked true*/
                if(maze.getNumCols()>curr.getCol()+1 && 
                    !maze.isWall(curr.getRow(), curr.getCol()+1)
                   && !travelto[curr.getRow()][curr.getCol()+1] )
                {
                    curr = new MazeLocation(curr.getRow(),curr.getCol()+1);
                }
                else if(curr.getCol()-1>-1 && !maze.isWall(curr.getRow(), curr.getCol()-1)
                && !travelto[curr.getRow()][curr.getCol()-1])
                {
                    curr = new MazeLocation(curr.getRow(),curr.getCol()-1);
                }
                else if(maze.getNumRows()>(curr.getRow()+1) && !maze.isWall(curr.getRow()+1, curr.getCol())
                && !travelto[curr.getRow()+1][curr.getCol()])
                {
                    curr = new MazeLocation(curr.getRow()+1,curr.getCol());
                }
                else if(curr.getRow()-1> -1 && !maze.isWall(curr.getRow()-1, curr.getCol())
                && !travelto[curr.getRow()-1][curr.getCol()])
                {
                    curr = new MazeLocation(curr.getRow()-1,curr.getCol());
                }  
                //if there is no more place to visit, we backtrack to the node where there is a place to visit and the next node is not visited
                else
                {
                    try{
                    raasta.pop();
                    curr = raasta.pop();
                    }catch(StackEmptyException e)
                    {
                        break;
                    }
                }
                

            }
            
            if(!raasta.isEmpty())
                {
                    raasta.push(curr);
                }
            
            
           
            
                
            
           
        return raasta.toString();
    }
}
