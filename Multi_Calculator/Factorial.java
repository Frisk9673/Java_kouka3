package Multi_Calculator;
//階乗の演算クラス
public class Factorial extends UnaryOperation {
    //Overrideでインターフェースを上書きする
    @Override
    //階乗の演算を実行するメソッド
    public double operate(double num1, double num2) {
        if (num1 < 0 || num1 != Math.floor(num1)) {
            throw new IllegalArgumentException("階乗の対象は0以上の正の整数である必要があります");
        }
        return calculateFactorial((int) num1);
    }

    //上で返したcalculateFactorialを使って結果を出す
    private int calculateFactorial(int num1) {
        if (num1 < 0) {
            throw new IllegalArgumentException("階乗の対象は0以上の整数である必要があります");
        }
        
        //resultの宣言と計算
        int result = 1;
        for (int i = 2; i <= num1; i++) {
            result *= i;
        }
        return result;
    }
}
