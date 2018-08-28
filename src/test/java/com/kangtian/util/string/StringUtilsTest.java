package com.kangtian.util.string;



import org.junit.Test;

import static org.junit.Assert.*;


public class StringUtilsTest {


    @Test
    public void isEmpty() {
        assert StringUtils.isEmpty("")==true;
    }

    @Test
    public void isNotEmpty() {
        assert StringUtils.isNotEmpty("   ")==true;
    }

    @Test
    public void isBlank() {
        assert StringUtils.isBlank(" ")==true;
    }

    @Test
    public void isNotBlank() {
        assert StringUtils.isNotBlank(" ")==true;
    }

    @Test
    public void strip() {
        assert  3==StringUtils.strip("  abc  ").length();
    }

    @Test
    public void stripHead() {
        assert  1==StringUtils.stripHead("abc","a").length();
    }

    @Test
    public void stripButtom() {
    }

    @Test
    public void deleteChidStr() {
        System.out.println(StringUtils.deleteChidStr("  abdcadabb","ab"));
    }
}
