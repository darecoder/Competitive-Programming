package com.company.FileCompression;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCodes {
    private class HuffmanNode implements Comparable<HuffmanNode> {
        Character ch;
        Integer freq;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode() {
            this.ch = '\0';
            this.left = null;
            this.right = null;
            this.freq = 0;
        }

        @Override
        public int compareTo(HuffmanNode node) {
            return freq - node.freq;
        }
    }

    private HuffmanNode root;
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    public HuffmanCodes() {
        encoder = new HashMap<>();
        decoder = new HashMap<>();
    }

    private void buildTree(HashMap<Character, Integer> map) {
        PriorityQueue<HuffmanNode> p = new PriorityQueue<>();
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            HuffmanNode n = new HuffmanNode();
            n.ch = key;
            n.freq = map.get(key);
            n.left = null;
            n.right = null;
            p.offer(n);
        }
        while (p.size() > 1) {
            HuffmanNode p1 = p.peek();
            p.poll();
            HuffmanNode p2 = p.peek();
            p.poll();
            HuffmanNode newp = new HuffmanNode();
            newp.freq = p1.freq + p2.freq;
            newp.ch = '-';
            newp.left = p1;
            newp.right = p2;
            root = newp;
            p.offer(newp);

        }
    }

    public void encode(String str) {
        HashMap<Character, Integer> map = Createhashmap(str);
        buildTree(map);
        setcode(root, "");
        System.out.println(encoder);

        for (int i = 0; i < str.length(); i++) {
            System.out.print(encoder.get(str.charAt(i)));
        }
    }

    public void decode(String str) {
        StringBuilder sb = new StringBuilder();
        decode(this.encoder);
        int count=1;
        for (int i = 0; i <str.length(); i++) {
            sb.append(str.charAt(i));
            if (decoder.containsKey(sb.toString())) {
                System.out.print(decoder.get(sb.toString()));
                sb.delete(0,count);
                count=1;
            } else {
                count++;
            }
        }
        System.out.println();
        System.out.println(decoder);
    }

    private void decode(HashMap<Character, String> map) {
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            decoder.put(map.get(key), key);
        }
    }


    private void setcode(HuffmanNode node, String ans) {
        if (node.left == null && node.right == null) {
            encoder.put(node.ch, ans);
            return;
        }
        setcode(node.left, ans + '0');
        setcode(node.right, ans + '1');

    }

    private HashMap<Character, Integer> Createhashmap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), 0);
        }
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String str="mississippi";
        System.out.println("Input String : " + str);
        HuffmanCodes h=new HuffmanCodes();
        System.out.print("String Encoding : ");
        h.encode(str);
        System.out.println();
        System.out.print("Decoded string : ");
        h.decode("100110011001110110111");

    }
}
