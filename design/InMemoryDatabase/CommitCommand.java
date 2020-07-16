package InMemoryDatabase;

public class CommitCommand implements Command {

	 @Override
	    public void execute(DataContainer dataContainer) {
	        Data data = dataContainer.getData();
	        TransactionManager transactionManager = dataContainer.getTransactionManager();

	        Data mergedTransaction = transactionManager.commit(data);
	        if (mergedTransaction == null) {
	            System.out.println("NO TRANSACTION");
	        } else {
	            dataContainer.setData(mergedTransaction);
	            transactionManager.cleanOldTransactions();
	            System.out.println();
	        }
	    }

}
