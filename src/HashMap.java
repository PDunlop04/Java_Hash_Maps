import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		try {
			getEntry(key);
			return true;
		} catch (KeyNotFoundException e) {
			return false;
		}
	}

	private Entry<K, V> getEntry(K key) throws KeyNotFoundException{
		List<Entry<K, V>> entries = getList(key);
		Iterator<Entry<K, V>> iter = entries.iterator();
		while (iter.hasNext()) {
			Entry<K, V> current = iter.next();
			if (current.getKey().equals(key)) {
				return current;
			}
		}
		throw new KeyNotFoundException();
	}

	private List<Entry<K, V>> getList(K key) {
		return table.get(getIndex(key));
	}


	public V get(K key) throws KeyNotFoundException {
		return getEntry(key).getValue();
	}

	public List<Entry<K,V>> entryList() {
		List<Entry<K,V>> result = new LinkedList<Entry<K, V>>();
		Iterator<List<Entry<K, V>>> iter = table.iterator();
		while (iter.hasNext()) {
			List<Entry<K, V>> current = iter.next();
			Iterator<Entry<K, V>> iter2 = current.iterator();
			while (iter2.hasNext()) {
				result.add(iter2.next());
			}
		}
		return result;
	}
	
	public void put(K key, V value) {
		try {
			Entry<K, V> entry = getEntry(key);
			entry.setValue(value);
		} catch (KeyNotFoundException e) {
			List<Entry<K, V>> entries = getList(key);
			entries.add(new Entry<K, V>(key, value));
			count++;
		}
	}

	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % tableSize;
	}

	public int size() {
		return count;
	}

    public void clear() {
		for (int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}