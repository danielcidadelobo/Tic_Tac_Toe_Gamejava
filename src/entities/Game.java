package entities;

public class Game {
    
    public char end(Board board){
        for (int i=0;i<3;i++){
            if (board.getElement(i,0) != " " && board.getElement(i,0)==board.getElement(i,1) && 
            board.getElement(i,1)==board.getElement(i,2)){
                return (char) board.getElement(i,0);
            }
            if (board.getElement(i,0) != " " && board.getElement(0,i)==board.getElement(1,i) && 
            board.getElement(1,i)==board.getElement(2,i)){
                return (char) board.getElement(0,i);
            }
        }
        if (board.getElement(0,0) != " " && board.getElement(0,0)==board.getElement(1,1) && 
            board.getElement(1,1)==board.getElement(2,2)){
                return (char) board.getElement(0,0);
            }
        if (board.getElement(2,0) != " " && board.getElement(2,0)==board.getElement(1,1) && 
            board.getElement(1,1)==board.getElement(0,2)){
                return (char) board.getElement(2,0);
            }
    return 'N';
    }
}
