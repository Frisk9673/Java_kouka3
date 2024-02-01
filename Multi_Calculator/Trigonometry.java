package Multi_Calculator;
//三角関数の演算クラス
public class Trigonometry extends UnaryOperation {
    //Overrideでインターフェースを上書きする
    @Override
    //三角関数の演算を実行するメソッド
    public double operate(double num1, double num2) {
        throw new UnsupportedOperationException("三角関数演算は1つの数に対してのみサポートされています。");
    }

    //サイン(正弦)を取得する
    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    //コサイン(余弦)を取得する
    public double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    //タンジェント(正接)を取得する
    public double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}