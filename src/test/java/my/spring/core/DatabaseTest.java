package my.spring.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

@Slf4j
public class DatabaseTest {

    @Test
    void testDatabaseSingleTon() {

        //ini adalah konsep singleton yang nanti akan dibawa oleh spring, saat membuat object dalam spring defaultnya selalu singleton

        var database1 = Database.getInstance();//kita tidak bisa mengakses new karna private
        var database2 = Database.getInstance();

        Assertions.assertSame(database2, database1);
        log.info("{}",database1,database2);

    }
}
