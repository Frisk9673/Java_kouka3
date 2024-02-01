package Multi_Calculator;
import java.util.Scanner;

public class kouka3_App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //1つ目の数値の入力をさせる
            System.out.print("1つ目の数値を入力してください：");
            double num1 = getValidNumber(scanner);

            //ユーザに演算子を指定させる
            System.out.print("利用する演算子を指定してください。\n 足し算・引き算・掛け算・割り算・べき乗・対数\nサイン・コサイン・タンジェント・平方根・階乗・円の面積\n (+, -, *, /, ^, log, sin, cos, tan, sqrt, !, circlearea)\n 利用する演算子：");
            String operator = scanner.next();

            //二項演算か一項演算かによって処理を分岐
            //二項演算の場合
            if (isBinaryOperator(operator)) {
                //ユーザに二番目の数の入力を促す
                System.out.print("2つ目の数値を入力してください：");
                double num2 = getValidNumber(scanner);
            
                //二項演算を実行させる
                executeBinaryOperation(operator, num1, num2);
            }
            //一項演算の場合 
            else if (isUnaryOperator(operator)) {
                //一項演算を実行させる
                executeUnaryOperation(operator, num1);
            } 
            //設定してない演算子が入力された場合
            else {
                //サポートされていないと表示する。
                System.out.println("サポートされていない演算子です。");
            }
        }
        //エラーが発生したらcatchする 
        catch (Exception e) {
            //エラーメッセージを表示
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
        //終了処理
        finally {
            scanner.close();
        }
    }
    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {
                System.out.print("数値の形式が正しくありません。\nもう一度入力してください。\n数値を入力: ");
                //不正な入力をクリア
                scanner.nextLine();
            }
        }
    }

    //二項演算子かどうかを判定するメソッド
    private static boolean isBinaryOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") ||
               operator.equals("/") || operator.equals("^") || operator.equals("log");
    }

    //一項演算子かどうかを判定するメソッド
    private static boolean isUnaryOperator(String operator) {
        return operator.equals("sin") || operator.equals("cos") || operator.equals("tan") ||
               operator.equals("sqrt") || operator.equals("!") || operator.equals("circlearea");
    }

    //二項演算子を実行するメソッド
    private static void executeBinaryOperation(String operator, double num1, double num2) {
        Operation operation = getBinaryOperation(operator);
        //operationがnullでない場合の処理
        if (operation != null) {
            double result = operation.operate(num1, num2);
            System.out.println("結果: " + result);
        }
        //それ以外の処理
        else {
            System.out.println("サポートされていない演算子です。");
        }
    }

    //一項演算子を実行するメソッド
    private static void executeUnaryOperation(String operator, double num1) {
        Operation operation = getUnaryOperation(operator);
        //operationがnullでない場合の処理
        if (operation != null) {
            double result = operation.operate(num1, 0);
            System.out.println("結果: " + result);
        }
        //それ以外の処理
        else {
            System.out.println("サポートされていない演算子です。");
        }
    }

    //二項演算のオブジェクトを取得するメソッド
    private static Operation getBinaryOperation(String operator) {
        switch (operator) {
            //足し算のケース
            case "+":
                return new Add();
            //引き算のケース
            case "-":
                return new Subtract();
            //掛け算のケース
            case "*":
                return new Multiply();
            //割り算のケース
            case "/":
                return new Devide();
            //べき乗のケース
            case "^":
                return new Power();
            //対数のケース
            case "log":
                return new Logarithm();
            //デフォルト(空白)
            default:
                return null;
        }
    }

    //一項演算のオブジェクトを取得するメソッド
    private static Operation getUnaryOperation(String operator) {
        switch (operator) {
            case "sin":
            return new Trigonometry();

            case "cos":
            return new Trigonometry();

            case "tan":
            return new Trigonometry();
            
            case "sqrt":
            return new SquareRoot();

            case "!":
            return new Factorial();

            case "circlearea":
            return new CircleArea();
            //デフォルト(空白)
            default:
                return null;
        }
    }
}