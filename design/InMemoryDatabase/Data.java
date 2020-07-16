package InMemoryDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;





public class Data {
    private Map<String, String> data = new ConcurrentHashMap<String, String>();
    private Map<String, Integer> valueCountMap = new HashMap<String, Integer>();
    TransationLogSerializer ser = null;
    
    Data()
    {
    	ser = new TransationLogSerializer();
    }
    
    public class Node<T>
    {
    	T value;
    	int versionId;
    	Node prev;
    	Node next;
    	
    }

    private List<String> keysToBeDeleted = new ArrayList<String>();

    public void setData(String key, String value) throws IOException {
        if (keysToBeDeleted.contains(key)) {
            keysToBeDeleted.remove(key);
        }
        //add transaction to log
        ser.WriteToFile(key, value, 0);
        data.put(key, value);
    }

    public Map<String, String> getData() {
        return data;
    }

    public boolean isKeyDeleted(String key) {
        return keysToBeDeleted.contains(key);
    }

    public String getKeyValue(String key) {
        if (keysToBeDeleted.contains(key)) {
            return null;
        }
        return data.get(key);
    }

    public Integer getValueCount(String value) {
        if (!valueCountMap.containsKey(value)) {
            return null;
        }
        return valueCountMap.get(value);
    }

    public void setValueCount(String value, Integer valueCount) {
        valueCountMap.put(value, valueCount);
    }

    public void unsetKey(String key) {
        keysToBeDeleted.add(key);
        data.remove(key);
    }

    public void mergeTransaction(Data transaction) {
        //merge keys
        for (String key : transaction.getData().keySet()) {
            this.data.put(key, transaction.getKeyValue(key));
        }

        //delete deleted keys
        for (String deletedKey : transaction.getKeysToBeDeleted()) {
            this.data.remove(deletedKey);
        }

        //update valueCounts
        for (String value : transaction.getValueCountMap().keySet()) {
            this.valueCountMap.put(value, transaction.getValueCount(value));
        }
    }

    private List<String> getKeysToBeDeleted() {
        return keysToBeDeleted;
    }

    private Map<String, Integer> getValueCountMap() {
        return valueCountMap;
    }
}