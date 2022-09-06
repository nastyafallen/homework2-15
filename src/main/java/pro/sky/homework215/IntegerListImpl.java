package pro.sky.homework215;

import pro.sky.homework215.exception.MyIllegalArgumentException;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    int item;
    int index;
    private int capacity;
    private final Integer[] arrayListInteger;

    public IntegerListImpl() {
        arrayListInteger = new Integer[5];
        capacity = 0;
    }

    public IntegerListImpl(int n) {
        if (n < 0) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        arrayListInteger = new Integer[n];
        capacity = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerListImpl that = (IntegerListImpl) o;
        return item == that.item && index == that.index && capacity == that.capacity;
    }


    @Override
    public int add(int item) {
        if (capacity >= arrayListInteger.length) {
            throw new MyIllegalArgumentException("Превышение допустимых размеров массива!");
        }
        arrayListInteger[capacity++] = item;
        return item;
    }

    @Override
    public int add(int index, int item) {
        if (index < 0 || index > arrayListInteger.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        if (capacity >= arrayListInteger.length) {
            throw new MyIllegalArgumentException("Превышение допустимых размеров массива!");
        }
        for (int i = arrayListInteger.length-1; i > index; i--) {
            arrayListInteger[i] = arrayListInteger[i-1];
        }
        arrayListInteger[index] = item;
        capacity++;
        return item;
    }

    @Override
    public int set(int index, int item) {
        if (index < 0 || index > arrayListInteger.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        arrayListInteger[index] = item;
        return item;
    }

    @Override
    public int remove(int item) {
        int indexForRemoving = -1;
        for (int i = 0; i < arrayListInteger.length; i++) {
            if (Objects.equals(item, arrayListInteger[i])) {
                indexForRemoving = i;
                break;
            }
        }
        if (indexForRemoving == -1) {
            throw new MyIllegalArgumentException("Элемент не найден!");
        }
        arrayListInteger[indexForRemoving] = null;
        capacity--;
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        if (index < 0 || index > arrayListInteger.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        for (int i = index; i < arrayListInteger.length-1; i++) {
            arrayListInteger[i] = arrayListInteger[i+1];
        }
        arrayListInteger[arrayListInteger.length-1] = null;
        capacity--;
        return null;
    }

    @Override
    public boolean contains(int item) {
        sort();

        int min = 0;
        int max = capacity - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, arrayListInteger[mid])) {
                return true;
            }
            if (item < arrayListInteger[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        int indexOfItem = -1;
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(item, arrayListInteger[i])) {
                indexOfItem = i;
                break;
            }
        }
        return indexOfItem;
    }

    @Override
    public int lastIndexOf(int item) {
        int indexOfItem = -1;
        for (int i = capacity-1; i >= 0; i--) {
            if (Objects.equals(item, arrayListInteger[i])) {
                indexOfItem = i;
                break;
            }
        }
        return indexOfItem;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index > arrayListInteger.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        return arrayListInteger[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!Objects.equals(otherList.get(i), arrayListInteger[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        if (capacity == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arrayListInteger[i] = null;
        }
        capacity = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = arrayListInteger[i];
        }
        return result;
    }

    private void sort() {
        for (int i = 1; i < capacity; i++) {
            int temp = arrayListInteger[i];
            int j = i;
            while (j > 0 && arrayListInteger[j - 1] >= temp) {
                arrayListInteger[j] = arrayListInteger[j - 1];
                j--;
            }
            arrayListInteger[j] = temp;
        }
    }
}
