import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cmd = 0;
        int num = 0;
        int tale = 0;
        int zeroCounter = 0;
        boolean result = false;
        AB state = AB.A;

        for (int i = 0; i < 5; i++) {
            cmd = sc.nextInt();
            num = Integer.parseInt(String.valueOf(cmd), 2);
            if (cmd == 0) {
                state = AB.B;
                zeroCounter++;
                result = false;
            }
            while (cmd != 0) {
                tale = cmd % 10;
                cmd /= 10;
                if (tale == 0) {
                    if (state == AB.A) {
                        state = AB.B;
                        result = false;
                        zeroCounter++;
                    } else if (state == AB.B) {
                        state = AB.A;
                        result = true;
                        zeroCounter++;
                    }
                } else if (tale == 1) {
                    if (state == AB.A) {
                        result = true;
                    } else if (state == AB.B) {
                        result = false;
                    }
                }
            }
            if (zeroCounter > 0) {
                if (result) {
                    System.out.println("Вход " + num + " содержит четное число нулей в двоичной системе счисления. "
                            + "Состояние автомата: " + state);
                } else {
                    System.out.println("Вход " + num + " содержит нечетное число нулей в двоичной системе счисления. "
                            + "Состояние автомата: " + state);
                    state = AB.A;
                }
                zeroCounter = 0;
            } else {
                System.out.println("Вход " + num + " не содержит нулей в двоичной системе счисления. Состояние "
                        + "автомата: " + state);
                state = AB.A;
                zeroCounter = 0;
            }
        }
    }
}
