package com.atguigu.mapreduce.friends;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TwoShareFriendsReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		StringBuffer sBuffer = new StringBuffer();
		
		for (Text person : values) {
			sBuffer.append(person).append(" ");
		}
		
		context.write(key, new Text(sBuffer.toString()));
	}
}
