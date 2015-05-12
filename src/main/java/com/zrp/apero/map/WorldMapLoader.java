package com.zrp.apero.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.thoughtworks.xstream.XStream;
import com.zrp.apero.map.converters.ChestsConverter;
import com.zrp.apero.map.converters.ExitsConverter;
import com.zrp.apero.map.converters.RoomsConverter;

public class WorldMapLoader {

    public static WorldMap loadMap() {
        XStream xstream = new XStream();

        xstream.alias("map", WorldMap.class);

        xstream.alias("room", Room.class);
        xstream.useAttributeFor(Room.class, "id");

        xstream.alias("exit", Exit.class);
        xstream.useAttributeFor(Exit.class, "direction");
        xstream.useAttributeFor(Exit.class, "room");

        xstream.alias("chest", Chest.class);
        xstream.useAttributeFor(Chest.class, "id");

        xstream.registerLocalConverter(WorldMap.class, "rooms", new RoomsConverter());
        xstream.registerLocalConverter(Room.class, "exits", new ExitsConverter());
        xstream.registerLocalConverter(Room.class, "chests", new ChestsConverter());

        try {
            return (WorldMap) xstream.fromXML(new FileInputStream("target/classes/map.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
