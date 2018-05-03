package lt.setkus.codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixSquareTest {

    private static void testing(String act, String exp) {
        assertEquals(exp, act);
    }

    @Test
    public void Basic_Tests() {
        System.out.println("Basic Tests");
        String[][] t2 = new String[][]{
                { "x","1"},
                { "2","1"}  };
        for (int i=0; i<2; i++)
            testing(Arrays.toString(MatrixSquare.matrixSquareUp(2)[i]),
                    Arrays.toString(t2[i]));

        String[][] t3 = new String[][]{
                { "x","x","1"},
                { "x","2","1"},
                { "3","2","1"}  };
        for (int i=0; i<3; i++)
            testing(Arrays.toString(MatrixSquare.matrixSquareUp(3)[i]),
                    Arrays.toString(t3[i]));

        String[][] t4 = new String[][]{
                { "x","x","x","1"},
                { "x","x","2","1"},
                { "x","3","2","1"},
                { "4","3","2","1"}    };
        for (int i=0; i<4; i++)
            testing(Arrays.toString(MatrixSquare.matrixSquareUp(4)[i]),
                    Arrays.toString(t4[i]));
    }
}