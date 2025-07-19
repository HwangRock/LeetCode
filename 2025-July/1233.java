import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String>ans=new ArrayList<>();

        PriorityQueue<String>pq=new PriorityQueue<>(Comparator.comparingInt(String::length));

        int fin=folder.length;
        for(int i=0;i<fin;i++){
            pq.add(folder[i]);
        }

        HashSet<String>set=new HashSet<>();

        while(!pq.isEmpty()){
            String cur=pq.poll();
            String c[]=cur.split("/");
            fin=c.length;

            StringBuilder sb=new StringBuilder();
            boolean able=true;
            for(int i=0;i<fin;i++){
                sb.append("/");
                sb.append(c[i]);
                if(set.contains(sb.toString())){
                    able=false;
                }
            }
            set.add(sb.toString());
            if(able){
                ans.add(cur);
            }
        }

        return ans;
    }
}