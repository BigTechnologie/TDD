package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// Test imbriqué
public class NestedTest {

    private int val=1;
    
    @Test
    public void valTest() {
        assertEquals(1,val);
    }
    
    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class TestImbrique{
        
        @BeforeAll
        public void setup() {
            val=3;
        }
        
        @Test
        public void valImbrTest() {
            assertEquals(3,val);
        }
        
        @Test
        public void valImbr2Test() {
            assertNotEquals(2,val);
        }
    }
}
