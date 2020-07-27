package Concepts;

public class XMS_XMX {

  /**
   * High Level Definition: xmx and xms are JVM, Java Virtual Machine, command-line options/flags
   * that are used by programmers to manipulate the heap size used by JVM.
   *
   * <p>XMS: (Initial memory allocation pool) -
   *
   * <p>1. xms is used to specify the initial lower bound of java heap memory size.
   *
   * <p>2. Default xms size is 1/64th of the physical memory size.
   *
   * <p>3. Java -xms{Numerical Size}{Unit} // java -xms1G or java -xms512m - Unit is k/Kk/K for
   * kilobytes, m/Mm/M for megabytes, and g/G for gigabytets. 4.
   *
   * <p>4. By default, the size is in bytes. Initial heap size for the startup, however, during the
   * working process the heap size can be less than -Xms due to users' inactivity or GC iterations.
   * This is not a minimal required heap size.
   *
   * <p>XMX: (Maximum memory allocation pool) --
   *
   * <p>1. xmx is used to specify the upper bound of java heap memory size.
   *
   * <p>2. Default xmx size is 1/4th of the physical memory size.
   *
   * <p>java -xmx{Numerical Size}{Unit} // java -xmx1G or java -xmx256k
   *
   * <p>Points to Note -
   *
   * <p>1. Note that the JVM uses more memory than just the heap. For example Java methods, thread
   * stacks and native handles are allocated in memory separate from the heap, as well as JVM
   * internal data structures.
   *
   * <p>2. If the programmer initializes a fairly large heap size, then the Garbage Collector will
   * more time while clearing the memory, which will slow down the program.consume
   *
   * <p>3. If the programmer initializes a fairly small heap size, then it is possible to run out of
   * memory. Insufficient memory will throw the following exception: java.lang.OutOfMemoryError:
   * Java heap space.
   */
}
