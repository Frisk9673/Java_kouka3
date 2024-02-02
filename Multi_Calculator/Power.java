package Multi_Calculator;
//べき乗の演算クラス
public class Power extends BinaryOperation {
    //Overrideで上書きをする
    @Override
    //べき乗の演算を実行するメソッド
    public double operate(double num1, double num2) {
        //returnで値を返す
        return Math.pow(num1, num2);
    }
}
