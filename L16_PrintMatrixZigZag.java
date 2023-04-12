public class ZigZagPrintMatrix {
  
  public static void printMatrixZigZag(int[][] matrix) {           // - Point A and B, start at (0, 0)
    int tR = 0, tC = 0;    // Point A                              //
    int dR = 0; dC = 0;    // Point B                              //             A(row,col) ----> ----> ---->  +   Move A to the right,       
    int endR = matrix.length - 1;                                  //  B(row,col)     1,   2,   3,   4,   5,    |   then move down. 
    int endC = matrix[0].length - 1;                               //       |         6,   7,   8,   9,  10,    v
    boolean fromUp = false;                                        //       V        11,  12,  13,  14,  15,    |       
    while (tR != endR + 1) {  // point A reaches ending Row.       //       |        16,  17,  18,  19,  20,   end 
      printLevel(matrix, tR, tC, dR, dC, fromUp);                  //       + ----> ----> ----> ----> ----> end
      tR = (tC == endC) ? tR+1 : tR;                               //    Move B down, the move to the right.
      tC = (tC == endC) ? tC : tC+1;                               //
      dC = (dR == endR) ? dC+1 : dC;                               // - print elements in line A->B, then move A and B
      dR = (dR == endR) ? dR : dR+1;                               //   print elements in line B->A, then move A and B
      fromUp = !fromUp;                                            //   print elements in line A->B, then move A and B
    }                                                              //   :::::::::::::::
    System.out.println();
  }
  
  public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean directionFromUp) {
    if (directionFromUp) {
      while (tR != dR + 1) {
        System.out.print(m[tR++][tC--] + " ");
      }
    } else {
      while (dR != tR - 1) {
        System.out.print(m[dR--][dC++] + " ");
      }      
    }
  }
  
}
