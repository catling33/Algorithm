package HashMap;

public class HashMap {

    // entry class
    public static class Entry {
        final String key;
        Integer value;
        Entry next;

        private Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    // maintain an array
    Entry[] array;
    // maintain int size
    int size = 0;
    // capacity of array
    private static final int CAPACITY = 11;
    // loadfactor
    private static final float LOADFACTOR = 0.75f;

    // constructor
    public HashMap(int capacity) {
        this.array = new Entry[capacity];
    }

    public HashMap() {
        this (CAPACITY);
    }

    // put an entry, return the value of entry
    public Integer put(String key, Integer value) {
        // get hashcode
        int hashCode = hash(key);
        // get index
        int index = hashCode % array.length;
        // if the same entry is already in the bucket --> return value
        Entry element = new Entry(key, value);
        Entry head = array[index];
        while (head != null) {
            if (head.getKey() == key) {
                if (head.getValue() == value) {
                    return value;
                } else {
                    Integer originalValue = head.getValue();
                    head.setValue(value);
                    return originalValue;
                }
            }
            head = head.next;
        }
        // otherwise, attach to head
        Entry oldHead = array[index];
        element.next = oldHead;
        array[index] = element;
        size++;
        if (size >= array.length * LOADFACTOR) {
            rehashing();
        }
        return null;
    }

    // rehashing
    private void rehashing() {
        // new double sized array
        Entry[] oldArray = array;
        array = (Entry[])(new Entry[array.length * 2]);
        for (Entry entry : oldArray) {
            while (entry != null) {
                Entry next = entry.next;
                int index = getIndex(entry.key);
                entry.next = array[index];
                array[index] = entry;
                entry = next;
            }
        }
    }

    private int getIndex(String key) {
        // get hashcode
        int hashCode = hash(key);
        // get index
        int index = hashCode % array.length;
        // if the same entry is already in the bucket --> return value
        return index;
    }

    // get hashcode
    private int hash(String key) {
        if (key == null) {
            return 0;
        }
        Integer code = key.hashCode();
        return code & 0x7FFFFFFF;
    }

    // get value based on key
    public Integer get(String key) {
        // get hashcode
        int hashCode = hash(key);
        // get index
        int index = hashCode % array.length;
        // find the key in bucket
        Entry head = array[index];
        while (head != null) {
            // if found -> return value
            if (head.getKey() == key) {
                return head.getValue();
            }
            head = head.next;
        }
        // if not found -> return null
        return null;
    }

    // size
    public int size() {
        return size;
    }

    // remove an entry, return value of removed entry
    public Integer remove(String key) {
        // get hashcode
        int hashCode = hash(key);
        // get index
        int index = hashCode % array.length;
        // find bucket
        Entry head = array[index];
        // bucket is empty
        if (head == null) {
            return null;
        }
        // remove head
        if (head.getKey() == key) {
            array[index] = head.next;
            head.next = null;
            return head.getValue();
        }
        // remove middle or end
        Entry prev = head;
        head = head.next;
        while (head != null) {
            if (head.getKey() == key) {
                prev.next = head.next;
                return head.getValue();
            }
            prev = head;
            head = head.next;
        }
        // didn't find
        return null;
    }
}
