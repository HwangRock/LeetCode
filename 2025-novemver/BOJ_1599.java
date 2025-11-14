import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, String> e2m = new HashMap<>();
    static HashMap<String, String> m2e = new HashMap<>();

    //문자들을 대응하는 영어 알파벳으로 대응시킴
    static String toEnglish(List<String> data) {
        StringBuilder sb = new StringBuilder();

        int fin = data.size();
        for (int i = 0; i < fin; i++) {
            String cur = data.get(i);
            String cha = e2m.get(cur);
            sb.append(cha);
        }

        return sb.toString();
    }

    //대응된 영어 알파벳을 다시 민식어로 바꿔줘서 반환
    static String toMin(String s) {
        StringBuilder sb = new StringBuilder();

        int fin = s.length();
        for (int i = 0; i < fin; i++) {
            String cur = String.valueOf(s.charAt(i));
            String nxt = m2e.get(cur);
            sb.append(nxt);
        }

        return sb.toString();
    }

    static void formMin() {
        for (String s : e2m.keySet()) {
            String v = e2m.get(s);
            m2e.put(v, s);
        }
    }

    //data의 문자열들의 문자들을 민식어 알파벳으로 분리 후 영어 반환
    static String[] solve(int n, String data[]) {
        String ans[] = new String[n];

        for (int i = 0; i < n; i++) {
            String s = data[i];
            List<String> mc = new ArrayList<>();
            int fin = s.length();
            for (int j = 0; j < fin; j++) {
                String cur = String.valueOf(s.charAt(j));
                if (cur.equals("n") && j + 1 < fin) {
                    String nx = String.valueOf(s.charAt(j + 1));
                    if (nx.equals("g")) {
                        String pp = cur + nx;
                        mc.add(pp);
                        j += 1;
                    } else {
                        mc.add(cur);
                    }
                } else {
                    mc.add(cur);
                }
            }
            String eng = toEnglish(mc);
            ans[i] = eng;
        }
        Arrays.sort(ans);

        for (int i = 0; i < n; i++) {
            String cur = ans[i];
            String enc = toMin(cur);
            ans[i] = enc;
        }

        return ans;
    }

    //a b k d e g h i l m n ng o p r s t u w y
    public static void main(String[] args) throws IOException {
        e2m.put("a", "a");
        e2m.put("b", "b");
        e2m.put("k", "c");
        e2m.put("d", "d");
        e2m.put("e", "e");
        e2m.put("g", "f");
        e2m.put("h", "g");
        e2m.put("i", "h");
        e2m.put("l", "i");
        e2m.put("m", "j");
        e2m.put("n", "k");
        e2m.put("ng", "l");
        e2m.put("o", "m");
        e2m.put("p", "n");
        e2m.put("r", "o");
        e2m.put("s", "p");
        e2m.put("t", "q");
        e2m.put("u", "r");
        e2m.put("w", "s");
        e2m.put("y", "t");
        formMin();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String inp[] = new String[n];
        for (int i = 0; i < n; i++) {
            inp[i] = br.readLine();
        }
        String ans[] = solve(n, inp);
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}
