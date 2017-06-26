package com.afocus.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupTest {
	
	//@Test
	public void testA() throws IOException{
		Document doc = Jsoup.connect("http://pa.afocus.com.cn/login.jsp").get();
		
	}

}
