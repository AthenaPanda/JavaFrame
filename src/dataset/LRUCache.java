package dataset;

import java.util.HashMap;

public class LRUCache {

	class Node {
		public Node pre;
		public Node next;
		public String key;
		public String value;
		Node(String key, String value){
			this.key = key;
			this.value = value;
		}
	}
	
	private Node head;
	private Node end;
	
	private int limit;
	
	public HashMap<String,Node> hashMap;
	
	public LRUCache(int limit) {
		this.limit = limit;
		hashMap = new HashMap<String, Node>();
	}
	
	public String get(String key) {
		Node node = hashMap.get(key);
		if(node == null) {
			return null;
		}
		refreshNode(node);
		return node.value;
	}
	
	
	public void put(String key, String value) {
		Node node = hashMap.get(key);
		if(node == null) {
			//key 不存在，插入key-value
			if(hashMap.size() >= limit) {
				String oldkey = removeNode(head);
				hashMap.remove(oldkey);
			}
			node = new Node(key, value);
			addNode(node);
			hashMap.put(key, node);
		}
		else {
			//key 存在，刷新 key-value
			node.value = value;
			refreshNode(node);
		}
	}
	
	private void refreshNode(Node node) {
		if(node == end) {
			return;
		}
		
		removeNode(node);
		addNode(node);
		
	}
	private String removeNode(Node node) {
		if(node == head && node == end) {
			//移除唯一的结点
			head = null;
			end = null;
		}
		else if(node == end) {
			//移除尾结点
			end = end.pre;
			end.next = null;
		}
		else if(node == head) {
			//移除头结点
			head = head.next;
			head.pre = null;
		}
		else {
			//移除中间结点
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		return node.key;
	}
	
	private void addNode(Node node) {
		if(end != null) {
			end.next = node;
			node.pre = end;
			node.next = null;
		}
		end = node;
		if(head == null) {
			head = node;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(5);
		lruCache.put("001", "1");
		lruCache.put("002", "2");
		lruCache.put("003", "3");
		lruCache.put("004", "4");
		lruCache.put("005", "5");
		lruCache.get("003");
		lruCache.put("004", "46");
		lruCache.put("006", "30");
		
		System.out.println(lruCache.get("002"));
		System.out.println(lruCache.get("006"));
	}

}
