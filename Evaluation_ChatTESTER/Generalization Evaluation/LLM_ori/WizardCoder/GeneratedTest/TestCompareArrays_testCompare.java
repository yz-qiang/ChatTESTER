package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
@RunWith(Parameterized.class) 
public class TestCompareArrays_testCompare {
    private final Object[][] testData = {{new Integer[]{1}, new Integer[]{2}},
                                         {new String[]{"abc", "def"}, new String[]{"ghi"}},
                                         {null, null}};
    public TestCompareArrays_testCompare(Object arg0, Object arg1){
        this.arg0= Arrays.<Integer>asList((Integer[]) arg0); 
        this.arg1=(String []) arg1;}
    @Parameters  
    public static Collection data(){   
       List listData = Lists.newArrayList();    
      Collections3.forEachCartesianProductOfLists(testData,(List l)->{listData.add(l)});     
         System.out.println("\n\tInput Parameters Combinations:"); 
         Iterator iterator = listData.iterator();         
            while(iterator.hasNext()){
                Object [] objArr =(Object []) iterator.next(); 
                System.out.print("{ ");                
                    for(Object o :objArr ){
                        System.out.print(o + ", ");                    
                     }
                 System.out.println("}");
             }
               return listData ; 
    };
   @Parameter(value = 0 ) 
   public List<? super Number[]> arg0;
   @Parameter( value = 1 ) 
   public? super String[] arg1;
  @Test 
  public void checkEqualLengthArraysShouldBeEqualWhenTheyHaveSameElements() throws Exception {       
        try {            
            assertEquals(-1*compare(arg0, arg1), -1*(Collections.reverseOrder().compare(arg0, arg1))); 
            assertTrue(!isEqual(arg0));             
        } catch (Exception e) {}        
  } 
  protected boolean isEqual(Collection<?> c) {      
      Set set = Sets.newHashSetWithExpectedSize(c.size());          
      Iterables.addAll(set, c);           
      return set.size()==1 &&!Iterators.containsDuplicates(c.iterator()) || isEmptyOrSingletonSet(set);              
  }
	protected boolean isEmptyOrSingletonSet(final Set s) {
		return s==null||s.isEmpty()||(s.size()==1&&!s.iterator().hasNext()); 
	}
}