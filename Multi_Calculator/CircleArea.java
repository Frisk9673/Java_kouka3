package Multi_Calculator;
//円の面積を求める演算クラス
public class CircleArea extends UnaryOperation {
    //Overrideで上書きをする
    @Override
    //円の面積の演算を実行するメソッド
    public double operate(double num1, double num2) {
        //num1が0以下の場合はエラーメッセージを表示させる
        if (num1 <= 0) {
            throw new IllegalArgumentException("円の面積の演算を実行するには1つ目の数値が1以上である必要があります。");
        }
        //returnでMath.PI(3.14) * Math.pow(num1, 2)を返す
        return Math.PI * Math.pow(num1, 2);
    }
}
