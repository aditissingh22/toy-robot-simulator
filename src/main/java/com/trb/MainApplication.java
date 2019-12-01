package com.trb;

import java.io.Console;
import java.util.Scanner;

import com.trb.exception.ToyRobotException;
import com.trb.simulator.SquareBoard;
import com.trb.simulator.ToyRobot;

public class MainApplication {

	public static void main(String[] args) {

		SquareBoard squareBoard = new SquareBoard(4, 4);
		ToyRobot robot = new ToyRobot();
		Game game = new Game(squareBoard, robot);

		System.out.println("Toy Robot Simulator");
		System.out.println("Enter a command, Valid commands are:");
		System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

		boolean keepRunning = true;
		while (keepRunning) {
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();

			if ("EXIT".equals(inputString)) {
				keepRunning = false;
			} else {
				try {
					String outputVal = game.eval(inputString);
					System.out.println(outputVal);
				} catch (ToyRobotException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}