class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        Boolean state = false;

        int fin = s.length();
        for (int i = 0; i < fin; i++) {
            char c = s.charAt(i);

            int sbl = sb.length();
            if (state == true && c == sb.charAt(sbl - 1)) {
                continue;
            } else if (sbl > 0 && c == sb.charAt(sbl - 1)) {
                state = true;
                sb.append(c);
            } else {
                sb.append(c);
                state = false;
            }
        }

        return sb.toString();
    }
}