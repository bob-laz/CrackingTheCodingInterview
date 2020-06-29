package chapter.two.list;

import java.util.Collection;

public interface ListInf<X> {
    void add(X item);
    void addAll(Collection<X> items);
    X remove();
    void insert(X item, int position);
    X removeAt(int position);
    int find(X item);
    X get(int position);
    int size();
}
