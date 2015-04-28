package com.zrp.apero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	private Player player = null;
	private List<Room> rooms = null;
	private Scanner uI = null;
	private boolean playerQuit = false;

	public Controller() {
		uI = new Scanner(System.in);
		playerQuit = false;

		rooms = new ArrayList<Room>();
		List<Exit> exits = new ArrayList<Exit>();

		// room 0
		Room room = new Room();
		Exit exit = new Exit();
		exit.setDirection("North");
		exit.setRoom(1);
		exits.add(exit);
		room.setExits(exits);
		rooms.add(room);

		// room 1
		exits = new ArrayList<Exit>();
		room = new Room();
		exit = new Exit();
		exit.setDirection("South");
		exit.setRoom(0);
		exits.add(exit);
		exit = new Exit();
		exit.setDirection("North");
		exit.setRoom(2);
		exits.add(exit);
		room.setExits(exits);
		rooms.add(room);

		// room 2
		room = new Room();
		exit = new Exit();
		exit.setDirection("South");
		exit.setRoom(1);
		exits.add(exit);
		exit = new Exit();
		exit.setDirection("East");
		exit.setRoom(3);
		exits.add(exit);
		room.setExits(exits);
		rooms.add(room);

		// room 3
		room = new Room();
		exit = new Exit();
		exit.setDirection("North");
		exit.setRoom(2);
		exits.add(exit);
		exit = new Exit();
		exit.setDirection("East");
		exit.setRoom(4);
		exits.add(exit);
		exit = new Exit();
		exit.setDirection("West");
		exit.setRoom(5);
		exits.add(exit);
		room.setExits(exits);
		rooms.add(room);
	}

	public void displayMainMenu() {
		System.out.println("MAIN MENU");
		System.out.println("---------");
		System.out.println("Type 1 for profiles");
		System.out.println("Type 2 for options");
		Scanner uI = null;

		try {
			uI = new Scanner(System.in);
			String answer = uI.next();

			if (answer.equalsIgnoreCase("1")) {

				player = new Player();
				playGame();

			} else if (answer.equalsIgnoreCase("2")) {

			} else {

			}
		} finally {
			if (uI != null) {
				uI.close();
			}
		}
	}

	private void playGame() {
		do {
			displayRoom(player.getRoom());
			System.out
					.println(" now, what would you like to do?");
			String answer = uI.next();
			System.out.println("ANSWER = " + answer);
			if (answer.equalsIgnoreCase("quit")
					|| answer.equalsIgnoreCase("exit")
					|| answer.equalsIgnoreCase("stop")) {
				playerQuit = true;
			} else {// if (answer.startsWith("go ")) {
				// System.out.println("Attempting to go in that direction...");
				player.go(getRoom(player.getRoom(), answer));
			}
		} while (!playerQuit);
	}

	private void displayRoom(int roomNumber) {
		Room room = rooms.get(roomNumber);
		List<Exit> exits = room.getExits();
		System.out.println("You are in room " + roomNumber);
		System.out.print("There are exits to the ");
		for (int i = 0; i < exits.size(); i++) {
			System.out.print(exits.get(i).getDirection()
					+ ", ");

		}
	}

	private int getRoom(int roomNumber, String direction) {
		System.out.println("Trying to go " + direction);
		Room room = rooms.get(roomNumber);
		List<Exit> exits = room.getExits();
		for (Exit exit : exits) {
			System.out.println("Found exit to the "
					+ exit.getDirection() + " to room "
					+ exit.getRoom());
			if (exit.getDirection().equalsIgnoreCase(
					direction)) {
				System.out.println("Room " + exit.getRoom()
						+ " is to the "
						+ exit.getDirection());
				return exit.getRoom();
			}
		}
		System.out.println("Did not find next room.");
		return roomNumber;
	}
}