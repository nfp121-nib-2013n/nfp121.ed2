
public class ListeP_JavaTest extends junit.framework.TestCase
{
    private ListeP_Java listeP_J1;

    public ListeP_JavaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    public void setUp()
    {   
        listeP_J1 = new ListeP_Java();
        listeP_J1.cons(new Integer(90));
        listeP_J1.cons(new Integer(36));
        listeP_J1.cons(new Integer(207));
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
        assertEquals("207 membre de [207, 36, 90] ?", true, listeP_J1.membre(207));
        assertEquals("36 membre de [207, 36, 90] ?", true, listeP_J1.membre(36));
        assertEquals("90 membre de [207, 36, 90] ?", true, listeP_J1.membre(90));
        assertEquals("58 membre de [207, 36, 90] ?", false, listeP_J1.membre(58));
    }

    public void test_renverse(){
        listeP_J1.renverse();
        assertEquals("L'inverse de [207, 36, 90]", "[90, 36, 207]", 
            listeP_J1.toString());
    }

    public void test_listeVide(){
        assertEquals("[207, 36, 90] est vide ?", false, listeP_J1.listeVide());
    }

    public void test_longueur(){
        assertEquals("Longueur de [207, 36, 90]", 3, listeP_J1.longueur());
    }

    public void test_clone() throws CloneNotSupportedException{
        assertEquals("Clonage de [207, 36, 90]", "[207, 36, 90]", 
            listeP_J1.clone().toString());
    }

}
