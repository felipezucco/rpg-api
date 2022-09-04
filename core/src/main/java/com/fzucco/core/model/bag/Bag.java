package com.fzucco.core.model.bag;

import com.fzucco.core.model.bag.bag_items.BagItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bag implements Set<BagItem> {

    private final HashSet<BagItem> map = new HashSet<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.contains(o);
    }

    @Override
    public Iterator<BagItem> iterator() {
        return map.iterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return map.toArray(a);
    }

    @Override
    public boolean add(BagItem bagItem) {
        for (BagItem item : map) {
            if (item.getName().equals(bagItem.getName())) {
                Double currentQuantity = item.getQuantity();
                item.setQuantity(currentQuantity + bagItem.getQuantity());
                return true;
            }
        }
        return map.add(bagItem);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return map.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends BagItem> c) {
        return map.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return map.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return map.removeAll(c);
    }

    @Override
    public void clear() {
        map.clear();
    }
}

