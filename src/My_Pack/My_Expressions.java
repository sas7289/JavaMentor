package My_Pack;

class My_Expressions {
    private String expr;//введённое выражение
    private String str1, str2; //строки соответствующие операндам
    private int num1, num2, res; //значения операндов в десятичной системе счисления и результат вычисления
    private boolean arabType;//флаг арабской системы счисление
    private char operation;//знак операции
    private static char[] arabN = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private static char[] romeN = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    {
        num1 = 0;
        num2 = 0;
        res = 0;
        operation = 0;
    }
    My_Expressions (String s){
        expr = s;
    }

    public void split (){
        expr = expr.replaceAll("\\s+", "");
        int count = 0;
        while (!ar_op2(this.expr.charAt(count))){
            count++;
        }
        str1 = this.expr.substring(0, count);
        str2 = this.expr.substring(count+1);
        operation = this.expr.charAt(count);
    }//метод, разделяющий введённое выражение на операнды и знак операции



    public static boolean ar_op(char ch){
        String op = "+-/*";
        for (int i = 0; i != op.length(); i++){
            if (ch == op.charAt(i))
            {
                return true;
            }
        }
        return false;
    }//метод возвращает true если на вход подана одна из операций +-/*

    public static boolean ar_op2(char ch){
        boolean result = true;
        for (char a:arabN){
            if (ch == a){
                result = false;
                break;
            }
            result = true;
        }
        if (result == true) {
            for (char a:romeN){
                if (ch == a){
                    result = false;
                    break;
                }
                result = true;
            }
        }
        return result;
    }//метод возвращает true если на вход подано что угодно, кроме числа в арабской или римской системе счсисления

    public void typeNum (){
        myArith.trueOperation(operation);
        int count1 = str1.length();
        int count2 = str2.length();
        char temp1 = 0;
        char temp2 = 0;
        boolean flag = true;
        boolean flag2 = true;

        for (int i = 0; i < count1; i++) {
            if (flag) {
                temp1 = str1.charAt(i);
                for (char a : arabN) {
                    if (temp1 == a) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag && i > 0){
                    System.exit(2);
                }
            }
        }


        if (flag) {
            for (int i = 0; i < count2; i++) {
                if (flag) {
                    temp2 = str2.charAt(i);
                    for (char a : arabN) {
                        if (temp2 == a) {
                            flag = true;
                            break;
                        }
                        else{
                            flag = false;
                        }
                    }
                    if (!flag){
                        System.exit(2);
                    }
                }
            }
            arabType = true;
            num1 = Integer.parseInt(str1);
            num2 = Integer.parseInt(str2);
        }



        if (!arabType) {
            for (int i = 0; i < count1; i++) {
                if (flag2) {
                    temp1 = str1.charAt(i);
                    for (char a : romeN) {
                        if (temp1 == a) {
                            flag2 = true;
                            break;
                        } else {
                            flag2 = false;
                        }
                    }
                    if (!flag2 && i > 0) {
                        System.exit(2);
                    }
                }
            }


            if (flag2) {
                for (int i = 0; i < count2; i++) {
                    if (flag2) {
                        temp2 = str2.charAt(i);
                        for (char a : romeN) {
                            if (temp2 == a) {
                                flag2 = true;
                                break;
                            } else {
                                flag2 = false;
                            }
                        }
                        if (!flag2) {
                            System.exit(2);
                        }
                    }
                }
            }
            arabType = false;
            num1 = myArith.toArab(str1);
            num2 = myArith.toArab(str2);
        }





    }//метод определяет, какой системе счсисления принадлежат операнды, отмечает соответствующим значением флаг
     //arabType. В случае, если введены операнды различных систем счисления, завершает программу с кодом 2
    public boolean getType (){
        return this.arabType;
    }//возвращает значени флага arabType




    public void calculate () {
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10){
            System.exit(4);
        }
        if (operation == '+') {
            res = num1 + num2;
        }
        if (operation == '-') {
            res = num1 - num2;
        }
        if (operation == '*') {
            res = num1 * num2;
        }
        if (operation == '/') {
            res = num1 / num2;
        }
    }//Вычисляет значение выражения и помещает его в поле res. Если операнды выходят за допустимые пределы [1;10],
     //завершает программу с кодом 4
    public void result (){
        if (arabType){
            System.out.println(res);
        }
        else{
            System.out.println(myArith.toRome(res));
        }
    }//выводит в консоль значение выражение в соответствующей операндам системе счисления
}
