package Multi_Calculator;
//割り算の演算クラス
public class Devide extends BinaryOperation {
    //Overrideで上書きをする
    @Override
    //割り算を実行するメソッド
    public double operate(double num1, double num2) {
        //num2に0が入力された場合のif文を用意する
        if (num2 == 0) {
            throw new ArithmeticException("0で割ることはできません！");
        }
        //returnでnum1 / num2を返す
        return num1 / num2;
    }
}
