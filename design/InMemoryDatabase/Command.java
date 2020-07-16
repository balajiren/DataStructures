package InMemoryDatabase;


public interface Command {
    public abstract void execute(DataContainer dataContainer);
}
