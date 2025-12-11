# BDLab

A collection of Big Data Laboratory Programs (ISL75, RITB ISE 2022)

## Setting the environment up

- **Organizing**
  
  ```bash
  mkdir env
  cd env
  ```

- **Extraction**
  
  ```bash
  wget https://archive.apache.org/dist/hadoop/core/hadoop-3.2.2/hadoop-3.2.2.tar.gz
  ```

  ```bash
  wget https://archive.apache.org/dist/spark/spark-3.5.2/spark-3.5.2-bin-hadoop3.tgz
  ```

  ```bash
  wget https://archive.apache.org/dist/pig/pig-0.17.0/pig-0.17.0.tar.gz
  ```

- **Renaming** (adjust if you are skipping this step)
  
  ```bash
  mv hadoop-3.2.2 hadoop
  mv spark-3.5.2-bin-hadoop3 spark
  mv pig-0.17.0 pig
  ```

- **Setting paths up**
  
  Create an env.sh within the env directory you worked on until now.
  
  ```bash
  export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
  export PATH=$PATH:$JAVA_HOME/bin

  export HADOOP_HOME=$HOME/Skywalker/BDLab/env/hadoop
  export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin

  export SPARK_HOME=$HOME/Skywalker/BDLab/env/spark
  export PATH=$PATH:$SPARK_HOME/bin

  export PIG_HOME=$HOME/Skywalker/BDLab/env/pig
  export PATH=$PATH:$PIG_HOME/bin
  ```

- **Test it out**
  
  ```bash
  hadoop version
  spark-shell --version
  pig -version
  ```

  Getting warnings, or errors would mean that there are some unresolved conflict or you messed the previous steps up.

## IDE Support

To get VSCode IDE support, along with the prescribed RedHat Java Extensions, add the followings to your local `.vscode/settings.json`:

```config
{
  "java.project.referencedLibraries": [
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/common/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/common/lib/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/hdfs/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/hdfs/lib/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/mapreduce/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/mapreduce/lib/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/yarn/*.jar",
    "/home/themohitnair/Skywalker/BDLab/env/hadoop/share/hadoop/yarn/lib/*.jar",
  ]
}
```
