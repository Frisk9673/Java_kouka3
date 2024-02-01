package Multi_Calculator;
//円の面積を求める演算クラス
public class CircleArea extends UnaryOperation {
    @Override
    //円の面積の演算を実行するメソッド
    public double operate(double num1, double num2) {
        if (num1 <= 0 || num2 != 0) {
            throw new IllegalArgumentException("円の面積演算は正の半径を1つだけ使います。\nお手数ですが入力する値をどちらか0にして入力し直してください。");
        }
        //returnでMath.PI(3.14) * Math.pow(num1, 2)を返す
        return Math.PI * Math.pow(num1, 2);
    }
}
