package WebCrawler;

public abstract class PageDataStore {
	
	
	abstract void add_link_to_crawl();
	abstract void remove_link_to_crawl();
	abstract void reduce_priority_to_crawl();
	abstract void crawled_similar();
	abstract void extract_max_priority_page();
	

}
