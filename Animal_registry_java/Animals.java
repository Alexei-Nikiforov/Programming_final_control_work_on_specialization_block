import java.util.ArrayList;
import java.util.List;

public class Animals {

    private String name;
    private List<String> commands = new ArrayList<>();

    public Animals (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommands(String command) {
        commands.add(command);
    }
    
}