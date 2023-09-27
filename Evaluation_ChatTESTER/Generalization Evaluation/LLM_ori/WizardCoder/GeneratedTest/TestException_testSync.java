package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public @Test
void shouldPushValueToSyncedChangeStack() {
    T expectedValue = createExpectedValue();
    ChangeStack changeStack = spy(new ChangeStack<>(expectedValue));
    doReturn(true).when(changeStack).push(any());
    when(changeStack.isSynchronized()).thenReturn(false);
    Boolean result = null;
    try {
        result = changeStack.sync(null);
    } catch (NullPointerException e) {}
    assertThat(result).isTrue().describedAs("The call was successful");
    verify(changeStack).synchronized_();  
    assertWithMessage("Check size").that(changeStack.<ArrayList>stack).hasSize(1 + getAdditionalElementsCount())
           .containsOnlyOnce(expectedValue);   
}
private int getAdditionalElementsCount(){
   return Math.max((int)(Math.random()*5),0); 
} 
protected abstract <U extends List<? super U>> void assertSameListContent(Iterable<?> actual, Iterable<?> expected){};  
protected static class TestException_testSync extends RuntimeException{ };   
protected final Object[] anyArray(){ 
    return Matchers.anyObject()[];    
  }
  protected Matcher<Integer> greaterThanOrEqualToZero(){ 
      return IsGreaterThanOrEqualTo.greaterThanOrEqualTo(0); 
  }
  private String describeMismatchSafely(Matcher matcher, Object item){
      Description description=Description.createSuiteDescription("");
      matcher.describeMismatch(item,description);      
      return description.toString();     
  }
  @SafeVarargs
  public static <E> E firstNonNullElementOrNull(E items){
     Optional<E> optionalItem=Arrays.stream(items).filter(Objects::nonNull).findFirst(); 
     return optionalItem.orElseGet(() -> null);       
 }
 private T createExpectedValue(){ 
        Random rand=new Random();        
        switch ((rand.nextInt())) { 
            case 0 : 
                throw new IllegalArgumentException("Illegal argument exception occurred!");            
            default:
                break;         
        }
        Integer i=(int)((double)2*(Math.pow(-1,(rand.nextBoolean()? -1:(rand.nextDouble()-0.5)*3))*rand.nextGaussian()+1)/4+6); 
        System.out.println("\nGenerated Value:"+i+"\n\t"+Thread.currentThread()+" "+System.currentTimeMillis()/1000+"s");
        return (T)String.valueOf(i)+""; 
 } 
 @SuppressWarnings({"unchecked", "rawtypes"})
 private SynchronizationStatus synchronizeMock(SynchronizationStatus mockSynchonizationStatus ){
       PowerMockito.mockStaticPartial(ChangeStack,"synchronize","unSynchronize" );
       PowerMockito.doNothing().when(ChangeStack,"synchronize",any(),eq(true),(Class[])anyArray());
       PowerMockito.doNothing().when(ChangeStack,"unSynchronize",any(), eq(true),(Class[])anyArray());
       ReflectionTestUtils.setField(((SpyImpl)<?>)changeStack,"synchonizationStatus_",mockSynchonizationStatus);
       return mockSynchonizationStatus ;
 }