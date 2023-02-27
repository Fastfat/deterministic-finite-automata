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
            while (cmd != 0) {
                tale = cmd % 10;
                cmd /= 10;
                if (tale == 0) {
                    if (state == ABC.A) {
                        result = true;
                    } else if (state == ABC.B) {
                        state = ABC.C;
                        result = false;
                    } else if (state == ABC.C) {
                        state = ABC.B;
                        result = false;
                    }
                } else if (tale == 1) {
                    if (state == ABC.A) {
                        state = ABC.B;
                        result = false;
                    } else if (state == ABC.B) {
                        state = ABC.A;
                        result = true;
                    } else if (state == ABC.C) {
                        result = false;
                    }
                }
            }
            if (result) {
                System.out.println("Число " + num + " делится на 3 без остатка. Состояние автомата: " + state);
            } else {
                System.out.println("Число " + num + " не делится на 3 без остатка. Состояние автомата: " + state);
                state = ABC.A;
            }
        }
    }
}
