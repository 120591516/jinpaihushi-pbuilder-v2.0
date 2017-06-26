package com.afocus.test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.afocus.pbuilder.common.utils.ArrayList;

public class StreamTest {

	public static final Integer[] data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16 };
	
	//private static final VelocityEngine velocityEngine = new VelocityEngine();

	
	//@Test
	public void testStream(){
		int sum = new ArrayList<Integer>().addAll(data).stream().mapToInt(e -> e).sum();
		System.out.println(sum);
	}
	
	//@Test
	public void testCollect(){
		System.out.println(Stream.of(data).filter(e -> e>5).collect(Collectors.toList()));
		
	}


}
