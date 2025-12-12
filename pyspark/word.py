from pyspark import SparkContext

sc = SparkContext("local", "Word")

rdd = sc.textFile("inputs/word_input.txt")

num_lines = rdd.count()
print(f"Number of lines: {num_lines}")

word_lengths = rdd.flatMap(lambda line: line.split()).map(
    lambda word: (word, len(word))
)

word_lengths_result = word_lengths.collect()

for word, length in word_lengths_result:
    print(f"Word: {word}, Length: {length}")

sc.stop()
