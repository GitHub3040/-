import java.util.HashSet;
import java.util.List;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> set=new HashSet<>(wordList);
        if (!set.contains(endWord)){
            return 0;
        }
        HashSet<String> small=new HashSet<>();
        HashSet<String> big=new HashSet<>();
        HashSet<String> next=new HashSet<>();
        small.add(beginWord);
        big.add(endWord);
        for (int len = 2; !small.isEmpty(); len++) {
            for (String w:small) {
                char[] word=w.toCharArray();
                for (int i = 0; i < word.length; i++) {
                    char old=word[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (old!=j){
                            word[i]=j;
                            String nxt=String.valueOf(word);
                            if (big.contains(nxt)){
                                return len;
                            }
                            if (set.contains(nxt)){
                                next.add(nxt);
                                set.remove(nxt);
                            }
                        }
                    }
                    word[i]=old;
                }
            }
            if (next.size()<=big.size()){
                HashSet<String> tmp=small;
                small=next;
                next=tmp;
            }else {
                HashSet<String> tmp=small;
                small=big;
                big=next;
                next=tmp;
            }
            next.clear();
        }
        return 0;
    }
}
