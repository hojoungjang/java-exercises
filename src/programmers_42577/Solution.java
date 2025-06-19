package programmers_42577;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    
    class Trie {
        private final static char END = '*';
        private Map<Character, Trie> trie = new HashMap<>();
        
        public boolean hasDigit(char digit) {
            return trie.containsKey(digit);
        }
        
        public void addDigit(char digit) {
            if (trie.containsKey(digit)) {
                return;
            }
            trie.put(digit, new Trie());
        }
        
        public int getSize() {
            return trie.size();
        }
        
        public Trie getDigit(char digit) {
            return trie.getOrDefault(digit, null);
        }
        
        public boolean addNumber(String number) {
            Trie node = this;
            for (char digit: number.toCharArray()) {
                node.addDigit(digit);
                node = node.getDigit(digit);
                if (node.hasDigit(END)) {
                    return false;
                }
            }
            if (node.getSize() > 0) {
                return false;
            }
            node.addDigit(END);
            return true;
        }
    }
    
    public boolean solution(String[] phone_book) {
        Trie root = new Trie();
        for (String number: phone_book) {
            if (!root.addNumber(number)) {
                return false;
            }
        }
        return true;
    }
}
