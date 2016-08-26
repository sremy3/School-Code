import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Implement the hash table interface here.
 * 
 * @author Stephanie Remy
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
	 * The new CAPACITY after load factor is reached.
	 */
	private int capacity = INITIAL_CAPACITY;
	
	/**
	 * The backing array of your hash table.
	 */
	private MapEntry<K, V>[] table;
	/**
	 * Initialize the backing array to the initial capacity and the size
	 * to the appropriate starting size.
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		this.size = 0;
		this.table = new MapEntry[INITIAL_CAPACITY];
	}
	/**
	 * Private helper method to see if by adding
	 * one more element it will make it pass
	 * the maximum load factor.
	 * @return boolean of true if it does, false otherwise.
	 */
	private boolean isFull() {
		double num = (((double) size + 1) / capacity);
		return MAX_LOAD_FACTOR <= num;
	}

	/**
	 * Increases the size of array and copies elements over to
	 * new position in new array.
	 */
	@SuppressWarnings("unchecked")
	private void regrow() {
		this.capacity = (2 * capacity) + 1;
		MapEntry<K, V>[] temp = new MapEntry[capacity];
		for (MapEntry<K, V> items: table) {
			if (items != null) {
				int hash = Math.abs(items.getKey().hashCode() % temp.length);
				boolean spotTaken = true;
		        while (spotTaken) {
		        	if (temp[hash] == null) {
		        		temp[hash] = items;
		        		spotTaken = false;
		        	} else {
		        		hash++;
		        		if (hash == capacity) {
		        			hash = 0;
		        		}
		        	}
		        }
			}
		}
		this.table = temp;
	}
	@Override
	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException();
		} else {
			int hash = Math.abs(key.hashCode() % table.length);
			if (table[hash] != null) {
				//check to see if it already exists
				if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
					V v = table[hash].getValue();
					table[hash].setValue(value);
					return v;
				} else {
			        for (int i = hash; i < capacity; i++) {
			        	if (table[i] != null) {
			        	    if (table[i].getKey().equals(key) && !table[i].isRemoved()) {
			        		    V v = table[i].getValue();
							    table[i].setValue(value);
							    return v;
			        	    }
						} else if (table[i] == null) {
							i = capacity - 1;
						}
			        }
			    }
			}
			//finished looking for it, not found so go back where it's supposed to be
	        //and put it in the next available spot that's either null or removed.
			//CHECK IF FULL FIRST THOUGH
			if (isFull()) {
				regrow();
			}
	        hash = Math.abs(key.hashCode() % table.length);
	        MapEntry<K, V> mE = new MapEntry<K, V>(key, value);
	        //look for open spot
	        boolean spotTaken = true;
	        while (spotTaken) {
	        	if (table[hash] == null) {
	        		spotTaken = false;
	        	} else if (table[hash].isRemoved()) {
	        		spotTaken = false;
	        	} else {
	        		hash++;
	        		if (hash == capacity) {
	        			hash = 0;
	        		}
	        	}
	        }
	        table[hash] = mE;
			size++;
			return null;
		}
	}
	@Override
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		} else {
			int hash = Math.abs(key.hashCode() % table.length);
			if (table[hash] != null) {
				if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
					return table[hash].getValue();
				} else {
					boolean notFound = true;
			        while (notFound) {
			        	if (table[hash] == null) {
			        		return null;
			        	} else if (!table[hash].isRemoved() && table[hash].getKey().equals(key)) {
			        		return table[hash].getValue();
			        	} else {
			        		hash++;
			        		if (hash == capacity) {
			        			hash = 0;
			        		}
			        	}
			        }
		        }
			}
			return null;
		}
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		} else {
			int hash = Math.abs(key.hashCode() % table.length);
			if (table[hash] != null) {
				if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
					table[hash].setRemoved(true);
					size--;
					return table[hash].getValue();
				} else {
			        while (table[hash] != null) {
			        	if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
							table[hash].setRemoved(true);
							size--;
							return table[hash].getValue();
						}
			        	hash++;
			        }
		        }
			}
			return null;
		}
	}

	@Override
	public boolean contains(V value) {
		if (value == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < capacity; i++) {
				if (table[i] != null) {
					if (table[i].getValue().equals(value) && !table[i].isRemoved()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean containsKey(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		} else {
			int hash = Math.abs(key.hashCode() % table.length);
			if (table[hash] != null) {
				if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
					return true;
				} else {
			        while (table[hash] != null) {
			        	if (table[hash].getKey().equals(key) && !table[hash].isRemoved()) {
							return true;
						}
			        	hash++;
			        	if (hash == capacity) {
		        			hash = 0;
		        		}
			        }
		        }
			}
		}
		return false;
	}

	@Override
	public Set<K> keySet() {
		Set<K> theSet = new HashSet<K>();
		if (size == 0) {
			return theSet;
		} else {
			for (int i = 0; i < capacity; i++) {
				if (table[i] != null) {
					if (!table[i].isRemoved()) {
						theSet.add(table[i].getKey());
					}
				}
			}
			return theSet;
		}
	}

	@Override
	public Collection<V> values() {
		Collection<V> theCollection = new ArrayList<V>();
		if (size == 0) {
			return theCollection;
		} else {
			for (int i = 0; i < capacity; i++) {
				if (table[i] != null) {
					if (!table[i].isRemoved()) {
						theCollection.add(table[i].getValue());
					}
				}
			}
			return theCollection;
		}
	}

	@Override
	public Set<MapEntry<K, V>> entrySet() {
		Set<MapEntry<K, V>> theSet = new HashSet<MapEntry<K, V>>();
		if (size == 0) {
			return theSet;
		} else {
			for (int i = 0; i < capacity; i++) {
				if (table[i] != null) {
					if (!table[i].isRemoved()) {
						theSet.add(table[i]);
					}
				}
			}
			return theSet;
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.size = 0;
		this.table = new MapEntry[INITIAL_CAPACITY];
	}

}
