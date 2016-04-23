package au.usyd.capstone.experiment;

import org.junit.*;

import au.usyd.capstone.utils.InvSqrt;

public class SqrtTest{
	
	public SqrtTest() {
		super();
	}

	@BeforeClass  
    public static void setUpBeforeClass() {  
        System.out.println("Set up before class");  
    }
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Set up");  
	}
	
	@Test
	public void testInvSqrt(){
		
		float a =   11111111f;
		
		long t1 = System.currentTimeMillis();

		for(float i = 0;i < a;i++)
		{
			float aa = InvSqrt.invSqrt(i);
		}

		long t2 = System.currentTimeMillis();

		System.out.println("InvSqrt用时："+(t2-t1));
		
	}
	
	@Test
	public void testMathSqrt(){
		
		float a =   11111111f;

		long t1 = System.currentTimeMillis();

		for(float i = 0;i < a;i++)
		{
			double aa = Math.sqrt(i);
			aa = 1/aa;
		}
		long t2 = System.currentTimeMillis();

		System.out.println("Math.sqrt用时："+(t2-t1));
		
	}
	
    @After  
    public void tearDown() throws Exception {  
        System.out.println("Tear down");  
    }
    
    @AfterClass  
    public static void tearDownAfterClass() {  
        System.out.println("Tear down After class");  
    }
	

	
}
