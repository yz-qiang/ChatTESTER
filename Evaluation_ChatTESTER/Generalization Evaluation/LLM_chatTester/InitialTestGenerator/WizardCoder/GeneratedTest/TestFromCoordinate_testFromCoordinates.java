package no.api.meteo.entity.core;
import org.junit.Assert;
import org.junit.Test;
// original test path: lazee_meteo###lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest###testFromCoordinates
public 
class TestFromCoordinate_testFromCoordinates {
    private Stream<Arguments> validInputs() {
        Object[][] data = {{
                "(56.789,-123.456)", "-123.456", "56.789" },
            {"(-123.456,+56.789)", "+56.789", "-123.456"},
            {"(+56.789,+123.456,1000)", "+123.456","+56.789"}};
        return Arrays.stream(data)
                   .map((args -> Arguments.of(((Object[]) args)[0], ((Object[]) args)[1], ((Object[]) args)[2])));
    }
    public void shouldCreateValidLocationsFromStringInput(final String coordsStr,
                                                        final double expectedLongitude,
                                                        final double expectedLatitude) throws Exception {
        System.out.println("\nTesting creation of locations from \"" + coordsStr +"\"");
        Location loc = Location.fromCoordinates(coordsStr);
       AssertionsForClassTypes.assertThat(loc.getLongitude()).isCloseTo(expectedLongitude, Offset.offset(.0001D))
              .overridingErrorMessage("\"%s\" has invalid Longitude.", coordsStr);
      assertThat(loc.getLatitude(), closeTo(expectedLatitude, offset(.0001)))
             .withFailMessage("%s does not have correct Latitude!", coordsStr);
    }
    @ParameterizedTest(name="should fail when creating Locations from \"{0}\".")  
    @MethodSource("invalidInputs")   
    public <T extends Throwable>void shouldThrowExceptionWhenCreatingInvalidLocationsFromStringInput(
                                            final String coordStr,
                                            final Class<? extends T> exceptionType){ 
          System.out.println("\n Testing failure case where we expect type:"
                  +exceptionType+"when parsing"+coordStr+".");
          Executable executableCode=()-> Location.fromCoordinates(coordStr);
          AssertionsForInterfaceTypes.<Throwable>assertThrows(exceptionType,executableCode)
                         .hasMessageMatching("\\Q"+coordStr+" \\Emust be on the pattern.*?\\. ");
   }
   private static Stream<Arguments> invalidInputs(){
        Object[] testData={ 
                "{56.789;-123.456}",      
                "(56.789-123.456)}",     
                "(56.789,,-123.456)",    
                "(56.789+-123.456)",     
                "("                        };       
        int i=0 ;        
        while(!testData[i].equals("")) { 
            ++i;            
        }       
        --i;         
        List<List<Object>> argLists=new ArrayList<>();          
        do {             
            List<Object> currArgSet=Arrays.asList(testData[(int)(Math.random()*i)]);           
            argLists.add(currArgSet);              
            testData=(Object[])ArrayUtils.removeElement(testData,(int)(Math.random()*i)+1);               
            i--;                   
        }while(!(argLists==null || argLists.isEmpty()));                
        return argLists.parallelStream().map(l->Arguments.of(l)).collect(Collectors.toList()).stream(); 
   }
}