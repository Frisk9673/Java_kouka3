package Multi_Calculator;
//球の体積の演算クラス
public class SphereVolume extends UnaryOperation {
    //Overrideで上書きをする
    @Override
    //球の体積の演算を実行するメソッド
    public double operate(double num1, double num2) {
        //returnで球の体積の計算結果を返す
        return 4.0 * Math.PI * Math.pow(num1, 3) / 3;
    }
}
