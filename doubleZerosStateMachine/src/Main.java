import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cmd = 0;
        int num = 0;
        int tale = 0;
        boolean result = false;
        ABC state = ABC.A;

        for (int i = 0; i < 5; i++) {
            cmd = sc.nextInt();
            num = Integer.parseInt(String.valueOf(cmd), 2);
            if (cmd == 0) {
                state = ABC.B;
                result = false;
            }
            while (cmd != 0) {
                tale = cmd % 10;
                cmd /= 10;
                if (tale == 0) {
                    if (state == ABC.A) {
                        state = ABC.B;
                        result = false;
                    } else if (state == ABC.B) {
                        state = ABC.C;
                        result = true;
                    } else if (state == ABC.C) {
                        result = true;
                    }
                } else if (tale == 1) {
                    if (state == ABC.A) {
                        result = false;
                    } else if (state == ABC.B) {
                        state = ABC.A;
                        result = false;
                    } else if (state == ABC.C) {
                        result = true;
                    }
                }
            }
            if (result) {
                System.out.println("Число " + num + " содержит подстроку \"00\" в двоичной системе счисления. "
                        + "Состояние автомата: " + state);
            } else {
                System.out.println("Число " + num + " не содержит подстроку \"00\" в двоичной системе счисления."
                        + " Состояние автомата: " + state);
            }
            state = ABC.A;
        }
    }
}
