package com.demo;

import com.google.common.base.Joiner;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import static com.google.common.collect.ImmutableMap.of;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 11:24
 **/
public class JoinerTest {

    private final Map<String, String> stringMap = of("Hello", "Guava", "Java", "Scala");

    private final List<String> stringListWithNullValue = Arrays.asList("Google", "Guava", "Java", "Scala", null);

    private final String targetFileName = "C:\\src\\guava-joiner.txt";
    private final String targetFileNameToMap = "C:\\src\\guava-joiner-map.txt";

    @Test
    public void testJoinOnWithMap() {
        assertThat(Joiner.on("#").withKeyValueSeparator('=').join(stringMap), equalTo("Hello=Guava#Java=Scala"));
    }

    @Test
    public void testJoinOnWithMapToAppendable() {
        try (FileWriter writer = new FileWriter(new File(targetFileNameToMap))) {
            Joiner.on("#").withKeyValueSeparator("=").appendTo(writer, stringMap);
            assertThat(Files.isFile().test(new File((targetFileNameToMap))), equalTo(true));
        } catch (IOException e) {
            fail("append to the writer occur fetal error.");
        }
    }
}
