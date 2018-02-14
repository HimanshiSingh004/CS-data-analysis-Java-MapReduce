package org;

import java.io.*;
	import org.apache.hadoop.conf.Configuration;
	import org.apache.hadoop.fs.Path;
	import org.apache.hadoop.io.IntWritable;
	import org.apache.hadoop.io.Text;
	import org.apache.hadoop.mapreduce.Job;
	import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

	public class SportsDriver{

		/**
		 * @param args
		 * @throws IOException 
		 */
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			Configuration conf=new Configuration();
			Job job=Job.getInstance(conf,"Count");
			
			job.setJarByClass(SportsDriver.class);
			job.setMapperClass(SportsMapper.class);
			job.setReducerClass(SportsReducer.class);
			job.setPartitionerClass(SportsPartitioner.class); //setting combiner
			job.setNumReduceTasks(3); //It will run reducer twice.
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			FileInputFormat.addInputPath(job,new Path("sportsinput"));
			FileOutputFormat.setOutputPath(job,new Path("sportsoutput"));
			
			try {
				job.waitForCompletion(true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


