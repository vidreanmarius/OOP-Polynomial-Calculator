import model.Monom;
import model.Polinom;
import org.junit.jupiter.api.Test;
import model.Operation;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
   public void addTest(){
        Operation addOperation = new Operation();

        Polinom pOne = new Polinom();
        Polinom pTwo = new Polinom();

        Monom one = new Monom(2, 2);
        Monom two = new Monom(2, 3);


        pOne.a.add(one);
        pTwo.a.add(two);

       assertTrue(addOperation.add(pOne, pTwo).toString().equals("+5x^2 "), "Adunarea merge");

       // assertEquals( pResult.toString() , "+5x^2 "  );
    }

    @Test
    public void subTest(){
        Operation addOperation = new Operation();

        Polinom pOne = new Polinom();
        Polinom pTwo = new Polinom();

        Monom one = new Monom(2, 5);
        Monom two = new Monom(2, 2);

        pOne.a.add(one);
        pTwo.a.add(two);

        assertTrue(addOperation.sub(pOne, pTwo).toString().equals("+3x^2 "), "Scaderea merge");
    }

    @Test
    public void multiplyTest(){
        Operation addOperation = new Operation();

        Polinom pOne = new Polinom();
        Polinom pTwo = new Polinom();

        Monom one = new Monom(2, 5);
        Monom two = new Monom(2, 2);

        pOne.a.add(one);
        pTwo.a.add(two);

        assertTrue(addOperation.multiply(pOne, pTwo).toString().equals("+10x^4 "), "Inmultirea merge");
    }

    @Test
    public void derivateTest(){
        Operation addOperation = new Operation();

        Polinom pOne = new Polinom();
        Polinom pResult = new Polinom();

        Monom one = new Monom(2, 5);
        Monom result = new Monom(1, 10);

        pOne.a.add(one);
        pResult.a.add(result);

        assertTrue(addOperation.derv(pOne).toString().equals("+10x "), "Derivarea merge");
    }

    @Test
    public void integrateTest(){
        Operation addOperation = new Operation();

        Polinom pOne = new Polinom();
        Polinom pResult = new Polinom();

        Monom one = new Monom(1, 4);
        Monom result = new Monom(2, 2);

        pOne.a.add(one);
        pResult.a.add(result);

        assertTrue(addOperation.integrate(pOne).toString().equals("+2x^2 "), "Integrarea merge");
    }


}
