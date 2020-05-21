
public class ListeP_TabTest extends junit.framework.TestCase
{
    private ListeP_Tab listeP_T1;

    public ListeP_TabTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    public void setUp()
    {   
        listeP_T1 = new ListeP_Tab();
        listeP_T1.cons(new Integer(8));
        listeP_T1.cons(new Integer(16));
        listeP_T1.cons(new Integer(44));
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
        assertEquals("44 membre de [44, 16, 8] ?", true, listeP_T1.membre(44));
        assertEquals("16 membre de [44, 16, 8] ?", true, listeP_T1.membre(16));
        assertEquals("8 membre de [44, 16, 8] ?", true, listeP_T1.membre(8));
        assertEquals("3 membre de [44, 16, 8] ?", false, listeP_T1.membre(3));
    }

    public void test_renverse(){
        listeP_T1.renverse();
        assertEquals("L'inverse de [44, 16, 8]", "[8, 16, 44]", 
            listeP_T1.toString());
    }

    public void test_listeVide(){
        assertEquals("[44, 16, 8] est vide ?", false, listeP_T1.listeVide());
    }

    public void test_longueur(){
        assertEquals("Longueur de [44, 16, 8]", 3, listeP_T1.longueur());
    }

    public void test_clone() throws CloneNotSupportedException{
        assertEquals("Clonage de [44, 16, 8]", "[44, 16, 8]", 
            listeP_T1.clone().toString());
    }

}
