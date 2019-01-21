package top.liyf.id;

import org.junit.Test;

/**
 * @author liyf
 * Created in 2019-01-20
 */
public class TestKeyGenerator {

    @Test
    public void testGeneratorId() {

        long id = KeyGenerator.INSTANCE.nextId();
        System.out.println("id = " + id);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            KeyGenerator.INSTANCE.nextId();
        }

        System.out.println(System.currentTimeMillis() - start);

    }

}