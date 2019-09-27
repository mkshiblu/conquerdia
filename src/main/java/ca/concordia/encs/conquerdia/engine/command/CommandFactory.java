package ca.concordia.encs.conquerdia.engine.command;

import ca.concordia.encs.conquerdia.engine.ConquerdiaModel;
import ca.concordia.encs.conquerdia.engine.map.Continent;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    public List<Command> getCommands(String userInput, ConquerdiaModel conquerdiaModel) {
        List<Command> commands = new ArrayList<>();
        commands.add(() -> "Invalid Command");
        return commands;
    }
}
