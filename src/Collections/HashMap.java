package Collections;

public class HashMap<K, V> implements IMap<K, V>  {
    private int _buckets;
    private int _count;
    private Node<K,V>[] _map;

    public HashMap() {
        this(4);
    }

    public HashMap(int buckets) {
        _buckets = buckets;
        _map = new Node[_buckets];
        _count = 0;
    }

    @Override
    public V put(K key, V value) {
        if (_buckets <= _count) {
            resize(_buckets * 2);
        }

        int keyHash = key.hashCode();
        int indexBucket = indexOf(keyHash);

        var currentNode = _map[indexBucket];

        if (currentNode == null) {
            _map[indexBucket] = new Node<>(key, value);
            _count++;

            return null;
        }

        do {
            if (currentNode.getHash() == keyHash) {
                V oldValue = currentNode.getValue();
                currentNode.setValue(value);

                return oldValue;
            }

            if (!currentNode.hasNext()) {
                currentNode.setNext(new Node<>(key, value));
                _count++;

                return null;
            }

            currentNode = (Node<K, V>) currentNode.getNext();
        } while (currentNode.hasNext());

        currentNode.setNext(new Node<>(key, value));
        _count++;

        return null;
    }

    public boolean resize(int buckets) {
        if (_buckets <= buckets) {
            return false;
        }

        HashMap<K, V> newMap = new HashMap<>(_buckets);

        for(var head : _map) {
            while (head != null) {
                newMap.put(head.getKey(), head.getValue());

                head = (Node<K, V>) head.getNext();
            }
        }

        _map = newMap._map;
        _count = newMap.count();

        return true;
    }

    @Override
    public Node<K, V> get(K key) {
        if (isEmpty()) return null;

        int keyHash = key.hashCode();
        int indexBucket = indexOf(keyHash);

        var currentNode = _map[indexBucket];

        do {
            if (currentNode.getHash() == keyHash) {
                return currentNode;
            }

            currentNode = (Node<K, V>) currentNode.getNext();
        } while (currentNode.hasNext());

        return null;
    }

    @Override
    public int count() {
        return _count;
    }

    @Override
    public int getBuckets() {
        return _buckets;
    }

    @Override
    public boolean remove(K key) {
        if (isEmpty()) return false;

        int keyHash = key.hashCode();
        int indexBucket = indexOf(keyHash);

        var currentNode = _map[indexBucket];

        if (currentNode == null) {
            return false;
        }

        if (currentNode.getHash() == keyHash) {
            _map[indexBucket] = (Node<K, V>) currentNode.getNext();
            _count--;

            return true;
        }

        while (currentNode.hasNext()) {
            if (currentNode.getNext().getHash() == keyHash) {
                if (currentNode.getNext().hasNext()) {
                    currentNode.setNext(currentNode.getNext().getNext());
                }
                else {
                    currentNode.setNext(null);
                }

                _count--;

                return true;
            }

            currentNode = (Node<K, V>) currentNode.getNext();
        }

        return false;
    }

    @Override
    public final boolean isEmpty() {
        return _count <= 0;
    }

    @Override
    public final boolean contains(K key) {
        if (isEmpty()) return false;

        int keyHash = key.hashCode();
        int indexBucket = indexOf(keyHash);

        var currentNode = _map[indexBucket];

        do {
            if (currentNode.getHash() == keyHash) {
                return true;
            }
            if (!currentNode.hasNext()) { return false; }

            currentNode = (Node<K, V>) currentNode.getNext();
        } while (currentNode.hasNext());

        if (currentNode.getHash() == keyHash) {
            return true;
        }

        return false;
    }

    private int indexOf(int hashCode) {
        int index = hashCode % _buckets;
        index = index >= 0 ? index : -index;
        return index;
    }
}
