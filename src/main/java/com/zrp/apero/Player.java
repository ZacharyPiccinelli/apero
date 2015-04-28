package com.zrp.apero;

public class Player {
	
		private int room = 0;
		private int bombCount = 0;
		private int arrowCount = 0;
		private int peerueCount = 5;
		private int maxPeerueCount = 10;
		private double health = 3.0;
		private int heartContainers = 3;
		private Item[]items = null;
		
		
		public boolean go(int roomNumber){
			setRoom (roomNumber);
			return true;
		}
		public int getRoom() {
			return room;
		}
		public void setRoom(int room) {
			this.room = room;
		}
		public int getBombCount() {
			return bombCount;
		}
		public void setBombCount(int bombCount) {
			this.bombCount = bombCount;
		}
		public int getArrowCount() {
			return arrowCount;
		}
		public void setArrowCount(int arrowCount) {
			this.arrowCount = arrowCount;
		}
		public int getPeerueCount() {
			return peerueCount;
		}
		public int setPeerueCount(int peerueCountChange) {
			int newTotal = peerueCount + peerueCountChange;
			if (newTotal <= maxPeerueCount) {
				peerueCount = newTotal;
				return 0;
			} else {
				peerueCount = maxPeerueCount;
				return newTotal - maxPeerueCount;
			}
		}
		public int getMaxPeerueCount() {
			return maxPeerueCount;
		}
		public void setMaxPeerueCount(int maxPeerueCount) {
			this.maxPeerueCount = maxPeerueCount;
		}
		public double getHealth() {
			return health;
		}
		public void setHealth(double health) {
			this.health = health;
		}
		public int getHeartContainers() {
			return heartContainers;
		}
		public void setHeartContainers(int heartContainers) {
			this.heartContainers = heartContainers;
		}
		public Item[] getItems() {
			return items;
		}
		public void setItems(Item[] items) {
			this.items = items;
		}
		
		
}
