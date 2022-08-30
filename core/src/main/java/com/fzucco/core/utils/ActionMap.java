package com.fzucco.core.utils;

import com.fzucco.core.enums.Actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionMap implements Map<Actions, String> {

    private final Map<Actions, String> map = new HashMap<>();

    public static ActionMap builder() {
        return new ActionMap();
    }

    public ActionMap _put(Actions action, String string) {
        map.put(action, string);
        return this;
    }

    public ActionMap _put(Actions action) {
        map.put(action, action.getDescription());
        return this;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(Actions key, String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends Actions, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Actions> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<String> values() {
        return map.values();
    }

    @Override
    public Set<Entry<Actions, String>> entrySet() {
        return map.entrySet();
    }
}
