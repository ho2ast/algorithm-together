package bruteforce;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Level3Test {
    @Test
    void equation() {
        int a = 1;
        int b = 3;
        int c = -1;
        int d = 4;
        int e = 1;
        int f = 7;

        int x = ((c * e) - (b * f)) / ((a * e) - (b * d));
        int y = ((c * d) - (a * f)) / ((b * d) - (a * e));

        Assertions.assertThat(x).isEqualTo(2);
        Assertions.assertThat(y).isEqualTo(-1);
    }
}
