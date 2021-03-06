package matrices;

public class Matrix{
  private int row,column;
  private int[][] matrix;

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

  private boolean isOrderSameAs(Matrix givenMatrix){
    return this.row==givenMatrix.row && this.column==givenMatrix.column;
  }

  public boolean isSameAs(Matrix givenMatrix){
    if(this.isOrderSameAs(givenMatrix)){
      for(int i=0;i<this.row;i++){
        for(int j=0;j<this.column;j++){
          if(this.getElementAt(i,j)!=givenMatrix.getElementAt(i,j))
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public Matrix addTwoMatrices(Matrix matrix1, Matrix matrix2){
    if(matrix1.isOrderSameAs(matrix2)){
      for(int i=0;i<matrix1.row;i++){
        for(int j=0;j<matrix1.column;j++){
          this.matrix[i][j]=matrix1.getElementAt(i,j)+matrix2.getElementAt(i,j);
        }
      }
      return this;
    }
    return null;
  }

  public Matrix multiplyTwoMatrices(Matrix givenMatrix){
    if(this.column==givenMatrix.row){
      Matrix result = new Matrix(this.row,givenMatrix.column);
      int ans=0;
      for (int i = 0; i < this.row; i++) {
        for (int j = 0; j < givenMatrix.column; j++) {
          for (int k = 0; k < this.column; k++) {
            result.matrix[i][j] +=  this.getElementAt(i,k) * givenMatrix.getElementAt(k,j);
          }
        }
      }
      return result;
    }
    return null;
  }

  public int determinant(){
    int sum=0,s,length=this.row;
    if(length==1){return(this.getElementAt(0,0));}
    for(int i=0;i<length;i++){
      Matrix smaller = new Matrix(length-1,length-1);
      for(int a=1;a<length;a++){
        for(int b=0;b<length;b++){
          if(b<i){smaller.matrix[a-1][b]=this.getElementAt(a,b);}
          else if(b>i){smaller.matrix[a-1][b-1]=this.getElementAt(a,b);}
        }
      }
      if(i%2==0){s=1;}
      else{s=-1;}
      sum+=s*this.getElementAt(0,i)*(smaller.determinant());
    }
    return(sum);
  }

}
