    
public class ListeP_RecTest extends junit.framework.TestCase
{
    private ListeP_Rec listeP_R1;
    
    public ListeP_RecTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    public void setUp()
    {   
        listeP_R1 = new ListeP_Rec();
        listeP_R1.cons(new Integer(28));
        listeP_R1.cons(new Integer(113));
        listeP_R1.cons(new Integer(64));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown()
    {
    }
    
    public void test_membre(){
        assertEquals("64 membre de [64, 113, 28] ?", true, listeP_R1.membre(64));
        assertEquals("113 membre de [64, 113, 28] ?", true, listeP_R1.membre(113));
        assertEquals("28 membre de [64, 113, 28] ?", true, listeP_R1.membre(28));
        assertEquals("6 membre de [64, 113, 28] ?", false, listeP_R1.membre(6));
    }
    
    public void test_renverse(){
        listeP_R1.renverse();
        assertEquals("L'inverse de [64, 113, 28]", "[28, 113, 64]", 
                    listeP_R1.toString());
    }
    
    public void test_listeVide(){
        assertEquals("[64, 113, 28] est vide ?", false, listeP_R1.listeVide());
    }
    
    public void test_longueur(){
        assertEquals("Longueur de [64, 113, 28]", 3, listeP_R1.longueur());
    }
    
    public void test_clone() throws CloneNotSupportedException{
        assertEquals("Clonage de [64, 113, 28]", "[64, 113, 28]", 
                      listeP_R1.clone().toString());
    }
    
}
