package com.atguigu.mapreduce.friends;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TwoShareFriendsMapper extends Mapper<LongWritable, Text, Text, Text>{

	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
	
		//切割
		//排序
		//A	I,K,C,B,G,F,H,O,D,
		String friend = value.toString().split("\t")[0];
		
		String[] persons = value.toString().split("\t")[1].split(",");
		
		Arrays.sort(persons);
		
		for (int i = 0; i < persons.length-1; i++) {
			//B-C A
			for (int j = i+1; j < persons.length; j++) {
				context.write(new Text(persons[i]+"-"+persons[j]), new Text(friend));
			}
		}
		
	}
}
