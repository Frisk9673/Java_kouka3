package Multi_Calculator;
//一項演算の基底クラス
abstract class UnaryOperation implements Operation {
    //単項演算を実行するメソッド(num2はダミーパラメータ扱いとする)
    public abstract double operate(double num1, double num2);
}
