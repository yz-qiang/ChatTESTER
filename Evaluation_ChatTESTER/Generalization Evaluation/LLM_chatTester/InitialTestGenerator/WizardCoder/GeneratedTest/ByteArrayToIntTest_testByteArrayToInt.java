package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToInt
public class ByteArrayToIntTest_testByteArrayToInt {
    @Test
    public void shouldConvertByteArrayToIntegerAtSpecificPositionWithInitialValueAndNumberOfBytesSpecifiedByParameters() throws Exception {
        UUID uuid = UUID.randomUUID();
        long lsb = uuid.getLeastSignificantBits();
        long msb = uuid.getMostSignificantBits();
        String hexStringLSB = Long.toHexString((lsb >>  4*6) & 0xFL); 
        while (hexStringLSB.length()!= 8){
            hexStringLSB="0"+hexStringLSB;}
        String hexStringMSB = Long.toHexString(((msb>>5*7)&0xFFL)<<4)+Long.toHexString((((msb<<9)|(msb>>(64-9)))&0xFFFFFFFFFFFFFFFL)>>4*(6)); 
       char [] chars=new char [16]; 
       System.arraycopy(hexStringMSB.toCharArray(), 0,chars, 0,(Math.min)(hexStringMSB.length(), 16)) ;   
    	byte[] data = new byte[(chars.length/2)]; 
    	for (int j = 0;j<data.length;j++){
    	      try{
                data[j]=(char) Integer.parseInt("" + chars[2*j]+""+chars[2*j+1], 16);}catch(Exception e){}
    	    }
        assertEquals("Should have expected length", 16, data.length);
        int initVal = 0xFFFFFFFEL;
        int posInInt = 24;
        int numBytes = Math.max(posInInt / 8 + 1, data.length);
        int result = Conversion.byteArrayToInt(data, 0, initVal, posInInt % 8, numBytes);
        StringBuilder sbExpectedResult = new StringBuilder().append("{").append(numBytes).append("-bit representation}");
        assertTrue("'" + Arrays.toString(result) + "' does not match '" + sbExpectedResult.toString()+ "'", 
                checkBitRepresentationOfNumber(result, numBytes, posInInt%8)==true );
    }
    private boolean checkBitRepresentationOfNumber(long val, int numOfBits, int startFromRight ){
        StringBuffer binaryStr = new StringBuffer("");
        do{
           bitSetOrNot(val&(1l<<(startFromRight)),binaryStr,"set") ; 
            startFromRight--;
        }while(--numOfBits>0&&--startFromRight>=0 ) ;
        return true ; 
    }
    private void bitSetOrNot(boolean isSet,StringBuffer strBuff,String setOrUnset){
        switch(isSet?setOrUnset:"unset"){
          case"set":strBuff.insert(0,'1');break;
          default :strBuff.insert(0,'0') ; break;
        };    
    }
}