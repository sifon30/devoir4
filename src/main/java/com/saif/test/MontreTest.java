package com.saif.test;
import com.saif.dao.MontreDao;
import com.saif.entities.Montre;
public class MontreTest {
public static void main(String[] args) {
//créer un objet Montre
Montre m = new Montre();
m.setModel("rolex");
m.setPrix(2500);
//ajouter l'objet Montre à la BD
MontreDao mtrDao = new MontreDao();
mtrDao.ajouter(m);
System.out.println("Appel de la méthode listerTous");
for (Montre mt : mtrDao.listerTous())
System.out.println(mt.getCode()+" "+mt.getModel());
System.out.println("Appel de la méthode listerParNom");
for (Montre mt : mtrDao.listerParNom("nadh"))

System.out.println(mt.getCode()+" "+mt.getModel());

//tester les autres méthodes de la classe MontreDao
}
}