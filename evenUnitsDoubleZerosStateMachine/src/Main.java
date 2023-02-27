import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cmd = 0;
        int num = 0;
        int tale = 0;
        boolean result = false;
        ABCDEF state = ABCDEF.A;

        for (int i = 0; i < 5; i++) {
            cmd = sc.nextInt();
            num = Integer.parseInt(String.valueOf(cmd), 2);
            if (cmd == 0) {
                state = ABCDEF.B;
                result = false;

            }
            while (cmd != 0) {
                tale = cmd % 10;
                cmd /= 10;
                if (tale == 0) {
                    if (state == ABCDEF.A) {
                        state = ABCDEF.B;
                        result = false;
                    } else if (state == ABCDEF.B) {
                        state = ABCDEF.C;
                        result = true;
                    } else if (state == ABCDEF.C) {
                        result = true;
                    } else if (state == ABCDEF.D) {
                        state = ABCDEF.E;
                        result = false;
                    } else if (state == ABCDEF.E) {
                        state = ABCDEF.F;
                        result = false;
                    } else if (state == ABCDEF.F) {
                        result = false;
                    }
                } else if (tale == 1) {
                    if (state == ABCDEF.A) {
                        state = ABCDEF.D;
                        result = false;
                    } else if (state == ABCDEF.B) {
                        state = ABCDEF.D;
                        result = false;
                    } else if (state == ABCDEF.C) {
                        state = ABCDEF.F;
                        result = false;
                    } else if (state == ABCDEF.D) {
                        state = ABCDEF.A;
                        result = false;
                    } else if (state == ABCDEF.E) {
                        state = ABCDEF.A;
                        result = false;
                    } else if (state == ABCDEF.F) {
                        state = ABCDEF.C;
                        result = true;
                    }
                }
            }
            if (result) {
                System.out.println("Число " + num + " содержит подстроку \"00\" и четное число единиц в двоичной "
                        + "системе счисления. Состояние автомата: " + state);
            } else if (state == ABCDEF.F) {
                System.out.println("Число " + num + " содержит подстроку \"00\" и нечетное число единиц в двоичной "
                        + "системе счисления. Состояние автомата: " + state);
            } else if (state == ABCDEF.A) {
                System.out.println("Число " + num + " не содержит подстроку \"00\" и нечетное число единиц в двоичной "
                        + "системе счисления. Состояние автомата: " + state);
            } else {
                System.out.println("Число " + num + " не содержит подстроку \"00\" и четное число единиц в двоичной "
                        + "системе счисления. Состояние автомата: " + state);
            }
            state = ABCDEF.A;
        }
    }
}