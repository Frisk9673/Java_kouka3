package Multi_Calculator;
//引き算の演算クラス
public class Subtract extends BinaryOperation {
    //Overrideでインターフェースを上書きする
    @Override
    //引き算を実行するメソッド
    public double operate(double num1, double num2) {
        //returnでnum1 - num2を返す
        return num1 - num2;
    }
}
