package oddeven;

import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
  public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
      Reporter reporter) throws IOException {
    int sum = 0;
    int count = 0;
    while (values.hasNext()) {
      sum += values.next().get();
      count++;
    }
    output.collect(new Text("Sum of " + key + "numbers is "), new IntWritable(sum));
    output.collect(new Text("Number of " + key + "numbers is "), new IntWritable(count));
  }
}
