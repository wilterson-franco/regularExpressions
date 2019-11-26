package com.wilterson;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author francow
 */
@DisplayName("Test regular expressions with String class")
class RegexTest
{
    public static final String EXAMPLE_TEST = "This is my small example string. Test #1.";

    @BeforeEach
    void setUp() throws Exception
    {

    }

    @Test
    @DisplayName("Split string on space characters")
    void splitOnSpace()
    {
        Pattern pattern = Pattern.compile("\\s+");
        String[] myStr = pattern.split(EXAMPLE_TEST);

        System.out.println(Arrays.asList(myStr));

        assertThat(myStr.length, is(8));
    }

    @Test
    @DisplayName("Split string on words")
    void splitOnWords()
    {
        Pattern pattern = Pattern.compile("\\S+");
        String[] myStr = pattern.split(EXAMPLE_TEST);

        System.out.println(Arrays.asList(myStr));

        assertThat(myStr.length, is(11));
    }

    @Test
    @DisplayName("Replace spaces by tabs")
    void replaceSpaceForTab()
    {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        assertThat(matcher.replaceAll("\t"), is("This\tis\tmy\tsmall\texample\tstring"));
    }
}
