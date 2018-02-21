package org;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class SportsMapper extends Mapper<LongWritable,Text,Text,Text>{
private Text outkey = new Text();
private Text outvalue = new Text();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stu
		String records = value.toString().trim();
		String[] fields = records.split(",");
		outkey.set(fields[2]);
		outvalue.set(fields[1]);
		context.write(outkey,outvalue);
	}
	

}
