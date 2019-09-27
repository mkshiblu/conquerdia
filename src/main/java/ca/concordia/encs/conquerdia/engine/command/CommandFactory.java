package ca.concordia.encs.conquerdia.engine.command;

import ca.concordia.encs.conquerdia.engine.ConquerdiaModel;
import ca.concordia.encs.conquerdia.engine.map.Continent;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    public List<Command> getCommands(String userInput, ConquerdiaModel conquerdiaModel) {

        try {
            String[] inputCommandParts = userInput.trim().split(" ");
            int cursor = 0;
            if (inputCommandParts.length > 2) {
                List<Command> commands = new ArrayList<>();
                switch (inputCommandParts[cursor++]) {
                    case "editcontinent":
                        while (cursor < inputCommandParts.length) {
                            switch (inputCommandParts[cursor++]) {
                                case ("-add"): {
                                    String continentName = inputCommandParts[cursor++];
                                    String continentValue = inputCommandParts[cursor++];
                                    Continent continent = new Continent.Builder(continentName)
                                            .setValue(continentValue)
                                            .setWorldMap(conquerdiaModel.getWorldMap())
                                            .build();
                                    commands.add(continent::addContinentToWorldMap);
                                }
                                case "-remove": {
                                    String continentName = inputCommandParts[cursor++];
                                    Continent continent = new Continent.Builder(continentName)
                                            .setWorldMap(conquerdiaModel.getWorldMap())
                                            .build();
                                    commands.add(continent::removeContinentFromWorldMap);
                                }
                            }
                        }
                        break;
                }
                return commands;
            }

        } catch (Exception ex) {
            //TODO: Log Exception
            String msg = ex.getMessage();
        }
        List<Command> commands = new ArrayList<>();
        commands.add(() -> "Invalid Command");
        return commands;
    }
}
