package Problems;

import java.util.*;


//uniqueid
//workerid

//dept_id, unit_id
public class CacheDesign {

	private enum IndexTypes{
		UNIT_ID,
		DEPTH_ID
	}
	
	private Map<IndexTypes, Map<Integer, List<WorkerObj>>> cache;
	
	public CacheDesign(){
		cache = new HashMap<>();
	}
	
	
	public List<WorkerObj> getWorkersByKey(IndexTypes indexType, Integer id){
		
		List<WorkerObj> results = null;
		Map<Integer, List<WorkerObj>> workersMap = cache.get(indexType);
		
		if(cache.containsKey(indexType) && cache.get(indexType).containsKey(id)){
			results = workersMap.get(id);
		}
		else{
			
			results = getServerWorkers(indexType, id);
			
			if(!cache.containsKey(indexType)){
				cache.put(indexType, new HashMap<>());
			}
			
			if(!cache.get(indexType).containsKey(id)){
				cache.get(indexType).put(id, results);
			}
		}
		
		return results;
	}
	
	
	
	private List<WorkerObj> getServerWorkers(IndexTypes indexType, Integer id){
		
		//return a lot of workers
		
		return null;
	}
	
	class WorkerObj{
		
		int workerId;
		
		int deptId;
		
		int unitId;
		
		String Name;
		
		String Surname;
		
		String Data;
	}
	
}
