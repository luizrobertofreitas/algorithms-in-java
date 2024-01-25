package org.algorithms.other;

import com.sangupta.murmur.Murmur3;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.Charset;

/*
    JMH usage test. This is not expected to be run as automated tests. It's only meant to be executed by developers
    in order to validate the logic performance under pressure conditions.
*/

@State(Scope.Benchmark)
public class JmhMicroBenchmarkTest {

    @Param({"100", "200"})
    private int iterations;

    private String password = "4v3rys3kur3p455w0rd";

    public static void main(String[] args) throws RunnerException {
        new Runner(
            new OptionsBuilder()
                    .include(JmhMicroBenchmarkTest.class.getSimpleName())
                    .forks(2)
                    .build()
        ).run();
    }

    @Setup
    public void setUp() {
        System.out.println("Invoking setup");
    }

    @Benchmark
    public void test() {
        final byte[] passwordBytes = password.getBytes(Charset.defaultCharset());
        for (int i = iterations; i  > 0; i--) {
            Murmur3.hash_x64_128(passwordBytes, passwordBytes.length, i);
        }
    }

}
