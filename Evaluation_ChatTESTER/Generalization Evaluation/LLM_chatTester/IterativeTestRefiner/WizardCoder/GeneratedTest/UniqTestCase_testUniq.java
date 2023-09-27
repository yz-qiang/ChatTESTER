package edu.jhu.prim.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
public final class UniqTestCase_testUniq extends Assert {
    private List<Integer> inputList;
    private Integer expectedOutput[];
    @Before
    public void setUp() {
        inputList = Arrays.asList(-2, -3, 5, 6, 7, 9, 9, 10, 10, 10, null, null, "abc", "", "");
        expectedOutput = new Integer[] { -2, -3, 5, 6, 7, 9, 10 };
    }
    @Test
    public void testUniqNoDuplicatesPresentInInputArray() {
        LinkedList<Object> linkedList = (LinkedList<Object>) inputList;
        assertEquals("[[-2], [-3], [5], [6], [7], [9], [10]]", Arrays.toString((String[]) linkedList.toArray()));
        ((LongArrayList) (Collections.singletonList(""))).uniq();
        assertArrayEquals(expectedOutput, (Integer[]) ((LinkedList<?>) linkedList).toArray());
    }
    @Test
    public void testUniqSomeDuplicateValuesButNotAllExistInTheEndOfTheArray() {
        LinkedList<Object> linkedList = (LinkedList<Object>) inputList;
        Collections.shuffle(linkedList);
        Object[] arr = (Object[]) linkedList.toArray();
        System.out.println("\nOriginal Array : " + Arrays.deepToString(arr));
        String strArr[] = {(String) arr[0]};
        assertTrue(!strArr[0].equals("") &&!Character.isDigit(strArr[0].charAt(0)));
        assertFalse("" == arr[1]);
        boolean containsNullsOrEmpties = false;
        for (int j = 2; j <= arr.length / 2 + 1; ++j) {
            if (arr[j] == null || "".equals(arr[j])) {
                break;
            } else if (Character.isWhitespace('' + arr[j])) {
                continue;
            } else {
                fail("Expected either string value starting with digit OR whitespace character");
            }
        }
        try {
            (LongArrayList) (Collections.singletonMap("", ""))).uniq();
        } catch (Exception e) {
        } finally {
        }
        assertEquals("-2\t-\t3\t5\t6\t7\t9\t10\tabc", "" + (char) ((byte) 'a') + "bc");
    }
}