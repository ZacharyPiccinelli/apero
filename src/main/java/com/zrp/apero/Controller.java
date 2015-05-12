package com.zrp.apero;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zrp.apero.map.Chest;
import com.zrp.apero.map.Exit;
import com.zrp.apero.map.Room;
import com.zrp.apero.map.WorldMap;
import com.zrp.apero.map.WorldMapLoader;

public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    private Player player = null;
    private Scanner uI = null;
    private boolean playerQuit = false;
    private WorldMap map = null;

    public Controller() {
        map = WorldMapLoader.loadMap();
        System.out.println("map = " + map);

        uI = new Scanner(System.in);
        playerQuit = false;
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
        logger.info("Starting game");
        do {
            displayRoom(player.getRoom());
            System.out.println(" now, what would you like to do?");
            String answer = uI.nextLine().toLowerCase();
            System.out.println("ANSWER = " + answer);
            if (answer.equalsIgnoreCase("quit") || answer.equalsIgnoreCase("exit")
                    || answer.equalsIgnoreCase("stop")) {
                playerQuit = true;
            } else if (answer.startsWith("go ") || answer.startsWith("walk ") || answer.startsWith("move ")) {
                String direction = answer.substring(answer.indexOf(" ") + 1);
                logger.info("Attempting to go " + direction);
                player.go(getRoom(player.getRoom(), direction));
            } else {
                System.out.println("Do not recognize command '" + answer + "'. Please try again.");
            }
        } while (!playerQuit);
    }

    private void displayRoom(int roomNumber) {
        Room room = map.getRoom(roomNumber);
        System.out.println("You are in room " + roomNumber);

        Map<String, Exit> exits = room.getExits();
        System.out.print("There are exits to the ");
        for (String direction : exits.keySet()) {
            System.out.print(direction + ", ");
        }

        Map<Integer, Chest> chests = room.getChests();
        if (!chests.isEmpty()) {
            System.out.print("There are chests here.");
            for (int number : chests.keySet()) {
                System.out.print(number + ", ");
            }
        }
    }

    private int getRoom(int roomNumber, String direction) {
        System.out.println("Trying to go " + direction);
        Room room = map.getRoom(roomNumber);
        Map<String, Exit> exits = room.getExits();
        for (String directionKey : exits.keySet()) {
            Exit exit = exits.get(directionKey);
            System.out.println("Found exit to the " + exit.getDirection() + " to room "
                    + exit.getRoom());
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                System.out.println("Room " + exit.getRoom() + " is to the " + exit.getDirection());
                return exit.getRoom();
            }
        }
        System.out.println("Did not find next room.");
        return roomNumber;
    }
}