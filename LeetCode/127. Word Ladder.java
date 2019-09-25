import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/* Word Ladder:
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 1, Only one letter can be changed at a time.
 * 2, Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * Note:
 * 1, Return 0 if there is no such transformation sequence.
 * 2, All words have the same length.
 * 3, All words contain only lowercase alphabetic characters.
 * 4, You may assume no duplicates in the word list.
 * 5, You may assume beginWord and endWord are non-empty and are not the same.
 */

public class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        for (String word : wordList) {    //将wordList中的单词加入dict
            dict.add(word);
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        set.add(start);
        
        int length = 1;
        while (!queue.isEmpty()) {			//开始bfs
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {		//枚举当前步数队列的情况
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    set.add(nextWord);				//存入新单词
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, HashSet<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {					//枚举替换字母
            for (int i = 0; i < word.length(); i++) {		//枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {				//如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;									//构造当前单词的全部下一步方案
    }
}
