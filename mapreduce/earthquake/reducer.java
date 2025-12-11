package earthquake;

import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
  public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
      Reporter reporter) throws IOException {
    Double max = -9999.50;
    while (values.hasNext()) {
      max = Math.max(max, values.next().get());
    }
    output.collect(new Text(key), new DoubleWritable(max));
  }
}
