package employee;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import java.io.*;
import java.util.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
  public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
      Reporter reporter) throws IOException {
    double sum = 0;
    int count = 0;
    while (values.hasNext()) {
      sum += values.next().get();
      count++;
    }

    output.collect(new Text("Number of " + key + " employees "), new DoubleWritable(count));
    output.collect(new Text("Average salary of " + key + " employees "), new DoubleWritable(sum / count));
  }
}
