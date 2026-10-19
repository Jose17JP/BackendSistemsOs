package com.store.dataestructure;
import com.store.model.Arista;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grapho {
    private Map<String, List<Arista>> listMap = new HashMap<>();

    public boolean addPlace(String name) {
        if (name == null) {
            return false;
        }
        if (listMap.containsKey(name)) {
            return false;
        }
        listMap.put(name, new LinkedList<>());
        return  true;
    }
    public boolean addRoad(String origen, String destino, int peso) {
        if (origen == null || destino == null) {
            return false;
        }
        addPlace(origen);
        addPlace(destino);

        listMap.get(origen).add(new Arista(destino, peso));
        listMap.get(destino).add(new Arista(origen, peso));
        return true;
    }
}
