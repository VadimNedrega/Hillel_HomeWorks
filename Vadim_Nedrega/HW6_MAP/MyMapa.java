package vadim_nedrega.HW6_MAP;

import java.util.*;

public class MyMapa<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 6;
    private myEntry<K, V>[] bucketArr;
    private int capacity;
    private int count = 0;


    public MyMapa() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyMapa(int capacity) {
        this.capacity = capacity;
        bucketArr = new myEntry[capacity];
    }

    private int getBucketIndex(K key){
        int result = key == null ? 0 : key.hashCode();
        result = Math.abs(result);
        result = result % capacity;
        return result;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        int bucketIndex = getBucketIndex((K) key);
        myEntry<K, V> currentElement = bucketArr[bucketIndex];
        while (currentElement!=null){
            if(Objects.equals(currentElement.key, key)){
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return findValueElement(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        int bucketIndex = getBucketIndex((K) key);
        myEntry<K, V> currentElement = bucketArr[bucketIndex];
        V result = null;
        while (currentElement!=null){
            if(Objects.equals(currentElement.key, key)){
                result = currentElement.value;
                break;
            }
            currentElement = currentElement.next;
        }

        return result;
    }

    @Override
    public V put(K key, V value) {
        V result = null;
        int bucketIndex = getBucketIndex(key);
        myEntry<K, V> currentElement = bucketArr[bucketIndex];
        while (currentElement!=null){
            if(Objects.equals(currentElement.key, key)){
                break;
            }
            currentElement = currentElement.next;
        }

        if(currentElement == null){
            myEntry<K, V> newElement = new myEntry<>();
            newElement.key = key;
            newElement.value = value;
            bucketArr[bucketIndex] = newElement;
        } else {
            result = currentElement.next.value;
            currentElement.next.value = value;
        }
        count++;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V result = null;
        int bucketIndex = getBucketIndex((K) key);
        myEntry<K, V> currentElement = bucketArr[bucketIndex];
        myEntry<K, V> prevElement = currentElement;
        while (currentElement!=null){
            if(Objects.equals(currentElement.key, key)){
                break;
            }
            prevElement = currentElement;
            currentElement = currentElement.next;
        }

        if(currentElement != null) {
            prevElement.next = currentElement.next;
            count--;
            result = currentElement.value;
        }

        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        Arrays.fill(bucketArr, null);
        count = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int bucketIndex  = 0; bucketIndex < capacity; bucketIndex++) {
            myEntry<K, V> currentElement = bucketArr[bucketIndex];
            while (currentElement != null) {
                set.add(currentElement.key);
                currentElement = currentElement.next;
            }
        }
        return set;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<V> values() {
        LinkedList<K> values = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            myEntry<K, V> currentValue = bucketArr[i];
            while (currentValue!=null) {
                values.add((K) currentValue.value);
                currentValue = currentValue.next;
            }
        }
        return (Collection<V>) values;
    }

    @Override
    @SuppressWarnings("uncheked")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> keys = new LinkedHashSet<>();
        for (int i = 0; i < capacity; i++) {
            myEntry<K, V> currentElement = bucketArr[i];
            keys.add(currentElement);
            currentElement = currentElement.next;
        }
        return keys;
    }



    public static class myEntry<K, V> implements Entry<K, V>{
        K key;
        V value;
        myEntry<K, V> next;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value=value;
        }
    }


    public boolean findValueElement(Object value){
        for (int bucketIndex  = 0; bucketIndex < DEFAULT_CAPACITY; bucketIndex++) {
            myEntry<K, V> currentElement = bucketArr[bucketIndex];
            while (currentElement!=null){
                if(Objects.equals(currentElement.value, value)){
                    return true;
                }
                currentElement = currentElement.next;
            }
        }

        return false;
    }
}
