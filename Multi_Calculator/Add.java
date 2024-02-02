package Multi_Calculator;
//足し算の演算クラス
public class Add extends BinaryOperation {
    //Overrideで上書きをする
    @Override
    //足し算を実行するメソッド
    public double operate(double num1, double num2) {
        //returnでnum1 + num2を返す
        return num1 + num2;
    }
}
