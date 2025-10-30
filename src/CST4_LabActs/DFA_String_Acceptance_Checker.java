package CST4_LabActs;

import java.util.Scanner;

public class DFA_String_Acceptance_Checker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nStates: q0 (start), q1, q2 (accept)\n" +
                "Language: Strings ending with '01'\n");

        while (true) {
            System.out.print("\nInput: ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("Done")) {
                System.exit(0);
            }

            if (accepted(input)) {
                System.out.println("Output: Accepted");
            } else {
                System.out.println("Output: Rejected");
            }
        }
    }

    public static boolean accepted(String s) {
        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (state) {
                case 0, 2:
                    if (c == '0') {
                        state = 1;
                    } else if (c == '1') {
                        state = 0;
                    } else {
                        return false;
                    }
                    break;

                case 1:
                    if (c == '0') {
                        state = 1;
                    } else if (c == '1') {
                        state = 2;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return state == 2;
    }
}
