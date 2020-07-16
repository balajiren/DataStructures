package WebCrawler;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



class HtmlParser {
	
	public List<String> getUrls(String url) {
		return null;
	}
}

public class Webcrawler {
	
	 private final Set<String> set = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
	    private final List<String> result = Collections.synchronizedList(new ArrayList<String>());
	    private String HOSTNAME = null;

	    public boolean judgeHostname(String url) {
	        int idx = url.indexOf('/', 7);
	        String hostName = (idx != -1) ? url.substring(0, idx) : url;
	        return hostName.equals(HOSTNAME);
	    }

	    private void initHostName(String url) {
	        int idx = url.indexOf('/', 7);
	        HOSTNAME = (idx != -1) ? url.substring(0, idx) : url;
	    }

	    public void getUrl(String startUrl, HtmlParser htmlParser) {
	        result.add(startUrl);
	        List<String> res = htmlParser.getUrls(startUrl);
	        List<Thread> threads = new ArrayList<>();
	        for (String url : res) {
	            if (judgeHostname(url) && !set.contains(url)) {
	                set.add(url);
	                threads.add(new Thread(() -> {
	                    getUrl(url, htmlParser);
	                }));
	            }
	        }
	        for (Thread thread : threads) {
	            thread.start();
	        }
	        try {
	            for (Thread thread : threads) {
	                thread.join();
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
	        initHostName(startUrl);
	        set.add(startUrl);
	        getUrl(startUrl, htmlParser);
	        return result;
	    }

}
