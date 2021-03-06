package com.blankj.utilcode.utils;

import org.junit.Test;

import static com.blankj.utilcode.utils.StringUtils.equalsIgnoreCase;
import static com.blankj.utilcode.utils.StringUtils.isEmpty;
import static com.blankj.utilcode.utils.StringUtils.isSpace;
import static com.blankj.utilcode.utils.StringUtils.length;
import static com.blankj.utilcode.utils.StringUtils.lowerFirstLetter;
import static com.blankj.utilcode.utils.StringUtils.null2Length0;
import static com.blankj.utilcode.utils.StringUtils.reverse;
import static com.blankj.utilcode.utils.StringUtils.toDBC;
import static com.blankj.utilcode.utils.StringUtils.toSBC;
import static com.blankj.utilcode.utils.StringUtils.upperFirstLetter;
import static com.google.common.truth.Truth.assertThat;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/16
 *     desc  : StringUtils单元测试
 * </pre>
 */
public class StringUtilsTest {

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(isEmpty("")).isTrue();
        assertThat(isEmpty(null)).isTrue();
        assertThat(isEmpty(" ")).isFalse();
    }

    @Test
    public void testIsSpace() throws Exception {
        assertThat(isSpace("")).isTrue();
        assertThat(isSpace(null)).isTrue();
        assertThat(isSpace(" ")).isTrue();
        assertThat(isSpace("　")).isFalse();
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(StringUtils.equals("blankj", "blankj")).isEqualTo(true);
        assertThat(StringUtils.equals("blankj", "Blankj")).isEqualTo(false);
    }

    @Test
    public void testEqualsIgnoreCase() throws Exception {
        assertThat(equalsIgnoreCase("blankj", "Blankj")).isEqualTo(true);
        assertThat(equalsIgnoreCase("blankj", "blankj")).isEqualTo(true);
        assertThat(equalsIgnoreCase("blankj", "blank")).isEqualTo(false);
    }

    @Test
    public void testNull2Length0() throws Exception {
        assertThat(null2Length0(null)).isEqualTo("");
    }

    @Test
    public void testLength() throws Exception {
        assertThat(length(null)).isEqualTo(0);
        assertThat(length("")).isEqualTo(0);
        assertThat(length("blankj")).isEqualTo(6);
    }

    @Test
    public void testUpperFirstLetter() throws Exception {
        assertThat(upperFirstLetter("blankj")).isEqualTo("Blankj");
        assertThat(upperFirstLetter("Blankj")).isEqualTo("Blankj");
        assertThat(upperFirstLetter("1Blankj")).isEqualTo("1Blankj");
    }

    @Test
    public void testLowerFirstLetter() throws Exception {
        assertThat(lowerFirstLetter("blankj")).isEqualTo("blankj");
        assertThat(lowerFirstLetter("Blankj")).isEqualTo("blankj");
        assertThat(lowerFirstLetter("1blankj")).isEqualTo("1blankj");
    }

    @Test
    public void testReverse() throws Exception {
        assertThat(reverse("blankj")).isEqualTo("jknalb");
        assertThat(reverse("blank")).isEqualTo("knalb");
        assertThat(reverse("测试中文")).isEqualTo("文中试测");
        assertThat(reverse(null)).isNull();
    }

    @Test
    public void testToDBC() throws Exception {
        assertThat(toDBC("　，．＆")).isEqualTo(" ,.&");
    }

    @Test
    public void testToSBC() throws Exception {
        assertThat(toSBC(" ,.&")).isEqualTo("　，．＆");
    }
}