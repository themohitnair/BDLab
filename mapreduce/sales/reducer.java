package sales;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import java.io.*;
import java.util.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
  public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
      Reporter reporter) throws IOException {
    int sum = 0;
    while (values.hasNext()) {
      sum += values.next().get();
    }
    output.collect(new Text(key), new IntWritable(sum));
  }

}
