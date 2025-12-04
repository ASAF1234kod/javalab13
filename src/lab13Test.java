//fendoglu
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lab13Test 
{
    lab13 lab;
    Integer[] expectedResult1;
    Integer[] expectedResult2;
    Integer[] expectedResult3;
    String inputFilename = "lab13_input_data.txt";
    String expectedResultsFilename = "lab13_expected_results.txt";

    @BeforeEach
    public void setUp() throws Exception 
    {
        lab = new lab13();
        
        lab.readData(inputFilename);
        
        ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
        for( int i = 0; i < 3; i++ )
        {
            testData.add(new ArrayList<Integer>());
        }
        
        try
        {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
            for( int i = 0; i < testData.size(); i++ )
            {
                ArrayList<Integer> currentTestData = testData.get(i); 
                String inn;
                input.readLine();
                while( (inn = input.readLine()) != null )
                {
                    if( inn.length() > 0 )
                    {
                        currentTestData.add(Integer.valueOf(inn.trim()));
                    }
                    else
                    {
                        break;
                    }
                }
                testData.set(i, currentTestData);
            }
            input.close();
            expectedResult1 = testData.get(0).toArray(new Integer[0]);
            expectedResult2 = testData.get(1).toArray(new Integer[0]);
            expectedResult3 = testData.get(2).toArray(new Integer[0]);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            System.exit(0);
        }       
    }

    @Test
    public void testGetTotalCount() {
        assertEquals(1000, lab.getTotalCount());
    }

    @Test
    public void testGetOddCount() {
        assertEquals(507, lab.getOddCount());
    }

    @Test
    public void testGetEvenCount() {
        assertEquals(493, lab.getEvenCount());
    }

    @Test
    public void testGetDistinctGreaterThanFiveCount() {
        assertEquals(94, lab.getDistinctGreaterThanFiveCount());
    }
    @Test
    public void testGetResult1() {
        assertArrayEquals(expectedResult1, lab.getResult1());
    }

    @Test
    public void testGetResult2() {
        assertArrayEquals(expectedResult2, lab.getResult2());
    }

    @Test
    public void testGetResult3() {
        assertArrayEquals(expectedResult3, lab.getResult3());
    }
}