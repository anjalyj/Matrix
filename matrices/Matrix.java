package matrices;

public class Matrix{
  int row,column;
  int[][] matrix;

  public Matrix(int row,int column){
    this.row = row;
    this.column = column;
    this.matrix = new int[row][column];
  }

  public void addElementToMatrix(int rowNO,int columnNo,int value){
    this.matrix[rowNO][columnNo]=value;
  }
  public int getElementAt(int rowNO,int columnNo){
    return this.matrix[rowNO][columnNo];
  }

  public Matrix addTwoMatrices(Matrix matrix1, Matrix matrix2){
    int[][] result = new int[matrix1.row][matrix1.column];
    for(int i=0;i<matrix1.row;i++){
      for(int j=0;j<matrix1.column;j++){
        this.matrix[i][j]=matrix1.matrix[i][j]+matrix2.matrix[i][j];
      }
    }
    return this;
  }

}
