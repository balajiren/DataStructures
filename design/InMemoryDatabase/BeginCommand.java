package InMemoryDatabase;

public class BeginCommand implements Command {

	@Override
    public void execute(DataContainer dataContainer) {
        dataContainer.updateDataToNewTransaction();
        System.out.println();
    }

}
