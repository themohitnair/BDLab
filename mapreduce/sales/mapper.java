package sales;

import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
  private final static IntWritable one = new IntWritable(1);

  public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {
    String[] line = value.toString().split(",");
    String mode = line[3];
    String country = line[7];
    Integer price = Integer.parseInt(line[2]);
    output.collect(new Text(country), new IntWritable(price));
    output.collect(new Text(mode), one);
  }
}
