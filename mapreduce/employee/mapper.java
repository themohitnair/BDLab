package employee;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import java.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {
  public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
      throws IOException {
    String[] line = value.toString().split("\\t");
    if (line.length < 9) {
      return;
    }
    String gender = line[3];
    Double salary = Double.parseDouble(line[8]);
    output.collect(new Text(gender), new DoubleWritable(salary));
  }
}
