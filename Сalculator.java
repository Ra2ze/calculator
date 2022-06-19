//sre 19.06.2022
import java.io.IOException;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Сalculator {

    static Scanner sc = new Scanner(System.in);
    static int num = 0;
    static int resInt = 0;
    static String res = "ERROR";

    public static void main(String[] args){
        String res = calc(sc.nextLine());
        System.out.println(res);
    }

    public static String calc(String input) {
        sc.close();
        int symbol = input.length();
        if (symbol == 1){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("Строка не является математической операцией");
                System.exit(1);
            }
        }else if (symbol < 5){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }
        }
        String[] str = input.split(" ");
        boolean checkNum1 = checkRoman(str[0]);
        boolean checkNum2 = checkRoman(str[2]);
        if (checkNum1 == checkNum2) {
                int num1 = getNum(str[0]);
                String operation = str[1];
                int num2 = getNum(str[2]);
                int resInt = calculate(num1, operation, num2);
                if (checkNum1) {
                    if (resInt>=1) {
                        res = romanStr(resInt);
                    } else {
                        try {
                            throw new Exception();
                        }catch (Exception e){
                            System.out.println("В римской системе нет отрицательных чисел");
                            System.exit(1);
                        }
                    }
                } else {
                    res = Integer.toString(resInt);
                }
        }else {
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("Используются одновременно разные системы счисления");
                System.exit(1);
            }
        }
        return res;
    }

    public static int getNum(String str) {

        switch (str){
            case "I", "1":
                num = 1;
                break;
            case "II", "2":
                num = 2;
                break;
            case "III", "3":
                num = 3;
                break;
            case "IV", "4":
                num = 4;
                break;
            case "V", "5":
                num = 5;
                break;
            case "VI", "6":
                num = 6;
                break;
            case "VII", "7":
                num = 7;
                break;
            case "VIII", "8":
                num = 8;
                break;
            case "IX", "9":
                num = 9;
                break;
            case "X", "10":
                num = 10;
                break;
            default:
                try {
                    throw new Exception();
                }catch (Exception e){
                    System.out.println("Введённ(ое/ые) числ(о/а) находится вне диапозона");
                    System.exit(1);
                }
        }
        return num;
    }

    public static boolean checkRoman(String str){

        for (Roman masStr : Roman.values()) {
            if (str.equals(masStr.name())) {
                return true;
            }
        }
        return false;
    }

    public static String romanStr(int num){

        for (Roman masInt : Roman.values()) {
            if (num == masInt.getNumber()) {
                return masInt.toString();
            }
        }
        return "";
    }

    public static int calculate(int num1, String operation, int num2){
        switch (operation){
            case "+":
                resInt = num1 + num2;
                break;
            case "-":
                resInt = num1 - num2;
                break;
            case "*":
                resInt = num1 * num2;
                break;
            case "/":
                resInt = num1 / num2;
                break;
            default:
                try {
                   throw new Exception();
                }catch (Exception e){
                    System.out.println("Введён некорректный элемент арифметических операции");
                    System.exit(1);
                }
        }
        return resInt;
    }

}
