package pro.sky.homework215;

import pro.sky.homework215.exception.MyIllegalArgumentException;

import java.util.Objects;

public interface IntegerList {
    int add(int item);

    int add(int index, int item);

    int set(int index, int item);

    int remove(int item);

    Integer removeByIndex(int index);

    boolean contains(int item);

    int indexOf(int item);

    int lastIndexOf(int item);

    int get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
