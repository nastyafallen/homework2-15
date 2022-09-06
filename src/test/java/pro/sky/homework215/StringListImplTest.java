package pro.sky.homework215;

import org.junit.jupiter.api.Test;
import pro.sky.homework215.exception.MyIllegalArgumentException;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringListImpl out = new StringListImpl();

    @Test
    public void addPositiveTest() {
        String test = "test test";
        assertThat(out.add("test test")).isEqualTo(test);
        assertThat(out.add(0, "test test")).isEqualTo(test);

    }

    @Test
    public void addNegativeTest() {
        String test = "test test";
        out.add(test);
        out.add(test);
        out.add(test);
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.add("test 2"));
    }

    @Test
    public void addNegativeTest2() {
        String test = "test test";
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.add(-1, "test 2"));
    }

    @Test
    public void setPositiveTest() {
        String test = "test test";
        assertThat(out.add(0, "test test")).isEqualTo(test);
    }

    @Test
    public void setNegativeTest() {
        String test = "test test";
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.set(3, test));
    }

    @Test
    public void removePositiveTest() {
        out.add("test");
        out.remove("test");
        assertThat(out.contains("test")).isFalse();
        assertThat(out.get(0)).isNull();
    }

    @Test
    public void removeNegativeTest() {
        out.add("test");
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.remove("test test"));
    }

    @Test
    public void removeByIndexPositiveTest() {
        out.add(0, "test");
        out.removeByIndex(0);
        assertThat(out.contains("test")).isFalse();
        assertThat(out.get(0)).isNull();
    }

    @Test
    public void removeByIndexNegativeTest() {
        out.add(0, "test");
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.removeByIndex(4));
    }

    @Test
    public void containsPositiveTest() {
        out.add("test");
        assertThat(out.contains("test")).isTrue();
    }

    @Test
    public void containsNegativeTest() {
        out.add("test");
        assertThat(out.contains("test2")).isFalse();
    }

    @Test
    public void indexOfPositiveTest() {
        out.add("test");
        assertThat(out.indexOf("test")).isEqualTo(0);
    }

    @Test
    public void indexOfNegativeTest() {
        out.add("test");
        assertThat(out.indexOf("test2")).isEqualTo(-1);
    }

    @Test
    public void lastIndexOfPositiveTest() {
        out.add("test");
        out.add("test");
        out.add("test");
        assertThat(out.lastIndexOf("test")).isEqualTo(2);
    }

    @Test
    public void lastIndexOfNegativeTest() {
        out.add("test");
        assertThat(out.lastIndexOf("test2")).isEqualTo(-1);
    }

    @Test
    public void getPositiveTest() {
        out.add("test");
        assertThat(out.get(0)).isEqualTo("test");
    }

    @Test
    public void getNegativeTest() {
        out.add("test");
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.get(4));
    }

    @Test
    public void equalsPositiveTest() {
        StringList testStringList = new StringListImpl(3);
        testStringList.add("test");
        out.add("test");
        assertThat(out.equals(testStringList)).isTrue();
    }

    @Test
    public void equalsNegativeTest() {
        StringList testStringList = new StringListImpl();
        testStringList.add("test");
        testStringList.add("test2");
        assertThat(out.size()).isNotEqualTo(testStringList.size());
        assertThat(out.equals(testStringList)).isFalse();
    }

    @Test
    public void sizeTest() {
        assertThat(out.size()).isEqualTo(0);
    }

    @Test
    public void isEmptyPositiveTest() {
        assertThat(out.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyNegativeTest() {
        out.add("test");
        out.add("test2");
        assertThat(out.isEmpty()).isFalse();
    }

    @Test
    public void clearTest() {
        out.add("test");
        out.add("test2");
        out.add("test3");
        out.clear();
        assertThat(out.isEmpty()).isTrue();
    }

    @Test
    public void toArrayPositiveTest() {
        out.add("test");
        out.add("test2");
        String[] test = out.toArray();
        assertThat(out.toArray()).containsExactlyElementsOf(Arrays.stream(test)
                .collect(Collectors.toList()));
    }

    @Test
    public void checkForNullPositiveTest() {
        String test = "test test";
        assertDoesNotThrow(() -> out.checkForNull(test));
    }

    @Test
    public void checkForNullNegativeTest() {
        String test = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> out.checkForNull(test));
    }
}