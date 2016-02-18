import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.Arrays;
import matrices.*;

public class MatrixTest{

  @Test
  public void addElementToMatrix_populates_matrix_with_value(){
    Matrix firstMatrix = new Matrix(2,3);
    int num=12;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    assertEquals(12,firstMatrix.getElementAt(0,0));
    assertEquals(14,firstMatrix.getElementAt(0,2));
    assertEquals(16,firstMatrix.getElementAt(1,1));
    assertEquals(15,firstMatrix.getElementAt(1,0));
  }

  @Test
  public void compareTwoMatrices_checks_number_of_rows_and_columns(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(2,3);
    assertTrue(firstMatrix.compareTwoMatrices(secondMatrix));
  }

  @Test
  public void isSameAs_returns_true_if_two_matrices_are_same(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(2,3);
    int num=12;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        secondMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    System.out.println(firstMatrix.isSameAs(secondMatrix));
    assertTrue(firstMatrix.isSameAs(secondMatrix));
  }

  @Test
  public void isSameAs_returns_false_if_two_matrices_are_not_same(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(2,3);
    int num=12,num1=1;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        secondMatrix.addElementToMatrix(i,j,num1);
        num1++;
      }
    }
    System.out.println(firstMatrix.isSameAs(secondMatrix));
    assertFalse(firstMatrix.isSameAs(secondMatrix));
  }

  @Test
  public void addTwoMatrices_returns_null_if_two_matrices_are_of_different_order(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(3,3);
    Matrix resultMatrix = new Matrix(2,3);
    int num=12,num1=1;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        secondMatrix.addElementToMatrix(i,j,num1);
        num1++;
      }
    }
    assertEquals(null,resultMatrix.addTwoMatrices(firstMatrix,secondMatrix));
  }

  @Test
  public void addTwoMatrices_adds_two_matrices_if_two_matrices_are_of_same_order(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(2,3);
    Matrix resultMatrix = new Matrix(2,3);
    int num=12,num1=1;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        secondMatrix.addElementToMatrix(i,j,num1);
        num1++;
      }
    }
    assertEquals(14,firstMatrix.getElementAt(0,2));
    assertEquals(6,secondMatrix.getElementAt(1,2));
    resultMatrix.addTwoMatrices(firstMatrix,secondMatrix);
    assertEquals(17,resultMatrix.getElementAt(0,2));
    assertEquals(21,resultMatrix.getElementAt(1,1));
  }
  @Test
  public void multiplyTwoMatrices_multiplies_two_given_matrices(){
    Matrix firstMatrix = new Matrix(3,3);
    Matrix secondMatrix = new Matrix(3,3);
    Matrix expectedMatrix = new Matrix(3,3);
    expectedMatrix.addElementToMatrix(0,0,30);
    expectedMatrix.addElementToMatrix(0,1,36);
    expectedMatrix.addElementToMatrix(0,2,42);
    expectedMatrix.addElementToMatrix(1,0,66);
    expectedMatrix.addElementToMatrix(1,1,81);
    expectedMatrix.addElementToMatrix(1,2,96);
    expectedMatrix.addElementToMatrix(2,0,102);
    expectedMatrix.addElementToMatrix(2,1,126);
    expectedMatrix.addElementToMatrix(2,2,150);
    int num=1;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        secondMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    Matrix result = firstMatrix.multiplyTwoMatrices(secondMatrix);
    assertTrue(result.isSameAs(expectedMatrix));
  }

  @Test
  public void multiplyTwoMatrices_returns_null_if_martices_order_doesnt_matches(){
    Matrix firstMatrix = new Matrix(2,3);
    Matrix secondMatrix = new Matrix(2,3);
    int num=1;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        firstMatrix.addElementToMatrix(i,j,num);
        secondMatrix.addElementToMatrix(i,j,num);
        num++;
      }
    }
    assertEquals(null,firstMatrix.multiplyTwoMatrices(secondMatrix));
  }

}
