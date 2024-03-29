package Multi_Calculator;
import java.util.Scanner;

public class kouka3_App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //1つ目の数値の入力をさせる
            System.out.print("1つ目の数値を入力してください：");
            //変数num1に1つ目に入力した数値を入れる
            double num1 = getValidNumber(scanner);

            //ユーザに演算子を指定させる
            System.out.print("利用する演算子を指定してください。\n足し算・引き算・掛け算・割り算・剰余・べき乗・対数\n平方根・階乗・円の面積・球の体積\n(+, -, *, /, %, ^, log, sqrt, !, circlearea, sphere)\n※ 余剰は余りの数値のみ表示されます\n 利用する演算子：");
            //変数operatorに入力した演算子を入れる(この後に入力したものに応じて演算処理をさせる)
            String operator = scanner.next();

            //二項演算か単項演算かによって処理を分岐
            //二項演算の場合
            if (isBinaryOperator(operator)) {
                //ユーザに二番目の数の入力を促す
                System.out.print("2つ目の数値を入力してください：");
                //変数num2に2つ目に入力した数値を入れる
                double num2 = getValidNumber(scanner);
            
                //二項演算を実行させる
                executeBinaryOperation(operator, num1, num2);
            }
            //単項演算の場合 
            else if (isUnaryOperator(operator)) {
                //単項演算を実行させる(num2は単項演算では使わないので記述しない)
                executeUnaryOperation(operator, num1);
            } 
            //設定してない演算子が入力された場合
            else {
                //サポートされていないと表示する。
                System.out.println("サポートされていない演算子です。");
            }
        }
        //エラーが発生したらcatchしてエラーメッセージを表示する 
        catch (Exception e) {
            //エラーメッセージを表示
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
        //終了処理
        finally {
            scanner.close();
        }
    }
    //数値を入力する際、数値以外が入力された場合の例外処理を作成
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
        return operator.equals("+") || operator.equals("-") || operator.equals("*") ||operator.equals("/") || 
               operator.equals("%") || operator.equals("^") || operator.equals("log");
    }

    //単項演算子かどうかを判定するメソッド
    private static boolean isUnaryOperator(String operator) {
        return operator.equals("sqrt") || operator.equals("!") || operator.equals("circlearea") || operator.equals("sphere");
    }

    //二項演算子を実行するメソッド
    private static void executeBinaryOperation(String operator, double num1, double num2) {
        Operation operation = getBinaryOperation(operator);
        //operationがnullでない場合の処理
        if (operation != null) {
            //変数resultにOperation内の上書きされた演算結果を入れる
            double result = operation.operate(num1, num2);
            System.out.println("結果: " + result);
        }
        //それ以外の処理
        else {
            System.out.println("サポートされていない演算子です。");
        }
    }

    //単項演算子を実行するメソッド
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
            //余剰のケース
            case "%":
                return new Surplus();
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

    //単項演算のオブジェクトを取得するメソッド
    private static Operation getUnaryOperation(String operator) {
        switch (operator) {
            //平方根のケース            
            case "sqrt":
            return new SquareRoot();
            //階乗のケース
            case "!":
            return new Factorial();
            //円の面積のケース
            case "circlearea":
            return new CircleArea();
            //球の体積のケース
            case "sphere":
            return new SphereVolume();
            //デフォルト(空白)
            default:
                return null;
        }
    }
}