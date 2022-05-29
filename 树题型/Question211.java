/*
 * @Author: Lhy1122 1319628965@qq.com
 * @Date: 2022-03-29 23:45:55
 * @LastEditors: Lhy1122 1319628965@qq.com
 * @LastEditTime: 2022-05-29 20:31:40
 * @FilePath: \undefinedd:\LeetCode\树题型\Question211.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.TreeMap;

class WordDictionary{
    public class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isword){
            this.isWord = false;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    
    }

    private Node root;

    public WordDictionary(){
        root = new Node();
    }

    public void addWord(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        return match(root, word, 0);
    }

    public boolean match(Node node, String word, int index){
        if(index == word.length())
            return node.isWord;

        char c = word.charAt(index);

        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        }
        else{
            for(char nextChar: node.next.keySet())
                if(match(node.next.get(nextChar), word, index + 1))
                    return truel;
        return false;
        }
    }

}
