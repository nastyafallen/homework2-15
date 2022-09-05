package pro.sky.homework215;

import pro.sky.homework215.exception.MyIllegalArgumentException;
import java.util.Objects;

public class StringListImpl implements StringList {
    String item;
    int index;
    private int capacity;
    private final String[] arrayList;

    public StringListImpl() {
        arrayList = new String[10];
        capacity = 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringListImpl that = (StringListImpl) o;
        return item.equals(that.item);
    }

    @Override
    public String add(String item) {
        checkForNull(item);
        if (capacity >= arrayList.length) {
            throw new MyIllegalArgumentException("Превышение допустимых размеров массива!");
        }
        arrayList[capacity++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkForNull(item);
        if (index < 0 || index > capacity) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        if (capacity >= arrayList.length) {
            throw new MyIllegalArgumentException("Превышение допустимых размеров массива!");
        }
        for (int i = capacity; i > index; i--) {
            arrayList[i] = arrayList[i-1];
        }
        arrayList[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= capacity || index > arrayList.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int indexForRemoving = -1;
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(item, arrayList[i])) {
                indexForRemoving = i;
                break;
            }
        }
        if (indexForRemoving == -1) {
            throw new MyIllegalArgumentException("Элемент не найден!");
        }
        remove(arrayList[indexForRemoving]);
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= capacity || index > arrayList.length) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        for (int i = index; i < capacity-1; i++) {
            arrayList[i] = arrayList[i+1];
        }
        arrayList[capacity-1] = null;
        capacity--;
        return null;
    }

    @Override
    public boolean contains(String item) {
        checkForNull(item);
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(item, arrayList[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkForNull(item);
        int indexOfItem = -1;
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(item, arrayList[i])) {
                indexOfItem = i;
                break;
            }
        }
        return indexOfItem;
    }

    @Override
    public int lastIndexOf(String item) {
        checkForNull(item);
        int indexOfItem = -1;
        for (int i = capacity-1; i >= 0; i--) {
            if (Objects.equals(item, arrayList[i])) {
                indexOfItem = i;
                break;
            }
        }
        return indexOfItem;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > capacity) {
            throw new MyIllegalArgumentException("Ввод некорректных данных!");
        }
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!Objects.equals(otherList.get(i), arrayList[i])) {
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
            arrayList[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = arrayList[i];
        }
        return result;
    }

    public void checkForNull(String s) throws IllegalArgumentException{
        if (Objects.isNull(s)) {
            throw new IllegalArgumentException("Ввод некорректных данных!");
        }
    }
}
