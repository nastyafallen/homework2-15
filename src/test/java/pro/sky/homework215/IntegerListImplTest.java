package pro.sky.homework215;

import org.junit.jupiter.api.Test;
import pro.sky.homework215.exception.MyIllegalArgumentException;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class IntegerListImplTest {

    IntegerListImpl out = new IntegerListImpl();

    @Test
    public void addPositiveTest() {
        int test = 34;
        assertThat(out.add(34)).isEqualTo(test);
        assertThat(out.add(0, 34)).isEqualTo(test);
    }

    @Test
    public void addNegativeTest() {
        int test = 9;
        out.add(test);
        out.add(test);
        out.add(test);
        out.add(test);
        out.add(test);
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.add(101));
    }

    @Test
    public void addNegativeTest2() {
        int test = 7;
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.add(-1, test));
    }

    @Test
    public void setPositiveTest() {
        int test = 123;
        assertThat(out.set(0, 123)).isEqualTo(test);
    }

    @Test
    public void setNegativeTest() {
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.set(6, 54));
    }

    @Test
    public void removePositiveTest() {
        out.add(12);
        out.remove(12);
        assertThat(out.isEmpty()).isTrue();
    }

   @Test
    public void removeNegativeTest() {
        out.add(7);
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.remove(9));
    }

    @Test
    public void removeByIndexPositiveTest() {
        out.add(1, 66);
        out.removeByIndex(1);
        assertThat(out.contains(66)).isFalse();
        assertThat(out.isEmpty()).isTrue();
    }

    @Test
    public void removeByIndexNegativeTest2() {
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.removeByIndex(6));
    }

    @Test
    public void containsPositiveTest() {
        out.add(22);
        assertThat(out.contains(22)).isTrue();
    }

    @Test
    public void containsNegativeTest() {
        out.add(90);
        out.add(4);
        out.add(272);
        out.add(22);
        out.add(1);
        assertThat(out.contains(24)).isFalse();
    }

    @Test
    public void indexOfPositiveTest() {
        out.add(2);
        assertThat(out.indexOf(2)).isEqualTo(0);
    }

    @Test
    public void indexOfNegativeTest() {
        out.add(2);
        assertThat(out.indexOf(9)).isEqualTo(-1);
    }

    @Test
    public void lastIndexOfPositiveTest() {
        out.add(7);
        out.add(7);
        out.add(7);
        assertThat(out.lastIndexOf(7)).isEqualTo(2);
    }

    @Test
    public void lastIndexOfNegativeTest() {
        out.add(70);
        assertThat(out.lastIndexOf(5)).isEqualTo(-1);
    }

    @Test
    public void getPositiveTest() {
        out.add(113);
        assertThat(out.get(0)).isEqualTo(113);
    }

    @Test
    public void getNegativeTest() {
        assertThatExceptionOfType(MyIllegalArgumentException.class)
                .isThrownBy(() -> out.get(8));
    }

    @Test
    public void equalsPositiveTest() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(9);
        out.add(9);
        assertThat(out.equals(integerList)).isTrue();
    }

    @Test
    public void equalsNegativeTest() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(20);
        integerList.add(1);
        assertThat(out.size()).isNotEqualTo(integerList.size());
        assertThat(out.equals(integerList)).isFalse();
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
        out.add(990);
        out.add(8);
        assertThat(out.isEmpty()).isFalse();
    }

    @Test
    public void clearTest() {
        out.add(1);
        out.add(3);
        out.add(2);
        out.clear();
        assertThat(out.isEmpty()).isTrue();
    }

    @Test
    public void toArrayPositiveTest() {
        out.add(43);
        out.add(55);
        Integer[] test = out.toArray();
        assertThat(out.toArray()).containsExactlyElementsOf(Arrays.stream(test)
                .collect(Collectors.toList()));
    }

}