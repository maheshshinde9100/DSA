//import java.util.List;
//
//class FindAllAnagramString {
//    public List<Integer> findAnagrams(String s, String p) {
//        if(p.length()>s.length()){
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>();
//        int[] map1 = new int[26];
//        int[] map2 = new int[26];
//        int k = p.length();
//        for(int i=0;i<k;i++){
//            map1[p.charAt(i)-'a']++;
//            map2[s.charAt(i)-'a']++;
//        }
//
//        if(match(map1,map2)){
//            res.add(0);
//        }
//
//        for(int i=k;i<s.length();i++){
//            map2[s.charAt(i)-'a']++;
//            map2[s.charAt(i-k)-'a']--;
//
//            if(match(map1,map2)){
//                res.add(i-k+1);
//            }
//        }
//
//        return res;
//    }
//
//    public boolean match(int[] map1,int[] map2){
//        for(int i=0;i<26;i++){
//            if(map1[i]!=map2[i]){
//                return false;
//            }
//        }
//        return true;
//    }
//}
