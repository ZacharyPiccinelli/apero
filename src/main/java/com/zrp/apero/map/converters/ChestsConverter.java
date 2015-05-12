package com.zrp.apero.map.converters;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.zrp.apero.map.Chest;

public class ChestsConverter implements Converter {

    @Override
    public boolean canConvert(Class arg0) {
        return Map.class.isAssignableFrom(arg0);
    }

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        throw new UnsupportedOperationException("Cannot marshall.");
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Map<Integer, Chest> chests = new HashMap<Integer, Chest>();

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            Chest chest = (Chest) context.convertAnother(context.currentObject(), Chest.class);
            chests.put(chest.getId(), chest);
            reader.moveUp();
        }

        return chests;
    }

}
