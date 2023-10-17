package com.woniu.p1;

public class AppDemo3 {
    public static void main(String[] args) {
        String spl = "-35+45+1-65-45+12-6-3-4+5";
        String[] split = spl.split("-");
        int sum = 0;
        for (String s : split) {
            if (!s.isEmpty()) {
                String[] split1 = s.split("\\+");
                sum += -Integer.parseInt(split1[0]);
                if (split1.length == 1) {
                    continue;
                }
                for (int i = 1; i < split1.length; i++) {
                    sum += Integer.parseInt(split1[i]);

                }
            }
        }
        System.out.println(sum);
    }
}
