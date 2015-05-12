package com.zrp.apero.map.converters;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.zrp.apero.map.Room;
import com.zrp.apero.map.WorldMap;

public class WorldMapConverter implements Converter {

    @Override
    public boolean canConvert(Class arg0) {
        System.out.println("canConvert " + arg0 + " returning " + arg0.isAssignableFrom(WorldMap.class));
        return arg0.isAssignableFrom(WorldMap.class);
    }

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        throw new UnsupportedOperationException("Cannot marshall.");
        // TODO Auto-generated method stub

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext arg1) {
        WorldMap worldMap = new WorldMap();

        while (reader.hasMoreChildren()) {
            reader.moveDown();

            if ("rooms".equals(reader.getNodeName())) {
                Map<Integer, Room> rooms = new HashMap<Integer, Room>();
                worldMap.setRooms(rooms);

                reader.moveDown();
                while ("room".equals(reader.getNodeName())) {
                    Room room = (Room) arg1.convertAnother(new Room(), Room.class);
                    System.out.println("room = " + room.getId());
                    rooms.put(room.getId(), room);
                }
                reader.moveUp();
            }
        }

        System.out.println("------------" + reader.getNodeName());
        reader.moveDown();
        System.out.println("------------" + reader.getNodeName());
        reader.moveUp();
        System.out.println("------------" + reader.getNodeName());

        // TODO Auto-generated method stub
        return worldMap;
    }

}
