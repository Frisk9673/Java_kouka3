package Multi_Calculator;
//二項演算の基底クラス
abstract class BinaryOperation implements Operation {
    //二項演算を実行するメソッド
    public abstract double operate(double num1, double num2);
}
