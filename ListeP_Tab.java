
import java.util.Iterator ;

public class ListeP_Tab extends ListePointAbstract 
{  
    private Object[] tabImplantation;

    public ListeP_Tab() {
        //3 ou n'importe quel autre nombre > 0 éléments
        tabImplantation = new Object[3];
    }

    public Object car() throws ListeVideException {
        if (listeVide()) 
            throw new ListeVideException();

        return tabImplantation[longueur() - 1];
    }

    public void cdr() throws ListeVideException {
        if (listeVide()) 
            throw new ListeVideException();

        tabImplantation[longueur() - 1] = null;
        nbreElements--;
    }

    public void cons(Object objet) {
        if (objet == null) 
            return;

        /* 
         * Les listes sont de longueur quelconque, 
         * elles sont NON bornées
         */
        if (longueur() == tabImplantation.length) {
            /*
             * Lorsque tabImplantation est plein, besoin de copier
             * les éléments vers un nouveau tableau "temp" et 
             * ajouter "objet". La taille de temp est quelconque 
             * ( > nbreElements), j'ai choisie une taille égale
             * à nbreElements + 3 
             */ 
            Object[] temp = new Object[nbreElements + 3];
            System.arraycopy(tabImplantation, 0, temp, 0, longueur());
            tabImplantation = temp;
        }

        tabImplantation[longueur()] = objet;
        nbreElements ++;
    }

    public void conc(ListePointInterface lst ){
        if(lst == null) 
            return;

        for (int i = 0; i < lst.longueur(); i += 1)
            this.cons(lst.getValue(i));
    }

    public Object getValue(int index){
        /* 
         * Le premier élément est considéré comme étant 
         * le dernier élément du tableau... 
         */
        return tabImplantation[this.longueur()-1 - index];
    }

    public void renverse() {
        if (listeVide()) 
            return;
        if (longueur() == 1) 
            return;

        int milieu = longueur() / 2;
        for (int i = 0, j = longueur() - 1; i < milieu; i += 1, j -= 1)
        {
            Object valeur1 = tabImplantation[i];
            Object valeur2 = tabImplantation[j];
            tabImplantation[j] = valeur1;
            tabImplantation[i] = valeur2;
        }
    }

    public boolean membre(Object objet){
        if (objet == null) 
            return false;

        for (int i = 0; i < longueur(); i += 1)
            if (objet.equals(getValue(i))) 
                return true;

        return false; 
    }

    public String toString() {
        if (longueur() == 0) 
            return "[]";

        String s = "[";
        for (int i = longueur() - 1; i > 0; i--) {
            s += tabImplantation[i].toString() + ", ";
        }

        return s + tabImplantation[0] + "]";
    }

    /*
    // Ces trois méthodes existent dans la classe ListePointAbstract
    public boolean listeVide() {
        return nbreElements == 0;
    }

    public int longueur() {
        return nbreElements;
    }

    public boolean equals(Object liste){
        if (liste == null) 
            return false;
        if(!(liste instanceof ListePointInterface)) 
            return false;

        ListePointInterface lst = (ListePointInterface)liste;
        if(longueur() != lst.longueur()) 
            return false;

        // Dans le cas où l'ordre des éléments n'est pas important
        for (int i = 0; i < longueur(); i += 1)
        {
            if (!membre(lst.getValue(i))) 
                return false;
        }   
        return true;

        // Si l'ordre des éléments est important:

        // Solution sans utilisation de toString()
        for (int i = 0; i < longueur(); i += 1)
            if ((getValue(i)!= null) && !getValue(i).equals(lst.getValue(i)))
                return false;

        // Solution avec utilisation toString()
        return this.toString().equals(lst.toString());
    }
     */

    // Iterator pour tabImplantation
    public Iterator iterator() {
        return new Iterator() {
            Object[] temp = tabImplantation;
            int indice = 0;

            public boolean hasNext() {
                return indice < nbreElements;
            }

            public Object next() {
                // get puis next
                Object obj = temp[indice];
                indice++;
                return obj;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public Object clone() throws CloneNotSupportedException {
        ListeP_Tab lst = (ListeP_Tab) super.clone();
        lst.tabImplantation = tabImplantation.clone();

        return lst;
    }
}