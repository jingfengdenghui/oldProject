package tree;

public class Test<Key extends Comparable<Key>, Value> {

	private static final int M = 4;

	private Node root;// 根
	private int height;// 高度
	private int n; // 数量

	private static final class Node {
		private int m;// 孩子数量
		private Entry[] children = new Entry[10];

		private Node(int k) {
			m = k;
		}
	}

	private static class Entry {
		private Comparable key;
		private Object value;
		private Node next; // helper field to iterate over array entries

		public Entry(Comparable key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public Test() {
		root = new Node(0);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return n;
	}

	public int height() {
		return height;
	}

	public Value get(Key key) {
		if (key == null) {
			throw new NullPointerException("key must not be null");
		}
		return search(root, key, height);
	}

	@SuppressWarnings("unchecked")
	private Value search(Node x, Key key, int ht) {
		Entry[] children = x.children;

		// external node到最底层叶子结点，遍历
		if (ht == 0) {
			for (int j = 0; j < x.m; j++) {
				if (eq(key, children[j].key)) {
					return (Value) children[j].value;
				}
			}
		}

		// internal node递归查找next地址
		else {
			for (int j = 0; j < x.m; j++) {
				if (j + 1 == x.m || less(key, children[j + 1].key)) {
					return search(children[j].next, key, ht - 1);
				}
			}
		}
		return null;
	}

	public void put(Key key, Value val) {
		if (key == null) {
			throw new NullPointerException("key must not be null");
		}
		Node u = insert(root, key, val, height); // 分裂后生成的右结点
		n++;
		if (u == null) {
			return;
		}

		// need to split root重组root
		Node t = new Node(2);
		t.children[0] = new Entry(root.children[0].key, null, root);
		t.children[1] = new Entry(u.children[0].key, null, u);
		root = t;
		height++;
	}

	private Node insert(Node h, Key key, Value val, int ht) {
		int j;
		Entry t = new Entry(key, val, null);

		// external node外部结点，也是叶子结点，在树的最底层，存的是内容value
		if (ht == 0) {
			for (j = 0; j < h.m; j++) {
				if (less(key, h.children[j].key)) {
					break;
				}
			}
		}

		// internal node内部结点，存的是next地址
		else {
			for (j = 0; j < h.m; j++) {
				if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
					Node u = insert(h.children[j++].next, key, val, ht - 1);
					if (u == null) {
						return null;
					}
					t.key = u.children[0].key;
					t.next = u;
					break;
				}
			}
		}

		for (int i = h.m; i > j; i--) {
			h.children[i] = h.children[i - 1];
		}
		h.children[j] = t;
		h.m++;
		if (h.m < M) {
			return null;
		} else { // 分裂结点
			return split(h);
		}
	}

	private Node split(Node h) {
		Node t = new Node(M / 2);
		h.m = M / 2;
		for (int j = 0; j < M / 2; j++) {
			t.children[j] = h.children[M / 2 + j];
		}
		return t;
	}

	private boolean less(Comparable k1, Comparable k2) {
		return k1.compareTo(k2) < 0;
	}

	private boolean eq(Comparable k1, Comparable k2) {
		return k1.compareTo(k2) == 0;
	}

	public static void main(String[] args) {
		 Test<String, String> st = new Test<String, String>();
		 
		    st.put("www.cs.princeton.edu", "128.112.136.12");
		    st.put("www.cs.princeton.edu", "128.112.136.11");
		    st.put("www.princeton.edu",  "128.112.128.15");
		    st.put("www.yale.edu",     "130.132.143.21");
		    st.put("www.simpsons.com",   "209.052.165.60");
		    st.put("www.apple.com",    "17.112.152.32");
		    st.put("www.amazon.com",    "207.171.182.16");
		    st.put("www.ebay.com",     "66.135.192.87");
		    st.put("www.cnn.com",     "64.236.16.20");
		    st.put("www.google.com",    "216.239.41.99");
		    st.put("www.nytimes.com",   "199.239.136.200");
		    st.put("www.microsoft.com",  "207.126.99.140");
		    st.put("www.dell.com",     "143.166.224.230");
		    st.put("www.slashdot.org",   "66.35.250.151");
		    st.put("www.espn.com",     "199.181.135.201");
		    st.put("www.weather.com",   "63.111.66.11");
		    st.put("www.yahoo.com",    "216.109.118.65");
		 
		 
		    System.out.println("cs.princeton.edu: " + st.get("www.cs.princeton.edu"));
		    System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
		    System.out.println("simpsons.com:   " + st.get("www.simpsons.com"));
		    System.out.println("apple.com:     " + st.get("www.apple.com"));
		    System.out.println("ebay.com:     " + st.get("www.ebay.com"));
		    System.out.println("dell.com:     " + st.get("www.dell.com"));
		    System.out.println();
		 
		    System.out.println("size:  " + st.size());
		    System.out.println("height: " + st.height());
		    System.out.println(st);
		    System.out.println();
	}

}
