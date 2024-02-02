package Multi_Calculator;
//平方根の演算クラス
public class SquareRoot extends UnaryOperation {
    //Overrideで上書きをする
    @Override
    /*平方根の計算では引数は1つしか使わないので
    num2は入れないようにする*/
    //平方根の演算を実行するメソッド
    public double operate(double num1, double num2) {
        //num1が0より下の場合エラーメッセージを表示させる
        if (num1 < 0) {
            throw new IllegalArgumentException("平方根の対象は0以上である必要があります。(負の数は不可)");
        }
        //平方根の結果を返す
        return Math.sqrt(num1);
    }
}
