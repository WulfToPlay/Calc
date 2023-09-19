import java.util.Scanner;
public class Calculator {
    private static boolean arabic_numbers = true;
    private static String[] pars(String input) {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length > 5 || parsed_input.length < 3) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Неверный формат ввода данных.");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else {
            return parsed_input;
        }
    }
    public static void main(String[] args) {
        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = input_a_value.nextLine();

        while (!input.isEmpty()) {
            String[] parsed_input = Calculator.pars(input);
            String operation = parsed_input[1];
            Number values;
            int value1 = 0;
            int value2 = 0;

            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
            } catch (NumberFormatException e) {
                arabic_numbers = false;
                System.out.println("Неверный формат ввода данных.");
            }
            if (value1 > 10 || value2 > 10){

                System.out.println("Слишком большое число");
                System.out.println();
                System.out.print("Введите следующее выражение: ");
                input = input_a_value.nextLine();
                continue;

            } else if (value1 < 1 || value2 < 1){
                System.out.println("Слишком маленькое число");
                System.out.println();
                System.out.print("Введите следующее выражение: ");
                input = input_a_value.nextLine();
                continue;

            }

            if (arabic_numbers) {
                    values = new Arabic(value1, value2);
                } else {
                    break;
                }

            switch (operation){
                case "+": values.sum();break;
                case "-": values.sub();break;
                case "*": values.mul();break;
                case "/": values.div();break;
            }

            if (arabic_numbers) {
                System.out.println("Ответ: " + values.getResult());
            }
            System.out.println();
            System.out.print("Введите следующее выражение: ");
            input = input_a_value.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");
    }
}
