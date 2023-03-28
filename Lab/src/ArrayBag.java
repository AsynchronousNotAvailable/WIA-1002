public class ArrayBag <T> implements BagInterface<T> {
    final int DEFAULT_CAPACITY = 25;
    T[] bag = (T[]) new Object[DEFAULT_CAPACITY];
    int numberOfEntries;
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()){
            return false;
        }
        bag[numberOfEntries++] = newEntry;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) return null;
        T item = bag[--numberOfEntries];
        bag[numberOfEntries] = null;
        return item;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = -1;
        for (int i = 0; i < numberOfEntries; i++)
            if (bag[i].equals(anEntry)) {
                index = i;
                break;
            }
        if (index == -1) return false;

        bag[index] = bag[--numberOfEntries];
        bag[numberOfEntries] = null;
        return true;
    }

    @Override
    public void clear() {
        for(T i: bag){
            i = null;
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for(int i = 0; i < numberOfEntries; i++){
            if(anEntry.equals(bag[i])){
                count += 1;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        for(int i = 0; i < numberOfEntries; i++){
            if(anEntry.equals(bag[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, result, 0, numberOfEntries);
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<? extends T> bag2) {
        ArrayBag<T> union = new ArrayBag<>();
        for (int i = 0; i < numberOfEntries; i++)
            union.add(bag[i]);
        T[] bag2Array = bag2.toArray();
        for (T item : bag2Array)
            union.add(item);
        return union;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<? extends T> bag2) {
        ArrayBag<T> intersection = new ArrayBag<>();
        T[] bag2Array = bag2.toArray();
        for (int i = 0; i < numberOfEntries; i++) {
            T item = bag[i];
            for (int j = 0; j < bag2Array.length; j++) {
                if (item.equals(bag2Array[j])) {
                    intersection.add(item);
                    bag2Array[j] = null;
                    break;
                }
            }
        }
        return intersection;
    }

    @Override
    public BagInterface<T> difference(BagInterface<? extends T> bag2) {
        ArrayBag <T> difference = new ArrayBag<>();
        for(int i = 0; i< numberOfEntries; i++){
            difference.add(bag[i]);
        }
        T [] bag2Array = bag2.toArray();
        for(T t: bag2Array){
            difference.remove(t);
        }
        return difference;
    }


}
