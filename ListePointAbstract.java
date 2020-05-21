
public abstract class ListePointAbstract implements ListePointInterface
{
    /*
     * Dans cette classe abstraite, on peut transférer la variable
     * "nbreElements" ainsi que trois méthodes qui sont communes 
     * entre toutes les listes : 
     * listeVide(), longueur() et equals()
     */

    protected int nbreElements;

    public boolean listeVide(){     
        return nbreElements == 0;
    }

    public int longueur(){
        return nbreElements;
    }

    public boolean equals(Object lst){
        if (lst == null) 
            return false;
        if(!(lst instanceof ListePointInterface)) 
            return false;

        ListePointInterface liste = (ListePointInterface)lst;
        if(longueur() != liste.longueur()) 
            return false; 

        return this.toString().equals(liste.toString());
    }

    public int hashCode(){
        return super.hashCode();
    }
}
