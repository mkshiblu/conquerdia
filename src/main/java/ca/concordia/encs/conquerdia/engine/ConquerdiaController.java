package ca.concordia.encs.conquerdia.engine;

import ca.concordia.encs.conquerdia.engine.command.Command;
import ca.concordia.encs.conquerdia.engine.command.CommandExecutor;
import ca.concordia.encs.conquerdia.engine.command.CommandFactory;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class ConquerdiaController {

    private final ConquerdiaModel conquerdiaModel = new ConquerdiaModel();
    private final CommandFactory commandFactory = new CommandFactory();

    public void start(Scanner scanner, PrintStream output) {
        output.println("Welcome to Conquerdia Game");


        while (true) {
            output.print("> ");
            String commandStr = scanner.nextLine();
            if ("exit".equals(commandStr)) {
                break;
            } else {
                executeCommand(commandStr, output);
            }
        }
    }

    void executeCommand(String commandStr, PrintStream output) {
        CommandExecutor commandExecutor = new CommandExecutor();
        List<Command> commands = commandFactory.getCommands(commandStr, conquerdiaModel);
        for (Command command : commands) {
            output.println(commandExecutor.executeCommand(command));
        }
    }
}
