package com.zrp.apero;

public class Exit {
	private String direction = null;
	private int room = -1;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((direction == null) ? 0 : direction
						.hashCode());
		result = prime * result + room;
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
		Exit other = (Exit) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (room != other.room)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exit [direction=" + direction + ", room="
				+ room + "]";
	}
}