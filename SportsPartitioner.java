package org;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class SportsPartitioner extends Partitioner<Text,Text> {

	@Override
	public int getPartition(Text key, Text value, int no_of_partition) {
		// TODO Auto-generated method stub
		String strkey = key.toString();
		String strvalue = value.toString();
		if(strkey.equalsIgnoreCase("cricket") && strvalue.equalsIgnoreCase("india"))
		return 0;
		if(strkey.equalsIgnoreCase("cricket") && !strvalue.equalsIgnoreCase("india"))
		return 1;
		else
			return 2;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
