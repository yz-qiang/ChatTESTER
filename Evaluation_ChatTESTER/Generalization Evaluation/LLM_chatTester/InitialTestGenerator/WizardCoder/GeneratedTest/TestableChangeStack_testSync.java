package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public @Test 
void shouldSyncValue() throws Exception {
    final Object lock = new Object();
    class TestableChangeStack_testSync extends ChangeStack<Object> {
        public volatile int numWaitingThreads = -1;
        @Override
        protected void _synced() {
            super._synced();
            synchronized (lock) {
                ++numWaitingThreads;
                try {
                    while (!isSynchronized())
                        wait();
                    notifyAll();
                } catch (InterruptedException e) {} finally {
                    --numWaitingThreads;
                }
            }
        }
        private boolean isSynchronized() {
            Thread currentThread = Thread.currentThread();
            StackTraceElement[] traceElements = currentThread.getStackTrace();
            String className = getClass().getName();
            for (int i=0 ; i < traceElements.length &&!className.equals(traceElements[i].getClassName()); i++) 
                continue;
            return!(++i >= traceElements.length ||
                     getMethodDepth("shouldSyncValue", traceElements)<getMethodDepth("wait", traceElements)); 
        }
        private static int getMethodDepth(String methodName, StackTraceElement traces) {
            List<Integer> depths = Arrays.stream(traces).filter((t)->methodName.equals(t.getMethodName())).mapToInt(StackTraceElement::getLineNumber).boxed().collect(Collectors.toList());
            Collections.sort(depths);
            assert(!depths.isEmpty()):"No "+methodName+" found";
            return depths.get(0)-2;    
        }
    };
    TestableChangeStack_testSync cstack = new TestableChangeStack_testSync("");
    Assert.assertTrue(cstack.sync("foo"));     
    Assert.assertEquals("", cstack.pop());      
    Assert.assertFalse(cstack.empty());         
   additional assertions here as needed
   assertTrue(cstack.getNumWaitingThreads()==0):
           "Expected zero waiting threads but got "+cstack.getNumWaitingThreads()+" instead.";
}