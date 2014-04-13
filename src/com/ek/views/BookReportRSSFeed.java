package com.virtualpairprogrammers.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Item;
import com.virtualpairprogrammers.domain.Book;


public class BookReportRSSFeed extends AbstractRssFeedView
{
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> arg0,
			HttpServletRequest arg1, HttpServletResponse arg2) throws Exception 
    {
		List<Item> feed = new ArrayList<Item>();

		List<Book> books = (List<Book>) arg0.get("allBooks");
		for (Book nextBook: books)
		{
			Item next = new Item();
			next.setTitle("New Book Added Today - " + nextBook.getTitle());
			next.setPubDate(new java.util.Date());
			
			Description desc = new Description();
			desc.setType("text/html");
			desc.setValue("We're pleased to announce that we have a new book in stock - " + nextBook.getTitle());			
			next.setDescription(desc);
			
			feed.add(next);
		}
		return feed;
	}

	@Override
	public void buildFeedMetadata(Map model, Channel feed, HttpServletRequest request) 
	{  
		// TODO we should inject this as a dependency - coming soon!
        feed.setTitle("JR Hartley's Book Store");  
        feed.setDescription("When new books arrive, they will appear here");  
        feed.setLink("http://www.jrhartley.com");  
    }  
      			
}
