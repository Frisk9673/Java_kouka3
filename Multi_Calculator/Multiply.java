package Multi_Calculator;
//掛け算の演算クラス
public class Multiply extends BinaryOperation {
    //Overrideで上書きをする
    @Override
    //掛け算を実行するメソッド
    public double operate(double num1, double num2) {
        //returnでnum1 * num2を返す
        return num1 * num2;
    }
}
