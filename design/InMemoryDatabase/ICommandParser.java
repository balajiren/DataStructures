package InMemoryDatabase;

public interface ICommandParser {
    public Command getCommand(String rawCommand);
}
