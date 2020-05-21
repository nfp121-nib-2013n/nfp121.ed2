public interface ListePointInterface extends Cloneable, Iterable
{
    /*
     * Le mot "public" est facultatif c'est parce que toutes
     * les méthodes d'une interface sont publiques
     */ 

    public Object car() throws ListeVideException;

    public void cdr() throws ListeVideException;

    public void cons(Object objet);

    public void conc(ListePointInterface lst);

    public Object getValue(int index);

    public void renverse();

    public boolean membre(Object objet);

    public boolean listeVide();

    public int longueur();
}
