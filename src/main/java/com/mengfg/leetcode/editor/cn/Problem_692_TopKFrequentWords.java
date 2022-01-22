//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 311 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Problem_692_TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new Problem_692_TopKFrequentWords().new Solution();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> strings = solution.topKFrequent(words, 2);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            if (words.length == 0) {
                return new ArrayList<>();
            }

            TreeMap<Node, Node> map = new TreeMap(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.str.equals(o1.str) ? 0 : o1.frequency - o2.frequency;
                }
            });
            for (String word : words) {
                Node node = new Node(word, 0);
                if (map.containsKey(node)) {
                    Node existed = map.get(node);
                    existed.frequency++;
                    map.put(existed, existed);
                } else {
                    node.frequency = 1;
                    map.put(node, node);
                }
            }

            List<String> res = new LinkedList<>();
            Set<Node> nodes = map.keySet();
            if (nodes.size() < k) {
                List list = new LinkedList<>();
                nodes.stream().forEach(node -> list.add(node.str));
                return list;
            }

            int i = 0;
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext() && i++ < k) {
                Node next = iterator.next();
                res.add(next.str);
            }
            return res;
        }
    }

    class Node {
        String str;
        int frequency;

        public Node(String word, int i) {
            this.str = word;
            this.frequency = i;
        }

        @Override
        public int hashCode() {
            return this.str.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.str.equals(((Node) obj).str);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}