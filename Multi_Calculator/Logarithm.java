package Multi_Calculator;
//対数の演算クラス
public class Logarithm extends BinaryOperation {
    //Overrideでインターフェースを上書きする
    @Override
    //対数の演算を実行するメソッド
    public double operate(double num1, double num2) {
        //底と対象が0以下の場合のエラーメッセージを表示する
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalArgumentException("対数演算では、底と対象はともに0より大きい必要があります。");
        }
        //returnで値を返す
        return Math.log(num1) / Math.log(num2);
    }
}
