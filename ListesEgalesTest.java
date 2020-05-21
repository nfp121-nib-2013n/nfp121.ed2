
public class ListesEgalesTest extends junit.framework.TestCase
{
    private ListeP_Tab listeP_T1;
    private ListeP_Rec listeP_R1;
    private ListeP_Java listeP_J1, listeP_J2;

    public ListesEgalesTest()
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
        listeP_T1.cons(new Integer(3));
        listeP_T1.cons(new Integer(13));
        listeP_T1.cons(new Integer(23));
        listeP_T1.cons(new Integer(33));
        listeP_R1 = new ListeP_Rec();
        listeP_R1.cons(new Integer(3));
        listeP_R1.cons(new Integer(13));
        listeP_R1.cons(new Integer(23));
        listeP_R1.cons(new Integer(33));
        listeP_J1 = new ListeP_Java();
        listeP_J1.cons(new Integer(3));
        listeP_J1.cons(new Integer(13));
        listeP_J1.cons(new Integer(23));
        listeP_J1.cons(new Integer(33));
        listeP_J2 = new ListeP_Java();
        listeP_J2.cons(new Integer(8));
        listeP_J2.cons(new Integer(97));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown()
    {
    }

    public void test_Conc(){
        listeP_T1.conc(listeP_J2);
        listeP_R1.conc(listeP_J2);
        listeP_J1.conc(listeP_J2);
        assertEquals("La concaténation de [33, 23, 13, 3] et [97, 8]", 
            "[8, 97, 33, 23, 13, 3]", listeP_T1.toString());
        assertEquals("La concaténation de [33, 23, 13, 3] et [97, 8]", 
            "[33, 23, 13, 3, 97, 8]", listeP_R1.toString());
        assertEquals("La concaténation de [33, 23, 13, 3] et [97, 8]", 
            "[33, 23, 13, 3, 97, 8]", listeP_J1.toString());
    }

    public void test_renverse(){
        listeP_T1.renverse();
        listeP_R1.renverse();
        listeP_J1.renverse();
        assertEquals("L'inverse de [33, 23, 13, 3]", "[3, 13, 23, 33]", 
            listeP_T1.toString());
        assertEquals("L'inverse de [33, 23, 13, 3]", "[3, 13, 23, 33]", 
            listeP_R1.toString());
        assertEquals("L'inverse de [33, 23, 13, 3]", "[3, 13, 23, 33]", 
            listeP_J1.toString());
    }

    public void test_listesEgales(){
        assertEquals(true, listeP_T1.equals(listeP_R1));
        assertEquals(true, listeP_R1.equals(listeP_J1));
        assertEquals(true, listeP_J1.equals(listeP_T1));

        assertEquals(false, listeP_T1.equals(listeP_J2));
        assertEquals(false, listeP_R1.equals(listeP_J2));
        assertEquals(false, listeP_J1.equals(listeP_J2));
    }

    
}
