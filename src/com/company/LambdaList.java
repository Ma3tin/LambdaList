package com.company;

import java.util.ArrayList;

public class LambdaList<T> {
    private final ArrayList<T> arrayList = new ArrayList<>();

    public void add(T item) {
        arrayList.add(item);
    }

    public T get(int index) {
        return arrayList.get(index);
    }

    public void remove(int index) {
        arrayList.remove(index);
    }

    public T min(IComparator<T> comparator) {
        T min = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (comparator.compare(min, arrayList.get(i)) > 0) min = arrayList.get(i);
        }
        return min;
    }

    public T max(IComparator<T> comparator) {
        T max = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (comparator.compare(max, arrayList.get(i)) < 0) max = arrayList.get(i);
        }
        return max;
    }

    public boolean any(IPredicate<T> predicator) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (predicator.test(arrayList.get(i))) return true;
        }
        return false;
    }

    public boolean all(IPredicate<T> predicator) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (!predicator.test(arrayList.get(i))) return false;
        }
        return true;
    }

    public LambdaList<T> filter(IPredicate<T> predicator) {
        LambdaList<T> lambdaList = new LambdaList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (predicator.test(arrayList.get(i))) lambdaList.add(arrayList.get(i));
        }
        return lambdaList;
    }

    public <N> LambdaList<N> map(IConvert<T, N> convertor) {
        LambdaList<N> lambdaList = new LambdaList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            lambdaList.add(convertor.convert(arrayList.get(i)));
        }
        return lambdaList;
    }

    public int size() {
        return arrayList.size();
    }

    @Override
    public String toString() {
        return "LambdaList{" +
                "arrayList=" + arrayList +
                '}';
    }
}
