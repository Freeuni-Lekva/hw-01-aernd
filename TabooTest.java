// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class TabooTest extends TestCase {
    public void testNoFollow1(){
        Taboo<String> t = new Taboo<>(Arrays.asList("a", "c", "a", "b"));
        assertEquals(new HashSet<String>(Arrays.asList("c","b")),t.noFollow("a"));
        assertEquals(new HashSet<String>(Arrays.asList("a")),t.noFollow("c"));
        assertEquals(Collections.emptySet(),t.noFollow("b"));
        assertEquals(Collections.emptySet(),t.noFollow("x"));
    }

    public void testNoFollow2(){
        Taboo<String> t = new Taboo<>(Arrays.asList());
        assertEquals(Collections.emptySet(),t.noFollow("a"));
    }

    public void testNoFollow3(){
        Taboo<Integer> t = new Taboo<>(Arrays.asList(1,2,1,3));
        assertEquals(new HashSet<Integer>(Arrays.asList(2,3)),t.noFollow(1));
        assertEquals(Collections.emptySet(),t.noFollow(3));
    }

    public void testNoFollow4(){
        Taboo<Character> t = new Taboo<>(Arrays.asList('%','%','%'));
        assertEquals(new HashSet<Character>(Arrays.asList('%')),t.noFollow('%'));
    }

    public void testNofollow5(){
        Taboo<Character> t = new Taboo<>(Arrays.asList('a','b',null,'c','d'));
        assertEquals(Collections.emptySet(),t.noFollow('b'));
    }

    public void testNofollow6(){
        Taboo<Character> t = new Taboo<>(Arrays.asList('a','b',null,'c','d'));
        assertEquals(Collections.emptySet(),t.noFollow(null));
    }

    public void testReduce1(){
        Taboo<String> t = new Taboo<>(Arrays.asList("a", "c", "a", "b"));
        List<String> before = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        List<String> after = new ArrayList<String>(Arrays.asList("a", "x", "c"));
        t.reduce(before);
        assertEquals(before, after);
    }

    public void testReduce2(){
        Taboo<String> t = new Taboo<>(Arrays.asList("a", "c"));
        List<String> before = new ArrayList<String>(Arrays.asList("a", "c", "c", "c", "c", "c"));
        List<String> after = new ArrayList<String>(Arrays.asList("a"));
        t.reduce(before);
        assertEquals(before, after);
    }

    public void testReduce3(){
        Taboo<Integer> t = new Taboo<>(Arrays.asList());
        Random r = new Random();
        for(int i=0;i<100;i++){
            int rand = r.nextInt() % 1000;
            List<Integer> before = new ArrayList<Integer>();
            for(int j=0;j<rand;j++){
                before.add(r.nextInt());
            }
            List<Integer> after = before;
            t.reduce(before);
            assertEquals(before,after);
        }
    }

    public void testReduce4(){
        Taboo<String> t = new Taboo<>(Arrays.asList(null, "c"));
        List<String> before = new ArrayList<String>(Arrays.asList(null, "c", "c", "c", "c", "c"));
        List<String> after = new ArrayList<String>(Arrays.asList(null, "c", "c", "c", "c", "c"));
        t.reduce(before);
        assertEquals(before, after);
    }
}
