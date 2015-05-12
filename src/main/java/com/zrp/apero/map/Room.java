package com.zrp.apero.map;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("room")
public class Room {
    private int id = -1;
    private Map<String, Exit> exits = null;
    private Map<Integer, Chest> chests = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exit getExit(String direction) {
        return exits.get(direction);
    }

    public Map<String, Exit> getExits() {
        return exits;
    }

    public void setExits(Map<String, Exit> exits) {
        this.exits = exits;
    }

    public Chest getChest(int id) {
        return chests.get(id);
    }

    public Map<Integer, Chest> getChests() {
        return chests;
    }

    public void setChests(Map<Integer, Chest> chests) {
        this.chests = chests;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", exits=" + exits + ", chests=" + chests + "]";
    }

}
