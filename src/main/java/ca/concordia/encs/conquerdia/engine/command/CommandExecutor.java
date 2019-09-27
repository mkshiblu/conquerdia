package ca.concordia.encs.conquerdia.engine.command;

public class CommandExecutor {

    public String executeCommand(Command command) {
        return command.execute();
    }
}
