public class InnGenerator {
    public static String generate() {
        String inn = "77";

        int codeOrg = (int) (Math.random() * 100);
        if (codeOrg < 10) inn += "0";
        inn += codeOrg;

        int ogrn = (int) (Math.random() * 1000000) + 1;
        int d = 100000;
        while (ogrn / d == 0) {
            inn += "0";
            d /= 10;
        }
        inn += ogrn;

        int[] w1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int cnt1 = 0;
        for (int i = 0; i < 10; i++) {
            cnt1 += Character.getNumericValue(inn.charAt(i)) * w1[i];
        }
        cnt1 %= 11;
        inn += (cnt1 == 10) ? 0 : cnt1;

        int[] w2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int cnt2 = 0;
        for (int i = 0; i < 11; i++) {
            cnt2 += Character.getNumericValue(inn.charAt(i)) * w2[i];
        }
        cnt2 %= 11;
        inn += (cnt2 == 10) ? 0 : cnt2;
        System.out.println(inn);

        return inn;
    }
}
