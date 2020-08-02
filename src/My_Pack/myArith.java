package My_Pack;


import java.util.Map;

public class myArith {
    static Map<Character, Integer> coastR = Map.of('I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000); //new HashMap<>();

    static Map<Integer, String> Rome = Map.of(1, "I",
            2, "II" ,
            3 , "III",
            4, "IV" ,
            5, "V",
            6, "VI" ,
            7, "VII",
            8, "VIII",
            9, "IX",
            10, "X"); //new HashMap<>();



    public static int toArab (String stroke){
        int count = stroke.length() - 1;
        int result = coastR.get(stroke.charAt(count));
        int one = 0;
        int two = 0;
        for (int i = count; i > 0; i--){
            one = coastR.get(stroke.charAt(i));
            two = coastR.get(stroke.charAt(i-1));
            if (one > two){
                result -= two;
            }
            else{
                result += two;
            }
        }
        return result;
    }//метод переводит число римской системы счисления в арабскую

    public static String toRome(int a){
        String result = "";
        int temp = 0;

        temp = a / 1000;
        if (temp > 0){
            for (int i = 0; i < temp; i++){
                result += 'M';
            }
        }
        a %= 1000;

        temp = a / 500;
        if (temp > 0){
            if (a >= 900){
                result += "CM";
            }
            else {
                result += 'D';
            }
        }
        if (temp == 0) {
            a %= 500;

            temp = a / 100;
            if (temp > 0) {
                if (a >= 400) {
                    result += "CD";
                } else {
                    for (int i = 0; i < temp; i++) {
                        result += "C";
                    }
                }
            }
        }
        a %= 100;

        temp = a / 10;
        if (temp >= 5 && temp < 9) {
            result += 'L';
            for (int i = 5; i < temp; i++) {
                result += 'X';
            }
        }
        else if (temp == 9){
            result += "XC";
        }
        else if (temp > 0 && temp < 4) {
            for (int i = 0; i < temp; i++) {
                result += 'X';
            }
        }
        else if (temp == 4){
            result += "Iv";
        }
        a %= 10;

        if (a > 0 && a <4){
            for (int i = 0; i < a; i++){
                result += 'I';
            }
        }
        else if (a == 4){
            result += "IV";
        }
        else if (a >= 5 && a < 9){
            result += 'V';
            for (int i = 5; i < a; i++){
                result += 'I';
            }
        }
        else if (a == 9){
            result += "IX";
        }
        return result;
    }//метод переводит число из арабской системы счисления в римскую

    public static void trueOperation(char ch){
        boolean res = false;
        char[] op = new char[] {'+','-','/','*'};
        for (char n:op){
            if (ch == n){
                res = true;
                break;
            }
        }
        if (res == false){
            System.exit(3);
        }
    }//метод проверяет знак операции на соответствие заданным +-/*. В ином случае завершает работу программы с кодом 3

}
