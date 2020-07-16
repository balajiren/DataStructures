package InMemoryDatabase;

public class InvalidCommand implements Command {
    private String errorMessage;

    public InvalidCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute(DataContainer dataContainer) {
        System.out.println(errorMessage);
    }
}