import java.util.Collection;
import java.util.Set;

/**
 * Implement the hash table interface here.
 * 
 * @author [YOUR NAME HERE]
 * @author Julia Ting
 * 
 */
public class HashTable<K, V> implements HashTableInterface<K, V> {

	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining max load factor, or when you will
	 * have to regrow the table.
	 */
	private static final double MAX_LOAD_FACTOR = .71;
	
	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining what size you will initialize your
	 * table array to.
	 */
	private static final int INITIAL_CAPACITY = 11;
	
	/**
	 * The number of entries in the table.
	 */
	private int size;
	
	/**
	 * The backing array of your hash table.
	 */
	private MapEntry<K, V>[] table;
	
	/**
	 * Initialize the backing array to the initial capacity and the size
	 * to the appropriate starting size.
	 */
	public HashTable() {
		
	}
	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(V value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MapEntry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
