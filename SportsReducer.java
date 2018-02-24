package org;
import java.io.IOException;
//reducer
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
public class SportsReducer extends Reducer<Text,Text,Text,IntWritable> {
	private Text outkey = new Text();
	private IntWritable outvalue = new IntWritable();
	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stu
int sum = 0;
for(Text v : values)
{
	sum ++;
}
outvalue.set(sum);
outkey.set(key);
context.write(outkey,outvalue);

}
}
