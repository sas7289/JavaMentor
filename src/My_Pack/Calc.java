package My_Pack;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение с двумя целыми операндами в пределах"+"\n"+
                "от 1 до 10 в арабской системе счисления или римской (операнды должны принадлежать одной системе счисления");
        System.out.print('>');
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        My_Expressions one = new My_Expressions(input);//создаём объект пользовательского класса, хранящий выражение
        one.split();//разбиваем строку на операнды и операци.
        one.typeNum();//определяем тип системы счисления
        one.calculate();//расссчитываем результат
        one.result();//выводим результат в обусловленной операндами системе счисления
    }
}
