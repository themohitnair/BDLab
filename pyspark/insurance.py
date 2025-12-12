import sys

if len(sys.argv) != 4:
    print("Please provide input and output files as arguments.")
    sys.exit(0)

from pyspark import SparkContext

sc = SparkContext("local", "Insurance")

f = sc.textFile(sys.argv[1])

temp = f.map(lambda x: (x.split(",")[16], 1))
build_count = temp.countByKey()
results = sc.parallelize(build_count.items())
results.saveAsTextFile(sys.argv[2])

temp = f.map(lambda x: (x.split(",")[2], 1))
county_count = temp.countByKey()
results = sc.parallelize(county_count.items())
results.saveAsTextFile(sys.argv[3])
