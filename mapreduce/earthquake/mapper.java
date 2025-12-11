package earthquake;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import java.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {
  public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
      throws IOException {
    String[] line = value.toString().split(",");
    Double longi = Double.parseDouble(line[7]);
    output.collect(new Text(line[11]), new DoubleWritable(longi));
  }
}
